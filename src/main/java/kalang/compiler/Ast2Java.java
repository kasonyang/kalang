package kalang.compiler;

import java.io.File;
import java.io.IOException;
import kalang.ast.*;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kalang.core.Type;
import kalang.core.Types;
import kalang.util.AstUtil;
import kalang.util.ClassNameUtil;
import org.apache.commons.io.FileUtils;

/**
 * The class output the ast as java source
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class Ast2Java extends AbstractAstVisitor<String> implements CodeGenerator{

    private List<VarObject> varList = new LinkedList<>();

    protected String code = "";
    private String indent = "";

    private boolean trim = false;

    private ClassNode cls;

    private MethodNode method;
    
    //private File outputDir  = null;

    public Ast2Java() {
        
    }

    private String getVarName(VarObject vo) {
        String name = vo.name;
        String tmpNamePrefix = "tmp";
        if (name == null || name.startsWith(tmpNamePrefix)) {
            if (!varList.contains(vo)) {
                varList.add(vo);
            }
            name = tmpNamePrefix + "_" + varList.indexOf(vo);
        }
        return name;
    }

    private List<String> trimStmtAll(List<String> stmts) {
        List retList = new LinkedList();
        for (String s : stmts) {
            retList.add(trimStmt(s));
        }
        return retList;
    }

    private void p(String code) {
        this.code += code;
    }

    private void c(String code) {
        addCode(code);
    }

    private void addCode(String code) {
        if (code == null) {
            return;
        }
        code = code.trim();
        if (code.endsWith("}")) {
            if (indent.length() >= 4) {
                indent = indent.substring(4);
            }
            code = "\r\n" + indent + code + "\r\n";
            code += indent;
        }
        if (code.endsWith("{")) {
            indent += "    ";
            code += "\r\n" + indent;
        }
        if (code.endsWith(";")) {
            if (trim) {
                code = code.substring(0, code.length() - 1);
            } else {
                code += "\r\n" + indent;
            }
        }
        this.code += code + " ";
    }

    private String trimStmt(String stmt) {
        stmt = stmt.trim();
        if (stmt.endsWith(";")) {
            stmt = stmt.substring(0, stmt.length() - 1);
        }
        return stmt;
    }

    private String toJavaString(ConstExpr ce) {
        Object v = ce.getValue();
        if (v instanceof String) {
            return "\"" + v + "\"";
        } else if (ce.getConstType() == Types.CHAR_TYPE) {
            return "'" + v + "'";
        } else if(ce.getConstType() == Types.NULL_TYPE) {
            return "null";
        }else{
            return v.toString();
        }
    }

    @Override
    public void generate(ClassNode cls){
        code = "";
        visit(cls);
    }

    public String getCode() {
        return code;
    }
    
//	
//    private String indent(String str){
//        return "";
//	//return	"  " + str.readLines().join("\r\n  ");
//    }
    
    private String className(String name){
        return name.replace("$", ".");
    }

    @Override
    public String visitCastExpr(CastExpr node) {
        return String.format("(%s)%s",className(node.getToType().toString()), visit(node.getExpr()));
    }

    @Override
    public String visitParameterExpr(ParameterExpr node) {
        return node.getParameter().name;
    }

//    @Override
//    public String visitNewExpr(NewExpr node) {
//        String args = String.join(",", visitAll(node.arguments)); //.join(",");
//        return String.format("new %s(%s)", node.toType, args);
//    }

    @Override
    public String visitVarExpr(VarExpr node) {
        return this.getVarName(node.getVar());
    }

    public String visitModifier(Integer modifier) {
        int m = modifier != null ? modifier : 0;
        return Modifier.toString(m);
    }

    String getVarStr(VarObject f) {
        String fs = "";
        String mdf = "";
        fs += Modifier.toString(f.modifier) + " ";
        fs += f.type + " " + f.name;
        if (f.initExpr != null) {
            fs += "=" + visit(f.initExpr);
        }
        return fs;
    }

    @Override
    public String visitClassNode(ClassNode node) {
        cls = node;
        String imports = "";// visit(node.imports).join("\r\n")
        String fs = "";
        String mdf = visitModifier(node.modifier);
        String pkg = "";
        String name = node.name;
        int dotIdx = name.lastIndexOf('.');
        if (dotIdx > 0) {
            pkg = name.substring(0, dotIdx);
            name = name.substring(dotIdx + 1);
        }
        String pkgStr = pkg.length()>0 ? "package " + pkg + ";" : "";
        String parentStr = "";
        if (node.parent != null) {
            parentStr = "extends " + node.parent.name;
        }
        String impStr = "";
        if (node.interfaces != null && node.interfaces.size() > 0) {
            List<String> interfaces = new LinkedList();
            for (ClassNode itf : node.interfaces) {
                interfaces.add(itf.name);
            }
            impStr = "implements " + String.join(",", interfaces);
        }
        String classType = node.isInterface ? "interface" : "class";
        c(pkgStr
                + "\r\n"
                + imports
                + "\r\n"
                + mdf
                + " "
                + classType
                + " "
                + name
                + " "
                + parentStr
                + " "
                + impStr
                + " {");
        for (FieldNode f : node.fields) {
            c(this.getVarStr(f) + ";\r\n");
        }
        visitAll(Arrays.asList(node.getMethodNodes()));
        c("}");
        return null;
    }

    @Override
    public String visitMethodNode(MethodNode node) {
        this.method = node;
        List<String> psList = new LinkedList<>();
        for (ParameterNode p : node.parameters) {
            psList.add(this.getVarStr(p));
        }
        String ps = String.join(",", psList);//.join(",");
        String exStr = "";
        if (node.exceptionTypes.size() > 0) {
            List<String> types = new ArrayList<>(node.exceptionTypes.size());
            for (Type et : node.exceptionTypes) {
                types.add(et.getName());
            }
            exStr = "throws " + String.join(",", types);//.join(",");
        }
        String mname = node.name;
        String typeStr = "";
        int mdf = node.modifier;
        if (mname.equals("<init>")) {
            mdf = mdf & (~Modifier.STATIC);
            int lastIdx = cls.name.lastIndexOf(".");
            if (lastIdx < 0) {
                mname = cls.name;
            } else {
                mname = cls.name.substring(lastIdx + 1);
            }
        } else {
            typeStr = node.type.getName();
        }
        c(visitModifier(mdf)
                + " "
                + typeStr
                + " "
                + mname
                + "("
                + ps
                + ")"
                + " "
                + exStr);
        if (node.body != null) {
            c(visit(node.body));
        } else {
            c(";");
        }
        return null;
    }

    @Override
    public String visitBlockStmt(BlockStmt node) {
        addCode("{");
        visitAll(node.statements);
        addCode("}");
        return null;
    }

    @Override
    public String visitBreakStmt(BreakStmt node) {
        addCode("break;");
        return null;
    }

    @Override
    public String visitContinueStmt(ContinueStmt node) {
        addCode("continue;");
        return null;
    }

    @Override
    public String visitExprStmt(ExprStmt node) {
        String expr = visit(node.getExpr());
        addCode(expr + ';');
        return null;
    }

    @Override
    public String visitIfStmt(IfStmt node) {
        String cdt = trimStmt(visit(node.getConditionExpr()));
        c("if(" + cdt + ")");
        visit(node.getTrueBody());
        if (node.getFalseBody() != null) {
            c("else");
            visit(node.getFalseBody());
        }
        return null;
    }

    @Override
    public String visitLoopStmt(LoopStmt node) {
        ExprNode pre = node.preConditionExpr;
        ExprNode post = node.postConditionExpr;
        if (pre != null) {
            c("for(");
            trim = true;
            visitAll(node.initStmts);
            trim = false;
            p(";");
            c(visit(pre));
            p(";");
            c(")");
            visit(node.loopBody);
        } else {
            c("do");
            visit(node.loopBody);
            c("while(");
            visit(post);
            c(");");
        }
        return null;
    }

    @Override
    public String visitReturnStmt(ReturnStmt node) {
        String expr = "";
        if (node.expr != null) {
            expr = visit(node.expr);
        }
        c("return"
                + " "
                + expr
                + ";");
        return null;
    }

    public void visitVarObject(VarObject var) {
        //varNames.put(node.varId,node.varName)
        String type = var.type != null ? var.type.getName() : "Object";
        type = className(type);
        String name = getVarName(var);
        String code = type
                + " "
                + name;
        if (null != var.initExpr) {
            code += "="
                    + visit(var.initExpr);
        }
        c(code + ";");
    }

    @Override
    public String visitAssignExpr(AssignExpr node) {
        String from = visit(node.getFrom());
        String to = visit(node.getTo());
        return to
                + "="
                + from;
    }

    @Override
    public String visitBinaryExpr(BinaryExpr node) {
        return "("
                + visit(node.getExpr1())
                + node.getOperation()
                + visit(node.getExpr2())
                + ")";
    }

    @Override
    public String visitConstExpr(ConstExpr node) {
        return toJavaString(node);
    }

    @Override
    public String visitElementExpr(ElementExpr node) {
        return visit(node.getArrayExpr())
                + "["
                + visit(node.getIndex())
                + "]";
    }

    @Override
    public String visitFieldExpr(FieldExpr node) {
        String target;
        //TODO super field"?
        if (node.getTarget() != null) {
            target = visit(node.getTarget());
        } else { //static field
            target = node.getField().classNode.name;
        }
        return target
                + "."
                + node.getField().name;
    }

    @Override
    public String visitInvocationExpr(InvocationExpr node) {
        String invokeTarget = null;
        if (node.getTarget() != null) {
            invokeTarget = visit(node.getTarget());
        }
        String args = String.join(",", visitAll(node.getArguments()));//.join(",");
        String mname = node.getMethod().name;
        if (mname.equals("<init>")) {
            ClassNode specialClass = node.getSpecialClass();
            if(cls.equals(specialClass)){
                return "this(" + args + ")";
            }else if(cls.isSubclassOf(specialClass)){
                return "super(" + args + ")";
            }else{
                throw new UnsupportedOperationException();
            }
        } else {
            if (invokeTarget != null && invokeTarget.length()>0) {
                invokeTarget += ".";
            }else{
                ClassNode specialClass = node.getSpecialClass();
node.getSpecialClass();
                if(AstUtil.isStatic(node.getMethod().modifier)){
                    invokeTarget = specialClass.name + ".";
                }else{
                    if(cls.equals(specialClass)){
                        invokeTarget = "";
                    }else{
                        invokeTarget = "super.";
                    }
                }
            }
            return invokeTarget
                    + node.getMethod().name
                    + "("
                    + args
                    + ")";
        }
    }

    @Override
    public String visitUnaryExpr(UnaryExpr node) {
        String expr = visit(node.getExpr());
        String op = node.getOperation();
        return "(" + op + expr + ")";
    }

    @Override
    public String visitNewArrayExpr(NewArrayExpr node) {
        String type = node.getComponentType().toString();
        return "new "
                + type
                + "["
                + visit(node.getSize())
                + "]";
    }

    @Override
    public String visitTryStmt(TryStmt node) {
        c("try");
        if(node.execStmt instanceof BlockStmt){
            visit(node.execStmt);
        }else{
            c("{");
            visit(node.execStmt);
            c("}");
        }     
        for (CatchBlock c : node.catchStmts) {
            visit(c);
        }
        if (node.finallyStmt != null) {
            c("finally ");
            if(node.finallyStmt instanceof BlockStmt){
                 visit(node.finallyStmt);
            }else{
                c("{");
                visit(node.finallyStmt);
                c("}");
            }           
        }
        return null;
    }

    @Override
    public String visitCatchBlock(CatchBlock node) {
        c("catch(");
        this.trim = true;
        visit(node.catchVar);
        this.trim = false;
        c(")");
        if(node.execStmt instanceof BlockStmt){
            visit(node.execStmt);
        }else{
            c("{");
            visit(node.execStmt);
            c("}");
        }
        
        return null;
    }

    @Override
    public String visitThisExpr(ThisExpr node) {
        return "this";
    }

    @Override
    public String visitMultiStmtExpr(MultiStmtExpr node) {
        for (Statement s : node.stmts) {
            visit(s);
        }
        return visit(node.reference);
    }

    @Override
    public String visitThrowStmt(ThrowStmt node) {
        String expr = visit(node.expr);
        c("throw " + expr + ";");
        return null;
    }

    @Override
    public String visitPrimitiveCastExpr(PrimitiveCastExpr node) {
        String expr = visit(node.getExpr());
        return "(" + node.getToType() + "/*" + node.getFromType() + "*/" + ")" + expr;
    }

    @Override
    public String visitLocalVarNode(LocalVarNode localVarNode) {
        visitVarObject(localVarNode);
        return null;
    }

    @Override
    public String visitParameterNode(ParameterNode parameterNode) {
        visitVarObject(parameterNode);
        return null;
    }

    @Override
    public String visitFieldNode(FieldNode fieldNode) {
        visitVarObject(fieldNode);
        return null;
    }

    @Override
    public String visitVarDeclStmt(VarDeclStmt node) {
        for (LocalVarNode v : node.vars) {
            visitVarObject(v);
        }
        return null;
    }

    @Override
    public String visitNewObjectExpr(NewObjectExpr node) {
        String args = "";
        if(node.getConstructor()!=null && node.getConstructor().getArguments()!=null){
            args = String.join(",", visitAll(Arrays.asList(node.getConstructor().getArguments())));
        }
        return String.format("new %s(%s)",className(node.getObjectType().toString()),args);
    }

    @Override
    public String visitIncrementExpr(IncrementExpr node) {
        String op=node.isIsDesc() ? "--" : "++";
        String vn = visit(node.getExpr());
        if(node.isIsPrefix()){
            return  op + vn;
        }else{
            return vn + op;
        }
    }

    @Override
    public String visitArrayLengthExpr(ArrayLengthExpr node) {
        return visit(node.getArrayExpr()) + ".length";
    }

    @Override
    public String visitUnknownFieldExpr(UnknownFieldExpr node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String visitUnknownInvocationExpr(UnknownInvocationExpr node) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}

package kalang.compiler;

import kalang.ast.*;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import kalang.core.Type;
import kalang.core.Types;

/**
 * The class output the ast as java source
 * 
 * @author Kason Yang <i@kasonyang.com>
 */
public class Ast2Java extends AbstractAstVisitor<String> {

    private List<VarObject> varList = new LinkedList<>();

    protected String code = "";
    private String indent = "";

    private boolean trim = false;

    private ClassNode cls;

    private MethodNode method;

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
        Object v = ce.value;
        if (v instanceof String) {
            return "\"" + v + "\"";
        } else if (ce.type == Types.CHAR_TYPE) {
            return "'" + v + "'";
        } else if(ce.type == Types.NULL_TYPE) {
            return "null";
        }else{
            return v.toString();
        }
    }

    public String generate(ClassNode cls) {
        code = "";
        visit(cls);
        return code;
    }
//	
//    private String indent(String str){
//        return "";
//	//return	"  " + str.readLines().join("\r\n  ");
//    }

    @Override
    public String visitCastExpr(CastExpr node) {
        return String.format("(%s)%s", node.type.toString(), visit(node.expr));
    }

    @Override
    public String visitParameterExpr(ParameterExpr node) {
        return node.parameter.name;
    }

//    @Override
//    public String visitNewExpr(NewExpr node) {
//        String args = String.join(",", visitAll(node.arguments)); //.join(",");
//        return String.format("new %s(%s)", node.type, args);
//    }

    @Override
    public String visitVarExpr(VarExpr node) {
        return this.getVarName(node.var);
    }

    @Override
    public String visitClassExpr(ClassExpr node) {
        return node.name;
    }

    public String visitModifier(Integer modifier) {
        int m = modifier != null ? modifier : 0;
        return Modifier.toString(m);
    }

    String getVarStr(VarObject f) {
        String fs = "";
        String mdf = "";
        if (f.modifier != null) {
            fs += Modifier.toString(f.modifier) + " ";
        }
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
        String classType = node.isInterface != null ? "interface" : "class";
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
        String expr = visit(node.expr);
        addCode(expr + ';');
        return null;
    }

    @Override
    public String visitIfStmt(IfStmt node) {
        String cdt = trimStmt(visit(node.conditionExpr));
        c("if(" + cdt + ")");
        visit(node.trueBody);
        if (node.falseBody != null) {
            c("else");
            visit(node.falseBody);
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
        String from = visit(node.from);
        String to = visit(node.to);
        return to
                + "="
                + from;
    }

    @Override
    public String visitBinaryExpr(BinaryExpr node) {
        return "(("
                + visit(node.expr1)
                + ") "
                + node.operation
                + "("
                + visit(node.expr2)
                + ") )";
    }

    @Override
    public String visitConstExpr(ConstExpr node) {
        return toJavaString(node);
    }

    @Override
    public String visitElementExpr(ElementExpr node) {
        return visit(node.arrayExpr)
                + "["
                + visit(node.index)
                + "]";
    }

    @Override
    public String visitFieldExpr(FieldExpr node) {
        String target;
        if (node.target != null) {
            target = visit(node.target);
        } else if (Modifier.isStatic(this.method.modifier)) {
            target = cls.name;
        } else {
            target = "this";
        }
        return target
                + "."
                + node.fieldName;
    }

    @Override
    public String visitInvocationExpr(InvocationExpr node) {
        String targetType = null;
        if (node.target != null) {
            targetType = visit(node.target);
        }
        String args = String.join(",", visitAll(node.arguments));//.join(",");
        String mname = node.methodName;
        if (mname.equals("<init>")) {
            if (node.target instanceof KeyExpr) {
                KeyExpr keyExpr = (KeyExpr) node.target;
                return keyExpr.key
                        + "("
                        + args
                        + ")";
            } else {
                return "new "
                        + targetType
                        + "("
                        + args
                        + ")";
            }
        } else {
            if (targetType != null && targetType.length()>0) {
                targetType += ".";
            }else{
                targetType = "";
            }
            return targetType
                    + node.methodName
                    + "("
                    + args
                    + ")";
        }
    }

    @Override
    public String visitUnaryExpr(UnaryExpr node) {
        return (node.preOperation != null ? node.preOperation : "")
                + visit(node.expr)
                + (node.postOperation != null ? node.postOperation : "");
    }

    @Override
    public String visitNewArrayExpr(NewArrayExpr node) {
        String type = node.type.toString();
        return "new "
                + type
                + "["
                + visit(node.size)
                + "]";
    }

    @Override
    public String visitTryStmt(TryStmt node) {
        c("try");
        visit(node.execStmt);
        for (CatchStmt c : node.catchStmts) {
            visit(c);
        }
        if (node.finallyStmt != null) {
            c("finally ");
            visit(node.finallyStmt);
        }
        return null;
    }

    @Override
    public String visitCatchStmt(CatchStmt node) {
        c("catch(");
        this.trim = true;
        visit(node.catchVarDecl);
        this.trim = false;
        c(")");
        visit(node.execStmt);
        return null;
    }

    @Override
    public String visitKeyExpr(KeyExpr node) {
        return node.key;
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
        c("throws " + expr + ";");
        return null;
    }

    @Override
    public String visitPrimitiveCastExpr(PrimitiveCastExpr node) {
        String expr = visit(node.expr);
        return "(" + node.toType + "/*" + node.fromType + "*/" + ")" + expr;
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
        if(node.arguments!=null){
            args = String.join(",", visitAll(Arrays.asList(node.arguments)));
        }
        return String.format("new %s(%s)", node.objectType,args);
    }

}

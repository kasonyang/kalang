package kalang.compiler

import jast.ast.AbstractAstVisitor
import jast.ast.AssignExpr;
import jast.ast.BinaryExpr;
import jast.ast.BlockStmt;
import jast.ast.BreakStmt;
import jast.ast.CastExpr;
import jast.ast.CatchStmt;
import jast.ast.ClassExpr;
import jast.ast.ClassNode;
import jast.ast.ConstExpr;
import jast.ast.ContinueStmt;
import jast.ast.ElementExpr;
import jast.ast.ExprNode;
import jast.ast.ExprStmt;
import jast.ast.FieldExpr;
import jast.ast.FieldNode;
import jast.ast.FinallyStmt;
import jast.ast.IAstVisitor
import jast.ast.AstVisitor
import jast.ast.IfStmt;
import jast.ast.InvocationExpr;
import jast.ast.LoopStmt;
import jast.ast.MethodNode;
import jast.ast.NewArrayExpr
import jast.ast.NewExpr;
import jast.ast.ParameterExpr;
import jast.ast.ParameterNode;
import jast.ast.ReturnStmt;
import jast.ast.Statement;
import jast.ast.TryStmt;
import jast.ast.UnaryExpr;
import jast.ast.VarDeclStmt;
import jast.ast.VarExpr;
import jast.ast.VarObject

import java.lang.reflect.Modifier
import java.util.prefs.AbstractPreferences.NodeAddedEvent;
@groovy.transform.TypeChecked
class Ast2Java extends AbstractAstVisitor<String>{
	
	List<VarObject> varList = []
    
    protected String code = "";
	
	private ClassNode cls;
	
	private MethodNode method
	
	private String getVarName(VarObject vo){
		String name = vo.name
		String tmpNamePrefix = "tmp"
		if(name==null || name.startsWith(tmpNamePrefix)){
			if(!varList.contains(vo)){
				varList.add(vo)
			}
			name = tmpNamePrefix + "_" + varList.indexOf(vo)
		}
		return name;
	}
	
	private List<String> trimStmtAll(List<String> stmts){
		List retList = []
		for(s in stmts){
			retList.add(trimStmt(s));
		}
		return retList
	}
    
    private String trimStmt(String stmt){
        stmt = stmt.trim();
		if(stmt.endsWith(";")){
            stmt = stmt.substring(0,stmt.length()-1);
        }
        return stmt;
    }
    
    
    private String toJavaString(ConstExpr ce){
        Object v = ce.value;
        if(v instanceof String){
            return "\"${v}\""
        }else if(ce.type == 'char'){
            return "'${v}'"
        }else{
            return v;
        }
    }

    public String generate(ClassNode cls){
        return visit(cls)
    }
	
	private String indent(String str){
		"  " + str.readLines().join("\r\n  ")
	}
	
    @Override
    public String visitCastExpr(CastExpr node) {
		"(${node.type}) ${visit(node.expr)}"
    }

    @Override
    public String visitParameterExpr(ParameterExpr node) {
		"${node.parameter.name}"
    }

    @Override
    public String visitNewExpr(NewExpr node) {
        def args = visit(node.arguments).join(",")
		"new ${node.type}(${args})"
    }
	
    @Override
    public String visitVarExpr(VarExpr node) {
		return this.getVarName(node.var)
    }

    @Override
    public String visitClassExpr(ClassExpr node) {
        return node.name
    }
	
    public String visitModifier(Integer modifier){
        int m = modifier?:0
        return Modifier.toString(m)
    }
	
	String getVarStr(VarObject f){
		String fs = ""
		String mdf = ""
		if(f.modifier){
			fs += Modifier.toString(f.modifier) + " "
		}
		fs += "${f.type} ${f.name}"
		if(f.initExpr){
			fs += "=${visit(f.initExpr)}"
		}
		return fs;
	}
	
    @Override
    public String visitClassNode(ClassNode node) {
		cls = node
        String imports = ""// visit(node.imports).join("\r\n")
        String fs = ""
		for(f in node.fields){
			fs += this.getVarStr(f) + ";\r\n";
		}
        String mds = visit(node.methods).join("\r\n");
        String mdf = visitModifier( node.modifier )
        def pkg = ""
        def name = node.name
        def dotIdx = name.lastIndexOf('.');
        if(dotIdx>0){
            pkg = name.substring(0,dotIdx)
            name = name.substring(dotIdx+1)
        }
        String pkgStr = pkg?"package ${pkg};":""
        String parentStr = node.parentName ? " extends ${node.parentName}" :""
        String impStr = ""
        if(node.interfaces && node.interfaces.size()>0){
            impStr = "implements ${node.interfaces.join(",")}"
        }
        String classType = node.isInterface ? "interface" : "class"
        return "${pkgStr}\r\n${imports}\r\n${mdf} ${classType} ${name} ${parentStr} ${impStr} {\r\n${indent(fs)}\r\n${indent(mds)}\r\n}"
    }

    @Override
    public String visitMethodNode(MethodNode node) {
		this.method = node
		List<String> psList = []
		for(p in node.parameters){
			psList.add(this.getVarStr(p))
		}
        String ps = psList.join(",")
        String body = ";";
        if(node.body){
            body = visit(node.body)
        }
		String exStr = ""
		if(node.exceptionTypes?.size()>0){
			exStr = "throws " + node.exceptionTypes.join(",")
		}
		String mname = node.name
		String typeStr = ""
		if(mname=="<init>"){
			mname = cls.name
		}else{
			typeStr = node.type
		}
        "${visitModifier(node.modifier)} ${typeStr} ${mname}(${ps}) ${exStr} ${(body)}"
    }

    @Override
    public String visitBlockStmt(BlockStmt node) {
        String body = visit(node.statements).join("\r\n")
		"\r\n{\r\n${indent(body)}" + "\r\n}\r\n"
    }

    @Override
    public String visitBreakStmt(BreakStmt node) {
        "break;"
    }

    @Override
    public String visitContinueStmt(ContinueStmt node) {
        "continue;"
    }

    @Override
    public String visitExprStmt(ExprStmt node) {
        return visit(node.expr) +';';
    }

    @Override
    public String visitIfStmt(IfStmt node) {
        def cdt = trimStmt(visit(node.conditionExpr));
        def trueStmt = trimStmt(visit(node.trueBody));
        def falseStmt;
        String res = "if(${cdt})${trueStmt}"
        if(node.falseBody){
			String falseBody =trimStmt(visit(node.falseBody))
			res += "\r\n" + "else ${falseBody}"
        }
        return  res + ";";
    }

    /*@Override
    public String visitImportNode(ImportNode node) {
    "import ${node.name};"
    }*/

    @Override
    public String visitLoopStmt(LoopStmt node) {
        def pre = node.preConditionExpr;
        def post = node.postConditionExpr;
        def init = trimStmtAll(visit(node.initStmts)).join(",");
        def body = visit(node.loopBody)
        if(pre){
            return "for(${trimStmt(init)};${trimStmt(visit(pre))};)${body}"
        }else{
            return "do{${body}}while(${visit(post)});"
        }
    }

    @Override
    public String visitReturnStmt(ReturnStmt node) {
		String expr = "";
		if(node.expr!=null){
			expr = visit(node.expr);
		}
        "return ${expr};"
    }

    @Override
    public String visitVarDeclStmt(VarDeclStmt node) {
        //varNames.put(node.varId,node.varName)
        String type = node.var.type ?: "Object";
        String name = node.var.name
        if(!name){
            name = getVarName(node.var)
        }
        String code = "${type} ${name}"
        if(node.var.initExpr){
            code+= "=${visit(node.var.initExpr)}"
        }
        code + ";"
    }

    @Override
    public String visitAssignExpr(AssignExpr node) {
		"${visit(node.to)}=${visit(node.from)}"
    }

    @Override
    public String visitBinaryExpr(BinaryExpr node) {
		"(${visit(node.expr1)}${node.operation}${visit(node.expr2)})"
    }

    @Override
    public String visitConstExpr(ConstExpr node) {
        "${toJavaString(node)}"
    }

    @Override
    public String visitElementExpr(ElementExpr node) {
		"${visit(node.target)}[${visit(node.key)}]"
    }

    @Override
    public String visitFieldExpr(FieldExpr node) {
        def target
        if(node.target){
            target = visit(node.target)
        }else{
			if(Modifier.isStatic(this.method.modifier)){
				target = cls.name
			}else{
				target = "this"
			}
        }
		"${target}.${node.fieldName}"
    }

    @Override
    public String visitInvocationExpr(InvocationExpr node) {
        def target = node.target ? "${visit(node.target)}" : ""
        def args = visit(node.arguments).join(",");
		String mname = node.methodName
		if(mname=="<init>"){
			return "new ${target}(${args})"
		}else{
			if(target) target+= "."
			"${target}${node.methodName}($args)"
		}
    }

    @Override
    public String visitUnaryExpr(UnaryExpr node) {
		"${node.preOperation?:''}${visit(node.expr)}${node.postOperation?:''}"
    }
    
    @Override
    public String visitNewArrayExpr(NewArrayExpr node){
        String type = node.type
        "new ${type}[${visit(node.size)}]"
    }


	@Override
	public String visitTryStmt(TryStmt node) {
		String exec = visit(node.execStmt);
		String catchStmt = "";
		for(def c:node.catchStmts){
			catchStmt += visit(c)
		}
		String finallyStmt = ""
		if(node.finallyStmt){
			finallyStmt = "finally " + visit(node.finallyStmt);
		}
		"try ${exec}\r\n${catchStmt}\r\n${finallyStmt}"
	}


	@Override
	public String visitCatchStmt(CatchStmt node) {
		String varDecl = this.trimStmt(visit(node.catchVarDecl));
		String exec = visit(node.execStmt);
		"catch(${varDecl}) ${exec}";
	}

}

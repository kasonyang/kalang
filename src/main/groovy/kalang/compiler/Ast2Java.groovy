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

import java.lang.reflect.Modifier
import java.util.prefs.AbstractPreferences.NodeAddedEvent;
@groovy.transform.TypeChecked
class Ast2Java extends AbstractAstVisitor<String>{

    HashMap<Integer,String> varNames = [:]
    
    protected String code = "";
	
    private String stmtDelim = ";"
	
    private String indent = "";
    
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
	
    @Override
    public String visitCastExpr(CastExpr node) {
		"(${node.type}) ${visit(node.expr)}"
    }

    @Override
    public String visitParameterNode(ParameterNode node) {
        return "${node.type} ${node.name}"
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
        def var = node.declStmt.varName
        if(!var){
            var = "tmp_" + node.varId
        }
        return var
    }

    @Override
    public String visitClassExpr(ClassExpr node) {
        return node.name
    }
	
    private void incIndent(){
        indent += "  "
    }
	
    private void decIndent(){
        indent = indent.substring(0,indent.length()-2)
    }
	
    public String visitModifier(Integer modifier){
        int m = modifier?:0
        return Modifier.toString(m)
    }
	
    @Override
    public String visitClassNode(ClassNode node) {
        String imports = ""// visit(node.imports).join("\r\n")
        incIndent()
        String fs = visit(node.fields).join("\r\n");
        String mds = visit(node.methods).join("\r\n");
        decIndent()
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
        return "${pkgStr}\r\n${imports}\r\n${mdf} ${classType} ${name} ${parentStr} ${impStr} {\r\n${fs}\r\n${mds}\r\n}"
    }

    @Override
    public String visitFieldNode(FieldNode node) {
        String type = node.type ?: "Object"
        indent + "${visitModifier(node.modifier)} ${type} ${node.name}" +(node.initExpr?"=${visit(node.initExpr)}":"") +";"
    }

    @Override
    public String visitMethodNode(MethodNode node) {
        this.stmtDelim = ""
        String ps = visit(node.parameters).join(",")
        this.stmtDelim = ";"
        incIndent()
        String body = ";";
        if(node.body){
            body = visit(node.body)
        }
        decIndent()
		String exStr = ""
		if(node.exceptionTypes?.size()>0){
			exStr = "throws " + node.exceptionTypes.join(",")
		}
        indent + "${visitModifier(node.modifier)} ${node.type} ${node.name}(${ps}) ${exStr} ${body}"
    }

    @Override
    public String visitBlockStmt(BlockStmt node) {
        incIndent()
        String body = visit(node.statements).join("\r\n")
        decIndent()
		"{\n${body}\n" + indent + "}"
    }

    @Override
    public String visitBreakStmt(BreakStmt node) {
        indent + "break;"
    }

    @Override
    public String visitContinueStmt(ContinueStmt node) {
        indent + "continue;"
    }

    @Override
    public String visitExprStmt(ExprStmt node) {
        return indent + visit(node.expr) +';';
    }

    @Override
    public String visitIfStmt(IfStmt node) {
        def cdt = trimStmt(visit(node.conditionExpr));
        def trueStmt = trimStmt(visit(node.trueBody));
        def falseStmt;
        String res = "if(${cdt})${trueStmt}"
        if(node.falseBody){
			String falseBody =trimStmt(visit(node.falseBody))
			res += "\r\n" + indent + "else ${falseBody}"
        }
        return indent + res + ";";
    }

    /*@Override
    public String visitImportNode(ImportNode node) {
    "import ${node.name};"
    }*/

    @Override
    public String visitLoopStmt(LoopStmt node) {
        def oldIndent = this.indent
        this.indent = ""
        def pre = node.preConditionExpr;
        def post = node.postConditionExpr;
        this.stmtDelim = ""
        def init = visit(node.initStmts).join(",");
        this.stmtDelim = ";"
        this.indent = oldIndent
        def body = visit(node.loopBody)
        if(pre){
            return indent + "for(${init};${visit(pre)};)${body}"
        }else{
            return indent + "do{${body}}while(${visit(post)});"
        }
    }

    @Override
    public String visitReturnStmt(ReturnStmt node) {
        indent + "return ${visit(node.expr)};"
    }

    @Override
    public String visitVarDeclStmt(VarDeclStmt node) {
        varNames.put(node.varId,node.varName)
        String type = node.type ?: "Object";
        String name = node.varName
        if(!name){
            name = "tmp_" + node.varId
        }
        String code = "${type} ${name}"
        if(node.initExpr){
            code+= "=${visit(node.initExpr)}"
        }
        indent + code + this.stmtDelim;
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
        def target = "" 
        if(node.target){
            target = visit(node.target) + "."
        }
		"${target}${node.fieldName}"
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
			finallyStmt = indent + "finally " + visit(node.finallyStmt);
		}
		indent + "try ${exec}\r\n${catchStmt}\r\n${finallyStmt}"
	}


	@Override
	public String visitCatchStmt(CatchStmt node) {
		String varDecl = this.trimStmt(visit(node.catchVarDecl));
		String exec = visit(node.execStmt);
		indent + "catch(${varDecl}) ${exec}";
	}

}

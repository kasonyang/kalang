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
import jast.ast.IAstVisitor
import jast.ast.AstVisitor
import jast.ast.IfStmt;
import jast.ast.InvocationExpr;
import jast.ast.KeyExpr;
import jast.ast.LoopStmt;
import jast.ast.MethodNode;
import jast.ast.MultiStmtExpr;
import jast.ast.NewArrayExpr
import jast.ast.NewExpr;
import jast.ast.ParameterExpr;
import jast.ast.ReturnStmt;
import jast.ast.Statement;
import jast.ast.ThrowStmt;
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
	private String indent = "";
	
	private trim = false;
	
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
	
	private void p(String code){
		this.code += code;
	}
	
    private void c(String code){
        addCode(code)
    }
    private void addCode(String code){
		if(code==null) return
		code = code.trim();
        if(code.endsWith("}")){
            if(indent.length()>=4){
                indent = indent.substring(4)
            }
			code = "\r\n" + indent + code + "\r\n"
			code += indent
        }
        if(code.endsWith("{")){
            indent += "    ";
			code += "\r\n" + indent
        }
        if(code.endsWith(";")){
			if(trim) code = code.substring(0,code.length()-1);
            else code += "\r\n" + indent
        }
        this.code += code + " "
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
        code = "";
        visit(cls)
        return code
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
        return node.parameter.name;
        //"${node.var.name}"
    }

    @Override
    public String visitNewExpr(NewExpr node) {
        def args = visitAll(node.arguments).join(",")
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
        c "${pkgStr}\r\n${imports}\r\n${mdf} ${classType} ${name} ${parentStr} ${impStr} {"
        for(f in node.fields){
            c this.getVarStr(f) + ";\r\n";
        }
        visitAll(node.methods);
        c "}"
    }

    @Override
    public String visitMethodNode(MethodNode node) {
        this.method = node
        List<String> psList = []
        for(p in node.parameters){
            psList.add(this.getVarStr(p))
        }
        String ps = psList.join(",")
        String exStr = ""
        if(node.exceptionTypes?.size()>0){
            exStr = "throws " + node.exceptionTypes.join(",")
        }
        String mname = node.name
        String typeStr = ""
        if(mname=="<init>"){
            int lastIdx = cls.name.lastIndexOf(".");
            if(lastIdx<0){
                mname = cls.name
            }else{
                mname = cls.name.substring(lastIdx+1)
            }
        }else{
            typeStr = node.type
        }
        c "${visitModifier(node.modifier)} ${typeStr} ${mname}(${ps}) ${exStr}"
        if(node.body){
            c visit(node.body)
        }else{
            c ";"
        }
    }

    @Override
    public String visitBlockStmt(BlockStmt node) {
        addCode "{"
        visitAll(node.statements)
        addCode "}"
    }

    @Override
    public String visitBreakStmt(BreakStmt node) {
        addCode "break;"
    }

    @Override
    public String visitContinueStmt(ContinueStmt node) {
        addCode "continue;"
    }

    @Override
    public String visitExprStmt(ExprStmt node) {
        String expr = visit(node.expr)
        addCode expr+';'
    }

    @Override
    public String visitIfStmt(IfStmt node) {
        def cdt = trimStmt(visit(node.conditionExpr));
        c "if(" + cdt + ")"
        visit(node.trueBody)
        if(node.falseBody){
            c "else"
            (visit(node.falseBody))
        }
    }

    /*@Override
    public String visitImportNode(ImportNode node) {
    "import ${node.name};"
    }*/

    @Override
    public String visitLoopStmt(LoopStmt node) {
        def pre = node.preConditionExpr;
        def post = node.postConditionExpr;
        if(pre){
            c "for("
			trim = true;
            visitAll(node.initStmts)
            trim = false;
			p ";"
            c visit(pre)
            p ";"
            c ")"
            visit(node.loopBody)
        }else{
            c "do"
            visit(node.loopBody)
            c "while("
            visit(post)
            c ");"
        }
    }

    @Override
    public String visitReturnStmt(ReturnStmt node) {
        String expr = "";
        if(node.expr!=null){
            expr = visit(node.expr);
        }
        c "return ${expr};"
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
        c (code + ";")
    }

    @Override
    public String visitAssignExpr(AssignExpr node) {
        String from = visit(node.from)
        String to = visit(node.to)
        return "${to}=${from}"
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
        def args = visitAll(node.arguments).join(",");
        String mname = node.methodName
        if(mname=="<init>"){
            if(node.target instanceof KeyExpr){
                KeyExpr keyExpr = (KeyExpr) node.target
                return "${keyExpr.key}(${args})";
            }else return "new ${target}(${args})";
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
		c 'try'
        visit(node.execStmt);
        for(def c:node.catchStmts){
            visit(c)
        }
        if(node.finallyStmt){
            c "finally "
			visit(node.finallyStmt);
        }
    }


    @Override
    public String visitCatchStmt(CatchStmt node) {
        c 'catch('
		this.trim = true;
		visit(node.catchVarDecl);
		this.trim = false;
		c ')'
        visit(node.execStmt);
    }

    @Override
    public String visitKeyExpr(KeyExpr node) {
        return node.key
    }

    @Override
    public String visitMultiStmtExpr(MultiStmtExpr node) {
        for(s in node.stmts) visit(s)
        return visit(node.reference);
    }

	@Override
	public String visitThrowStmt(ThrowStmt node) {
		String expr = visit(node.expr);
		c "throws " + expr + ";";
		return null;
	}

}

package kalang.compiler.compile.analyzer;

import kalang.compiler.ast.*;
import kalang.compiler.compile.Diagnosis;
import kalang.compiler.compile.DiagnosisReporter;
import kalang.compiler.compile.OffsetRange;
import kalang.compiler.core.Type;
import kalang.compiler.core.VarTable;
import kalang.compiler.exception.Exceptions;
import kalang.compiler.util.AstUtil;
import kalang.compiler.util.CollectionsUtil;
import kalang.compiler.util.ModifierUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The assignment analyzer class.
 *
 * @author Kason Yang
 */
public class AssignmentAnalyzer extends AstVisitor<Object> {

    private VarTable<VarObject, Void> assignedVars;

    private DiagnosisReporter diagnosisReporter;
    
    private boolean returned;

    private MethodNode method;

    public AssignmentAnalyzer(DiagnosisReporter diagnosisReporter) {
        this.diagnosisReporter = diagnosisReporter;
    }

    public void analyze(ClassNode clazz) {
        visit(clazz);
    }

    @Override
    public Object visit(AstNode node) {
        if (node == null) {
            return null;
        }
        if (node instanceof VarExpr) {
            if (!assignedVars.exist(((VarExpr) node).getVar(), true)) {
                this.diagnosisReporter.report(Diagnosis.Kind.ERROR
                        , ((VarExpr) node).getVar().getName() + " is uninitialized!", ((VarExpr) node).offset);
            }
        }
        return super.visit(node);
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        AssignableExpr to = node.getTo();
        if (to instanceof VarExpr) {
            LocalVarNode varObj = ((VarExpr) to).getVar();
            validateModifier(varObj, node.offset);
            assignedVars.put(varObj, null);
        } else if (to instanceof FieldExpr) {
            FieldNode varObj = ((FieldExpr) to).getField().getFieldNode();
            if (ModifierUtil.isFinal(varObj.modifier)) {
                if (AstUtil.isConstructor(method)) {
                    validateModifier(varObj, node.offset);
                } else {
                    reportAssignFinalVarError(varObj, node.offset);
                }
            }
            assignedVars.put(varObj, null);
        } else if (to instanceof ParameterExpr) {
            ParameterNode varObj = ((ParameterExpr) to).getParameter();
            if (ModifierUtil.isFinal(varObj.modifier)) {
                reportAssignFinalVarError(varObj, node.offset);
            }
        } else if (to instanceof ElementExpr) {
            //do nothing
        } else {
            throw Exceptions.unsupportedTypeException(to);
        }
        return super.visitAssignExpr(node);
    }

    @Override
    public Type visitTryStmt(TryStmt node) {
        List<VarTable<VarObject, Void>> assignedList = new ArrayList(node.getCatchStmts().size() + 1);
        enterNewFrame();
        if (!visitAndCheckReturned(node.getExecStmt())){
            assignedList.add(assignedVars);
        }
        exitFrame();
        for (CatchBlock cs : node.getCatchStmts()) {
            enterNewFrame();
            if (!visitAndCheckReturned(cs)){
                assignedList.add(assignedVars);
            }
            exitFrame();
        }
        addIntersectedAssignedVar(assignedList);
        Statement finallyStmt = node.getFinallyStmt();
        if (finallyStmt != null) {
            visit(finallyStmt);
        }
        return null;
    }

    @Override
    public Type visitIfStmt(IfStmt node) {
        List<VarTable<VarObject, Void>> assignedVarsList = new ArrayList(2);
        enterNewFrame();
        if (!visitAndCheckReturned(node.getTrueBody())){
            assignedVarsList.add(assignedVars);
        }
        exitFrame();
        enterNewFrame();
        if (!visitAndCheckReturned(node.getFalseBody())){
            assignedVarsList.add(assignedVars);
        }
        exitFrame();        
        addIntersectedAssignedVar(assignedVarsList);
        return null;
    }

    @Override
    public Type visitLoopStmt(LoopStmt node) {
        visit(node.getPreConditionExpr());
        enterNewFrame();
        visit(node.getLoopBody());
        exitFrame();
        enterNewFrame();
        visit(node.getUpdateStmt());
        exitFrame();
        visit(node.getPostConditionExpr());
        return null;
    }

    @Override
    public Object visitMethodNode(MethodNode node) {
        method = node;
        returned = false;
        assignedVars = new VarTable<>();
        return super.visitMethodNode(node);
    }

    protected void enterNewFrame() {
        assignedVars = new VarTable<>(assignedVars);
    }

    protected void exitFrame() {
        assignedVars = assignedVars.getParent();
    }

    protected void addIntersectedAssignedVar(List<VarTable<VarObject, Void>> assignedVarsList) {
        if (assignedVarsList.isEmpty()){
            return;
        }
        if (assignedVarsList.size()==1){
            for(Map.Entry<VarObject, Void> s:assignedVarsList.get(0).vars().entrySet()){
                assignedVars.put(s.getKey(), null);
            }
            return;
        }
        Set<VarObject>[] assigned = new Set[assignedVarsList.size()];
        for (int i = 0; i < assigned.length; i++) {
            assigned[i] = assignedVarsList.get(i).keySet();
        }
        Set<VarObject> sets = CollectionsUtil.getIntersection(assigned);
        for (VarObject s : sets) {
            assignedVars.put(s, null);
        }
    }

    @Override
    public Object visitCatchBlock(CatchBlock node) {
        assignedVars.put(node.catchVar, null);
        return super.visitCatchBlock(node);
    }

    @Override
    public Object visitReturnStmt(ReturnStmt node) {
        returned = true;
        return super.visitReturnStmt(node);
    }

    @Override
    public Object visitThrowStmt(ThrowStmt node) {
        returned = true;
        return super.visitThrowStmt(node);
    }
    
    private boolean visitAndCheckReturned(AstNode node){
        boolean oldReturned = returned;
        returned = false;
        visit(node);
        boolean ret = returned;
        returned = oldReturned;
        return ret;
    }

    private void validateModifier(VarObject toVarObj, OffsetRange offset) {
        if (ModifierUtil.isFinal(toVarObj.modifier) && assignedVars.exist(toVarObj)) {
            reportAssignFinalVarError(toVarObj, offset);
        }
    }

    private void reportAssignFinalVarError(VarObject toVarObj, OffsetRange offset) {
        diagnosisReporter.report(Diagnosis.Kind.ERROR, "cannot assign a value to final variable " + toVarObj.getName(), offset);
    }
    
}

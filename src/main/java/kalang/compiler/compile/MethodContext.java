package kalang.compiler.compile;

import kalang.compiler.ast.*;
import kalang.compiler.core.*;
import kalang.compiler.exception.Exceptions;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MethodContext {

    public static final int NULLSTATE_MUST_NULL = 0,
            NULLSTATE_MUST_NONNULL = 1,
            NULLSTATE_UNKNOWN = 2,
            NULLSTATE_NULLABLE = 3;

    public final ClassNode classNode;

    public final MethodNode method;

    public boolean returned = false;

    public VarTable<String,LocalVarNode> varTables = new VarTable();

    public VarTable<VarObject, Type> overrideTypes = new VarTable();

    public VarTable<VarObject,Integer> nullState = new VarTable();

    public MethodContext(ClassNode classNode, MethodNode methodNode) {
        this.classNode = classNode;
        this.method = methodNode;
    }

    public void newFrame(){
        this.varTables = varTables.newStack();
    }

    public void popFrame(){
        this.varTables = this.varTables.popStack();
    }

    public void onAssign(ExprNode to,ExprNode expr){
        removeOverrideType(to);
        if(to instanceof VarExpr){
            ((VarExpr)to).removeOverrideType();
        }else if(to instanceof ParameterExpr){
            ((ParameterExpr) to).removeOverrideType();
        }
        VarObject key = getOverrideTypeKey(to);
        if(key!=null){
            Type toType = to.getType();
            if(toType instanceof ObjectType){
                Type type = expr.getType();
                int ns;
                if(Types.NULL_TYPE.equals(type)){
                    ns = NULLSTATE_MUST_NULL;
                }else if(type instanceof ObjectType){
                    ns = getNullState(((ObjectType) type).getNullable());
                }else{
                    throw Exceptions.unexpectedValue(type);
                }
                nullState.put(key, ns);
            }
        }
    }

    public void onIf(ExprNode expr, boolean onTrue){
        if(expr instanceof InstanceOfExpr && onTrue){
            InstanceOfExpr ie = (InstanceOfExpr) expr;
            changeTypeTemporarilyIfCould(ie.getExpr(), Types.getClassType(ie.getTarget().getReferencedClassNode()));
        } else if(expr instanceof CompareBinaryExpr) {
            CompareBinaryExpr ce = (CompareBinaryExpr) expr;
            ExprNode e1 = ce.getExpr1();
            ExprNode e2 = ce.getExpr2();
            boolean isEQ = ce.getOperation().equals(CompareBinaryExpr.OP_EQ);
            if (e1.getType().equals(Types.NULL_TYPE)) {
                onNull(e2, onTrue, isEQ);
            } else if (e2.getType().equals(Types.NULL_TYPE)) {
                onNull(e1, onTrue, isEQ);
            }
        } else if (expr instanceof StaticInvokeExpr) {
            StaticInvokeExpr sie = (StaticInvokeExpr) expr;
            ExprNode[] args = sie.getArguments();
            if (args==null || args.length != 2) {
                return;
            }
            String invokeClass = sie.getInvokeClass().getReferencedClassNode().name;
            if (!Objects.class.getName().equals(invokeClass)) {
                return;
            }
            String methodName = sie.getMethod().getName();
            if (!"equals".equals(methodName) && !"deepEquals".equals(methodName)) {
                return;
            }
            if (Types.NULL_TYPE.equals(args[0].getType())) {
                onNull(args[1],onTrue,true);
            } else if (Types.NULL_TYPE.equals(args[1].getType())) {
                onNull(args[0],onTrue,true);
            }
        } else if(expr instanceof UnaryExpr){
            onIf(((UnaryExpr) expr).getExpr(),!onTrue);
        } else if(expr instanceof LogicBinaryExpr){
            LogicBinaryExpr le = (LogicBinaryExpr) expr;
            if(le.getOperation().equals(LogicBinaryExpr.OP_LOGIC_AND)){
                if(onTrue){
                    onIf(le.getExpr1(),true);
                    onIf(le.getExpr2(),true);
                }
            }else if(le.getOperation().equals(LogicBinaryExpr.OP_LOGIC_OR)){
                if(!onTrue){
                    onIf(le.getExpr1(),false);
                    onIf(le.getExpr2(),false);
                }
            }
        }

    }

    public Type getVarObjectType(VarObject p) {
        Type type = overrideTypes.get(p);
        if(type==null) type = p.getType();
        //TODO handle other object type
        if(type instanceof ClassType){
            Integer ns = nullState.get(p);
            NullableKind nullable;
            if(ns==null){
                nullable = ((ObjectType) type).getNullable();
            }else if(ns==NULLSTATE_MUST_NONNULL){
                nullable = NullableKind.NONNULL;
            }else if(ns==NULLSTATE_UNKNOWN){
                nullable = NullableKind.UNKNOWN;
            }else if(ns==NULLSTATE_MUST_NULL|| ns== NULLSTATE_NULLABLE){
                nullable = NullableKind.NULLABLE;
            }else{
                throw Exceptions.unexpectedValue(ns);
            }
            return Types.getClassType((ClassType)type,nullable);
        }else{
            return type;
        }
    }

    public void handleMultiBranchedAssign(Map<VarObject,Integer>... assignedTable){
        if(assignedTable.length<2){
            throw Exceptions.illegalArgument(assignedTable);
        }
        HashMap<VarObject,Integer> ret = new HashMap();
        ret.putAll(assignedTable[0]);
        for(int i=1;i<assignedTable.length;i++){
            Map<VarObject,Integer> other = assignedTable[i];
            for(Map.Entry<VarObject,Integer> e:ret.entrySet()){
                Integer oneNullable = e.getValue();
                Integer otherNullable = other.get(e.getKey());
                if(oneNullable.equals(otherNullable)) continue;
                if(otherNullable==null) ret.remove(e.getKey());
                else{
                    int ns;
                    if(
                            (oneNullable.equals(NULLSTATE_MUST_NONNULL) && otherNullable.equals(NULLSTATE_UNKNOWN))                           || (otherNullable.equals(NULLSTATE_MUST_NONNULL) && oneNullable.equals(NULLSTATE_UNKNOWN))
                    ){
                        ns = NULLSTATE_UNKNOWN;
                    }else{
                        ns = NULLSTATE_NULLABLE;
                    }
                    ret.put(e.getKey(),ns);
                }
            }
        }
        for(Map.Entry<VarObject,Integer> e:ret.entrySet()){
            nullState.put(e.getKey(), e.getValue());
        }
    }

    @Nullable
    public LocalVarNode getNamedLocalVar(String name){
        return varTables.get(name);
    }

    public void newOverrideTypeStack(){
        overrideTypes = new VarTable(overrideTypes);
    }

    public void popOverrideTypeStack(){
        overrideTypes = overrideTypes.getParent();
    }

    @Nullable
    public ParameterNode getNamedParameter(String name){
        for (ParameterNode p : method.getParameters()) {
            if (name.equals(p.getName())) {
                return p;
            }
        }
        return null;
    }

    private void changeTypeTemporarilyIfCould(ExprNode expr,Type type){
        VarObject key = getOverrideTypeKey(expr);
        if(key!=null){
            overrideTypes.put(key, type);
        }
    }

    private void onNull(ExprNode expr,boolean onTrue,boolean isEQ){
        boolean mustNull = (onTrue && isEQ) || (!onTrue && !isEQ);
        VarObject key = this.getOverrideTypeKey(expr);
        if(key!=null){
            nullState.put(key,mustNull ? NULLSTATE_MUST_NULL : NULLSTATE_MUST_NONNULL);
        }
    }

    @Nullable
    private VarObject getOverrideTypeKey(ExprNode expr){
        VarObject key ;
        //It isn't supported to override type of field because it is not safe
        if(expr instanceof VarExpr){
            key = ((VarExpr) expr).getVar();
        }else if(expr instanceof ParameterExpr){
            key = ((ParameterExpr) expr).getParameter();
        }else{
            key = null;
        }
        return key;
    }

    private void removeOverrideType(ExprNode expr){
        VarObject key = getOverrideTypeKey(expr);
        if(key!=null) overrideTypes.remove(key, true);
    }

    private int getNullState(NullableKind nullable){
        int ns;
        if(nullable==NullableKind.NONNULL){
            ns = NULLSTATE_MUST_NONNULL;
        }else if(nullable==NullableKind.NULLABLE){
            ns = NULLSTATE_NULLABLE;
        }else if(nullable==NullableKind.UNKNOWN){
            ns = NULLSTATE_UNKNOWN;
        }else{
            throw Exceptions.unexpectedValue(nullable);
        }
        return ns;
    }

}

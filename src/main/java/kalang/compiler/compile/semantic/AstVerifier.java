package kalang.compiler.compile.semantic;

import kalang.compiler.compile.MalformedAstException;
import kalang.compiler.ast.*;
import kalang.compiler.core.PrimitiveType;
import kalang.compiler.core.Type;
import kalang.compiler.core.Types;
import kalang.compiler.util.Exceptions;

import java.util.Objects;

/**
 * @author KasonYang
 */
public class AstVerifier extends AstVisitor {

    private MethodNode method;

    @Override
    public Object visitMethodNode(MethodNode node) {
        this.method = node;
        super.visitMethodNode(node);
        this.method = null;
        return null;
    }

    @Override
    public Object visitReturnStmt(ReturnStmt node) {
        Type retType = method.getType();
        if (node.expr == null) {
            if(!retType.equals(Types.VOID_TYPE)){
                throw new MalformedAstException("missing return value", node);
            }
        }else{
            checkAssignable(node.expr, method.getType(), node);
        }
        return super.visitReturnStmt(node);
    }

    @Override
    public Object visitAssignExpr(AssignExpr node) {
        super.visitAssignExpr(node);
        Type tt = node.getTo().getType();
        requireNotNull(tt, node,"type of to is null");
        checkAssignable(node.getFrom(), tt, node);
        return null;
    }

    @Override
    public Object visitBinaryExpr(BinaryExpr node) {
        super.visitBinaryExpr(node);
        ExprNode e1 = node.getExpr1();
        ExprNode e2 = node.getExpr2();
        String op = node.getOperation();
        Type t1 = e1.getType();
        Type t2 = e2.getType();

        if (node instanceof ArithmeticBinaryExpr) {
            requireEquals(t1, t2, node, "type of operands should be same");
        } else if (node instanceof BitwiseBinaryExpr) {
            switch (op) {
                case BinaryExpr.OP_SHIFT_LEFT:
                case BinaryExpr.OP_SHIFT_RIGHT:
                case BinaryExpr.OP_UNSIGNED_SHIFT_RIGHT:
                    requireTrue(Types.INT_TYPE.equals(e2.getType()), node, "the second operand should be int type");
                    break;
                default:
                    requireEquals(t1, t2, node, "type of operands should be same");
            }
        } else if (node instanceof CompareBinaryExpr) {
            if (t1 instanceof PrimitiveType && t2 instanceof PrimitiveType) {
                requireEquals(t1, t2, node, "type of operands should be same");
            }
        } else if (node instanceof LogicBinaryExpr) {
            requireTrue(Types.isIntCompatibleType(t1), node , "operand should be int or boolean");
            requireTrue(Types.isIntCompatibleType(t2), node , "operand should be int or boolean");
        } else {
            throw Exceptions.unknownValue(node);
        }
        return null;
    }

    private void requireTrue(boolean value, AstNode originalNode, String msg) {
        if (!value) {
            throw new MalformedAstException(msg, originalNode);
        }
    }

    private void requireEquals(Object o1, Object o2, AstNode originalNode, String msg) {
        if (!Objects.equals(o1, o2)) {
            throw new MalformedAstException(msg, originalNode);
        }
    }

    private void requireNotNull(Object obj, AstNode originalNode, String msg) {
        if (obj == null) {
            throw new MalformedAstException(msg, originalNode);
        }
    }

    private void checkAssignable(ExprNode from , Type toType , AstNode node) {
        Type ft = from.getType();
        requireNotNull(ft, from,"type of from is null");
        requireTrue(toType.isAssignableFrom(ft),node , ft + " is not assignable to " + toType);
    }

}

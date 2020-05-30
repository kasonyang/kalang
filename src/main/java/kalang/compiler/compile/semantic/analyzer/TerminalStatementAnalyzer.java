package kalang.compiler.compile.semantic.analyzer;

import kalang.compiler.ast.*;
import kalang.compiler.util.Exceptions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author KasonYang
 */
public class TerminalStatementAnalyzer {

    private final Map<Statement, Boolean> cache;

    public TerminalStatementAnalyzer() {
        cache = null;
    }

    public TerminalStatementAnalyzer(boolean enableCache) {
        cache = enableCache ? new HashMap<>() : null;
    }

    public boolean isTerminalStatement(Statement statement) {
        if (cache == null) {
            return checkTerminalStatement(statement);
        } else {
            return cache.computeIfAbsent(statement, this::checkTerminalStatement);
        }
    }

    private boolean checkTerminalStatement(Statement statement) {
        if (statement == null) {
            return false;
        } else if (statement instanceof BlockStmt) {
            return isTerminalStatementBlock(((BlockStmt) statement).statements);
        } else if (statement instanceof BreakStmt) {
            return true;
        } else if (statement instanceof ContinueStmt) {
            return true;
        } else if (statement instanceof ExprStmt) {
            return false;
        } else if (statement instanceof IfStmt) {
            IfStmt ifStmt = (IfStmt) statement;
            return isTerminalStatement(ifStmt.getTrueBody()) && isTerminalStatement(ifStmt.getFalseBody());
        } else if (statement instanceof LoopStmt) {
            return false;
        } else if (statement instanceof MultiStmt) {
            return isTerminalStatementBlock(((MultiStmt) statement).statements);
        } else if (statement instanceof ReturnStmt) {
            return true;
        } else if (statement instanceof ThrowStmt) {
            return true;
        } else if (statement instanceof TryStmt) {
            TryStmt tryStmt = (TryStmt) statement;
            if (isTerminalStatement(tryStmt.getFinallyStmt())) {
                return true;
            }
            List<Statement> branches = new LinkedList<>();
            branches.add(tryStmt.getExecStmt());
            for (CatchBlock cb : tryStmt.getCatchStmts()) {
                branches.add(cb.execStmt);
            }
            return isAllTerminalStatement(branches);
        } else if (statement instanceof VarDeclStmt) {
            return false;
        } else {
            throw Exceptions.unexpectedValue(statement);
        }
    }

    private boolean isAllTerminalStatement(List<Statement> statements) {
        for (Statement s : statements) {
            if (!isTerminalStatement(s)) {
                return false;
            }
        }
        return true;
    }

    private boolean isTerminalStatementBlock(List<Statement> statements) {
        Statement[] array = statements.toArray(new Statement[0]);
        for (int i = array.length - 1; i >= 0; i--) {
            if (isTerminalStatement(array[i])) {
                return true;
            }
        }
        return false;
    }

}

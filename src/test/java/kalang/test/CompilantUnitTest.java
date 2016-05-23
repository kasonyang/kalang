/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalang.test;

import kalang.compiler.AstBuilder;
import kalang.compiler.CompilationUnit;
import kalang.compiler.CompilePhase;
import kalang.compiler.DefaultCompileContext;
import kalang.compiler.KalangSource;
import kalang.util.ParseTreeNavigator;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class CompilantUnitTest {
    
    public CompilantUnitTest() {
    }
    
    @Test
    public void test(){
        KalangSource source = new KalangSource("Test", "class{"
                + "void main(){"
                + "}"
                + "}","Test.kl");
        CompilationUnit cu = new CompilationUnit(source,new DefaultCompileContext());
        cu.compile(CompilePhase.PHASE_PARSING);
        AstBuilder astBuilder = cu.getAstBuilder();
        ParseTreeNavigator treeNav = new ParseTreeNavigator(astBuilder.getParseTree());
        ParseTree tree = treeNav.getParseTree(0);
        assertNotNull(tree);
        ParseTree treeMd = treeNav.getParseTree(2);
        ParseTree treeMdEnd = treeNav.getParseTree(7);
        //System.out.println(treeMd);
        //System.out.println(treeMdEnd);
        assertNotNull(treeMd);
        assertNotNull(treeMdEnd);
        //assertEquals(treeMd, treeMdEnd.getParent().getParent());
//        AstNode ast = sp.getAstNode(tree);
//        assertNotNull(ast);
//        System.out.println("ast:"+ast);
//        RuleContext treeOfAst = sp.getParseTree(ast);
//        assertNotNull(treeOfAst);
    }
    
}

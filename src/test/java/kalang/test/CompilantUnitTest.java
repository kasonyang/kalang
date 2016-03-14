/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalang.test;

import kalang.ast.AstNode;
import kalang.compiler.JavaAstLoader;
import kalang.compiler.AstBuilder;
import kalang.compiler.KalangSource;
import kalang.util.ParseTreeNavigator;
import kalang.util.AstBuilderFactory;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
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
                + "}");
        AstBuilder sp = AstBuilderFactory.createAstBuilder(source);
        sp.compile();
        ParseTreeNavigator treeNav = new ParseTreeNavigator(sp.getParseTree());
        ParseTree tree = treeNav.getParseTree(0);
        assertNotNull(tree);
        ParseTree treeMd = treeNav.getParseTree(2);
        ParseTree treeMdEnd = treeNav.getParseTree(7);
        System.out.println(treeMd);
        System.out.println(treeMdEnd);
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

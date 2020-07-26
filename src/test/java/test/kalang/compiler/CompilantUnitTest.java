package test.kalang.compiler;

import kalang.compiler.compile.*;
import kalang.compiler.compile.util.DefaultCompileContext;
import kalang.compiler.compile.semantic.AstBuilder;
import kalang.compiler.util.ParseTreeNavigator;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Kason Yang 
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

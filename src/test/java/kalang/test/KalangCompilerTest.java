package kalang.test;

import kalang.compiler.antlr.KalangLexer;
import kalang.compiler.ast.ClassNode;
import kalang.compiler.compile.CodeGenerator;
import kalang.compiler.compile.CompilationUnit;
import kalang.compiler.compile.KalangCompiler;
import kalang.compiler.compile.codegen.Ast2JavaStub;
import kalang.compiler.util.ParseTreeNavigator;
import kalang.compiler.util.TokenNavigator;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 *
 * @author Kason Yang 
 */
public class KalangCompilerTest {
    
    public KalangCompilerTest() {
    }
    
    @Test
    public void test(){
        KalangCompiler kc = new KalangCompiler(){
            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return new Ast2JavaStub();
            }
        };
        kc.addSource("Test", "class{  }","Test.kl");
        kc.compile();
        CompilationUnit unit = kc.getCompilationUnit("Test");
        assert unit != null;
        CommonTokenStream ts = unit.getTokenStream();
        //the tokens contains tokens in all channels
        List<Token> tokens = ts.getTokens();
        assertEquals(5, ts.size());
        testTokenNavigator(tokens.toArray(new Token[0]),unit.getAstBuilder().getParseTree());
    }

    @Test
    public void testRecompile(){
        KalangCompiler kc = new KalangCompiler(){
            @Override
            public CodeGenerator createCodeGenerator(CompilationUnit compilationUnit) {
                return new Ast2JavaStub();
            }
        };
        kc.addSource("Test", "class{  }","Test.kl");
        kc.compile();
        kc.compile();
        CompilationUnit unit = kc.getCompilationUnit("Test");
        assertNotNull(unit);
    }
    
    private void testTokenNavigator(Token[] tokens,ParseTree tree){
        TokenNavigator tokenNav = new TokenNavigator(tokens);
        ParseTreeNavigator treeNav = new ParseTreeNavigator(tree);
        assertEquals(0,tokenNav.getCurrentTokenIndex());
        assertEquals("class", treeNav.getParseTree(tokenNav.getCurrentToken()).getText());
        
        
        
        
        
        tokenNav.move(5);
        assertEquals("{", tokenNav.getCurrentToken().getText());
        assertEquals(1,tokenNav.getCurrentTokenIndex());
        tokenNav.next(KalangLexer.DEFAULT_TOKEN_CHANNEL);
        assertEquals("}", tokenNav.getCurrentToken().getText());
        
        tokenNav.move(8);
        assertEquals("}",tokenNav.getCurrentToken().getText());
        
        assertEquals("}", treeNav.getParseTree(tokenNav.getCurrentToken()).getText());
        assertEquals(3, tokenNav.getCurrentTokenIndex());
        
    }
}

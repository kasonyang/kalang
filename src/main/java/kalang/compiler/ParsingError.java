/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kalang.compiler;
/**
 *
 * @author Kason Yang
 */
public class ParsingError extends CompileError{
    
    private final AstBuilder astBuilder;

    public ParsingError(String description,CompilationUnit source,OffsetRange offset,AstBuilder astBuilder) {
        super(description, source, offset);
        this.astBuilder = astBuilder;
    }


    public AstBuilder getAstBuilder() {
        return astBuilder;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package kalang.compiler;
import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import kalang.antlr.KalangParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.Token;
/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class SourceParsingError extends CompileError{
    
    private final AstBuilder astBuilder;

    public SourceParsingError(String description,CompilationUnit source,OffsetRange offset,AstBuilder astBuilder) {
        super(description, source, offset);
        this.astBuilder = astBuilder;
    }


    public AstBuilder getAstBuilder() {
        return astBuilder;
    }

    @Override
    public String toString() {
        return "SourceParsingException{" + "offset=" + offset + ", compilantUnit=" + astBuilder + ", description=" + description + '}';
    }

}

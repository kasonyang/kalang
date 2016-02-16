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
public class SourceParsingException extends RuntimeException{
    
    private OffsetRange offset;
    
    private final SourceUnit compilantUnit;
    
    private String description;

    public SourceParsingException(String description,OffsetRange offset,SourceUnit compilantUnit) {
        super(description);
        this.offset = offset;
        this.compilantUnit = compilantUnit;
        this.description = description;
    }


    public SourceUnit getSourceUnit() {
        return compilantUnit;
    }

    public String getDescription() {
        return description;
    }

    public OffsetRange getOffset() {
        return offset;
    }

    @Override
    public String toString() {
        return "SourceParsingException{" + "offset=" + offset + ", compilantUnit=" + compilantUnit + ", description=" + description + '}';
    }

}

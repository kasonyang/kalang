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
public class SemanticErrorException extends RuntimeException{
    
    RuleContext tree;
    
    Token token;
    private final CompilantUnit compilantUnit;
    private String description;

    public SemanticErrorException(String description, Token token,RuleContext tree,CompilantUnit compilantUnit) {
        super(description);
        this.tree = tree;
        this.token = token;
        this.compilantUnit = compilantUnit;
        this.description = description;
    }

    public RuleContext getTree() {
        return tree;
    }

    public Token getToken() {
        return token;
    }

    public CompilantUnit getCompilantUnit() {
        return compilantUnit;
    }

    @Override
    public String toString() {
        return "SemanticErrorException{" + "tree=" + tree + ", token=" + token + ", compilant=" + compilantUnit + ", description=" + description + '}';
    }

    public String getDescription() {
        return description;
    }

}

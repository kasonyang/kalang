package kalang.compiler;

import java.io.*;
import java.nio.*;
import java.net.*;
import java.util.*;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.InputMismatchException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;

public class AntlrErrorString {

    public static String noViableAlt(Parser recognizer, NoViableAltException e) {
        TokenStream tokens = recognizer.getInputStream();
        String input = null;
        if (tokens != null) {
            Token startToken = e.getStartToken();
            if (startToken.getType() == Token.EOF) {
                input = "<EOF>";
            } else {
                input = tokens.getText(
                        startToken, e.getOffendingToken()
                );
            }
        }
        return "failed to select rule at input:" + input;
    }

    public static String inputMismatch(InputMismatchException e) {
        return "mismatched input " + e.getOffendingToken().getText();
    }

    public static String failedPredicate(FailedPredicateException e) {
        String ruleName = e.getRecognizer().getRuleNames()[e.getRuleIndex()];
        return "rule<" + ruleName + ">:" + e.getMessage();
    }

    public static String exceptionString(Parser parser, RecognitionException ex) {
        if (ex instanceof FailedPredicateException) {
            return failedPredicate((FailedPredicateException) ex);
        } else if (ex instanceof InputMismatchException) {
            return inputMismatch((InputMismatchException) ex);
        } else if (ex instanceof NoViableAltException) {
            return noViableAlt(parser, (NoViableAltException) ex);
        } else {
            System.err.println("unknown recognition exception:" + ex);
            return ex.toString();
        }
    }
}

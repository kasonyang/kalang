package kalang.compiler.util;

import org.antlr.v4.runtime.*;

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
        return "syntax error at input:" + input;
    }

    public static String inputMismatch(InputMismatchException e) {
        return "mismatched input:" + e.getOffendingToken().getText();
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

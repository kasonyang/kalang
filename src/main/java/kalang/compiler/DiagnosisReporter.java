package kalang.compiler;

import kalang.util.OffsetRangeHelper;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;

/**
 *
 * @author Kason Yang
 */
public class DiagnosisReporter {

    private final CompileContext compileContext;

    private final DiagnosisHandler disgnosisHandler;

    private final KalangSource kalangSource;

    public DiagnosisReporter(CompileContext compileContext, DiagnosisHandler disgnosisHandler, KalangSource kalangSource) {
        this.compileContext = compileContext;
        this.disgnosisHandler = disgnosisHandler;
        this.kalangSource = kalangSource;
    }
    
    public void report(Diagnosis.Kind kind,String message,OffsetRange offset){
        Diagnosis diagnosis = new Diagnosis(compileContext, kind, offset, message, kalangSource);
        this.disgnosisHandler.handleDiagnosis(diagnosis);
    }
    
    public void report(Diagnosis.Kind kind,String message,Token start,Token end){
        OffsetRange offset = OffsetRangeHelper.getOffsetRange(start, end);
        this.report(kind, message, offset);
    }
    
    public void report(Diagnosis.Kind kind,String message,Token offset){
        this.report(kind, message, offset,offset);
    }
    
    public void report(Diagnosis.Kind kind,String message,ParserRuleContext parserRuleCtx){
        OffsetRange offset = OffsetRangeHelper.getOffsetRange(parserRuleCtx);
        this.report(kind, message, offset);
    }
    
    public void report(Diagnosis.Kind kind,String message){
        this.report(kind, message,OffsetRange.NONE);
    }
    
    public CompileContext getCompileContext() {
        return compileContext;
    }

    public DiagnosisHandler getDisgnosisHandler() {
        return disgnosisHandler;
    }

    public KalangSource getKalangSource() {
        return kalangSource;
    }
    
}

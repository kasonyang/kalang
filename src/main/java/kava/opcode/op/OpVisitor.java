package kava.opcode.op;
public interface OpVisitor{
        public void visitNOOP();
        public void visitADD(kava.opcode.VarObject result,kava.opcode.VarObject v1,kava.opcode.VarObject v2);
        public void visitSUB(kava.opcode.VarObject result,kava.opcode.VarObject v1,kava.opcode.VarObject v2);
        public void visitMUL(kava.opcode.VarObject result,kava.opcode.VarObject v1,kava.opcode.VarObject v2);
        public void visitDIV(kava.opcode.VarObject result,kava.opcode.VarObject v1,kava.opcode.VarObject v2);
        public void visitMOD(kava.opcode.VarObject result,kava.opcode.VarObject v1,kava.opcode.VarObject v2);
        public void visitCMP(kava.opcode.VarObject result,kava.opcode.VarObject v1,kava.opcode.VarObject v2);
        public void visitASSIGN(kava.opcode.VarObject result,kava.opcode.VarObject v1);
        public void visitPARAM(kava.opcode.VarObject result);
        public void visitIFFALSE(kava.opcode.VarObject v1,Integer v2);
        public void visitIFTRUE(kava.opcode.VarObject v1,Integer v2);
        public void visitIFEQ(kava.opcode.VarObject v1,Integer v2);
        public void visitIFNE(kava.opcode.VarObject v1,Integer v2);
        public void visitIFLT(kava.opcode.VarObject v1,Integer v2);
        public void visitIFGT(kava.opcode.VarObject v1,Integer v2);
        public void visitIFLE(kava.opcode.VarObject v1,Integer v2);
        public void visitIFGE(kava.opcode.VarObject v1,Integer v2);
        public void visitGOTO(Integer v1);
        public void visitIINC(kava.opcode.VarObject v1,Integer v2);
        public void visitICONST(kava.opcode.VarObject result,Integer v1);
        public void visitLDC(kava.opcode.VarObject result,kava.opcode.Constant v1);
        public void visitANEW(kava.opcode.VarObject result,kava.opcode.Constant v1,Integer v2);
        public void visitAOFFSET(kava.opcode.VarObject v1);
        public void visitAGET(kava.opcode.VarObject result,kava.opcode.VarObject v1);
        public void visitAPUT(kava.opcode.VarObject v1,kava.opcode.VarObject v2);
}
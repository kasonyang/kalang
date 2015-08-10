package com.kasonyang.kava.ast.opcode;

public enum OpType {
	NOOP
	,ADD,SUB,MUL,DIV,MOD
	,ASSIGN,INVOKE,PARAM,LCONST
	,IFFALSE,IFTRUE,IFEQ,IFNE,IFLT,IFGT,IFLE,IFGE
	,LOGIC_NOT,GOTO
	,IINC
	,ICONST
	
}

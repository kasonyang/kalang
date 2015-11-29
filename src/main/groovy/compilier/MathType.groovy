package compilier

class MathType {
	public static final int INT = 1;
	public static final int LONG = 2;
	public static final int FLOAT = 3;
	public static final int DOUBLE = 4;
	
	public static final String    INT_STR = "int";
	public static final String   LONG_STR = "long";
	public static final String  FLOAT_STR = "float";
	public static final String DOUBLE_STR = "double";
	
	public static final int OP_ADD = 1;
	public static final int OP_SUB = 2;
	public static final int OP_MUL = 3;
	public static final int OP_DIV = 4;
	public static final int OP_MOD = 4;
	
	public static final String OP_ADD_STR = "+";
	public static final String OP_SUB_STR = "-";
	public static final String OP_MUL_STR = "*";
	public static final String OP_DIV_STR = "/";
	public static final String OP_MOD_STR = "%";
	
	
	static boolean isFloatPoint(String type){
		return type==FLOAT_STR || type==DOUBLE_STR
	}
	
	static boolean isFloatPoint(int type){
		return type==FLOAT||type==DOUBLE
	}
	
	static int getType(String type){
		if(type==INT_STR) return INT
		if(type==LONG_STR) return LONG
		if(type==FLOAT_STR) return FLOAT
		if(type==DOUBLE_STR) return DOUBLE
	}
	
	static String getTypeStr(int type){
		if(type==   INT) return    INT_STR
		if(type==  LONG) return   LONG_STR
		if(type== FLOAT) return  FLOAT_STR
		if(type==DOUBLE) return DOUBLE_STR
	}
	
	static int getOperation(String op){
		if(op==OP_ADD_STR) return OP_ADD
		if(op==OP_SUB_STR) return OP_SUB
		if(op==OP_MUL_STR) return OP_MUL
		if(op==OP_DIV_STR) return OP_DIV
		if(op==OP_MOD_STR) return OP_MOD
	}
	
	static String getOperationStr(int op){
		if(op==OP_ADD) return OP_ADD_STR;
		if(op==OP_SUB) return OP_SUB_STR;
		if(op==OP_MUL) return OP_MUL_STR;
		if(op==OP_DIV) return OP_DIV_STR;
		if(op==OP_MOD) return OP_MOD_STR;
	}
	
	static String getType(String type1,String type2,String op){
		int t1 = getType(type1)
		int t2 = getType(type2)
		int o = getOperation(op)
		int ret = getType(t1,t2,o)
		return getTypeStr(ret)
	}
	
	static int getType(int type1,int type2,int op){
		if(isFloatPoint(type1)||isFloatPoint(type2)||op==OP_DIV){
			return DOUBLE
		}
		if(type1==LONG||type2==LONG){
			return LONG
		}
		return INT
	}
	
}

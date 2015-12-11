package kalang.compiler;

public class MathType   {
  public static final int INT=1;
  public static final int LONG=2;
  public static final int FLOAT=3;
  public static final int DOUBLE=4;
  public static final java.lang.String INT_STR="int";
  public static final java.lang.String LONG_STR="long";
  public static final java.lang.String FLOAT_STR="float";
  public static final java.lang.String DOUBLE_STR="double";
  public static final int OP_ADD=1;
  public static final int OP_SUB=2;
  public static final int OP_MUL=3;
  public static final int OP_DIV=4;
  public static final int OP_MOD=5;
  public static final java.lang.String OP_ADD_STR="+";
  public static final java.lang.String OP_SUB_STR="-";
  public static final java.lang.String OP_MUL_STR="*";
  public static final java.lang.String OP_DIV_STR="/";
  public static final java.lang.String OP_MOD_STR="%";
  public static boolean isFloatPoint(java.lang.String type)  
  {
    return ((type==kalang.compiler.MathType.FLOAT_STR)||(type==kalang.compiler.MathType.DOUBLE_STR));
  }
  
  public static boolean isFloatPoint(int type)  
  {
    return ((type==kalang.compiler.MathType.FLOAT)||(type==kalang.compiler.MathType.DOUBLE));
  }
  
  public static int getType(java.lang.String type)  
  {
    if((type==kalang.compiler.MathType.INT_STR)){
      return kalang.compiler.MathType.INT;
    }
    else {
      
    };
    if((type==kalang.compiler.MathType.LONG_STR)){
      return kalang.compiler.MathType.LONG;
    }
    else {
      
    };
    if((type==kalang.compiler.MathType.FLOAT_STR)){
      return kalang.compiler.MathType.FLOAT;
    }
    else {
      
    };
    if((type==kalang.compiler.MathType.DOUBLE_STR)){
      return kalang.compiler.MathType.DOUBLE;
    }
    else {
      
    };
    return 0;
  }
  
  public static java.lang.String getTypeStr(int type)  
  {
    if((type==kalang.compiler.MathType.INT)){
      return kalang.compiler.MathType.INT_STR;
    }
    else {
      
    };
    if((type==kalang.compiler.MathType.LONG)){
      return kalang.compiler.MathType.LONG_STR;
    }
    else {
      
    };
    if((type==kalang.compiler.MathType.FLOAT)){
      return kalang.compiler.MathType.FLOAT_STR;
    }
    else {
      
    };
    if((type==kalang.compiler.MathType.DOUBLE)){
      return kalang.compiler.MathType.DOUBLE_STR;
    }
    else {
      
    };
    return "";
  }
  
  public static int getOperation(java.lang.String op)  
  {
    if((op==kalang.compiler.MathType.OP_ADD_STR)){
      return kalang.compiler.MathType.OP_ADD;
    }
    else {
      
    };
    if((op==kalang.compiler.MathType.OP_SUB_STR)){
      return kalang.compiler.MathType.OP_SUB;
    }
    else {
      
    };
    if((op==kalang.compiler.MathType.OP_MUL_STR)){
      return kalang.compiler.MathType.OP_MUL;
    }
    else {
      
    };
    if((op==kalang.compiler.MathType.OP_DIV_STR)){
      return kalang.compiler.MathType.OP_DIV;
    }
    else {
      
    };
    if((op==kalang.compiler.MathType.OP_MOD_STR)){
      return kalang.compiler.MathType.OP_MOD;
    }
    else {
      
    };
    return 0;
  }
  
  public static java.lang.String getOperationStr(int op)  
  {
    if((op==kalang.compiler.MathType.OP_ADD)){
      return kalang.compiler.MathType.OP_ADD_STR;
    }
    else {
      
    };
    if((op==kalang.compiler.MathType.OP_SUB)){
      return kalang.compiler.MathType.OP_SUB_STR;
    }
    else {
      
    };
    if((op==kalang.compiler.MathType.OP_MUL)){
      return kalang.compiler.MathType.OP_MUL_STR;
    }
    else {
      
    };
    if((op==kalang.compiler.MathType.OP_DIV)){
      return kalang.compiler.MathType.OP_DIV_STR;
    }
    else {
      
    };
    if((op==kalang.compiler.MathType.OP_MOD)){
      return kalang.compiler.MathType.OP_MOD_STR;
    }
    else {
      
    };
    return "";
  }
  
  public static java.lang.String getType(java.lang.String type1,java.lang.String type2,java.lang.String op)  
  {
    int t1=getType(type1);
    int t2=getType(type2);
    int o=getOperation(op);
    int ret=getType(t1,t2,o);
    return getTypeStr(ret);
  }
  
  public static int getType(int type1,int type2,int op)  
  {
    if(((isFloatPoint(type1)||isFloatPoint(type2))||(op==kalang.compiler.MathType.OP_DIV))){
      return kalang.compiler.MathType.DOUBLE;
    }
    else {
      
    };
    if(((type1==kalang.compiler.MathType.LONG)||(type2==kalang.compiler.MathType.LONG))){
      return kalang.compiler.MathType.LONG;
    }
    else {
      
    };
    return kalang.compiler.MathType.INT;
  }
}
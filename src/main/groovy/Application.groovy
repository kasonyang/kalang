import compilier.*
import jast.ast.*
import kalang.antlr.KalangLexer
import kalang.antlr.KalangParser
import kalang.core.VarObject
import kalang.core.VarTable
import kava.antlr.*

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

class Application {
    static void main(args) {
        def input = '''\
import java.util.*;
class  kava {
  var f as int = 123;
  var f2;
  
  var func() as int{
    var a as int=3;
    var l as long = 3;
	var str = "hehe";
    var map = new HashMap();
    map.put("a",str);
    var b;
    a= a + 1;
    l = l + 1;
    //b.func(a);
    func2(a);
    func2(l);
    return (int)a;
  }
  var func2(p as long){
    f = 123;
    for(var i as int=0;i<10;i++){
      p++;
    }
	func2(p);
  }
}
''';

        def astLoader = new JavaAstLoader();
        def cpl = new KalangCompiler(astLoader);
        cpl.addSource("kava",input)
        cpl.addSource("Test","class Test {var k as kava;}");
        cpl.compile();
		
		
        //println names
        //println cls;
    }
}
import compilier.*
import jast.ast.*
import kalang.Compiler
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
        kalang.Compiler.compile(
            new File("TestScript/src")
            ,new File("TestScript/java")
        )
    }
}
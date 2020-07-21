@echo off
java -cp %~dp0/lib/antlr-4.7.2-complete.jar org.antlr.v4.Tool %* KalangLexer.g4 -o build
java -cp %~dp0/lib/antlr-4.7.2-complete.jar org.antlr.v4.Tool %* KalangParser.g4 -o build -lib build

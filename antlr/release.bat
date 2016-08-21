@echo off
java -cp %~dp0/lib/antlr-4.5.1-complete.jar org.antlr.v4.Tool KalangLexer.g4 -o %~dp0/../src/main/java/kalang/antlr -package kalang.antlr
java -cp %~dp0/lib/antlr-4.5.1-complete.jar org.antlr.v4.Tool KalangParser.g4 -o %~dp0/../src/main/java/kalang/antlr -package kalang.antlr -visitor

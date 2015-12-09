@echo off
java -cp %~dp0/lib/antlr-4.5.1-complete.jar org.antlr.v4.Tool Kalang.g4 -o %~dp0/../src/main/groovy/kalang/antlr -package kalang.antlr -visitor
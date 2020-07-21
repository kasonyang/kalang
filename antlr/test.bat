@echo off
java -cp %~dp0/build;%~dp0/lib/antlr-4.7.2-complete.jar org.antlr.v4.gui.TestRig Kalang compilationUnit %* TestScript/* TestInput.kl
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalang.java;

import java.io.*;
import java.net.*;
import java.nio.*;
import java.util.*;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaCompiler.CompilationTask;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

/**
 *
 * @author Kason Yang <i@kasonyang.com>
 */
public class JavacHelper {

    static public boolean compile(List<File> sources, String outputPath) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        //TODO maybe null
        DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector();
        List<JavaFileObject> jfiles = new LinkedList<>();
        for (File sf : sources) {
            jfiles.add(new JavaSource(sf));
        }
        String[] options = new String[2];
        options[0] = "-d";
        options[1] = outputPath;//String.format("\"%s\"", outputPath);
        CompilationTask task = compiler.getTask(null, null, diagnostics, Arrays.asList(options), null, jfiles);

        boolean success = task.call();
        for (Diagnostic<? extends JavaFileObject> diagnostic : diagnostics.getDiagnostics()) {
            System.out.println(diagnostic.getCode());
            System.out.println(diagnostic.getKind());
            System.out.println(diagnostic.getPosition());
            System.out.println(diagnostic.getStartPosition());
            System.out.println(diagnostic.getEndPosition());
            System.out.println(diagnostic.getSource());
            System.out.println(diagnostic.getMessage(null));
            return false;
        }
        return true;
    }
}

class JavaSource extends SimpleJavaFileObject {

    File file;

    public JavaSource(File file) {
        super(file.toURI(), SimpleJavaFileObject.Kind.SOURCE);
        this.file = file;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        String str = "";
        Reader r = new FileReader(file);
        BufferedReader br = new BufferedReader(r);
        String line;
        while((line=br.readLine())!=null){
            str += line + "\r\n";
        }
        return str;
    }

}

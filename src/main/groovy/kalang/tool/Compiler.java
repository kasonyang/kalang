package kalang.tool;

import kalang.compiler.*;
import jast.ast.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kalang.antlr.KalangLexer;
import kalang.antlr.KalangParser;
import kalang.core.VarTable;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.apache.commons.io.FileUtils;

public class Compiler {

    static void printUsage() {
        System.out.println("kac src dest");

    }

    public static void main(String[] args) throws IOException {
        String srcDir = ".";
        String outDir = ".";
        if (args.length == 1) {
            srcDir = outDir = args[0];
        } else if (args.length >= 2) {
            srcDir = args[0];
            outDir = args[1];
        }
        File src = new File(srcDir);
        File dest = new File(outDir);
        if (!src.exists()) {
            throw new RuntimeException("source directory not exist!");
        }
        if (!dest.exists()) {
            dest.mkdirs();
        }
        compile(src, dest);
    }

    static List<File> getFiles(File dir) {
        List list = new LinkedList();
        File[] files = dir.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                list.addAll(getFiles(f));
            } else {
                list.add(f);
            }
        }
        return list;
    }

    public static void compile(String className, String src) throws IOException {
        compile(className, src, null);
    }

    public static void compile(String className, String src, File outDir) throws IOException {
        SourceUnit su = new SourceUnit();
        List<SourceUnit> list = new LinkedList();
        list.add(su);
        su.className = className;
        su.source = src;
        compile(list, outDir);
    }

    public static void compile(List<SourceUnit> sources) throws IOException {
        compile(sources, null);
    }

    public static void compile(List<SourceUnit> sources, File outDir) throws IOException {
        JavaAstLoader astLoader = new JavaAstLoader();
        KalangCompiler cpl = new KalangCompiler(astLoader);
        int size = sources.size();
        HashMap<String, SourceUnit> sourcesMap = new HashMap<>();
        for (int i = 0; i < size; i++) {
            SourceUnit src = sources.get(i);
            String clsName = src.className;
            sourcesMap.put(clsName, src);
            cpl.addSource(clsName, src.source);
        }
        cpl.setCompileErrorHandlerrrorHandler((CompileError error) -> {
            String cname = error.className;
            String fn = sourcesMap.get(cname).fileName;
            System.err.println(fn + ":" + error);
        });
        cpl.compile();
        HashMap<String, String> javaCodes = cpl.getJavaCodes();
        for (String cls : javaCodes.keySet()) {
            String code = javaCodes.get(cls);
            if (outDir != null) {
                String fname = cls.replace(".", "/") + ".java";
                File destFile = new File(outDir, fname);
                FileUtils.write(destFile, code);
            } else {
                System.out.println(code);
            }
        }
    }

    public static void compile(File srcDir, File outDir) throws IOException {
        List<File> srcs = getFiles(srcDir);
        String abSrcPath = srcDir.getAbsolutePath();
        List srcUnits = new LinkedList();
        for (File s : srcs) {
            String fname = s.getAbsolutePath();
            if (!fname.endsWith(".kl")) {
                continue;
            }
            String clsName = fname.substring(abSrcPath.length() + 1, fname.length() - 3).replace(File.separator, ".");
            String txt = FileUtils.readFileToString(s);
            SourceUnit sUnit = new SourceUnit();
            sUnit.className = clsName;
            sUnit.fileName = fname.substring(abSrcPath.length() + 1);
            sUnit.source = txt;
            srcUnits.add(sUnit);
        }
        compile(srcUnits, outDir);
    }
}

package com.bruce.demo.annotations.pap;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Locale;
import javax.annotation.processing.Processor;
import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.FileObject;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class TestCompiler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fm = compiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> files= 
		fm.getJavaFileObjectsFromStrings(Arrays.asList("src\\com\\bruce\\demo\\annotations\\pap\\Testing.java"));
		DiagnosticCollector<FileObject> collector = new DiagnosticCollector<FileObject>();
		//Iterable<String> classes = Arrays.asList("com.bruce.demo.annotations.pap.ToBeTested");
		CompilationTask task = compiler.getTask(new PrintWriter(System.out), fm, collector, null, null, files);
		Iterable<? extends Processor> processors = Arrays.asList(new MyAnnotationProcessor());
		task.setProcessors(processors);
		boolean result = task.call();
		for (Diagnostic<? extends FileObject> diagnostic : collector.getDiagnostics()) {
			System.out.println(diagnostic.getMessage(Locale.ENGLISH));
		}
		if(result)
		{
			System.out.println("Successed");
		}
	}

}

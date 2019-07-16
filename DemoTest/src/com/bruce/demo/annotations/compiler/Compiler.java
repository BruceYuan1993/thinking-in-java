package com.bruce.demo.annotations.compiler;

import java.util.Arrays;
import java.util.List;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;


public class Compiler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String file1Name = "src\\com\\bruce\\demo\\annotations\\apt\\Target.java";
		String file2Name = "src\\com\\bruce\\demo\\annotations\\compiler\\Calculator.java";
		JavaCompiler compiler =  ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
		Iterable<? extends JavaFileObject> files = manager.getJavaFileObjectsFromStrings(Arrays.asList(file1Name,file2Name));
		CompilationTask task = compiler.getTask(null, manager, null, null, null, files);
		Boolean result = task.call();
		if( result == true ) {
			System.out.println("Succeeded");
		}
	}
	


}

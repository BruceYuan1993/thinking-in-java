package com.bruce.demo.annotations.compiler;

import java.io.FileOutputStream;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class SimpleCompiler {
	public static void main(String[] args){
		//System.out.println(System.getProperties());
		String fileName = "src\\com\\bruce\\demo\\annotations\\apt\\Target.java";
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		try {
			FileOutputStream stream = new FileOutputStream("err.txt");
			int compilationResult = compiler.run(null, null, stream,"-verbose", fileName);
			if(compilationResult == 0){
				 System.out.println("Done");
			} else {
				 System.out.println("Fail");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}

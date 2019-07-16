package com.bruce.demo.annotations.compiler;

import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.tools.JavaCompiler.CompilationTask;

public class AdvancedCompiler {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		JavaFileObject object = constructTestor();
		CompilationTask task = compiler.getTask(null, fileManager, null, null, null,Arrays.asList(object));
		if(task.call()){
			System.out.println("Succeeded");
		}
	}
	
	private static SimpleJavaFileObject constructTestor() {
		StringBuilder contents = new StringBuilder(
		           "package com.bruce.demo.annotations.compiler;" +
		           "class CalculatorTest {\n" +
		      	   "  public void testMultiply() {\n" +
				   "    Calculator c = new Calculator();\n" +
				   "    System.out.println(c.multiply(2, 4));\n" +
				   "  }\n" +
				   "  public static void main(String[] args) {\n" +
				   "    CalculatorTest ct = new CalculatorTest();\n" +
				   "    ct.testMultiply();\n" +
				   "  }\n" +
				   "}\n");
		StringObject so = null;
		try {
				so = new StringObject("math.CalculatorTest", contents.toString());
			} catch(Exception exception) {
				exception.printStackTrace();
			}
			return so;
		}

}

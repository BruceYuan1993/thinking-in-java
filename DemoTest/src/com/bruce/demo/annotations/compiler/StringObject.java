package com.bruce.demo.annotations.compiler;

import java.io.IOException;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class StringObject extends SimpleJavaFileObject{
	private String content;
	protected StringObject(String className, String content) throws Exception {
		super(new URI(className), Kind.SOURCE);
		// TODO Auto-generated constructor stub
		this.content = content;
	}
	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors)
			throws IOException {
		// TODO Auto-generated method stub
		return content;
	}
	

}

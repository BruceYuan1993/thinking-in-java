package com.bruce.demo.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String>{
	public static String read(String fileName){
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				// TODO: handle finally clause
				in.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
		return sb.toString();
	}
	
	public static void write(String fileName, String text){
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				// TODO: handle finally clause
				out.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	
	public TextFile(String fileName, String splitter){
		super(Arrays.asList(read(fileName).split(splitter)));
		if ("".equals(get(0))){
			remove(0);
		}
	}
	
	public TextFile(String fileName){
		this(fileName, "\n");
	}
	
	
	public void write(String fileName){
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for (String s : this) {
					out.println(s);
				}
			} finally {
				// TODO: handle finally clause
				out.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		String file = read("src\\com\\bruce\\demo\\io\\TextFile.java");
		write("test.txt", file);
		
		TextFile text = new TextFile("test.txt");
		text.write("test2.txt");
		
		TreeSet<String> words = new TreeSet<String>(
				new TextFile("src\\com\\bruce\\demo\\io\\TextFile.java","\\W+"));
		System.out.println(words.headSet("a"));
		
	}
}

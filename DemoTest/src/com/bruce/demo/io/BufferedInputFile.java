package com.bruce.demo.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile {
	public static String read(String fileName) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String s;
		StringBuilder sb = new StringBuilder();
		while ((s = in.readLine())!= null) {
			sb.append(s);
			sb.append("\n");
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(read("src\\com\\bruce\\demo\\io\\BufferedInputFile.java"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

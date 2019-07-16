package com.bruce.demo.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;


public class DirList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File path = new File(".");
		String[] list = path.list(new DirFilter(".project"));
		System.out.println(path.getAbsolutePath());
		
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));
	}

}

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	
	public DirFilter(String regex) {
		super();
		this.pattern = Pattern.compile(regex);
	}

	@Override
	public boolean accept(File dir, String name) {
		// TODO Auto-generated method stub
		//System.out.println(dir.getAbsolutePath());
		return pattern.matcher(name).matches();
	}
	
}

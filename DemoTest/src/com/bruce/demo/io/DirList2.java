package com.bruce.demo.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList2 {
	public static FilenameFilter filter(final String regex){
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				System.out.println(dir.length() + "--> ");
				return pattern.matcher(name).matches();
			}
		};
	}
	public static void main(String[] args) {
		File path = new File(".");
//		String[] list = path.list(filter(".project"));
//		System.out.println(path.getAbsolutePath());
//		
//		Arrays.sort(list);
//		System.out.println(Arrays.toString(list));
		File[] fs = Directory.local(path, ".project");
		System.out.println(Arrays.toString(fs));
	}
}

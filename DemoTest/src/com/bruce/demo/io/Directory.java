package com.bruce.demo.io;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class Directory {
	
	public static File[] local(File dir, final String regex){
		return dir.listFiles(new FileFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File pathname) {
				// TODO Auto-generated method stub
				return pattern.matcher(pathname.getName()).matches();
			}
		});
	}
	
	public static File[] local(String dir,  String regex){
		return local(new File(dir), regex);
	}
	
	public static class TreeInfo implements Iterable<File>{
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();
		@Override
		public Iterator<File> iterator() {
			// TODO Auto-generated method stub
			return files.iterator();
		}
		
		void addAll(TreeInfo other){
			files.addAll(other.files);
			dirs.addAll(other.dirs);
		}

		@Override
		public String toString() {
			return "dirs: " + PPrint.pFormat(dirs) + "\n\n files: " + PPrint.pFormat(files);
		}
	}
	
	static TreeInfo recurseDirs(File startDir, String regex){
		TreeInfo result = new TreeInfo();
		for (File item : startDir.listFiles()){
			if (item.isDirectory()) {
				result.dirs.add(item);
				result.addAll(recurseDirs(item, regex));
			}else if (item.getName().matches(regex)){
				result.files.add(item);
			}
		}
		return result;
	}
	
	public static TreeInfo walk(File start, String regex){
		return recurseDirs(start,regex);
	}
	
	public static TreeInfo walk(String start, String regex){
		return recurseDirs(new File(start),regex);
	}
	
	public static TreeInfo walk(File start){
		return recurseDirs(start, ".*");
	}
	
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start), ".*");
	}
}

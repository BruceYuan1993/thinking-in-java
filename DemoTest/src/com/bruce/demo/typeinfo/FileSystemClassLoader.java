package com.bruce.demo.typeinfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileSystemClassLoader extends ClassLoader {
	private String rootDir;
	public FileSystemClassLoader(String rootDir)
	{
		super(null);
		this.rootDir = rootDir;
		
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		byte[] classData = getClassData(name);
		if (classData != null) {
			return super.defineClass(name, classData, 0, classData.length);
		}else {
			throw new ClassNotFoundException();
		}
	}
	private String classNameToPath(String name){
		return rootDir + File.separator +name.replace('.', File.separatorChar) + ".class";
	}
	
	private byte[] getClassData(String name){
		String path = classNameToPath(name);
		try {
			InputStream ins = new FileInputStream(path);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			int bufferSize = 4096; 
			byte[] buffer = new byte[bufferSize]; 
	        int bytesNumRead = 0; 
	        while ((bytesNumRead = ins.read(buffer)) != -1) { 
	            baos.write(buffer, 0, bytesNumRead); 
	        } 
	        return baos.toByteArray(); 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return null;
	}
}

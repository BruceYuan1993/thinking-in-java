package com.bruce.demo.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class UsingProcessBuilder {
	public static List<String> getPhysicalAddress(){
		List<String> address = new ArrayList<String>(); 
		Process p = null;
		try {
			p = new ProcessBuilder("ipconfig","/all").start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		byte[] b = new byte[1024];
        int readbytes = -1;
        StringBuffer sb = new StringBuffer();
        
        
        InputStream in = p.getInputStream();
        
        try {
			while ((readbytes = in.read(b))!= -1) {
				sb.append(new String(b,0,readbytes));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        System.out.println(sb.toString());
		
		return address;
	} 
	
	public static void executeMyCommand1(){
		ProcessBuilder pb = new ProcessBuilder("myCommand","myArg1","myArg2");
		Map<String, String> env = pb.environment();
		env.put("VAR1", "myValue");
        env.remove("VAR0");
        env.put("VAR2", env.get("VAR1") + ";");
        Iterator it=env.keySet().iterator();
        String sysatt = null;
        while(it.hasNext())
        {
               sysatt = (String)it.next();
               System.out.println("System Attribute:"+sysatt+"="+env.get(sysatt));
        }
        
        System.out.println(pb.directory());
        pb.directory(new File("C:/temp"));
        
        try {
			Process process = pb.start();
			int i = process.waitFor();
			if (i != 0){
				InputStream error = process.getErrorStream();
				//System.out.println(error);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public static void executeMyCommand2(){
		 ProcessBuilder pb = new ProcessBuilder("cmd.exe");
		 //pb.directory(new File("d:"));
         try {
			Process p = pb.start();
			BufferedWriter out = new BufferedWriter(
					new OutputStreamWriter(p.getOutputStream()));
			out.write("test.bat /r/n");
			out.write("ping -t 192.168.28.114 /r/n");
			out.flush();
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String s = null;
			while ((s = reader.readLine()) != null){
				System.out.println(0);
			}
			
         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	
	public static void main(String[] args) {
		getPhysicalAddress();
		//executeMyCommand1();
		executeMyCommand2();
		
		//Runtime.getRuntime().exec(command)
	}
}

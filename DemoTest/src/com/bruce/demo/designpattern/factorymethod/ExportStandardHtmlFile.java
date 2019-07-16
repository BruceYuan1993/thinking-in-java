package com.bruce.demo.designpattern.factorymethod;

public class ExportStandardHtmlFile implements ExportFile{

	@Override
	public boolean export(String data) {
		// TODO Auto-generated method stub
		System.out.println("export standard html");
		return true;
	}

}

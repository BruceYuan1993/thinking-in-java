package com.bruce.demo.designpattern.factorymethod;

public class ExportFinancialHtmlFile implements ExportFile{

	@Override
	public boolean export(String data) {
		// TODO Auto-generated method stub
		System.out.println("export financial html");
		return true;
	}

}

package com.bruce.demo.designpattern.factorymethod;

public class ExportFinancialPdfFile implements ExportFile{

	@Override
	public boolean export(String data) {
		// TODO Auto-generated method stub
		System.out.println("export financial pdf");
		return true;
	}

}

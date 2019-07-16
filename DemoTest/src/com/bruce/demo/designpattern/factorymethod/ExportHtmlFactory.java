package com.bruce.demo.designpattern.factorymethod;

public class ExportHtmlFactory implements ExportFactory{

	@Override
	public ExportFile factory(String type) {
		// TODO Auto-generated method stub
		if ("standard".equals(type)) {
			return new ExportStandardHtmlFile();
		} else if ("financial".equals(type)) {
			return new ExportFinancialHtmlFile();
		} else {
			throw new RuntimeException("not found");
		}
	}

}

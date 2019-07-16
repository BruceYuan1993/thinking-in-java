package com.bruce.demo.designpattern.factorymethod;

public class ExportPdfFactory implements ExportFactory {

	@Override
	public ExportFile factory(String type) {
		// TODO Auto-generated method stub
		if ("standard".equals(type)) {
			return new ExportStandardPdfFile();
		} else if ("financial".equals(type)) {
			return new ExportFinancialPdfFile();
		} else {
			throw new RuntimeException("not found");
		}
	}

}

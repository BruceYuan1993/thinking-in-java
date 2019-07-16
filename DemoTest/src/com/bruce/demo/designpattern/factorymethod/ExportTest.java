package com.bruce.demo.designpattern.factorymethod;

public class ExportTest {
	//more than one condition
	// file type & content type
	// adapter new file type
	public static void main(String[] args) {
		String data = "";
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile ef = exportFactory.factory("financial");
        ef.export(data);
	}
}

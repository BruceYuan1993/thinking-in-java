package com.bruce.demo.designpattern.factorymethod;

public interface ExportFactory {
	ExportFile factory(String type);
}

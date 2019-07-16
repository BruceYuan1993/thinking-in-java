package com.bruce.demo.annotations.orm;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		if (args.length < 1){
			System.out.println("arguments: annotated classes");
			System.exit(0);
		}
		for (String string : args) {
			Class<?> cla = Class.forName(string);
			if (cla != null) {
				DBTable dbTable = cla.getAnnotation(DBTable.class);
				if (dbTable == null) {
					System.out.println("No DBTable annotations in class "+ string);
					continue;
				}
				String tbName = dbTable.name();
				if (tbName.length() < 1) {
					tbName = cla.getSimpleName().toUpperCase();
				}
				List<String> columnDef  = new ArrayList<String>();
				for (Field field : cla.getDeclaredFields()){
					String columnName = null;
					Annotation[] annotations = field.getAnnotations();
					if (annotations.length < 1) {
						continue;
					}
					if (annotations[0] instanceof SQLInteger){
						SQLInteger sInteger  = (SQLInteger)annotations[0];
						if(sInteger.name().length() < 1){
							columnName = field.getName().toUpperCase();
						}else {
							columnName = sInteger.name();
						}
						columnDef.add(columnName + " INT "+ getConstraints(sInteger.constraints()));
					}
					if (annotations[0] instanceof SQLString){
						SQLString sInteger  = (SQLString)annotations[0];
						if(sInteger.name().length() < 1){
							columnName = field.getName().toUpperCase();
						}else {
							columnName = sInteger.name();
						}
						columnDef.add(columnName + " VARCHAR("+sInteger.value()+") "+ getConstraints(sInteger.constraints()));
					}
				}
				
				StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tbName +"("); 
				for(String s : columnDef){
					createCommand.append("\n" + s + ",");
				}
				String tableCreate = createCommand.substring(0, createCommand.length() - 1) + ")";
				System.out.println("Table Creation SQL for " + string +" is :\n"+tableCreate);
			}
		}
	}
	private static String getConstraints(Constraints con){
		String constraints = "";
		if(!con.allowNull()){
			constraints += " NOT NULL";
		}
		if(con.primaryKey()){
			constraints += " PRIMARY KEY";
		}
		if(con.unique()){
			constraints += " UNIQUE";
		}
		return constraints;
	}
}

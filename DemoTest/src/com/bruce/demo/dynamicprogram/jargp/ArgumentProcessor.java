package com.bruce.demo.dynamicprogram.jargp;

import java.lang.reflect.Field;


public class ArgumentProcessor {
	private Object m_targetObject;
	private int m_currentIndex;
	
	public ArgumentProcessor(ParameterDef[] parms, Object target){
		for (ParameterDef parameterDef : parms) {
			parameterDef.bindingToClass(target.getClass());
		}
		m_targetObject = target;
		
		
	}
	public void setValue(Object value, Field field){
		try {
			field.set(m_targetObject, value);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int processArgs(String[] args,
	        ParameterDef[] parms, Object target) {
	        ArgumentProcessor inst = new ArgumentProcessor(parms, target);
	        
			return 0;
	    }
}

package com.bruce.demo.dynamicprogram.jargp;

import java.lang.reflect.Field;

public abstract class ParameterDef {
	protected char m_char; //-
	protected String m_name; //
	protected Field m_field; //this field
	
	protected ParameterDef(char mChar, String mName) {
		m_char = mChar;
		m_name = mName;
	}

	public char getFlag() {
		return m_char;
	}
	
	protected void bindingToClass(Class<?> cls) {
		try {
			m_field = cls.getDeclaredField(m_name);
			m_field.setAccessible(true);
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	 public abstract void handle(ArgumentProcessor proc);
}

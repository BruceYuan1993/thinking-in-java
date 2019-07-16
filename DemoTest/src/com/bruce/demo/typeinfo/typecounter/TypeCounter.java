package com.bruce.demo.typeinfo.typecounter;

import java.util.HashMap;
import java.util.Map.Entry;

public class TypeCounter extends HashMap<Class<?>, Integer> {
	private Class<?> baseClass;

	public TypeCounter(Class<?> baseClass) {
		this.baseClass = baseClass;
	}

	public void count(Object obj) {
		Class<?> cls = obj.getClass();
		countClass(cls);
//		if (cls != null && baseClass.isAssignableFrom(cls)) {
//			
//		} else {
//			throw new RuntimeException();
//		}
	}

	private void countClass(Class<?> cls) {
		if (cls != null && baseClass.isAssignableFrom(cls)) {
			Integer count = get(cls);
			put(cls, count == null ? 1 : count + 1);
			Class<?> up = cls.getSuperclass();
			countClass(up);
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuilder result = new StringBuilder("{");
		for (Entry<Class<?>, Integer> pair : entrySet()) {
			result.append(pair.getKey().getSimpleName());
			result.append("=");
			result.append(pair.getValue());
			result.append(",");
		}
		result.delete(result.length() - 1, result.length());
		result.append("}");
		return result.toString();
	}
}

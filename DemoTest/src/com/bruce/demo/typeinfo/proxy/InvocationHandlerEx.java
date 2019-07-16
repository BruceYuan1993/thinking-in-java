package com.bruce.demo.typeinfo.proxy;

import java.lang.reflect.InvocationHandler;

public interface InvocationHandlerEx extends InvocationHandler{
	Object getStub(Class stubClass);
}

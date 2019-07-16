package com.bruce.demo.typeinfo.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
	public static void main(String[] args) throws RemoteException, Exception {
		PersonService personService = new PersonServiceImpl();
		LocateRegistry.createRegistry(6600);
		Naming.rebind("rmi://127.0.0.1:6600/PersonService", personService);
		System.out.println("service started");
	}
}

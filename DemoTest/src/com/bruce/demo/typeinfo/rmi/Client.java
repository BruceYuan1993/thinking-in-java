package com.bruce.demo.typeinfo.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class Client {

	/**
	 * @param args
	 * @throws Exception
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	public static void main(String[] args) throws MalformedURLException,
			RemoteException, Exception {
		// TODO Auto-generated method stub
		PersonService personService = (PersonService) Naming
				.lookup("rmi://127.0.0.1:6600/PersonService");

		for (PersonEntity person : personService.GetList()) {
			System.out.println("ID:" + person.getId() + " Age:"
					+ person.getAge() + " Name:" + person.getName());
		}
	}

}

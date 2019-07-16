package com.bruce.demo.thread.threadlocal;

public interface TransactionManager {
	Connection getConnection();
	void beginTransaction();
	void commit();
	void rollBack();
}
 class Connection{
	void commit(){
		System.out.println("Commit");
	}
	
	void close(){
		System.out.println("close");
	}
	boolean isClosed()
	{
		return false;
	}
	void rollback(){
		System.out.println("roll back");
	}
}

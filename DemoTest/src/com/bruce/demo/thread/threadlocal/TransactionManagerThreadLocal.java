package com.bruce.demo.thread.threadlocal;

public class TransactionManagerThreadLocal implements TransactionManager {
	private static final ThreadLocal<TransactionManager> tranManager = new ThreadLocal<TransactionManager>(){

		@Override
		protected TransactionManager initialValue() {
			// TODO Auto-generated method stub
			return new TransactionManagerImpl();
		}
		
	};
	//proxy
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return tranManager.get().getConnection();
	}

	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollBack() {
		// TODO Auto-generated method stub
		
	}
	
}

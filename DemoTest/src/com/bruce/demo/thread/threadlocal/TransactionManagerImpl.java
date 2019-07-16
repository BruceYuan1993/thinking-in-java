package com.bruce.demo.thread.threadlocal;

import java.util.Stack;

public class TransactionManagerImpl implements TransactionManager{
	private Stack<Connection> connections = new Stack<Connection>();
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		if (connections.isEmpty()){
			this.addConn();
		}
		return connections.peek();
	}
	
	private void addConn() {
        try {
            Connection con = new Connection();
            connections.push(con);
            System.out.println(con.toString() +"--Conection---");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		this.addConn();
	}

	@Override
	public void commit() {
		// TODO Auto-generated method stub
		if (connections.peek() != null&& !connections.peek().isClosed()) {
            System.out.println(connections.peek().toString() +"--Commit---");
            connections.peek().commit();
            connections.pop().close();
        }
	}

	@Override
	public void rollBack() {
		// TODO Auto-generated method stub
		if (connections.peek() != null&& !connections.peek().isClosed()) {
            System.out.println(connections.peek().toString() +"--Rollback---");
            connections.peek().rollback();
            connections.pop().close();
        }
	}
	
	

}

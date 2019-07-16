package com.bruce.demo.exception;

class NeedsCleanup{
	private static long counter = 1;
	private final long id = counter++;
	public void dispose(){
		System.out.println("NeedsCleanup" + id + " Disposed");
	}
}

class ConstructionException extends Exception{}

class NeedsCleanup2 extends NeedsCleanup{
	public NeedsCleanup2() throws ConstructionException{}
}


public class CleanupIdiom {
	public static void main(String[] args) {
		NeedsCleanup n1 = new NeedsCleanup();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			n1.dispose();
		}
		
		NeedsCleanup n2 = new NeedsCleanup();
		NeedsCleanup n3 = new NeedsCleanup();
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			n3.dispose();
			n2.dispose();
		}
		
		try {
			NeedsCleanup2 n4 = new NeedsCleanup2();
			try {
				NeedsCleanup2 n5 = new NeedsCleanup2();
				try {
					
				} catch (Exception e) {
					// TODO: handle exception
				}finally{
					n5.dispose();
				}
			} catch (ConstructionException e) {
				// TODO: handle exception
				System.out.println(e);
			}finally{
				n4.dispose();
			}
		} catch (ConstructionException e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
}

package com.xzz.com.dummy;

public class ExceptionTests {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(new ExceptionThrower(){

			@Override
			public void DoSomething() {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public static void test(ExceptionThrower et){
		try {
			et.DoSomething();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

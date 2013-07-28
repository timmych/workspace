package com.xzz.util;

import java.util.Date;

public class Timing {
	public Timing(){
		
	}
	
	private Date lastCheck;

	public void reset(){
		lastCheck = new Date();
	}
	
	public void check(String s){
		Date newDate = new Date();
		System.out.printf("[timer]%s::%d\n", s, newDate.getTime() - lastCheck.getTime());
		lastCheck = new Date();
	}
}

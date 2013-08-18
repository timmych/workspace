package com.foo.bar.sandbox;

import java.util.Arrays;
import java.util.List;

public class Sandbox {
	public static void main(String[] args){
		String s = "";//System.getProperty("blar");
		if(s != null){
			for(String k : s.split(",")){
				System.out.println(">>>" + k);
			}
			List<String> blarList = Arrays.asList(s.split(","));
			System.out.println(blarList);
		}
		System.out.println();
	}
}

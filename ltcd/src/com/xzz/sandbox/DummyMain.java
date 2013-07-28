package com.xzz.sandbox;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    Integer i = 1;
	    int j = 1;
	    System.out.println(i == j);
		// TODO Auto-generated method stub
//		Boolean b = null;
//		System.out.println(!b);
		System.out.println(new String[]{"foo", "bar"});
		System.out.println(Arrays.asList("foo", "bar"));
		List<String> a = Arrays.asList("foo", "bar");
		List<String> b = Arrays.asList("bar", "foo");
		Collections.sort(a);
		Collections.sort(b);
		System.out.println(a.equals(b));
		
		Map<String, List<String>> myMap = new HashMap<String, List<String>>();
		myMap.put("a", a);
		myMap.put("d", b);
		System.out.println(myMap);
		
		
		
		System.out.println(String.format("%s=>%s", "foo", null));
		System.out.println(Arrays.asList(myMap, null).toString());
	}

}

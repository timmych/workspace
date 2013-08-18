package com.foo.bar.sandbox;

public class hanoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new hanoi().hanoi(1, 2, 3, 3);
	}

	public void hanoi(int from, int to, int spare, int height){
		if(height == 0){
			return;
		}
		
		hanoi(from, spare, to, height - 1);
		System.out.println(String.format("moving plate #%d from %d to %d ..", height, from, to));
		hanoi(spare, to, from, height - 1);
	}
}

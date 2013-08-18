package com.foo.bar.sandbox;


public class NextBits {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(toBits(-1));
//		System.out.println(toBits(0));
//		System.out.println(toBits(Integer.MAX_VALUE));
//		System.out.println(toBits(Integer.MIN_VALUE));
//		
//		for(int i = 0; i < 32; ++i){
//			System.out.println(toBits(1 << 31));
//			System.out.println(toBits(Integer.MIN_VALUE));
			
		//int test = 1;
		//System.out.println(test << 31);
		//System.out.println(((long)test) << 31);
			
			
		NextBits nb = new NextBits();
		//1010=>1100
		//1011=>1101
		//10110=>11001
		//101001=>101010
		//10000=>100000
		//11000=>100001
		for(int i = 0; i < 50; ++i){
			System.out.print(String.valueOf(toBits(i)) + " => ");
			System.out.println(String.valueOf(toBits(nb.fip(i))));
			//System.out.println(toBits(nb.getNextSmallest(i)));
		}
		
		int test = Integer.MAX_VALUE - 7621 << 1;
		System.out.print(String.valueOf(toBits(test)) + " => ");
		System.out.println(String.valueOf(toBits(nb.fip(test))));
	}
	
	public int fip (int n){
		// 1010 => 0101
		// 1110 => 1101
		// 0110 => 1001
		long mask = Long.parseLong("10101010101010101010101010101010", 2);
		long leftToRight = (n & mask) >> 1;
		long rightToLeft = (n & (mask >> 1)) << 1;
		return (int) (leftToRight | rightToLeft);
	}

	private static char[] toBits(int i) {
	//	System.out.println("processing: " + i);
		char[] str = new char[32];
		
		for(int k = 0; k < 32; ++k){
			str[31 - k] = (i & (1 << k)) != 0 ? '1' : '0';
		}
		return str;
	}
	
	public int getNextSmallest(int n) {
		//1010=>1100
		//1011=>1101
		//10110=>11001
		//101001=>101010
		//10000=>100000
		//11000=>100001
		
		long mask = 1;
		int ones = 0;
		int i = 0;
		for(; i < 32; ++i){
			if((n & mask) != 0){
				if((n & (mask << 1)) == 0){
					n |= (mask << 1);
					break;
				}else{
					ones++;
				}
			}
			mask <<= 1;
		}
		
		mask = 1;
		for(int k = 0; k <= i; ++k){
			if(ones-- > 0){
				n |= mask;
			}else{
				n &= ~mask;
			}
			mask <<= 1;
		}
		return n;
	}
}

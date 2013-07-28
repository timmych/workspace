package com.xzz.sandbox;


public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println (new BestTimeToBuyAndSellStock().maxProfit(new int[]{
				//5,1,2,3,4,5,6,3,2,1
				//2,1,2,0,1
				2,1,4,5,2,9,7
		}));
	}

	public class Pair{
		public int low;
		public int high;
		public Pair(int low, int high){
			this.low = low;
			this.high = high;
		}
	}

	
	private int maxGain = 0;
	public int maxProfit(int[] prices) {
		maxGain = 0;
		mergePrices(prices, 0, prices.length - 1);
		return maxGain;
	}
	
	private Pair mergePrices(int[] prices, int start, int end){
		if(start > end){
			return null;
		}
		if(start == end){
			return new Pair(prices[start], prices[end]);
		}
		else if(end - start == 1){
			if(prices[start] > prices[end]){
				return new Pair(prices[end], prices[start]);
			}else{
				if(prices[end] - prices[start] > maxGain){
					maxGain = prices[end] - prices[start];
				}
				return new Pair(prices[start], prices[end]);
			}
		}
		int mid = (start + end) / 2;
		Pair left = mergePrices(prices, start, mid);
		Pair right = mergePrices(prices, mid + 1, end);
		if(left == null || right == null){
			return null;
		}
		if(right.high - left.low > maxGain){
			maxGain = right.high - left.low;
		}
		
		return new Pair(Math.min(left.low, right.low), 
				Math.max(right.high, left.high));
	}

}

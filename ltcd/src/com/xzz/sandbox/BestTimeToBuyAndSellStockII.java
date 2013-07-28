package com.xzz.sandbox;



public class BestTimeToBuyAndSellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println (new BestTimeToBuyAndSellStockII().maxProfit(new int[]{
				//5,1,2,3,4,5,6,3,2,1
				//2,1,2,0,1
				2,1,4,5,2,9,7
		}));
	}
	
    public int maxProfit(int[] prices) {
    	int day = 0;
    	int lastBuy = -1;
    	int gain = 0;
    	while(day < prices.length){
    		if(lastBuy < 0){
    			//nothing bought
    			if(day + 1 < prices.length){
    				 if( prices[day + 1] > prices[day] ){
    					 lastBuy = prices[day];//buy it because it's going up
    				 }
    			}
    		}else{//bought, find a date to sell
    			if(day + 1 == prices.length){//last day , sell
    				gain += (prices[day] - lastBuy);
    			}else{
    				if(prices[day + 1] < prices[day]){//its going to drop, sell
    					gain += (prices[day] - lastBuy);
    					lastBuy = -1;
    				}
    			}
    		}
    		++day;
    	}
    	return gain;
    }

}

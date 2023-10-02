package mandatoryHomeWork.Foundation;

import org.junit.Test;

import junit.framework.Assert;

public class p05__BuyAndSell {
	
	@Test
	public void test() {
		
		int[] prices = {3,2,5,4,7};
		int findMaxProfit = findMaxProfit(prices);
		System.out.println(findMaxProfit);
		
		Assert.assertEquals(5, findMaxProfit);
	}
	
	@Test
	public void test1() {
		
		int[] prices = {7,6,5,4,1};
		int findMaxProfit = findMaxProfit(prices);
		System.out.println(findMaxProfit);
		
		Assert.assertEquals(0, findMaxProfit);
	}
	
	
	public int findMaxProfit(int[] prices) {
		
		
		int buy = prices[0];
		int maxProfit = 0;
		
		for (int i = 0; i < prices.length; i++) {
			
			if(buy>prices[i]) {
				buy=prices[i];
			}else if(prices[i]-buy >maxProfit) {
				maxProfit=prices[i]-buy;
			}
		}
	return maxProfit;
	}
	

}

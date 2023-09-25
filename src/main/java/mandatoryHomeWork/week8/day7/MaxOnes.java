package mandatoryHomeWork.week8.day7;

import org.testng.annotations.Test;

public class MaxOnes {
	

	@Test
	public void testData() {
		
		int arithmeticProgressionOutput = findMaxOnes(new int[] {1,0,1,1,0,1});
		System.out.println(arithmeticProgressionOutput);
	}

	private int findMaxOnes(int[] num) {
		int left = 0, right = 0, maxCount =  0, count = 0 ;
		while(right<=num.length-1) {
			if(num[right]==1) {
				count++;
				right++;
				if(count>maxCount) {
					maxCount=count;
				}
			}else if(num[right]==0) {
					right++;
					left = right;
					count=0;
				}
			}		
		return maxCount;
	}
	
	/*
	  int left = 0, right = 0, maxCount =  0;

 
	 */
	
	
	
}

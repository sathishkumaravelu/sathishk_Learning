package mandatoryHomeWork.week7.day7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumOfConsecutiveTarget {


	/*
	 * Problem Statement:
	 * Highest sum of any three consecutive element 
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - int[] array
	 * 		Output - int
	 * 		constrains
	 * 	
	 * 
	 * 2. Test Data
	 * 3. do you know solution ? Yes
	 * 4. Best solution / alternate solution -
	 * 5. Pseudo code
	 * 6. dry run the pseudo code
	 * 7. write the code on notepad
	 * 8. dry run the code on notepad
	 * 9. Write code on IDE
	 * 10. Test and debug
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		
		int sum =consecutiveSum(new int[] {1,5,2,3,7,1});
		Assert.assertEquals(sum, 12);
		
	}
	
	@Test
	public void invalidData() {
		
		
		int sum =consecutiveSum(new int[] {1,5,2,3,7});
		Assert.assertEquals(sum, 12);
	}
	@Test
	public void edgeData() {
		int sum =consecutiveSum(new int[] {-1,-5,-2,-1});
		Assert.assertEquals(sum, -8);
	
	}
	
	//Pseudo Code
	
	
	
	
	//Time complexity 
	//Space complexity
	
	public int consecutiveSum( int[] num ){
		int maxSum=0;
		//int maxSum=Integer.MIN_VALUE;
		int sum=0;
		if(num.length<=3) return num[0]+num[1]+num[2];
		for(int i=0;i<=num.length/2;i++) {
			int j=i+1; 
			int k=j+1;
			//sum = num[i]+num[j]+num[k];
			sum = sumOfThree(num[i],num[j],num[k]);
			
			if(maxSum<sum) {
				maxSum=sum;
			}
		}
		if(num.length%2!=0) {
			int temp = num.length/2;
			//sum=num[temp]+num[temp+1]+num[temp+2];
			sum = sumOfThree(num[temp],num[temp+1],num[temp+2]);
			if(maxSum<sum) {
				maxSum=sum;
			}
		}
	return maxSum;
	}
	
	private int sumOfThree(int a, int b, int c) {
		
		return a+b+c;
	}
	
	
	
	
}

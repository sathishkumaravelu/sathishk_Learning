package mandatoryHomeWork.week7.day7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SlidingWindow {
	@Test
	public void validData() {
		
		int sum =slidingWindow1(new int[] {1,5,2,3,7,1},3);
		Assert.assertEquals(sum, 12);
		
	}
	
	@Test
	public void invalidData() {
		
		
		int sum =slidingWindow1(new int[] {1,5,2,3,7},4);
		Assert.assertEquals(sum, 17);
	}
	@Test
	public void edgeData() {
		int sum =slidingWindow1(new int[] {-1,-5,-2,-1},3);
		Assert.assertEquals(sum, -8);
	
	}
	
	
	private int slidingWindow(int[] nums, int k){
		int max =Integer.MIN_VALUE, pointer = 0, currentSum=0;
		 while(pointer < k)
	            currentSum += nums[pointer++];
		 while( pointer < nums.length){
	            max = Math.max(currentSum, max);
	            currentSum += nums[pointer] - nums[pointer-k];
	            pointer++;
	        }
		 return Math.max(currentSum, max);
	}
	
	
	
	private int slidingWindow1(int[] nums, int k){
		int max =Integer.MIN_VALUE, pointer = 0, currentSum=0;
		 while(pointer < k)
	            currentSum += nums[pointer++];
		for(int i=pointer;i<nums.length;i++){
	            max = Math.max(currentSum, max);
	            currentSum += nums[i] - nums[i-k];
	            
	        }
		 return Math.max(currentSum, max);
	}
	
	
	
}

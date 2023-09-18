package mandatoryHomeWork.week7.day6.Twpinter;

import org.junit.Assert;
import org.testng.annotations.Test;

public class TwoSum {

	/*
	 * Problem statement: Given a sorted array of integers nums and an integer
	 * target, return indices of the two numbers such that they add up to target.
	 * Input: nums = [2,3,5,7], target = 9 Output: [0,3] Output: Because nums[0] +
	 * nums[3] == 9, we return [0, 3].
	 */
	
	
	/*
	 * Understanding :
	 * input - int array , int target 
	 * output - int array 
	 * constrain 
	 * 
	 * 
	 * Test data :
	 * 
	 * 1. [2,3,5,7] - 9 output [0,3]
	 * 2. [2,3,4,4,5] - 8  output [1,4]
	 * 3. [0,1,2,3,4] - 12 output[0,0]
	 * 4. [2,2,4,4] - 6 output[0,3]//[1,3]/[1,2]/[0,2]
	 * 
	 * 
	 * Know the solution - yes 
	 * best solution - 2 pointer
	 * pseudo code
	 * 
	 * take the start index  end index should be length-1 
	 * while start index == end index 
	 * 		
	 * 		sum = start index + end index;
	 * 	if sum == target
	 * 		return the sum and target 
	 * 		else 
	 * 			end --;  
	 * out side while again 
	 *
	 *********************************************
	 *
	 *  take the start value as zero , end value as lenght()-1
	 *	
	 *	iterate thru start<end
	 *		- sum the start value and end value if the sum matches the target
	 *		return the start and end value 
	 *		- 	sum the start value and end value if the sum < the target
	 *			decrement the end value 
	 *		- 	sum the start value and end value if the sum > the target
	 *			increment the start value 
	 *	
	 *		if not return the default value 
	 *
	 * 	
	 * int start =0;
	 * int endValue= nums.length()-1;
	 * int[] result = new int[2];
	 * while(start<endvalue){
	 * 		sum = nums[start]+nums[endValue];
	 * 		if(sum==target){
	 * 		result[0] = start;
	 * 		result[1] = end;
	 * 		return result;
	 * 		}else if(sum>target){
	 * 					
	 * 			endValue--;
	 * 		}else if(sum<target){
	 * 			start++;
	 * 		}
	 * 
	 * }
	 * return result;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	@Test
	public void validData() {
		int[] twoSum = twoSum(new int[] {2,3,5,7},9);
		Assert.assertArrayEquals(twoSum, new int[] {0,3});
	}
	@Test
	public void invalidData() {
		int[] twoSum = twoSum(new int[] {2,3,4,4,5},8);
		Assert.assertArrayEquals(twoSum, new int[] {1,4});
		
	}
	@Test
	public void edgeData() {
	
		int[] twoSum = twoSum(new int[] {0,1,2,3,4},12);
		Assert.assertArrayEquals(twoSum, new int[] {0,0});
		
	}
	
	
	public int[] twoSum(int[] nums, int target) {

		int[] result = { 0, 0 };
		int start = 0;
		int endValue = nums.length - 1;
		while (start < endValue) {
			int sum = 0;
			sum = nums[start] + nums[endValue];
			if (sum == target) {
				result[0] = start;
				result[1] = endValue;
				return result;
			} else if (sum > target) {
				endValue--;
			} else if (sum < target) {
				start++;
			}
		}
		return result;
	}
	
	
}

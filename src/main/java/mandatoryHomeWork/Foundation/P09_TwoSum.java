package mandatoryHomeWork.Foundation;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P09_TwoSum {

	/*
	 * input = int[] array and i have target int op = int[] array constrain is to
	 * add two element's and need to return the index of the elemetns that maches
	 * the sum to target -----
	 * 
	 * TD:
	 * 
	 * int[] nums= {2,7,11,15} --> 9 0,1
	 * 
	 * 
	 * int[] nums =[2,3,4,3] target --> 6
	 * 
	 * [0,2]
	 * 
	 * int[] nums =[2,3,4,5] target = 11 [-1,-1]
	 * 
	 * --------
	 * 
	 * 1. set the value in int array and set the target in int 2. for a forloop with
	 * the size of the array 3. create a output int array size 2 for(int
	 * i=0;i<=array.length-1;i++){ for(int j=i+1;i<=array.length;j++){
	 * 
	 * if(num[i]+num[j]==target){
	 * 
	 * output.add(i,j); return output;
	 * 
	 * } } }retrun [-1,-1]
	 * 
	 * 
	 */
	
	@Test
	 public void testTwoSumNoSolution() {
	        int[] nums = {2, 7, 11, 15};
	        int target = 20;
	        int[] twoSum = twoSum(nums, target); // Expects an IllegalArgumentException
	       System.out.println("testTwoSumNoSolution "+Arrays.toString(twoSum));
	       
	       Assert.assertArrayEquals(new int[] {-1,-1}, twoSum);
	    }

	@Test
	 public void testTwoSumNoSolution1() {
	        int[] nums = {2,7,11,15};
	        int target = 9;
	        int[] twoSum = twoSum(nums, target); // Expects an IllegalArgumentException
	       System.out.println("testTwoSumNoSolution1 "+Arrays.toString(twoSum));
	       Assert.assertArrayEquals(new int[] {0, 1}, twoSum);
	    }
	
	@Test
	 public void testTwoSumNoSolution2() {
	        int[] nums = {2,3,4,3};
	        int target = 6;
	        int[] twoSum = twoSum(nums, target); // Expects an IllegalArgumentException
	       System.out.println("testTwoSumNoSolution2 "+Arrays.toString(twoSum));
	       Assert.assertArrayEquals(new int[] {0, 2}, twoSum);
	    }
	
	int[] twoSum(int[] nums, int target) {
		// Iterate over each element in the array
		for (int i = 0; i < nums.length; i++) {
			// Check if there is another element that sums up to the target
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] { i, j }; // Return the indices if found
				}
			}
		}
		return new int[] {-1,-1};

	}
}

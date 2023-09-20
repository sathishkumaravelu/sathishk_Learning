package mandatoryHomeWork.week8.day1;

import org.junit.Assert;
import org.testng.annotations.Test;

public class W8_D1_DSA_LC_905_SortArray_OddEven {


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/sort-array-by-parity/description/
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem - 2 Min
	 * 		Input  - int []
	 * 		Output - int[]
	 * 		constrains
    		1 <= nums.length <= 5000
    		0 <= nums[i] <= 5000

	 * 	
	 * 
	 * 2. Test Data - 2 Min
	 * 3. do you know solution ?  Yes
	 * 4. Best solution / alternate solution - 2 Pointer
	 * 5. Pseudo code - 5 Min
	 * 6. dry run the pseudo code - 5 Min
	 * 7. write the code on notepad - 5 Min
	 * 8. dry run the code on notepad - 5 Min
	 * 9. Write code on IDE - 2 Min 
	 * 10. Test and debug - 2 Min 
	 * 11. Code optimization - Yes
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		int[] sortArrayByParity = sortArrayByParity(new int[] {3,1,2,4});
		Assert.assertArrayEquals(sortArrayByParity, new int[] {4,2,1,3});
	}
	
	@Test
	public void invalidData() {
		int[] sortArrayByParity = sortArrayByParity(new int[] {5,3,4,3,1});
		Assert.assertArrayEquals(sortArrayByParity, new int[] {4,5,3,1,3});
	}
	
	@Test
	public void edgeData() {
		int[] sortArrayByParity = sortArrayByParity(new int[] {5});
		Assert.assertArrayEquals(sortArrayByParity, new int[] {5});
	}
	@Test
	public void edgeData1() {
		int[] sortArrayByParity = sortArrayByParity(new int[] {1,0,5});
		Assert.assertArrayEquals(sortArrayByParity, new int[] {0,1,5});
	}
	
	//Pseudo Code
	/*
	 * 1. if length of the input array is zero then return the same 
	 * 2. initalize 2 pointer left and right 
	 * 		left = 0 ; right = input.length
	 * 3. iterate thru till left < right 
	 * 		
	 * 		check if the value of left is odd and right is even
	 * 			then swap the values and increment left and decrement right 
	 * 		check if the value of left is odd and right is odd
	 * 			then increment the left
	 * 		check if the value of left is even and right is even
	 * 			then swap the values increment left
	 * 		check if the value of left is even and right is odd
	 * 			then increment the left and decrement right 
	 */
	
	
	
	//Time complexity O(N)
	//Space complexity O(1)
	
	public int[] sortArrayByParity1(int[] nums) {
		//if(nums.length==0)return nums;
		int left =0, right = nums.length-1;		
		while(left<right) {	
			if(nums[left]%2!=0 && nums[right]%2==0) {
				int temp = nums[right];
				nums[right--]=nums[left];
				nums[left++]=temp;
			}else if(nums[left]%2!=0 && nums[right]%2!=0) {
				left++;
			}else if(nums[left]%2==0 && nums[right]%2==0) {
				int temp = nums[right];
				nums[right]=nums[left];
				nums[left++]=temp;
			}else if(nums[left]%2==0 && nums[right]%2!=0) {
				left++;
				right--;
			}
		}
		return nums;
	}

	
	//Pseudo Code
		/*
		 * 1. if length of the input array is zero then return the same 
		 * 2. initalize 2 pointer left and right 
		 * 		left = 0 ; right = input.length
		 * 3. iterate thru till left < right 
		 *       if value of left is even, increment left
		 *       if value of right is odd, decrement right
		 *       else 
		 *       	swap the value and increment left and decrement right
		 */
		
	//Time complexity - O(n) worst case / o(n/2)  best 
	//Space complexity - O(1) 
	/** Optimized code***/
	public int[] sortArrayByParity(int[] nums) {
		if(nums.length==0)return nums;
		int left =0, right = nums.length-1;
		while(left<right) {
			if(nums[left]%2==0) {
				left++;
			}else if(nums[right]%2!=0) {
				right--;
			}else {
				int temp = nums[right];
				nums[right--]=nums[left];
				nums[left++]=temp;
			}
		
		}
		return nums;
	}

	//Time complexity - O(n) 
	//Space complexity - O(1) 
	/** Optimized code uni directional***/
	public int[] sortArrayTwoPointerUniDirectional(int[] nums) {
		int slow = 0,fast = 0;
		while(fast<nums.length) {
			if(nums[fast]%2==0 && nums[slow]%2!=0 ) {
				int temp = nums[fast];
				nums[fast++]= nums[slow];
				nums[slow++]=temp;
			}else if(nums[fast]%2!=0 && nums[slow]%2!=0) {
				fast++;
			}else {
				fast++;
				slow++;
			}
		}
		return nums;
	}
}

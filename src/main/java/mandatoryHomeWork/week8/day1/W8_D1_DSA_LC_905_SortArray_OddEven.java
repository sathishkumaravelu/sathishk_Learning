package mandatoryHomeWork.week8.day1;

import org.junit.Assert;
import org.testng.annotations.Test;

public class W8_D1_DSA_LC_905_SortArray_OddEven {


	/*
	 * Problem Statement:
	 * 
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - 
	 * 		Output -
	 * 		constrains
	 * 	
	 * 
	 * 2. Test Data
	 * 3. do you know solution ? 
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
	
	
	
	//Time complexity 
	//Space complexity
	
	public int[] sortArrayByParity1(int[] nums) {
		
		if(nums.length==0)return nums;
		
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


}

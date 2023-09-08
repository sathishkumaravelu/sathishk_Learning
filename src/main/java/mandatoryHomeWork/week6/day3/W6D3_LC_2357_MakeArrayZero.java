package mandatoryHomeWork.week6.day3;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W6D3_LC_2357_MakeArrayZero {
	
	/*
	Problem Statement:
	https://leetcode.com/problems/make-array-zero-by-subtracting-equal-amounts/description/
	 
	You are given a non-negative integer array nums. In one operation, you must:
	Choose a positive integer x such that x is less than or equal to the smallest non-zero element in nums.
	Subtract x from every positive element in nums.
	Return the minimum number of operations to make every element in nums equal to 0.
	
	1. Problem understanding - 2 Mins
		input - int array
		output - int 
		constrain 
		1 <= nums.length <= 100
		0 <= nums[i] <= 100
	2. Test Data - 2 mins
	3. do you know the solution - Yes
	4. do you know the alternate solution - no
	5. Pseudo code - 7 mins
	6. Dry run the pseudo code - 1 Min
	7. Write the code on notepad - 3 Mins
	8. Dry run the code with all test data - 2 Mins
	9. Write code on IDE - 1 Min
	10. Test the code + Debug the code - 1 Min
	11. Check for any gaps of code optimization - NA
	 
	 */

	
	@Test
	public void validData() {
		
	
		int[] nums = {1,1,3,4,3,1};
		int minValue = minimumOperations(nums);
		Assert.assertEquals(minValue, 3);
//	x=1:0,0,0,2,2,3
//	x=2:2,2,3
//	x=1:0,0,1
//		0,0,0
		
	}
	@Test
	public void negativeData1() {
		
		int[] nums = {0,0,0,0,0,0};
		int minValue = minimumOperations(nums);
		Assert.assertEquals(minValue, 0);
		//x=0 since its already zero	
	}
	@Test
	public void edgeData1() {
		
		int[] nums = {0,0,0,0,0,100};
		int minValue = minimumOperations(nums);
		Assert.assertEquals(minValue, 1);
		//x=0 since its already zero	
	}

	
	
//	sort the array		
//	check if the last element of the array is zero, then return zero		
//	iterate the array to the length of the array		
//	have a value min value = 0		
//	iterate the array to the length of the array		
//	"- check if element value >= min value 
//	    update the min value as the element value"		
//	iterate the array to the length of the array		
//	"   - element value = element value - min value;
//	- add counter varaible as ++;		
	
	public int minimumOperations(int[] nums) {
		Arrays.sort(nums);
		int count=0;
		System.out.println(nums.length);
		if(nums[nums.length-1]==0)return count;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0) {
				int minValue= nums[i];
				count++;
				for (int j = i; j < nums.length; j++) {
					nums[j]=nums[j]-minValue;
				}
			}
		}
		

		return count;
	}
}

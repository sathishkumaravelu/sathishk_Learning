package mandatoryHomeWork.week8.day3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.testng.annotations.Test;

public class W8_D3_DSA_LC_ArithmeticTriplets {


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/number-of-arithmetic-triplets/description/
	 * 
	 */
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - int[], int
	 * 		Output - int
	 * 		constrains
	 * 		i < j < k,
	 *     nums[j] - nums[i] == diff, and
	 *     nums[k] - nums[j] == diff.

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
		int arithmeticTriplets = arithmeticTriplets(new int[] {0,1,4,6,7,10}, 3);
		System.out.println(arithmeticTriplets);
		
	}
	

	@Test
	public void invalidData() {
		int arithmeticTriplets = arithmeticTriplets(new int[] {4,5,6,7,8,9}, 2);
		System.out.println(arithmeticTriplets);
	}
	public void edgeData() {
		arithmeticTriplets(new int[] {0,1,4,6,7,10},10);
	
	}
	
	//Pseudo Code
	
//	initalize two pointer left and right 
//	where right length of the array 
//	left is right minus one 
//  iterate from the last value to the first digit of the array 
//	     - if difference of right and left is not equal to difference, decrement left
//	     - if difference of right and left is equal to difference, decrement right --
//	        then add the left and right value to hash map 
//
//	finally iterate thru the hash map, if value is  >=2 add count 
//
//	return count ;

	
	//Time complexity 
	//Space complexity
	
	public int arithmeticTriplets(int[] nums, int diff) {

		int right = nums.length - 1;
		int left = right;
		int uniqueArithmeticTriplets = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (left >= 0) {
			if (nums[right] - nums[left] != diff) {
				left--;
			} else if (nums[right] - nums[left] == diff) {
				int count = 0;
				if (map.containsKey(nums[right])) {
					count = map.get(nums[right]);
				}
				if (map.containsKey(nums[left])) {
					count = map.get(nums[left]);
				}
				map.put(nums[right], count + 1);
				map.put(nums[left], count + 1);
				right--;
				left--;
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int value = entry.getValue();
			if (value >= 2) {
				uniqueArithmeticTriplets++;
			}
		}
		return uniqueArithmeticTriplets;
	}
	

}

package mandatoryHomeWork.week8.day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W8D1_DSA_SubArray_Threshold {


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - int[] , int, int
	 * 		Output - int
	 * 		constrains:
    		1 <= arr.length <= 105
    		1 <= arr[i] <= 104
    		1 <= k <= arr.length
    		0 <= threshold <= 104

	 * 2. Test Data - 2 Min
	 * 3. do you know solution ?  Yes 
	 * 4. Best solution / alternate solution - Yes 
	 * 5. Pseudo code  - 5 Mins
	
		1. Initalize a variable left, right, windowSize
		2. get the first 3 value and sum the value and store in current sum value
		3. if the current sum value is greater then or equal to the threshold value increement a counter 
		4. iterate thru till the length 
			 to the currentsum, add the new value and decrement the initall left value 
			 check if the current sum value is greater then or equal to threshold value then increment the counter
			 increment the left and right pointer 
		5. finally return the counter"					
					
	 * 6. dry run the pseudo code - 2 Mins
	 * 7. write the code on notepad - 5 Mins
	 * 8. dry run the code on notepad - 2 Mins
	 * 9. Write code on IDE - 2 Mins
	 * 10. Test and debug - 1 Min
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		
		int numOfSubarrays = numOfSubarrays(new int[] {2,2,2,2,5,5,5,8},3,4 );
		Assert.assertEquals(numOfSubarrays,3);
	}
	@Test
	public void invalidData() {
		int numOfSubarrays = numOfSubarrays(new int[] {2,2,2,2},3,0 );
		Assert.assertEquals(numOfSubarrays, 2);
		
	}
	@Test
	public void edgeData() {
		int numOfSubarrays = numOfSubarrays(new int[] {2,2,2,2},2,1 );
		Assert.assertEquals(numOfSubarrays, 3);	
	
	}
	
	//Pseudo Code
	
	
	
	
	//Time complexity  - O(N)
	//Space complexity - O(1)
	
	public int numOfSubarrays(int[] arr, int k, int threshold) {
		int left = 0, right = k, counter = 0, currentSum = 0;
		while (left < right) {
			currentSum += arr[left++];
		}
		if (checkThreshold(currentSum, threshold, k)) {
			counter++;
		}
		while (left < arr.length) {
			currentSum += arr[left++] - arr[right - k];
			right++;
			if (checkThreshold(currentSum, threshold, k)) {
				counter++;
			}
		}
		return counter;
	}
	
	public boolean checkThreshold(int currentSum,int threshold,int k) {
		
		return currentSum / k >= threshold;
	}
}

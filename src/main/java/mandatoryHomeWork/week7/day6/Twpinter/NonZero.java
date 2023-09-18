package mandatoryHomeWork.week7.day6.Twpinter;

import java.util.Arrays;

import org.junit.Assert;
import org.testng.annotations.Test;

public class NonZero {


	/*
	 * Problem Statement:
	 * Given an integer array nums, move all 0's to the right of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
 
Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - int[]
	 * 		Output - output []
	 * 		constrains
	 * 	
	 * 
	 * 2. Test Data
	 * 
	 * [0,0,0,1] output - [1,0,0,0]
	 * [1,2,0,3,1] output - [1,2,3,1,0]
	 * [1,2,0,0,3,1] output - [1,2,3,1,0,0]
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
		int[] moveZero = moveZero(new int[] {0,1,0,3,12});
		System.out.println(Arrays.toString(moveZero));
		Assert.assertArrayEquals(moveZero, new int[] {1,3,12,0,0});
	}
	@Test
	public void invalidData() {
		int[] moveZero = moveZero(new int[] {1,0,3,12});
		System.out.println(Arrays.toString(moveZero));
		Assert.assertArrayEquals(moveZero, new int[] {1,3,12,0});
	}
	@Test
	public void edgeData() {
		int[] moveZero = moveZero(new int[] {0,0,0,0});
		System.out.println(Arrays.toString(moveZero));
		Assert.assertArrayEquals(moveZero, new int[] {0,0,0,0});
	}
	
	//Pseudo Code
	
//	1. assign the left and right value as zero
//	2. iterate thru left and right index cross the index
//	3. if the left index value is zero, right value is not zero , replace the left and right 
//	4. if the left value is not zero, increment the left (right should be always higher than the left)
//	5. if right is equal to zero, increment right
	
	
	//Time complexity 
	//Space complexity
	
	public int[] moveZero2( int[] input){
		int left=0;
		int right =0;
		
		while(left<input.length && right<input.length) {
			
			if(input[left]==0 && input[right] !=0) {
				input[left] = input[right];
				input[right]=0;
			}else if(input[left]!=0 ) {
				left++;
				right++;
			}else if(input[right]==0 ) {
				right++;
			}
		}
		
		//aString.valueOf(false);
		return input;
	}

	public int[] moveZero( int[] input){
	
		int s=0,f=0;
		
		if(input.length==0) return input;
		
		while (f<input.length) {
			
			if(input[f]!=0) {
				int temp = input[f];
				input[f++]=input[s];
				input[s++]=temp;
			}else {
				f++;
			}
		}
		return input;
	}
		
}

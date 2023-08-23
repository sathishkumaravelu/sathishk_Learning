package mandatoryHomeWork.week4.day1;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class W4_D3_LC_561_Array_Partition {

	/*
	 * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.
	 * 
	 * 1. Problem understanding : 15 Mins
	 * 2. Test data enumuration : 10 Mins
	 * 		valid data : 
	 * 		[3,1,4,5,2,6] - 9
	 * 		[1,2,4,6,8,9] - 13
	 * 		invalid data:
	 * 		[0,1] - 0
	 * 		Edge data:
	 * 		[6,6,6,6,6,6] - 18
	 * 3. do you know the solution - Yes  
	 * 4. do you know the alternate solution - No
	 * 7.Write the code on notepad  - 5 Mins
	 * 8. Dry run the code with all test data from step #2 - 3 Mins
	 * 9. Write code on IDE (remember to add comments and practice coding standards) -4 Mins
	 * 10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE 
	 * 11. Check for any gaps of code optimization (if not optimized already in Step #9)
	 */

	@Test
	public void validTest() {
		Assert.assertEquals(9,arrayPartition(new int[] {3,1,4,5,2,6}));
	}
	@Test
	public void validTest1() {
		Assert.assertEquals(13,arrayPartition(new int[] {1,2,4,6,8,9}));
	}
	
	@Test
	public void invalidTest() {
		Assert.assertEquals(0,arrayPartition(new int[] {0,0}));
	}
	
	
	@Test
	public void edgeTest() {
		Assert.assertEquals(18,arrayPartition(new int[] {6,6,6,6,6,6}));
	}
	
	
	public int arrayPartition(int [] num) {
		Arrays.sort(num);
		int sum=0;
		for (int i = 0; i < num.length; i++) {
			if(i%2==0) {
				sum+=num[i];
			}
		}
		return sum;
	}
	
}

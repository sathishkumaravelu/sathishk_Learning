package mandatoryHomeWork.java.week2;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class W2D1_LC_2455_EvenNoDivisibleByThree {

	/*
	 * Iterate thru the loop with the length of check if the no is even and divisble
	 * by 3
	 * increase the count variable also add the values divide the sum value by 2
	 * 
	 * 
	 * 
	 */

	@Test
	public void test() {
		int producArray = producArray(new int[] { 1, 3, 6, 10, 12, 15 });
		System.out.println(producArray);
		Assert.assertEquals(9, producArray);

	}

	@Test
	public void test2() {
		int producArray = producArray(new int[] { 1, 2, 4, 7, 10 });
		System.out.println(producArray);
		Assert.assertEquals(0, producArray);

	}

	public int producArray(int[] nums) {
		int count = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0 && nums[i] % 3 == 0) {
				sum = sum + nums[i];
				count++;
			}

		}
		if (count == 0) {
			return 0;
		}

		return sum / count;
	}

}

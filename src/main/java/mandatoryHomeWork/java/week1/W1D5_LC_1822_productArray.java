package mandatoryHomeWork.java.week1;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class W1D5_LC_1822_productArray {

	/*
	 * Iterate thru the loop with the length of the input check for the zeros
	 * present in the array, if so return directly zero check for negative value in
	 * the array, have a counter variable increase the value check if the counter is
	 * zero then return 0 check if the counter is odd or even, if its odd the return
	 * -1, else 1
	 * 
	 * 
	 */

	@Test
	public void test() {
		int producArray = producArray(new int[] {-1,-2,3,-1});
		System.out.println(producArray);
		Assert.assertEquals(-1, producArray);
		
	}

	@Test
	public void test1() {
		
		int producArray = producArray(new int[] {-1,-2,-3,-1});
		System.out.println(producArray);
		Assert.assertEquals(1, producArray);
		
	}
	
	@Test
	public void test2() {
		int producArray = producArray(new int[] {-1,-2,0,3,-1});
		System.out.println(producArray);
		Assert.assertEquals(0, producArray);
	
	}
	@Test
	public void test3() {
		int producArray = producArray(new int[] {1,2,3,1});
		System.out.println(producArray);
		Assert.assertEquals(1, producArray);
		
	}
	
	public int producArray(int[] nums) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 0) {
				return 0;
			} else if (nums[i] < 0) {
				count++;
			}
		}
		if (count != 0) {
			if (count % 2 == 0) {
				return 1;
			} else {
				return -1;
			}
		}
		return 1;
	}

}

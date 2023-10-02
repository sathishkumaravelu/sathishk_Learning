package mandatoryHomeWork.Foundation;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Day4_MoveZeros {

	/*
	 * 1. check the size of the arrray
	 *  2. iterate the element from the first index on the size check if num i == 0 
	 * 3. iterate the element from i+1, move the
	 * value of num[j] ==0 do nothing
	 * else move the num[j] to num[i] using a temp variable
	 *  return the nums[]
	 * 
	 */

	@Test
	public void test1() {

		int[] moveZeroes = moveZeroes(new int[] { 0, 1, 2, 3 });

		System.out.println("test 1 :" + Arrays.toString(moveZeroes));
		Assert.assertArrayEquals(new int[] {3, 2, 1, 0}, moveZeroes);
	}

	@Test
	public void test2() {

		int[] moveZeroes = moveZeroes(new int[] { 0, 0, 2, 3 });
		System.out.println("test 2 :" + Arrays.toString(moveZeroes));
		Assert.assertArrayEquals(new int[] {3, 2, 0, 0}, moveZeroes);
	}

	@Test
	public void test3() {

		int[] moveZeroes = moveZeroes(new int[] { 0, 0, 2, 23, 3, 0 });
		System.out.println("test 3 :" + Arrays.toString(moveZeroes));
		Assert.assertArrayEquals(new int[] {3, 23, 2, 0, 0, 0}, moveZeroes);
		
		
	}

	public int[] moveZeroes(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {

			if (nums[i] == 0) {

				for (int j = i + 1; j < nums.length; j++) {

					if (nums[j] == 0) {

					} else {
						int temp = nums[i];
						int temp1 = nums[j];
						nums[j] = temp;
						nums[i] = temp1;

					}

				}

			}

		}

		// System.out.println(Arrays.toString(nums));

		return nums;

	}

}

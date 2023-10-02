package mandatoryHomeWork.Foundation;
import java.util.Arrays;

import org.junit.Test;

public class Day2_PlusOne {

	@Test
	public void test1() {
		int[] nums = { 1, 2, 8 };
		int[] plusOne = plusOne(nums);
		System.out.println(Arrays.toString(plusOne));
	}

	@Test
	public void test2() {

		int[] nums = { 1, 2, 9 };
		int[] plusOne = plusOne(nums);
		System.out.println(Arrays.toString(plusOne));
	}

	@Test
	public void test3() {

		int[] nums = { 9, 9 };
		int[] plusOne = plusOne(nums);
		System.out.println(Arrays.toString(plusOne));
	}

	public int[] plusOne(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {

			if (nums[i] < 9) {
				nums[i]++;
				return nums;
			}
			nums[i] = 0;
		}
		int[] newarray = new int[nums.length + 1];

		newarray[0] = 1;
		return newarray;
	}
}

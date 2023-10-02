package mandatoryHomeWork.Foundation;

import java.util.Arrays;

import org.junit.Test;

public class p06_MajorityElement {

	@Test
	public void test() {

		int[] nums = { 3, 2, 3 };
		int checkMajorityElement = checkMajorityElement(nums);
		System.out.println(checkMajorityElement);
	}


	@Test
	public void test1() {

		int[] nums = { 2,2,1,1,1,2, 2 };
		int checkMajorityElement = checkMajorityElement(nums);
		System.out.println(checkMajorityElement);
	}
	
	public int checkMajorityElement(int[] nums) {

		Arrays.sort(nums);
		int count = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {

				if (nums[i] == nums[j]) {
					count++;
				}

			}

			if (count > nums.length / 2) {
				return nums[i];
			}
			count=1;
		}

		return 0;

	}

}

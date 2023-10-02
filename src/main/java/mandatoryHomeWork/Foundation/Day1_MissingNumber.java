package mandatoryHomeWork.Foundation;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class Day1_MissingNumber {

	@Test
	public void test() {

		int missingNumber = missingNumber(new int[] { 3, 0, 1 });
		System.out.println(missingNumber);
		Assert.assertEquals(2, missingNumber);

	}

	@Test
	public void test1() {
		int missingNumber = missingNumber(new int[] { 0,1 });
		System.out.println(missingNumber);
		Assert.assertEquals(2, missingNumber);
	}
	

	@Test
	public void test2() {
		int missingNumber = missingNumber(new int[] { 9,6,4,2,3,5,7,0,1 });
		System.out.println(missingNumber);
		Assert.assertEquals(8, missingNumber);
	}
	
	public int missingNumber(int nums[]) {

		int op = 0;
		Arrays.sort(nums);

		for (int i = 0; i <= nums.length; i++) {

			if(i==nums.length) {
				return nums.length;
			}else if (nums[i] != i) {
				 return i;
			}

		}
		return op;
		
		
	}
	
}

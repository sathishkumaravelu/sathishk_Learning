package mandatoryHomeWork.Foundation;

import org.junit.Test;

import junit.framework.Assert;

public class P02082023_occurrencesOfTarget {

	@Test
	public void test() {

		int checkOccurance = checkOccurance(new int[] { 1, 1, 2, 2, 2, 2, 3 }, 2);
		System.out.println(checkOccurance);
		Assert.assertEquals(4, checkOccurance);
	}

	@Test
	public void test1() {
		int checkOccurance = checkOccurance(new int[] { 1, 1, 2, 2, 2, 2, 3 }, 3);

		System.out.println(checkOccurance);
		Assert.assertEquals(1, checkOccurance);
	}

	@Test
	public void test2() {
		int checkOccurance = checkOccurance(new int[] { 1, 1, 2, 2, 2, 2, 3 }, 1);
		System.out.println(checkOccurance);
		Assert.assertEquals(2, checkOccurance);
	}

	@Test
	public void test3() {
		int checkOccurance = checkOccurance(new int[] { 1, 1, 2, 2, 2, 2, 3 }, 4);
		System.out.println(checkOccurance);
		Assert.assertEquals(-1, checkOccurance);
	}

	public int checkOccurance(int[] arr, int target) {
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == target) {
				counter++;
				if (arr[i] != target) {
					break;
				}
			}
		}

		if (arr.length == 0 || counter == 0) {
			return -1;
		}
		return counter;
	}

}

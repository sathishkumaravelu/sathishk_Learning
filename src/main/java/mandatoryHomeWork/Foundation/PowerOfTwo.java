package mandatoryHomeWork.Foundation;

import org.junit.Test;

public class PowerOfTwo {

	@Test
	public void Test1() {

		int n = 10;
		Boolean checkPowerOfTwo = checkPowerOfTwo(n);
		System.out.println(checkPowerOfTwo);
	}

	@Test
	public void Test2() {

		int n = 16;
		Boolean checkPowerOfTwo = checkPowerOfTwo(n);
		System.out.println(checkPowerOfTwo);
	}

	public Boolean checkPowerOfTwo(int num) {

		/*
		 * if (num <= 0) { return false; // Negative numbers and zero are not powers of
		 * two } else if (num == 1) { return true; }
		 */

		while (num % 2 == 0) {
			num = num / 2;
		}
		if (num == 1) {
			return true;
		}
		return false;
	}

}

package mandatoryHomeWork.Foundation;

import org.junit.Test;

public class Day3_AddDigit {

	@Test
	public void test1() {
		int n = 144;

		int value = addDigits(n);
		System.out.println(value);
	}

	public int addDigits(int n) {
		int value = 0;

		while (n > 9) {
			int rem=(n % 10);
			int q = (n/10);
			value = value + rem + q;
			n = value;
			value = 0;
		}

		return n;
	}

}

/*
 * 1+4+4 5+4 9
 */

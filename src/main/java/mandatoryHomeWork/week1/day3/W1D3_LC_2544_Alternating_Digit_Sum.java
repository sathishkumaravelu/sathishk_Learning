package mandatoryHomeWork.week1.day3;

import java.util.Iterator;

import org.junit.Test;

import junit.framework.Assert;

public class W1D3_LC_2544_Alternating_Digit_Sum {

	@Test
	public void test() {

		int alternateDigitSum = alternateDigitSum(521);
		System.out.println(alternateDigitSum);
		Assert.assertEquals(4, alternateDigitSum);
	}
	

	@Test
	public void test1() {

		int alternateDigitSum = alternateDigitSum(111);
		System.out.println(alternateDigitSum);
		Assert.assertEquals(1, alternateDigitSum);
	}


	@Test
	public void test2() {

		int alternateDigitSum = alternateDigitSum(886996);
		System.out.println(alternateDigitSum);
		Assert.assertEquals(1, alternateDigitSum);
	}
	
	public int alternateDigitSum(int input) {
		int sum = 0;
		Integer newNum = input;
		char[] charArray = newNum.toString().toCharArray();
		//System.out.println(charArray.length);
		for (int i = 0; i < charArray.length; i++) {

			if (i % 2 == 0) {
				int value = charArray[i] - '0';
				sum = sum + value;
			} else if (i % 2 != 0) {
				int value = charArray[i] - '0';
				sum = sum - value;
			}
		}
		return sum;

	}

}

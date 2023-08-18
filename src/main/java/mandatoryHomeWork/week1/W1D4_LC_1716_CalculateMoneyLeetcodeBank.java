package mandatoryHomeWork.week1;

import org.junit.Test;

import junit.framework.Assert;

public class W1D4_LC_1716_CalculateMoneyLeetcodeBank {

	@Test
	public void test() {
		int actualCalculateMoney = calculateMoney1(20);
		Assert.assertEquals(96, actualCalculateMoney);
	}

	@Test
	public void test1() {
		int actualCalculateMoney = calculateMoney1(7);
		Assert.assertEquals(28, actualCalculateMoney);
	}


	@Test
	public void test2() {
		int actualCalculateMoney = calculateMoney1(14);
		Assert.assertEquals(63, actualCalculateMoney);
	}
	
	public int calculateMoney(int day) {

		int temp = 0;
		int result = 0;
		int quo = 0;
		int rem = 0;
		int startValue = 0;
		int endValue = 0;

		quo = day % 7;
		rem = day / 7;

		if (quo == 0) {
			startValue = rem;
			endValue = 7 + (rem - 1);

		} else if (quo != 0) {
			startValue = rem + 1;
			endValue = rem + quo;

		}
		System.out.println(startValue + " " + endValue);
		for (int i = startValue; i <= endValue; i++) {
			temp = temp + i;
		}
		System.out.println(temp);
		if (quo == 0 && rem == 1) {
			result = 28 * quo + temp;

		} else {
			result = 28 + (rem*7 )+ temp;
		}

		System.out.println(result);
		return result;
	}

	public int calculateMoney1(int day) {
		int balance = 0, count = 0, saving=0;
/*		if (day <= 7) {
			while (count < day) {
				balance = balance + 1;
				saving = saving +balance;
				count++;
				
			}
			return saving;
		} else if (day > 7) {*/
			int inializer=0;
			for (int i = 1; i <= day; i++) {
				balance = balance + 1;
				saving = saving +balance;
				count++;
				if (count == 7) {
					balance= ++inializer;
					count = 0;
				}

			}

	// System.out.println(balance);
	return saving;

}

}

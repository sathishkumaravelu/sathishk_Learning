package mandatoryHomeWork.Foundation;

import org.junit.Test;

import junit.framework.Assert;

public class p07_FindPrimeNumber {

	@Test
	public void test1() {
		boolean prime = isPrime(5);
		Assert.assertEquals(true, prime);
	}

	@Test
	public void test2() {
		boolean prime = isPrime(2);
		Assert.assertEquals(true, prime);
	}

	@Test
	public void test3() {
		boolean prime = isPrime(6);
		Assert.assertEquals(false, prime);
	}

	
	public boolean isPrime(int num) {

		if (num <= 1) {
			return false;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;

	}

}

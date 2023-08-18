package mandatoryHomeWork.week2;

import org.junit.Test;

/*
 * 1. Assign a count variable count
 * 2. Iterate thru the input 
 * 3. increase count if the input divisible by iterator
 * 4. finally check if the count is exactly 3, return true else false
 * */

public class W2D2_LC_1952_threeDivisors {
	
	@Test
	public void testCase1() {
		junit.framework.Assert.assertEquals(false, isThree(2));
	}
	@Test
	public void testCase2() {
		junit.framework.Assert.assertEquals(true, isThree(4));
	}
	
	@Test
	public void testCase3() {
		junit.framework.Assert.assertEquals(false, isThree(5));
	}
	@Test
	public void testCase4() {
		junit.framework.Assert.assertEquals(false, isThree(6));
	}

	
	public boolean isThree(int n) {
		int count = 0;
		int i = 1;
		while (i <= n) {
			if (n % i == 0) {
				count++;
			}
			i++;
		}
		if (count == 3) {
			return true;
		}

		return false;

	}
}

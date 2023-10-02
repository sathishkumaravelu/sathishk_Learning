package mandatoryHomeWork.Foundation;
import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class p03_ArrangeCoin {

	@Test
	public void test1() {
		int n = 5;
		int completedRow = getCompletedRow(n);
		System.out.println(completedRow);
		Assert.assertEquals(5, completedRow);
	}
	
	@Test
	public void test2() {
		int n = 3;
		int completedRow = getCompletedRow(n);
		System.out.println(completedRow);
		Assert.assertEquals(3, completedRow);
	}

	@Test
	public void test3() {
		int n = 0;
		int completedRow = getCompletedRow(n);
		System.out.println(completedRow);
		Assert.assertEquals(0, completedRow);
	}
	public int getCompletedRow(int input) {
		int op =0;
		int temp = input;

		for (int i = 1; i <= input; i++) {
			if (temp >= i) {
				op=op+1;
			}
		}
		return op;
	}

}

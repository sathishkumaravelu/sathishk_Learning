package mandatoryHomeWork.Foundation;

import org.junit.Test;

public class p14_XplusOne {

	@Test
	public void test() {
		int[] num = { 1, 2, 3 };
		int checkXPlusOne = checkXPlusOne(num);
		System.out.println(checkXPlusOne);
	}

	@Test
	public void test1() {
		int[] num = { 1, 1, 3, 3, 5, 5, 7, 7 };
		int checkXPlusOne = checkXPlusOne(num);
		System.out.println(checkXPlusOne);
	}

	public int checkXPlusOne(int[] num) {

		int count = 0;
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				if (num[i] + 1 == num[j]) {

					count++;
				}
			}
		}
		return count;
	}
}

package mandatoryHomeWork.java.week1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class W1D1_LC_728_self_dividing_numbers {

	/*
	 * 1. create an array list of integer 2. iterate loop with i=leftip to rightip
	 * 3. create a while loop with input 4. spilt no by digits %10 5. if reminder is
	 * zero break 6. check original no with the module of splitno is equal to zero
	 * increase the count then split the num 7. finaly if the count is greater zero
	 * 8. add the i to the array
	 * 
	 * 
	 */

	@Test
	public void test() {
		List<Integer> checkSelfDividing = checkSelfDividing(1, 22);
		List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
		Assert.assertEquals(expectedList, checkSelfDividing);	
	}
	
	@Test
	public void test1() {
		List<Integer> checkSelfDividing = checkSelfDividing(47, 85);
		List<Integer> expectedList = Arrays.asList(48,55,66,77);
		Assert.assertEquals(expectedList, checkSelfDividing);	
	}

	public List<Integer> checkSelfDividing(int leftip, int rightip) {

		ArrayList<Integer> outputArr = new ArrayList<Integer>();

		for (int i = leftip; i <= rightip; i++) {
			int num = i;
			int count = 0;
			while (num > 0) {
				int split = num % 10;
				if (split == 0) {
					count = 0;
					break;
				} else if (i % split == 0) {
					count++;
					num = num / 10;
				} else {
					count = 0;
					break;
				}
			}
			if (count > 0) {
				outputArr.add(i);
			}

		}

		return outputArr;

	}

}

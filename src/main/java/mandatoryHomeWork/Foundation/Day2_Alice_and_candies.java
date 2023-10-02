package mandatoryHomeWork.Foundation;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Assert;
import org.junit.Test;

public class Day2_Alice_and_candies {

	/*
	 * Input - int [] candies ; op - int op;
	 * 
	 * 
	 * Test data: candies=[1,2,3,1] / n = 3 candies=[1,2,3,3] / n = 2
	 * candies=[6,6,6,6] / n = 1
	 *
	 * create a set and added the values by having a for loop till size
	 *	- now all duplicates will be removed
	 *check for the size of set with candies/2 
	 *
	 *if set size is < candies/2  or if set size is == candies/2 or set size is >= candies/2return set size
	 * 
	 * 
	 * 
	 */

	@Test
	public void test1() {
		int[] candies = { 1, 2, 3, 4, 5, 6 };

		int findCandies = findCandies(candies);
		System.out.println("Test 1 " + findCandies);
		
		Assert.assertEquals(6, findCandies);
	}

	@Test
	public void test2() {
		int[] candies = { 1, 2, 3, 2, 1, 1 };

		int findCandies = findCandies(candies);
		System.out.println("Test 2 " + findCandies);
		Assert.assertEquals(3, findCandies);
	}

	@Test
	public void test3() {
		int[] candies = { 6, 6, 6, 6, 6, 6 };

		int findCandies = findCandies(candies);
		System.out.println("Test 3 " + findCandies);
		Assert.assertEquals(1, findCandies);
	}

	@Test
	public void test4() {
		int[] candies = { 1, 2, 3, 4, 5, 1 };

		int findCandies = findCandies(candies);
		System.out.println("Test 4 " + findCandies);
		Assert.assertEquals(5, findCandies);
	}

	public int findCandies(int[] candies) {

		int size = candies.length / 2;

		HashSet<Integer> newCandiesArr = new HashSet<>();
		for (int i = 0; i < candies.length; i++) {
			newCandiesArr.add(candies[i]);
		}

		System.out.println(newCandiesArr);
		// System.out.println(newCandiesArr.size());
		if (newCandiesArr.size() < size || newCandiesArr.size() == candies.length || newCandiesArr.size() >= size) {

			return newCandiesArr.size();
		} else if (newCandiesArr.size() > size) {
			return newCandiesArr.size() / 2;
		}
		return 100;
	}

}

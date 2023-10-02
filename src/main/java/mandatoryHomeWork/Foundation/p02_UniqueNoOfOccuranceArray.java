package mandatoryHomeWork.Foundation;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.Test;

import junit.framework.Assert;

public class p02_UniqueNoOfOccuranceArray {

	/*
	 * Input -> int array output -> boolean constrain -> check if the occurance of
	 * each element is unique. ie., there should be duplicate between the no of
	 * occurance for each elements
	 * 
	 * Test Data :
	 * 
	 * int [] arr = [1,2,3,4,1,2,2,3,3,3,4,4,4,4] output -> true
	 * 
	 * input[] arr = [1,2] output -> False
	 * 
	 * Psuedo Code :
	 * 
	 * 1. create a for loop from 1 to N of the array 2. if nums[i] == nums[i+1] add
	 * the count array as +1 3. validate the count array at finally by iterating the
	 * loop if it has duplicate return false, else return true
	 * 
	 * 
	 */
	
	@Test
	public void test() {
		boolean checkDuplicate = checkDuplicate(new int[] { 1, 2, 3, 2, 1, 1 });
		System.out.println(checkDuplicate);
		Assert.assertEquals(true, checkDuplicate);

	}

	@Test
	public void test1() {
		boolean checkDuplicate = checkDuplicate(new int[] { 1, 2, 3, 4, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4 });
		System.out.println(checkDuplicate);
		Assert.assertEquals(true, checkDuplicate);

	}

	@Test
	public void test2() {
		boolean checkDuplicate = checkDuplicate(new int[] { 1, 2 });
		System.out.println(checkDuplicate);
		Assert.assertEquals(false, checkDuplicate);

	}

	public boolean checkDuplicate(int[] num) {

		HashMap<Integer, Integer> numOccurance = new HashMap<Integer, Integer>();
		for (int i = 0; i < num.length; i++) {
			if (numOccurance.containsKey(num[i])) {
				Integer value = numOccurance.get(num[i]);
				numOccurance.put(num[i], value + 1);
			} else {
				numOccurance.put(num[i], 1);
			}
		}
//		System.out.println(numOccurance);
		HashSet<Integer> valueSet = new HashSet<>(numOccurance.values());
		System.out.println(valueSet);
		if (valueSet.size() != numOccurance.size()) {
			return false;
		}

		return true;
	}
}

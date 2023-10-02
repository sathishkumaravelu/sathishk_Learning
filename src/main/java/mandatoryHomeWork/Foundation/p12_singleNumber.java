package mandatoryHomeWork.Foundation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class p12_singleNumber {

	// @Test
	public void test() {

		int[] nums = { 1, 2, 2 };
		int singleNumberCheck = singleNumberCheck(nums);
		System.out.println(singleNumberCheck);
	}

	@Test
	public void test1() {

		int[] nums = { 1, 2, 3, 4, 4, 1, 2, 2 };
		int singleNumberCheck = singleNumberCheck(nums);
		System.out.println(singleNumberCheck);
	}

	public int singleNumberCheck(int[] input) {



		HashMap<Integer, Integer> inputMap = new HashMap<Integer, Integer>();
		int count = 0;
		for (int i = 0; i < input.length; i++) {

			if (inputMap.containsKey(input[i])) {
				int value = inputMap.get(input[i]);
				inputMap.put(input[i], value + 1);

			} else {

				inputMap.put(input[i], 1);
			}

		}

		System.out.println(inputMap);
		for (Map.Entry<Integer, Integer> eachEntry : inputMap.entrySet()) {
			if (eachEntry.getValue() == 1) {
				count = eachEntry.getKey();
			}
		}
		return count;
	

	}

}

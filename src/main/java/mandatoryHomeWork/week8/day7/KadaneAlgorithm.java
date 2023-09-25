package mandatoryHomeWork.week8.day7;

import java.util.Iterator;

import org.testng.annotations.Test;

public class KadaneAlgorithm {

	@Test
	public void testData() {
		int value = kadaneAlgo(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, -4 });
		System.out.println(value);
	}

	// Time Complexity  : O(2N) --> O(N) 
	// Space Complexity O(1)
	
	public int kadaneAlgo(int[] arr) {
		int currentMax = 0;
		int maximum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) { //O(N)
			maximum = Math.max(maximum, arr[i]);
		}
		for (int i = 0; i < arr.length; i++) { //O(N)
			currentMax += arr[i];
			if (currentMax < 0) {
				currentMax = 0;
			} else if (currentMax >= 0) {
				maximum = Math.max(maximum, currentMax);
			}
		}
		return maximum;
	}

}

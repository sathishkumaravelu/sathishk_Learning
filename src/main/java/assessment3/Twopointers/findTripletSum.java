package assessment3.Twopointers;

import java.util.Arrays;

import org.junit.Test;

public class findTripletSum {

	// Input : {5, 32, 1, 7, 10, 50, 19, 21, 2}

	@Test
	public void testData() {
		int[] findTriplet = findTriplet(new int[] { 5, 32, 1, 7, 10, 50, 19, 21, 2 });
		System.out.println(Arrays.toString(findTriplet));
	}

	public int[] findTriplet(int[] arr) {
		int n = arr.length;
		int[] outArr = new int[3];
		Arrays.sort(arr);
		for (int i = n - 1; i >= 0; i--) {
			int j = 0;
			int k = i - 1;
			while (j < k) {
				if (arr[i] == arr[j] + arr[k]) {
					// pair found
					System.out.println("numbers are " + arr[i] + " " + arr[j] + " " + arr[k]);
					outArr[0] = arr[j];
					outArr[1] = arr[k];
					outArr[2] = arr[i];
					return outArr;
				} else if (arr[i] > arr[j] + arr[k])
					j += 1;
				else
					k -= 1;
			}
		}

		// no such triplet is found in array
		System.out.println("No such triplet exists");
		return outArr;
	}
}

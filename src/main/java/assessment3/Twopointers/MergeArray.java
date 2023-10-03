package assessment3.Twopointers;

import java.util.Arrays;

import org.junit.Test;

public class MergeArray {
	/*
	 * https://www.geeksforgeeks.org/merge-two-sorted-arrays/
	 */

	@Test
	public void testData() {
		int[] mergeArrays = mergeArrays(new int[] { 1, 3, 5, 7 }, new int[] { 2, 4, 6, 8 });
		System.out.println(Arrays.toString(mergeArrays));
	}

	@Test
	public void testData1() {
		int[] mergeArrays = mergeArrays(new int[] { 1, 2, 3 }, new int[] { 2, 5, 5 });
		System.out.println(Arrays.toString(mergeArrays));
	}

	
	public int[] mergeArrays(int[] arr1, int[] arr2) {

		int[] result = new int[arr1.length + arr2.length];
		int arr1Start = 0, arr2Start = 0;
		int resultStart = 0;
		while (arr1Start < arr1.length && arr2Start < arr2.length) {
			if (arr1[arr1Start] < arr2[arr2Start])
				result[resultStart++] = arr1[arr1Start++];
			else 
				result[resultStart++] = arr2[arr2Start++];
		}
		while(arr1Start<arr1.length) {
			result[resultStart++] = arr1[arr1Start++];
		}
		while(arr2Start<arr2.length) {
			result[resultStart++] = arr2[arr2Start++];
		}
		
		return result;
	}
}

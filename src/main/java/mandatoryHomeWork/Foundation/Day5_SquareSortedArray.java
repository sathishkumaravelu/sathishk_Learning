package mandatoryHomeWork.Foundation;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class Day5_SquareSortedArray {

	/*
	 * input - int [] array output- int [] array
	 * 
	 * Psuedo code:
	 * 
	 * 1. store the input array 2. have a for loop with the size of the array 3.
	 * sort the square off the value 4. do the sorting
	 * 
	 */
	
	@Test
	public void test1() {

		int[] squareSortedArray = squareSortedArray(new int[] { 1, 2, -3, 0, 10 });
		System.out.println("Test 1 : "+Arrays.toString(squareSortedArray));
		Assert.assertArrayEquals(new int[] { 0, 1, 4, 9, 100 }, squareSortedArray);
	}

	
	@Test
	public void test2() {

		int[] squareSortedArray = squareSortedArray(new int[] { -4,-1,0,3,10});
		System.out.println("Test 2 : "+Arrays.toString(squareSortedArray));
		Assert.assertArrayEquals(new int[] { 0,1,9,16,100 }, squareSortedArray);
	}
	
	@Test
	public void test3() {

		int[] squareSortedArray = squareSortedArray(new int[] {-7,-3,2,3,11});
		System.out.println("Test 3 : "+Arrays.toString(squareSortedArray));
		Assert.assertArrayEquals(new int[] { 4,9,9,49,121 }, squareSortedArray);
	}
	
	
	public int[] squareSortedArray(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i] = inputArray[i] * inputArray[i];
		}
		Arrays.sort(inputArray);  
		return inputArray;
	}

}

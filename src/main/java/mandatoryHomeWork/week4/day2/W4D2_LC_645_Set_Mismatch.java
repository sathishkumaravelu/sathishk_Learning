package mandatoryHomeWork.week4.day2;

import java.util.Arrays;

import org.junit.Test;

/*
 * [10 mins]
 *	 * problem statement : You have a set of integers s, which originally contains
		 * all the numbers from 1 to n. Unfortunately, due to some error, one of the
		 * numbers in s got duplicated to another number in the set, which results in
		 * repetition of one number and loss of another number.
		 * 
		 * You are given an integer array nums representing the data status of this set
		 * after the error.
		 * 
		 * Find the number that occurs twice and the number that is missing and return
		 * them in the form of an array.
		 * 
		 * 1. Understanding the problem - yes - input : int array - output : int array
		 * 2. Test data: [5 Mins]
		 * valid data: [1,2,3,3,5] op : [3,4] 
		 * invalid data:
		 * [1,2,3,4] op: [-1,-1] 
		 * edge data: [1,2,4,5,6,2] op: [2,3]
		 * 3. solution : yes i know the
		 * 
		 * solution 4. alternate approaches? no 
		 * 
		 * 6. dry run psuedo code with testdata - yes [12 Mins]
		 * 7. Write the code on notepad - [10Mins]
		 * 
 * 
 * 
 */

public class W4D2_LC_645_Set_Mismatch {

	@Test
	public void valid_Data() {
		
		int[] findErrorNumbers = findErrorNumbers(new int[] {2,2});
		System.out.println(Arrays.toString(findErrorNumbers));
		System.out.println("expected [2,1]" );

	}

	@Test
	public void valid_Data2() {
		
		int[] findErrorNumbers = findErrorNumbers(new int[] {1,2,2,4});
		System.out.println(Arrays.toString(findErrorNumbers));
		System.out.println("expected [2,3]" );
	}

	@Test
	public void invalid_Data() {
		
		int[] findErrorNumbers = findErrorNumbers(new int[] {1,2,3,4});
		System.out.println(Arrays.toString(findErrorNumbers));
		System.out.println("expected [-1,-1]" );

	}
	@Test
	public void edge_Data() {
		
		int[] findErrorNumbers = findErrorNumbers(new int[] {1,2,3,3,5,6});
		System.out.println(Arrays.toString(findErrorNumbers));
		System.out.println("expected [3,4]" );

	}
	
	/*
	
	 * 5. Psuedo code : [15 Mins]
	 * > sort the array 
	 * > need to know the size 
	 * > create 1 loops, check if element are duplicate if so add
	 * it in result array zero th element 
	 * > add one to the duplicate value and place it results of first element
	 */
	//o(n)
	public int[] findErrorNums(int[] nums) {
	   int size = nums.length;
	      Arrays.sort(nums);
	      int[] resultArr = new int[2];
	      for (int i = 0; i < size - 1; i++) {
	    	  if (nums[i] == nums[i + 1]) {
				resultArr[0] = nums[i];
	    	  }
	    	  resultArr[1] = resultArr[0] + 1;
			
	      }
	      return resultArr;		
	}
	
	
	public int[] findErrorNumbers1(int[] numbers) {
		int totalSum = 0, expectedSum=0, duplicateNo=0, missingNo=0;
		int size = numbers.length;
	    //sort the unsorted array   
		Arrays.sort(numbers);
		//create a result array with size 2
 	    int[] resultArr = new int[2];
		//find the duplicate element in the array
 	    for (int sum : numbers) {
 	    	totalSum+=sum;
		}
		int n=size-1;
		expectedSum= n*(n+1)/2;
		int diff=totalSum-expectedSum;
		
		int[] frequency = new int[size+1];
	    int duplicate = -1;
	    for (int num : numbers) {
	        frequency[num]++;
	        if (frequency[num] == 2) {
	            duplicate = num;
	            resultArr[0] = duplicate;
	            break;
	        }
	    }

		resultArr[1]=diff;
		
		return resultArr;
		
	}
	
	
	/*
	 * create a count array
	 * iterate and keep adding 1 to the num of count array
	 * keep duplicate and missing as -1  if array doesnt contatins 
	 * return it
	 * no create a loop for count array from 1 and if it has 2 then its a duplicate if its zero then its the missing element 
	 * 
	 */
	//o(n) +0(n) > o(2n) : > o(n)
	public int[] findErrorNumbers(int[] nums) {
	    int n = nums.length;
	    Arrays.sort(nums);
	    int[] result = new int[2];
	    int[] count = new int[n + 1];
	    
	    for (int num : nums) {
	        count[num]++;
	    }
	    
	    int duplicate = -1;
	    int missing = -1;
	    for (int i = 1; i <= n; i++) {
	        if (count[i] == 2) {
	            duplicate = i;
	        }
	        if (count[i] == 0) {
	            missing = i;
	        }
	    }
	    
	    result[0] = duplicate;
	    result[1] = missing;
	    
	    return result;
	}
	
}

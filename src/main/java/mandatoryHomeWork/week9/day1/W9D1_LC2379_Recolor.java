package mandatoryHomeWork.week9.day1;

import org.checkerframework.checker.units.qual.min;
import org.testng.annotations.Test;

public class W9D1_LC2379_Recolor {
	

	/*
	 * Problem Statement:
	 * 
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem - 4 Mins
	 * 		Input  - String 
	 * 		Output - int
	 * 		constrains
	 * 	
	 * 2. Test Data - 3 Mins
	 * 3. do you know solution ?  Yes 
	 * 4. Best solution / alternate solution - Sliding Window
	 * 5. Pseudo code  - 15 Mins
	 * 6. dry run the pseudo code - 2 Mins 
	 * 7. write the code on notepad - 10 Mins
	 * 8. dry run the code on notepad - 5 Mins
	 * 9. Write code on IDE - 3 Mins
	 * 10. Test and debug - 2 Mins
	 * 11. Code optimization 
	 * 
	 */
	
	//Pseudo Code
	
	// Iterate till the given k window size
	// get the no of white blocks present in it, if it has min assign to min value 
	// iterate from the k to length of the string 
	// 		decrement the white count 
	//		increment the white count if its present in the right side of the string
	
	// finaly check it contains the min value of white to be replaced else return the min value from the first iteration
	
	
	
	
	@Test
	public void testData() {
		int value = minimumRecolors("BBBBWW",2);
		System.out.println(value);
	}

	//Time : O(N)
	//Space: O(1)
	public int minimumRecolors(String blocks, int k) {
		int left = 0, right = 0;
		int wCount = 0;
		int minWhites = blocks.length();
		while (right < k) {
			if (blocks.charAt(right++) == 'W')
				wCount++;
		}
		minWhites = Math.min(wCount, minWhites);
		for (int i = right; i < blocks.length(); i++) {
			if (blocks.charAt(i) == 'W')
				wCount++;
			if (blocks.charAt(left++) == 'W')
				wCount--;
			minWhites = Math.min(minWhites, wCount);
		}
		return minWhites;
	}
}

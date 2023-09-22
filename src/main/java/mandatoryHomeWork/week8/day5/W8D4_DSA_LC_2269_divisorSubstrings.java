package mandatoryHomeWork.week8.day5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W8D4_DSA_LC_2269_divisorSubstrings {
	


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/find-the-k-beauty-of-a-number/description/
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem 2 Min
	 * 		Input  - int
	 * 		Output - int
	 * 		constrains
	 * 	
	 * 
	 * 2. Test Data - 3 min
	 * 3. do you know solution ? Yes
	 * 4. Best solution / alternate solution - Sliding window
	 * 5. Pseudo code - 5 Mins
	 * 6. dry run the pseudo code - 2 mins
	 * 7. write the code on notepad - 3 Mins
	 * 8. dry run the code on notepad - 2 Mins
	 * 9. Write code on IDE - 1 Min
	 * 10. Test and debug
	 * 11. Code optimization 
	 * 
	 */
	
	@Test
	public void validData() {
		int kCount = divisorSubstrings(150,2);
		Assert.assertEquals(kCount, 2);
	}
	
	
	//Pseudo code
//	create two variables start and pointer with 0 and 1st index
//    add the values of the index to a int variable  
//    check if the number is divisor of the given number 
//    then add the count variable 
//
//    now iterate thru the size of the num
//    remove the first value and add the last value to the temp value 
//    check it if the temp diviosor of the given number if so 
//    increment the counter
	
	public int divisorSubstrings(int num, int k) {
		int start = 0, pointer = k;
		String temp = "";
		String s = num + "";
		int count = 0;
		while (start < pointer) {
			temp += s.charAt(start++);
		}
		if (num % Integer.parseInt(temp) == 0) {
			count++;
		}
		while (pointer <= s.length()-1) {
			temp = temp.substring(1);
			temp += s.charAt(pointer);
			pointer++;
			if(Integer.parseInt(temp)!=0) {
			if (num % Integer.parseInt(temp) == 0) {
				count++;
			}
			}
		}
		return count;
	}
}

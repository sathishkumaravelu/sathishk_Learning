package mandatoryHomeWork.week8.day3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W8D3_DSA_SubString_allThreeChar {



	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
	 * 
	 * Given a string s consisting only of characters a, b and c.
	   Return the number of substrings containing at least one occurrence of all these characters a, b and c.
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem - 5 Mins
	 * 		Input  - String
	 * 		Output - int
	 * 		constrains:
    		1 <= arr.length <= 105
    		1 <= arr[i] <= 104
    		1 <= k <= arr.length
    		0 <= threshold <= 104

	 * 2. Test Data - 5 Min
	 * 3. do you know solution ?  Yes 
	 * 4. Best solution / alternate solution - Brut force
	 * 5. Pseudo code  - 10 Mins					
	 * 6. dry run the pseudo code - 2 Mins
	 * 7. write the code on notepad - 5 Mins
	 * 8. dry run the code on notepad - 2 Mins
	 * 9. Write code on IDE - 2 Mins
	 * 10. Test and debug - 1 Min
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		int numberOfSubstrings = numberOfSubstrings("abcabc");
		Assert.assertEquals(numberOfSubstrings, 10);
	}
	@Test
	public void invalidData() {
		int numberOfSubstrings = numberOfSubstrings("abc");
		Assert.assertEquals(numberOfSubstrings, 1);		
	}
	@Test
	public void edgeData() {
		int numberOfSubstrings = numberOfSubstrings("aba");
		Assert.assertEquals(numberOfSubstrings, 0);		
	}
	
	//Pseudo Code
//  start and end 	
//	iterate till the length-3
//	iterate from the first element (pointer=start+3) to length
//	    create a sub string and check if it contains a , b , c
//	increment the pointer to get the substring formation
//	increment the pointer
//	increment a counter
//	return count;
	
	public int numberOfSubstrings(String s) {

		int start = 0, end = (s.length()) - 3;
		int count = 0;
		int pointer = start + 3;
		
		StringBuilder string = new StringBuilder(s);
		//O(N^2) Time
		//O(
		while (start <= end) { //O(N-3)
			boolean alreadyCheck = false;
			while (pointer <= string.length()) { //O(n)
				// System.out.println(string.substring(start,pointer));
				if (count != 0 && alreadyCheck == true) {
					count++;
				} else if (string.substring(start, pointer).contains("a")
						&& string.substring(start, pointer).contains("b")
						&& string.substring(start, pointer).contains("c")) {
					alreadyCheck = true;
					count++;
				}
				pointer++;
			}
			start++;
			pointer = start + 3;
		}
		return count;

	}

}

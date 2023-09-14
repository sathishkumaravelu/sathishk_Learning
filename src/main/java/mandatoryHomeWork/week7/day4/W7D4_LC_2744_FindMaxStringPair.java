package mandatoryHomeWork.week7.day4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W7D4_LC_2744_FindMaxStringPair {


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/
	 * You are given a 0-indexed array words consisting of distinct strings.
	 * The string words[i] can be paired with the string words[j] if:
	 * The string words[i] is equal to the reversed string of words[j].
	 * 0 <= i < j < words.length.
	 * Return the maximum number of pairs that can be formed from the array
	 * words.
	 * Note that each string can belong in at most one pair.
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem : Yes - 1 Min
	 * 		Input  - String [] words
	 * 		Output - int
	 * 		constrains
	 * 		1 <= words.length <= 50
	 * 		words[i].length == 2
	 * 		words consists of distinct strings.
	 * 		words[i] contains only lowercase English letters.
	 * 
	 * 2. Test Data - 2 mins
	 * 3. do you know solution ?  Yes
	 * 4. Best solution / alternate solution - No
	 * 5. Pseudo code - 4 Mins
	 * 6. dry run the pseudo code - 1 Min
	 * 7. write the code on notepad - 3 Mins
	 * 8. dry run the code on notepad - 2 Mins
	 * 9. Write code on IDE - 1 Min
	 * 10. Test and debug - 1 Min
	 * 11. Code optimization - NA
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		String[] words = {"cd","ac","dc","ca","zz"};
		int count = maximumNumberOfStringPairs(words);
		Assert.assertEquals(count, 2);
	}
	
	@Test
	public void invalidData() {
		String[] words = {"aa","ab"};
		int count = maximumNumberOfStringPairs(words);
		Assert.assertEquals(count, 0);
		
	}
	@Test
	public void edgeData() {
		String[] words = {"ab","ba","cc"};
		int count = maximumNumberOfStringPairs(words);
		Assert.assertEquals(count, 1);
	
	}
	
	//Pseudo Code
	
	//1. iterate thru the length of the array 
    //		a. iterate thru the length of the word array
	//			i) both words are at same index break and move to next 	//				element
	//			ii) have a temp variable which call the reverse string of 					the work of inner loop
    //       	iii) check if the words[i] and words[j] matches 
	//			iv) increment counter
	//2. retrun counter

	
	//Time complexity //O(n^2*m)
	//Space complexity O(n)
	
	public int maximumNumberOfStringPairs(String[] words) {

		int count = 0;
		//O(n^2*m)
		for (int i = 0; i < words.length; i++) { //o(n)
			for (int j = 0; j < words.length; j++) { //o(n)
				if (i == j) {
					break;
				}
				String rev = "";
				rev = reverseString(words[j]);
				if (words[i].equals(rev)) {
					count++;
				}
			}
		}
		return count;
	}
	
	private String reverseString(String s) { //o(m)
		String temp = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp += s.charAt(i);
		}
		return temp;
	}
}

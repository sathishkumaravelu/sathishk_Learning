package mandatoryHomeWork.week7.day3;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W7D3_LC_1528_ShuffleString {


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/shuffle-string/description/
	 * You are given a string s and an integer array indices of the same 	  	 * length. The string s will be shuffled such that the character at the 	 	 * ith position moves to indices[i] in the shuffled string.
	 *	
	 *	Return the shuffled string.
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - String s and int[] indices
	 * 		Output - String shuffledString
	 * 		constrains
	 * 	    s.length == indices.length == n
	 *      1 <= n <= 100
	 *      s consists of only lowercase English letters.
	 *      0 <= indices[i] < n
	 *      All values of indices are unique.

	 * 
	 * 2. Test Data - 2Min
	 * 3. do you know solution ? - Yes  
	 * 4. Best solution / alternate solution - Yes
	 * 5. Pseudo code - 2 Mins
	 * 6. dry run the pseudo code - 2 Min
	 * 7. write the code on notepad - 4 Min 
	 * 8. dry run the code on notepad - 3 Min
	 * 9. Write code on IDE - 1 Min
	 * 10. Test and debug - 1 Min
	 * 11. Code optimization - NA
	 * 
	 */
	
	
	@Test
	public void validData() {
		int[] indices = {4,5,6,7,0,2,1,3};
		String restoreString = restoreString("codeleet",indices);
		Assert.assertEquals(restoreString, "leetcode");
		
	}
	@Test
	public void invalidData() {
		int[] indices = {0,1,2,3,4,5,6};
		String restoreString = restoreString("sathish",indices);
		Assert.assertEquals(restoreString, "sathish");
	}
	@Test
	public void edgeData() {
		int[] indices= {25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
		String restoreString = restoreString("abcdefghijklmnopqrstuvwxyz",indices);
		Assert.assertEquals(restoreString, "zyxwvutsrqponmlkjihgfedcba");
	
	}
	
	//Pseudo Code
	/*
	 * 1. create a hash map 
	 * 2. iterate thru the length of the string 
	 * 		- check if the key contains indices 
	 *      - add the value and key to the map 
	 * 3. iterate thru the length of the map 
	 * 		- get the value of key 
	 * 		- append to the empty string 
	 * 4.return result
	 * 
	 */
	
	//Time complexity  - O(N)
	//Space complexity - O(N)
	
	public String restoreString(String s, int[] indices) {

		String result="";
		HashMap<Integer, Character> map = new HashMap<Integer, Character>();
		for (int i = 0; i < s.length(); i++) {
			if (!map.containsKey(indices[i])) {
				map.put(indices[i], s.charAt(i));
			}
		}
		for (int i = 0; i < s.length(); i++) {
			result += map.get(i);
		}
		return result;

	}
}

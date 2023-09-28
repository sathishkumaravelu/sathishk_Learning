package mandatoryHomeWork.week9.day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.Test;

public class W9D4_FindAllAnagrams {
	
	/*
	 	Problem Statement: https://leetcode.com/problems/find-all-anagrams-in-a-string/
	 */
	/*
	 	1. Problem Understanding - 2 Mins
	 	 	input = String , String
	 	 	output = List<Integer>
	 	2. Test Data - 2 Mins
	 	3. Know Solution - Yes
	 	4. Solution - Sliding Window Static
	 	5. Pseudo code - 25 Mins ( since intial logic is incorrect )
	 	6. dry run - pseudo code - 5 mins
	 	7. write the code on paper - 10 mins 
	 	8. test code - 5 mins
	 	9. code on IDE - 5 Mins
	 	10. test nd debug - 2 mins
	 	11. optimize
	 	
	 */
	

	@Test
	public void validDate() {
		List<Integer> findAnagrams = findAnagrams("cbaebabacd","abc");
		Assert.assertEquals(findAnagrams,Arrays.asList(0,6) );  
	}
	
	@Test
	public void invalidDate() {
		List<Integer> findAnagrams = findAnagrams("abab","ab");
		Assert.assertEquals(findAnagrams,Arrays.asList(0,1,2) );  
	}

	//Pseudo Code
	/*
	   1. Create a list for output
	   2. create 2 char array for s and p strings 
	   3. iterate thru the length of p and add to the char array 
	   4. iterate thru the start pointer and p lengh as the sliding window 1
	    	add the first sliding window values to the charArray of s
	    	if the both validate char array and s array are equal add the start index to the list
	   5. Iterate thru the next sliding point to the lenght of the s string 
	   		decrement the value of value of start index of sliding window
	   		add the value of end index of the sliding window
	   		if the both validate char array and s array are equal add the start index to the list
	   		
	   6. finally return the output		
	   		
	 */
	
	//Time - O(N)
	//Space - O(5) - O(1)
	private List<Integer> findAnagrams(String s, String p) {
		List<Integer> outputList = new ArrayList<Integer>();
		if(s.length()<p.length()) return outputList;
		char[] sArray = new char[26];
		char[] pArray = new char[26];
		
		for(int i=0; i<p.length();i++) {
			pArray[p.charAt(i)-'a']++;
		}
		int pointer = 0, end = p.length();
		while(pointer<p.length()) {
			sArray[s.charAt(pointer++)-'a']++;
		}
		if(Arrays.equals(sArray, pArray)) outputList.add(pointer-end);
		
		while(pointer<s.length()) {
			sArray[s.charAt(pointer-end)-'a']--;
			sArray[s.charAt(pointer++)-'a']++;			
			if(Arrays.equals(sArray, pArray)) outputList.add(pointer-end);
		}
		return outputList;
	}
	
	
	/* incorrect logic
	private List<Integer> findAnagrams_1(String s, String p) {
		int pSum = 0;
		List<Integer> outputList = new ArrayList<Integer>();
		for(int i=0; i<p.length();i++) {
			pSum+=p.charAt(i);
		}
		int pointer = 0, end = p.length();
		int windowValue=0;
		while(pointer<end) {
			windowValue+=s.charAt(pointer++);
		}
		if(windowValue==pSum) outputList.add(pointer-end);
		while(pointer<s.length()) {
			windowValue-=s.charAt(pointer-end);
			windowValue+=s.charAt(pointer);
			pointer++;
			if(windowValue==pSum) outputList.add(pointer-end);
		}
		return outputList;
	}
	*/
}

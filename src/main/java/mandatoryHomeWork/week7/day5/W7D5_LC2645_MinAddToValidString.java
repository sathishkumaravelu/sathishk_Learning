package mandatoryHomeWork.week7.day5;

import org.checkerframework.checker.units.qual.s;
import org.testng.annotations.Test;

public class W7D5_LC2645_MinAddToValidString {


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/minimum-additions-to-make-valid-string/description/
	 * 
	 * Given a string word to which you can insert letters "a", "b" or "c" anywhere and any number of times, return the minimum number of letters that must be inserted so that word becomes valid.

A string is called valid if it can be formed by concatenating the string "abc" several times.
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - String s
	 * 		Output - int count
	 * 		constrains
	 * 		1 <= word.length <= 50
	 *		word consists of letters "a", "b" and "c" only. 
	 * 
	 * 2. Test Data
	 * 3. do you know solution ? 
	 * 4. Best solution / alternate solution -
	 * 5. Pseudo code
	 * 6. dry run the pseudo code
	 * 7. write the code on notepad
	 * 8. dry run the code on notepad
	 * 9. Write code on IDE
	 * 10. Test and debug
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	//@Test
	public void validData() {
		int minValue = addMinimum("a");
		System.out.println(minValue);
	}
	
	@Test
	public void invalidData() {
		int minValue = addMinimum("cab");
		System.out.println(minValue);
	}
	public void edgeData() {
		 addMinimum("abc");
	}
	
	//Pseudo Code
	
	
	
	
	//Time complexity 
	//Space complexity
	
	public int addMinimum(String word) {
	
		if(word.length()==0) return 3;
		if(word.length()==1) return 2;
		int count=0;
		for(int i=0;i<word.length()/2;i++) {
			int j=i+1;
		}
		
		
    }
}

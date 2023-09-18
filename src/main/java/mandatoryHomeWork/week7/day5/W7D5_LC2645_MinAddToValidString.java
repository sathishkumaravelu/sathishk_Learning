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
	 * 1. Understanding the problem -> 3 Mins
	 * 		Input  - String s
	 * 		Output - int count
	 * 		constrains
	 * 		1 <= word.length <= 50
	 *		word consists of letters "a", "b" and "c" only. 
	 * 
	 * 2. Test Data - 2 Mins
	 * 3. do you know solution ? Yes
	 * 4. Best solution / alternate solution - No
	 * 5. Pseudo code - 1 Hr ( HINT ) 
	 * 		
	 * 		1. check if the string length is 1 then return 2 
	 * 		2. iterate till the length of the given string (pointer)
	 * 				- intialize a temp counter to check no of existing a's, b's, c's
	 * 				- check the a if its increment the counter and pointer
	 * 				- check the next character if pointer less then lenght and next is 'b'
	 * 					then increment the counter and pointer
	 * 				- check the next character if pointer less then lenght and next is 'b'
	 * 					then increment the counter and pointer
	 * 				- in result, sub the count with the default value (3)
	 * 		3. return sub 
	 * 
	 * 6. dry run the pseudo code
	 * 7. write the code on notepad
	 * 	if(word.length()==1) return 2;
	 * 	int count =0; i =0,result=0;
	 * 	while (i<s.length()){
	 * 	int temp = 0;
	 * 	
	 * 	if(word[i]< word.length() && words[i]='a'){
	 * 		count++;
	 * 		i++;
	 * }
	 * if(word[i]< word.length()&& words[i]='b'){
	 * 		count++;
	 * 		i++;
	 * }
	 * if(word[i]< word.length()&& words[i]='c'){
	 * 		count++;
	 * 		i++;
	 * }
	 * result+= 3-count;
	 * }
	 * return result;
	 * 
	 * }
	 * 
	 * 8. dry run the code on notepad - 5 Mins
	 * 9. Write code on IDE - 5 Mins 
	 * 10. Test and debug - 3 Mins
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		int minValue = addMinimum("a");
		System.out.println(minValue);
	}
	
	@Test
	public void invalidData() {
		int minValue = addMinimum("cab");
		System.out.println(minValue);
	}
	@Test
	public void edgeData() {
		 addMinimum("abc");
	}
	
	//Pseudo Code
	
	
	
	
	//Time complexity 
	//Space complexity
	
	public int addMinimum(String wordStr) {

		if (wordStr.length() == 1)
			return 2;
		int i= 0, result = 0;
		char[] word = wordStr.toCharArray();
		while (i < word.length) {
			int count = 0;
			if (i < word.length && word[i] == 'a') {
				count++;
				i++;
			}
			if (i < word.length && word[i] == 'b') {
				count++;
				i++;
			}
			if (i < word.length && word[i] == 'c') {
				count++;
				i++;
			}
			result += 3 - count;
		}
		return result;

	}

    }
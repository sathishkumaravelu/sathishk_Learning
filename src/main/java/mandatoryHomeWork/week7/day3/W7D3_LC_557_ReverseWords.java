package mandatoryHomeWork.week7.day3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W7D3_LC_557_ReverseWords {



	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/reverse-words-in-a-string-iii/
	 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
	 */
	
	
	/*
	 * 1. Understanding the problem - 1 Min
	 * 		Input  - String s
	 * 		Output - String reverse
	 * 		constrains
	 *     1 <= s.length <= 5 * 104
	 *     s contains printable ASCII characters.
	 *     s does not contain any leading or trailing spaces.
	 *     There is at least one word in s.
	 *     All the words in s are separated by a single space.
	 * 
	 * 2. Test Data - 3 Mins
	 * 3. do you know solution ? Yes
	 * 4. Best solution / alternate solution - Yes
	 * 5. Pseudo code - 5 Mins
	 * 6. dry run the pseudo code 2 Mins
	 * 7. write the code on notepad -  2 Mins
	 * 8. dry run the code on notepad - 1 Mins
	 * 9. Write code on IDE - 2 Min
	 * 10. Test and debug - 2 Min
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		String s="I yats tuo oot etal toG 'nihton ni ym niarb s'tahT tahw elpoep yas";
		String expectedOutput = "I stay out too late Got nothin' in my brain That's what people say";
		String reverseWords = reverseWords(s);
		Assert.assertEquals(reverseWords, expectedOutput);
	}
	
	@Test
	public void edgeData() {
		String s="mom";
		String expectedOutput = "mom";
		String reverseWords = reverseWords(s);
		Assert.assertEquals(reverseWords, expectedOutput);
		
	}
	
	
	//Pseudo Code
	
	
	
	
	//Time complexity - o(n)
	//Space complexity - o(n)
	
	
	public String reverseWords(String s) {
		String reversedString = "";
		if (!s.contains(" ")) {
			return reverseWord(s);
		}
		String[] splitArray = s.split(" ");
		for (int i = 0; i < splitArray.length; i++) {
			String temp = reverseWord(splitArray[i]);
			reversedString += temp + " ";
		}
		return reversedString.trim();

	}

	private String reverseWord(String s) {
		String rev = "";
		for (int i = s.length()-1; i >= 0; i--) {
			rev += s.charAt(i);
		}
		return rev;
	}
}
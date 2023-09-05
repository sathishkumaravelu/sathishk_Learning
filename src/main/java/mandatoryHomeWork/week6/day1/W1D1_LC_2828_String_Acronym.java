package mandatoryHomeWork.week6.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W1D1_LC_2828_String_Acronym{

	/*
	 Problem:
	 Given an array of strings words and a string s, determine if s is an acronym of words.
	 The string s is considered an acronym of words if it can be formed by concatenating the first character 	 	 of each string in words in order. For example, "ab" can be formed from ["apple", "banana"], but it can't 	 	 be formed from ["bear", "aardvark"].
	 Return true if s is an acronym of words, and false otherwise. 
	 
	 Constraints:
     1 <= words.length <= 100
     1 <= words[i].length <= 10
     1 <= s.length <= 100
     words[i] and s consist of lowercase English letters.

	 Problem understanding: 1 Min
	 Input statement: Array String  and String 
	 output : boolean true / false
	 
	 3.Do you know the Solution? - Yes
	 4.Do you have any alternate approaches?  - Yes
	 6. Dry run the pseudo code with all test data from step #2 - 2 mins
	 7.Write the code on notepad - 5 Mins
		if(input.length != validateText.length()) return false;
		String temp="";
		for (int i = 0; i < input.length; i++) {	
			temp=temp+input[i].charAt(0);
		}
		return temp.equals(validateText);
		
	 8. Dry run the code with all test data from step #2 -- 2 Mins
	 9. Write code on IDE  -- 2 Mins
	 10. Test the code + Debug the code - 1 Mins
	 11. Check for any gaps of code optimization  
	 */
	
	//2. Test Data -3 Mins
	@Test
	public void validData() {
		boolean isAccronym=checkIsAcronym(new String[] {"hellow","india"},"hi");
		Assert.assertEquals(isAccronym, true);
	}
	@Test
	public void invalidData() {
		boolean isAccronym=checkIsAcronym(new String[] {"aura","ball","cat"},"ab");
		Assert.assertEquals(isAccronym, false);
	}
	@Test
	public void edgeData() {
		boolean isAccronym=checkIsAcronym(new String[] {"abc","bbc","cbc"},"s k");
		Assert.assertEquals(isAccronym, false);
	}
	@Test
	public void edgeData1() {
		boolean isAccronym=checkIsAcronym(new String[] {"hellow","india"," ", "aaa","leen","love"},"hi all");
		Assert.assertEquals(isAccronym, true);
	}
	
	//5.psuedo code - 5 Mins
	/*
	 1.check the length of given string and given array, not equal then return false 
	 2. Iterate the loop to the length of string
	 		have a temp string variable
	 		get the first string get the first char and append with temp variable
	 3. check if the temp variable and 	input string return value	
	 */
	
	//Time complexity - o[n]
	public boolean checkIsAcronym(String input[],String validateText) {
		if(input.length != validateText.length()) return false;
		String temp="";
		for (int i = 0; i < input.length; i++) {	
			temp=temp+input[i].charAt(0);
		}
		return temp.equals(validateText);
	}
}

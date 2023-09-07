package mandatoryHomeWork.week6.day3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W6D3_LC_1816_Truncate_Sentence {

	/*
	 problem statement :
	 https://leetcode.com/problems/truncate-sentence
	 A sentence is a list of words that are separated by a single space with no leading or trailing spaces. 	  	 Each of the words consists of only uppercase and lowercase English letters (no punctuation).

	 For example, "Hello World", "HELLO", and "hello world hello world" are all sentences.
	 You are given a sentence s​​​​​​ and an integer k​​​​​​. You want to truncate s​​​​​​ such that it contains only the first 	 	 k​​​​​​ words. Return s​​​​​​ after truncating it.
	 
	 1. understanding problem - Yes : 1 Min
	 2. Test Data - 2 Mins
	 3. Do you know the Solution? - Yes
	 4. Do you have any alternate approaches? - No
	 5. Pesudo code -7 Mins
	 6. Dry run the pseudo code - 1 Min
	 7. Write the code on notepad - 3 Mins
	 8. Dry run the code with all test data - 2 Mins
	 9. Write code on IDE - 1 Min
	 10. Test the code + Debug the code - 1 Min
	 11. Check for any gaps of code optimization - NA
	*/

	// Test Data
	@Test
	public void validData() {
		String s = "The sun shone brightly and shines";
		int k = 2;
		String truncatedSentence = truncateSentence(s, k);
		Assert.assertEquals(truncatedSentence, "The sun");
	}

	// Test Data
	@Test
	public void negativeData() {
		String s = "The sunshine in east";
		int k = 1;
		String truncatedSentence = truncateSentence(s, k);
		Assert.assertEquals(truncatedSentence, "The");
	}

	// Test Data
	@Test
	public void edgeData() {
		String s = "The sunshine";
		int k = 2;
		String truncatedSentence = truncateSentence(s, k);
		Assert.assertEquals(truncatedSentence, "The sunshine");
	}

	
	//pesudo code - 7 Mins
	/*
	 //convert the string into a char Array
//	 iterate thru the length of string
//	     - initalize the count varaiable as zero
//	     - check if the char value contains ==' '
//		 - add the count variable 
//	 finally add the count value+1 to identify the no of variable 
//	 
//	 if k value is greater than the input string words return s as it is,
//	 
 * 
   	 have a temp - string and count - int variable 
   	 now,  iterate thru the length of string	  	 
	  	 - if char value contains ==' ' add another counter 	  	 	
	  	 	check if the count varaible matches the k or if the value of iterator is equal to length of string
	  	 	return the temp string variable
	  
	 */
	
	/*
	    String temp="";
	    int count=0;
	 	for(int i=0;i<s.length();i++){	
	 		temp=temp+s.charAt(i);
	 		if(s.charAt(i)==' '){
	 		 count++;
	 		}
	 		if(count == k || i==s.length()){
	 		return temp;
	 		}
	 	}
	 	return s;
	 	
	 
	 */
	//O[N]
	public String truncateSentence(String s, int k) {
		String temp = "";
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			temp = temp + s.charAt(i);
			if (s.charAt(i) == ' ') {
				count++;
			}
			if (count == k || i == s.length()) {
				return temp.trim();
			}
		}
		return temp;
	}
		
		
}

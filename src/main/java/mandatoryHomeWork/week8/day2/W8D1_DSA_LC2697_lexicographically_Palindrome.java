package mandatoryHomeWork.week8.day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W8D1_DSA_LC2697_lexicographically_Palindrome {
	//https://leetcode.com/problems/lexicographically-smallest-palindrome/


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/lexicographically-smallest-palindrome/
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem -5 Mins
	 * 		Input  - String
	 * 		Output - String 
	 * 		constrains
	 * 	      make s a palindrome with the minimum number of operations 
	 * 		  If there are multiple palindromes that can be made using the minimum number of operations, make 	 	 * 		the lexicographically smallest one.
	 * 
	 * 2. Test Data - 2 Min
	 * 3. do you know solution ? Yes
	 * 4. Best solution / alternate solution - 2 pointer
	 * 5. Pseudo code
	 * 
	 * 1. have the start index as zero and end index as length 
	 		convert the stringa charArray
	 * 2. iterate till the left index breaks right
         		check the value of left index value and right index value
          		if value is not equal, then check which is the smallest digit 				and replace the respective side
	 * 3. return as string
	 * 
	 * 6. dry run the pseudo code -  2 Mins
	 * 7. write the code on notepad - 2 Mins
	 * 8. dry run the code on notepad - 1 Mins
	 * 9. Write code on IDE - 2 Mins
	 * 10. Test and debug - 1 Min
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	@Test
	public void validData() {	
		String output = makeSmallestPalindrome("malayalbs");
		System.out.println(output);
		Assert.assertEquals(output, "malayalam");
	}
	
	

	public void invalidData() {
		String output = makeSmallestPalindrome("adcb");
		System.out.println(output);
		Assert.assertEquals(output, "acca");

	}
	public void edgeData() {
		String output = makeSmallestPalindrome("mom racecar mom");
		System.out.println(output);
		Assert.assertEquals(output, "mom racecar mom");
	}
	
	//Pseudo Code
	
	
	
	
	//Time complexity - o(n) 
	//Space complexity - o(n)
	
	public String makeSmallestPalindrome(String s) {
		
		char[] charArray = s.toCharArray();
		int left =0 , right = charArray.length-1;

		while(left<right){
		if(charArray[left]==charArray[right]){
		        left++;
		        right--;
		}else if (charArray[left]<charArray[right]){
		        charArray[right--] = charArray[left];
		        left++;
		}else{
		        charArray[left++] = charArray[right];
		        right--;
		}
		}
		return new String(charArray);
		
	}
	

}

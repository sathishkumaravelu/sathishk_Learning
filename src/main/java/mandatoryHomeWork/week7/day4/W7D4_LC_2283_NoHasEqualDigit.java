package mandatoryHomeWork.week7.day4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W7D4_LC_2283_NoHasEqualDigit {


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/find-maximum-number-of-string-pairs/description/
	 * You are given a 0-indexed string num of length n consisting of digits.
	 * 
	 *	Return true if for every index i in the range 0 <= i < n, the digit i 		occurs num[i] times in num, otherwise return false.
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem - Yes 5 Mins (to hint from friend for understanding since i confused myself)
	 * 		Input  - string 
	 * 		Output - boolean
	 * 		constrains
	 * 		n == num.length 
	 *      1 <= n <= 10
	 *      num consists of digits.
	 * 
	 * 2. Test Data - 2 Mins
	 * 3. do you know solution ? yes
	 * 4. Best solution / alternate solution - Yes
	 * 5. Pseudo code - 4 Mins
	 * 6. dry run the pseudo code - 2 Mins
	 * 
	 * String temp=""
	 * for(int i=0;i<s.length-1;i++){
     * int count=0;
     * for(int j=0;j<s.length-1;j++){ 
     * if(num[j] ==i){
     *    count++;
	 * }
	 * temp+=count;
	 * }
	 * if(s.equals(temp)) return true     
	 * else false;
	 * 
	 * 7. write the code on notepad - 5 Mins
	 * 8. dry run the code on notepad - 2 Mins
	 * 9. Write code on IDE - 2 Min
	 * 10. Test and debug - 5 Mins
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		boolean isValid = digitCount("1210");
		Assert.assertTrue(isValid);
	}
	@Test
	public void invalidData() {
		boolean isValid = digitCount("030");
		Assert.assertTrue(!isValid);		
		
	}
	@Test
	public void edgeData() {		
		boolean isValid = digitCount("00000");
		Assert.assertTrue(!isValid);
	}
	
	//Pseudo Code
	
//	1. iterate thru the length of string -1
//	 	a. check the count of i in the string 
//		b. convert the into to char for comparision
//	      - iterate thru another loop to compare the value
//	 	  - if i and charAt of num[0] equals 
//		  - add the count (no of repeat)
//	add the counter to a temp string
//	compare the string and num string 
//	return true if matches else false

	//Time complexity - o(n^2)
	//Space complexity - o(n) 
	
	//o(n^2)
	public boolean digitCount(String num) {
		String temp = "";
		for (int i = 0; i < num.length(); i++) { //o(n)
			int count = 0;
			char charToCompare = (char) ('0' + i);
			for (int j = 0; j < num.length(); j++) { //o(n)
				if (num.charAt(j) == charToCompare) {
					count++;
				}
			}
			temp += count;
		}
//		if (num.equals(temp))
//			return true;
//		else
//			return false;
		
		return num.equals(temp);
	}
}

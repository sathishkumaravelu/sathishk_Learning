package mandatoryHomeWork.week9.day5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W9D5_ReverseString2 {

	/*
 	1. Problem Understanding - 2 Mins
 	 	input = String ,int
 	 	output = String
 	2. Test Data - 2 Mins
 	3. Know Solution - Yes
 	4. Solution - Two Pointer
 	5. Pseudo code -  10 Mins
 	6. dry run - pseudo code - 2 mins
 	7. write the code on paper - 5 mins 
 	8. test code - 2 mins
 	9. code on IDE - 5 Mins
 	10. test nd debug - 2 mins
 	11. optimize
 	
 */
	
	
	@Test
	public void validTestData() {
		String reversedString = reverseStr("abcdefg", 2);
		Assert.assertEquals(reversedString, "bacdfeg");
	}

	@Test
	public void invalidTestData() {
		String reversedString = reverseStr("abcdefg", 8);
		Assert.assertEquals(reversedString, "gfedcba");
	}
	@Test
	public void edgeTestData() {
		String reversedString = reverseStr("abcdefg", 1);
		Assert.assertEquals(reversedString, "abcdefg");
	}

	//Pseudo code
	/*
	 	1. create an array char for the given string 
	 	2. iterate till the length 
	 		for ever 2k characters check with length if k values is less then return the k value for revers
	 		else return length for reverse
	 	3. return the result as string 
	 */
	public String reverseStr(String s, int k) {
		char[] charArray = s.toCharArray();
		for(int i = 0;i < charArray.length;i=i+2*k) {
			int kStart = i;
			int end = Math.min(kStart+k-1,charArray.length-1);
			while(kStart < end) {
				char temp = charArray[kStart];
				charArray[kStart++]=charArray[end];
				charArray[end--]=temp;
			}
		}
		return  String.valueOf(charArray);
	}

}

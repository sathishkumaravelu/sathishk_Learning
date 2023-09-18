package mandatoryHomeWork.week7.day4;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseString {


	/*
	 * Problem Statement:
	 * 	Reverse the string using time constrain O(n/2)
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - String 
	 * 		Output - String
	 * 		constrains - O(n/2)
	 * 	
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
	@Test
	public void validData() {
		String reversedString = reverseString("Sathishh");
		Assert.assertEquals(reversedString, "hhsihtaS");
	}
	
	@Test
	public void invalidData() {
		String reversedString = reverseString("Sathish");
		Assert.assertEquals(reversedString, "hsihtaS");
		
	}
	@Test
	public void edgeData() {
		String reversedString = reverseString("");
		Assert.assertEquals(reversedString, "");
	}
	
	//Pseudo Code
	
	
	
	
	//Time complexity 
	//Space complexity
	
	public String reverseString(String s){
		if(s.length()==0)return s;
		char[] charArray = new char[s.length()];
		for(int i=0;i<=s.length()/2;i++) {
			int j=s.length()-i;
			charArray[i]=s.charAt(j-1);
			charArray[j-1]=s.charAt(i);
		}
		if(s.length()%2!=0) {
			charArray[s.length()/2]=s.charAt(s.length()/2);
		}
		return  new String(charArray);
	}

}

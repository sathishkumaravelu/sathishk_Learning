package mandatoryHomeWork.week7.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W7D1_LC_1051_Height_Checker {

	/*
	 problem statement: 
	 https://leetcode.com/problems/faulty-keyboard/
	 Your laptop keyboard is faulty, and whenever you type a character 'i' on it, it reverses the string that 	 	 you have written. Typing other characters works as expected.
	 You are given a 0-indexed string s, and you type each character of s using your faulty keyboard.
	 Return the final string that will be present on your laptop screen
	 */
	
	/*
	 Understanding Problem: 1 Min
	 	Input - String s
	 	output - String newWord
	 	Constrain:
	 	S: Length >=1 <= 100
	 	s[0] != 0
	 	
	 Test Data:	3 Mins
	 Solution know ?? - Yes
	 Alternate Solution - No 
	 Pseudo Code: 10 Mins 

	 Check if the given string contains i in it, if not return the same string as output 
	 create an rev, result string 
	 iterate thru the length of the string at each char
     check if the char is not 'i', add the char to result 
	 else if the char is 'i', null the rev ="", then pass result to reverse function
	 add the reversed char to result again 
 	 return result 
	
	6. Dry run the pseudo code with all test data from step #2  - 3 mins 
    7.Write the code on notepad - 3 Mins
    
    if (!input.contains('')){
    return input;
    }
    
    for( int i=0;i<input.length-1;i++){
    if(s.charAt(i) =='i'){
    result = result+s.charAt(i);
    }else{
    	for(int j=result.length()-1; j>=0;j--){
    	
    	rev=rev+result.charAt(i);
    }
    result =rev;
    }
    return result;
    
    8. Dry run the code with all test data from step #2 - 1 Min
    9. Write code on IDE (remember to add comments and practice coding standards) - 2 Mins
	10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE -1 Min
	11. Check for any gaps of code optimization (if not optimized already in Step #9)  - NA
	
	 */
	
	@Test
	public void validData() {
		String newWord =finalString("Same Old Love Selena Gomes Song");
		Assert.assertEquals(newWord,"Same Old Love Selena Gomes Song");
	}
	

	@Test
	public void negativeData() {
		String newWord =finalString("siiiiiiiiiiiiiiiiiiiiiiiiiiii");
		Assert.assertEquals(newWord,"s");
	}
	@Test
	public void edgeData() {
		String newWord =finalString("            i");
		Assert.assertEquals(newWord,"            ");		
	}
	//O[n]
	private String finalString(String s) {
		if (!s.contains("i"))
			return s;
		String rev = "", result = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != 'i') {
				result = result + s.charAt(i);
			} else if (s.charAt(i) == 'i') {
				rev = "";
				for (int j = result.length() - 1; j >= 0; j--) {
					rev = rev + result.charAt(j);
				}
				result = rev;
			}
		}
		return result;

	}
}

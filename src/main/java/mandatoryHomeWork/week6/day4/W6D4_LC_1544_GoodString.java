package mandatoryHomeWork.week6.day4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W6D4_LC_1544_GoodString {

	/*
	 * Given a string s of lower and upper case English letters.
	 * 
	 * A good string is a string which doesn't have two adjacent characters s[i] and
	 * s[i + 1] where:
	 * 
	 * 0 <= i <= s.length - 2 s[i] is a lower-case letter and s[i + 1] is the same
	 * letter but in upper-case or vice-versa. To make the string good, you can
	 * choose two adjacent characters that make the string bad and remove them. You
	 * can keep doing this until the string becomes good.
	 * 
	 * Return the string after making it good. The answer is guaranteed to be unique
	 * under the given constraints.
	 * 
	 * Notice that an empty string is also good.
	 1. Understanding the problem: 3 Mins	
	 		Input -> String s
	 		Output-> String output 
	 2. Test data - 2 Mins
	 3. Do you know the Solution? - Yes
	 4. Do you have any alternate approaches? - No
	 5. Pesudo code - 10 Mins (Hint)
	 6. Dry run the pseudo code -
	 7. Write the code on notepad - 

     
	 8. Dry run the code with all test data -  Mins
	 9. Write code on IDE -  Min
	 10. Test the code + Debug the code -  Min
	 11. Check for any gaps of code optimization - NA


	 */
	
	@Test
	public void validData() {
		
		String output = formGoodString("leEeetcode");
		Assert.assertEquals(output, "leetcode");
	}
	
	
	@Test
	public void validData1() {
		
		String output = formGoodString("abBAcC");
		Assert.assertEquals(output, "");
	}
	
	@Test
	public void validData2() {
		
		String output = formGoodString("s");
		Assert.assertEquals(output, "s");
	}
	
	
	private String formGoodString(String s) {
		if(s.length()==1) return s;
		boolean found = true;
		while (found) {
			found =false;
			StringBuilder sb = new StringBuilder();
            int i = 0;
            while (i < s.length()) {
                if (i < s.length() - 1 && isBadPair(s.charAt(i), s.charAt(i + 1))) {
                    i += 2;
                    found = true;
                } else {
                    sb.append(s.charAt(i));
                    i++;
                }
            }
            
            s = sb.toString(); 
        }
        
        return s;
    }
    
    private boolean isBadPair(char a, char b) {
     
    	
    	return true;
    }
}

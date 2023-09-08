package mandatoryHomeWork.week6.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W6D1_LC_541_Reverse_String {

	
	/*
	Problem:
	Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.

If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.
	 
	1.Understanding the problem to detailed level (clarity on input and output, constraints)
		Input - String , int 
		output - String
	2.Frame Test data (valid, invalid, complex and edge cases)
	
	3.Do you know the Solution?
	4.Do you have any alternate approaches? (Thing of alternate approaches)
	5. Derive Pseudo code in paper (for the best chosen approach)
    6. Dry run the pseudo code with all test data from step #2
    7.Write the code on notepad
    8. Dry run the code with all test data from step #2
    9. Write code on IDE (remember to add comments and practice coding standards)
	10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE
	11. Check for any gaps of code optimization (if not optimized already in Step #9) 
	 */
	
	//testData
	@Test
	public void validData() {
		String revesedString=findReverseString("sathishkumaravelu", 2);
		Assert.assertEquals(revesedString, "asthsihkmuarvaelu");
	}
	@Test
	public void inValidData() {
		String revesedString=findReverseString("leen", 5);
		Assert.assertEquals(revesedString, "neel");
	}
	@Test
	public void edgeData() {
		String revesedString=findReverseString("ab", 1);
		Assert.assertEquals(revesedString, "ba");
	}
	
	
	public String findReverseString(String string, int k) {

		int tk=2*k;
		
		for (int i = 0; i < string.length()/tk; i++) {
			
			int start =i;
			for (int j = 0; j < tk; j++) {
				
				
			}
			
		}
		
		return null;
	}
	
}
	
	
	


package mandatoryHomeWork.week7.day2;

import java.util.HashMap;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W7D2_LC_1221_BalancedString {

	/*
	 problem statement: 
	 https://leetcode.com/problems/number-of-lines-to-write-string/description/
	You are given a string s of lowercase English letters and an array widths denoting how many pixels wide 	each lowercase English letter is. Specifically, widths[0] is the width of 'a', widths[1] is the width of 	'b', and so on.

	You are trying to write s across several lines, where each line is no longer than 100 pixels. Starting at 	the beginning of s, write as many letters on the first line such that the total width does not exceed 100 	pixels. Then, from where you stopped in s, continue writing as many letters as you can on the second line. 	Continue this process until you have written all of s.
	 */
	
	/*
	 Understanding Problem: 2 Min
	 	Input - int[] widths,String s
	 	output - int[] count
	 	Constrain:
    	
    	widths.length == 26
    	2 <= widths[i] <= 10
    	1 <= s.length <= 1000
    	s contains only lowercase English letters.

	 	
	 Test Data:	2 Mins
	 Solution know ?? - Yes
	 Alternate Solution - No 
	 Pseudo Code: 
	6. Dry run the pseudo code with all test data from step #2  - 
    7.Write the code on notepad - 
   		
   	

    8. Dry run the code with all test data from step #2 - 
    9. Write code on IDE (remember to add comments and practice coding standards) - 
	10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE -
	11. Check for any gaps of code optimization (if not optimized already in Step #9)  - NA
	
	 */
	
	@Test
	public void validData() {
		int[] widths = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		int[] output = numberOfLines(widths, "abcdefghijklmnopqrstuvwxyz");
		int[] outputExpected ={3,60};
		Assert.assertEquals(output,outputExpected);
	}
	
	@Test
	public void negativeData() {
		int[] widths = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
		int[] output = numberOfLines(widths, "bbbcccdddaaa");
		int[] outputExpected ={2,4};
		Assert.assertEquals(output,outputExpected);
	
	}
	private int[] numberOfLines(int[] widths, String s) {
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String temp="abcdefghijklmnopqrstuvwxyz";
		for(int i = 0;i<26;i++) {
			if(!map.containsKey(temp.charAt(i))) {
				map.put(temp.charAt(i), widths[i]);
			}
		}
		
		int sum =0;
		int line=1;
		int[] result =new  int[2];
		for (int i = 0; i < s.length(); i++) {
			int width = map.get(s.charAt(i));
			 if ( sum + width<= 100) {
		            sum += width;
		        } else {
		            line++;
		            sum = width;
		        }
		}
		result[0]=line;
		result[1]=sum;
		return result;
	}


	
}

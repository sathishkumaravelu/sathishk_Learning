package mandatoryHomeWork.week6.day1;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W1D1_LC_771_Jewely_Stones {

	/*
	 Problem:
	 You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.
	 Letters are case sensitive, so "a" is considered a different type of stone from "A".
	 
	 Constraints:
	 1 <= jewels.length, stones.length <= 50
     jewels and stones consist of only English letters.
	 All the characters of jewels are unique.

	 Problem understanding: 1 Min
	 Input statement: String  and String 
	 output : int 
	 
	 3.Do you know the Solution? - Yes
	 4.Do you have any alternate approaches?  - no
	 6.Dry run the pseudo code with all test data from step #2 - 
	 7.Write the code on notepad - 3 Mins
		
		
	 8. Dry run the code with all test data from step #2 -- 2
	 
	 int counter = 0;
	 for(int i=0; i<stones.length();i++){
	 for(int j=0; i<jewles.length();i++){
	 	if(jewles.charAt(j)==stones.charAt(i){
	 	counter++;
	 	}
	 }
	 return counter;
	 9. Write code on IDE  -- 
	 10. Test the code + Debug the code - 
	 11. Check for any gaps of code optimization  
	 */
	
	
	//Test Data - 3 Mins
	
	@Test
	public void validData() {
		int countStones=findNoStones("aAAbbbb","aA");
		Assert.assertEquals(countStones, 3);
	}
	@Test
	public void invalidData() {
		int countStones=findNoStones("aBC","Abc");
		Assert.assertEquals(countStones, 0);
	}
	@Test
	public void edgeData() {
		int countStones=findNoStones("cccccccccccccccccccccccccccccccccccccccccccccccccc","c");
		Assert.assertEquals(countStones, 50);
	}
	
	//Pseudo code
	/*
	 1. intiallize the conter as zero 
	 1. iterate thru length of stones
	 2. iterate thru length of jewles
	 		get each character wise of jewles compared with stones 
	 		if both are equal add an increment of counter
	 3. at end return the counter value
	 */
	//O[n]
	public int findNoStones(String stones,String jewels) {
		 int counter = 0;
		 for(int i=0; i<stones.length();i++){
		 for(int j=0; j<jewels.length();j++){
		 	if(jewels.charAt(j)==stones.charAt(i)){
		 	counter++;
		 	}
		 }
	}
		 return counter;
	}
}

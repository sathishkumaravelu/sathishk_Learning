package mandatoryHomeWork.week7.day7;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.testng.annotations.Test;

public class MinDifferenceScore {

	/*
	 * Problem Statement:
	 * to find the min difference between the 
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem
	 * 		Input  - int[] array
	 * 		Output - int
	 * 		constrains
	 * 		K- should be a 1<k<length of array
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
		int minDifference = minDifference(new int[] {9,4,1,7},2);
		System.out.println(minDifference);
	}
	
	

	@Test
	public void invalidData() {
		int minDifference = minDifference(new int[] {9,4,1,10,12,15},3);
		System.out.println(minDifference);
		
	}
	public void edgeData() {
	
	
	}
	
	//Pseudo Code
	
	
	
	
	//Time complexity 
	//Space complexity
	public int minDifference(int[] scores, int range) {
		int min=Integer.MAX_VALUE;
		Arrays.sort(scores);
		for(int i =0; i<scores.length;) {
			int temp=i+range-1;
			int currentMin = Math.subtractExact(scores[temp], scores[temp-1]);
			if(min>currentMin) {
				min = currentMin;
			}
			i=i+range;
		}
		return min;
	}
	
}

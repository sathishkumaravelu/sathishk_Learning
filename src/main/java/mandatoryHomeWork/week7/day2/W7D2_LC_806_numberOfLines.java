package mandatoryHomeWork.week7.day2;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W7D2_LC_806_numberOfLines {

	/*
	 problem statement: 
	 https://leetcode.com/problems/height-checker/
	 A school is trying to take an annual photo of all the students. The students are asked to stand in a  	 	  	 single file line in non-decreasing order by height. Let this ordering be represented by the integer 	 	  	 array expected where expected[i] is the expected height of the ith student in line.

	 You are given an integer array heights representing the current order that the students are standing in. 	 Each heights[i] is the height of the ith student in line (0-indexed).

	 Return the number of indices where heights[i] != expected[i].
	 */
	
	/*
	 Understanding Problem: 1 Min
	 	Input - int[] array 
	 	output - int count 
	 	Constrain:
    	1 <= heights.length <= 100
    	1 <= heights[i] <= 100

	 	
	 Test Data:	1 Mins
	 Solution know ?? - Yes
	 Alternate Solution - No 
	 Pseudo Code: 5 Mins
		
		Initalize this input array in an temp array
		sort the temp array 
		iterate thru length of the array if the values not match have a counter variable 
		return the count
	
	6. Dry run the pseudo code with all test data from step #2  - 1 Min
    7.Write the code on notepad - 
    
    int [] temp = input;
    
    Arrays.sort(temp);
    for(int i=0; i<temp.length; i==){
    if(temp[i]!=inout[i]){
    count++;
    }
    }
    return count;
    
    8. Dry run the code with all test data from step #2 - 1 Min
    9. Write code on IDE (remember to add comments and practice coding standards) - 1 Mins
	10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE -1 Min
	11. Check for any gaps of code optimization (if not optimized already in Step #9)  - NA
	
	 */
	
	@Test
	public void validData() {
		int[] heights= {1,2,6,4,3,5};
		int count=heightChecker(heights);
		Assert.assertEquals(count, 3);
	}
	

	@Test
	public void negativeData() {
		int[] heights= {1,2,3,3,5};
		int count=heightChecker(heights);
		Assert.assertEquals(count, 0);
	}
	@Test
	public void edgeData() {
		int[] heights= {5,5,5,5,5};
		int count=heightChecker(heights);
		Assert.assertEquals(count, 0);
	}
	//O(N log N)
	private int heightChecker(int[] heights) {
		
		int[] temp = Arrays.copyOf(heights, heights.length); 
		System.out.println(temp.toString());
		Arrays.sort(temp);
		
		int count=0;
		for(int i=0;i<temp.length;i++) {
			if(temp[i]!= heights[i]) {
				count++;
			}
		}
		return count;
	}
}

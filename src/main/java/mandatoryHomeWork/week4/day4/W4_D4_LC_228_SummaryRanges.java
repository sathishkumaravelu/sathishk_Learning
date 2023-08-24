package mandatoryHomeWork.week4.day4;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class W4_D4_LC_228_SummaryRanges {

	/*
	 * Problem : LC 228 Summary Ranges
	 * 
	 * You are given a sorted unique integer array nums.
	 * 
	 * A range [a,b] is the set of all integers from a to b (inclusive).
	 * 
	 * Return the smallest sorted list of ranges that cover all the numbers in the
	 * array exactly. That is, each element of nums is covered by exactly one of the
	 * ranges, and there is no integer x such that x is in one of the ranges but not
	 * in nums.
	 * 
	 * Each range [a,b] in the list should be output as:
	 * 
	 * "a->b" if a != b "a" if a == b
	 * 
	 * 1. Problem understanding - Yes [5 Mins]
	 * 		input - int array 
	 * 		output - list of string 
	 * 2. Test data 
	 * 		valid data : [0,1,2,4,5,6,8]
	 * 		invalid data: [-1,0,1,2,5,7,8]
	 * 
	 * 3. do you know the solution - yes
	 * 4. do you know the alternate solution - no
	 * 6. Dry run the pseudo code with all test data from step #2 - 5 mins
	 * 7. Write the code on notepad - 15 mins
	 * 8. Dry run the code with all test data from step #2
	 * 9. Write code on IDE (remember to add comments and practice coding standards) - 5 mins
	 * 10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE 
	 * 11. Check for any gaps of code optimization (if not optimized already in Step #9)

	 */
	
	@Test
	public void validData() {
		System.out.println(summaryRanges(new int[] {0,1,2,3,5}));
	}
	
	@Test
	public void validData1() {
		System.out.println(summaryRanges(new int[] {0,2,3,5}));
	}

	@Test
	public void invalidData() {
		System.out.println(summaryRanges(new int[] {}));
	}
	
	@Test
	public void edgeData() {
		System.out.println(summaryRanges(new int[] {0}));
	}
	
	/*
	 * Pseudo code : 30 Mins
	 * 
	 * Check if the length of the input is zero then return empty string array list
	 * store the value of first element in the start variable
	 * iterate thru the length starting with 2nd element 
	 * 
	 * check if num of iteration till the missing no and add to the list 
	 * 	- check if the start and number is same if add only no
	 *  - else add the value to string concat of start and end with ->
	 * finaly when  loop break check for the last element 
	 * 
	 */
	
	//o(n)
	public List<String> summaryRanges(int[] nums) {
	    List<String> ls = new ArrayList<String>();
	    //o(1)
	    if (nums.length == 0) {
	        return ls;
	    }
	    
	    int start = nums[0]; // Initialize the start of the range
	    //o(n)
	    for (int i = 1; i < nums.length; i++) {
	        if (nums[i] != nums[i - 1] + 1) {
	            if (start == nums[i - 1]) {
	                ls.add(Integer.toString(start));
	            } else {
	                ls.add(start + "->" + nums[i - 1]);
	            }
	            start = nums[i]; 
	        }
	    }
	    
	    if (start == nums[nums.length - 1]) {
	        ls.add(Integer.toString(start));
	    } else {
	        ls.add(start + "->" + nums[nums.length - 1]);
	    }
	    
	    return ls;
	}
	
	
}
package mandatoryHomeWork.week4.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.testng.reporters.AbstractXmlReporter.Count;

public class W4_D5_LC_445_AssignCookies {

	/*
	 * Problem : LC 445 Assign Cookies
	 * 
	 * You are given a sorted unique integer array nums.
	 * 
	 * Assume you are an awesome parent and want to give your children some cookies.
	 * But, you should give each child at most one cookie.
	 * 
	 * Each child i has a greed factor g[i], which is the minimum size of a cookie
	 * that the child will be content with; and each cookie j has a size s[j]. If
	 * s[j] >= g[i], we can assign the cookie j to the child i, and the child i will
	 * be content. Your goal is to maximize the number of your content children and
	 * output the maximum number.
	 * 
	 * 
	 * 1. Problem understanding - Yes [5 Mins] 
	 * input - int array cookies / childGreed
	 * output - int
	 * 2. Test data - 10 Mins
	 * valid data : 
	 * [1,2,3] [1,1] - 1
	 * [10,9,8,7] [5,6,7,8] - 2
	 * invalid data:
	 * [2,3,10] [15] - 1 
	 * edge data:
	 * [4,4,5,10] [1,2,2,3,3] - 0
	 * 3. do you know the solution - yes 
	 * 4. do you know the alternate solution - no
	 * 6. Dry run the pseudo code with all test data from step #2 - 5 mins
	 *  7. Write the code on notepad - 15 mins 
	 *  8. Dry run the code with all test data from step #2 
	 *  9. Write code on IDE (remember to add comments and practice coding standards) - 5 mins 
	 *  10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE 
	 *  11. Check for any gaps of code optimization (if not optimized already in Step #9)
	 * 
	 */
	
	@Test
	public void validData() {
		System.out.println("tc 1 :"+assignCookies(new int[] {0,1,2,3,5},new int[] {1,1}));
	}
	
	@Test
	public void validData1() {
		System.out.println("tc 2 :"+assignCookies(new int[] {10,9,8,7},new int[] {5,6,7,8}));
	}

	@Test
	public void invalidData() {
		System.out.println("tc 3 :"+assignCookies(new int[] {2,3,10},new int[] {15}));
	}
	
	@Test
	public void edgeData() {
		System.out.println("tc 4 :"+assignCookies(new int[] {4,4,5,10},new int[] {1,2,2,3,3}));
	}
	
	/*
	 * Pseudo code : 15 Mins 
	 * Sort the input arrays 
	 * assign a counter variable 
	 * take cookies , count and check again the greed 
	 * when each cookies is greater in size than child greed factor increment count 
	 * assign the child value to zero and skip if the value is zero
	 * return count
	 */
	
	public int assignCookies(int[] greedChild,int[] cookies) {
		
		//O(n log n)
		Arrays.sort(greedChild);
		//O(m log m)
		Arrays.sort(cookies);		
			int count=0;
		for (int i = 0; i < cookies.length; i++) {
			for (int j = 0; j < greedChild.length; j++) {
				if(greedChild[j]<=cookies[i]&&greedChild[j]>0) {
					count++;
					greedChild[j]=0;
				}
			}
		}
	        

	        return count;
	    }
	
	
}
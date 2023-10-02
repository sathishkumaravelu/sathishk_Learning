package mandatoryHomeWork.week8.day5;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W8_D5_DSA_LC_922_sortArrayByParityII {


	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/sort-array-by-parity-ii/description/
	 * 
	 */
	
	/*
	 * 1. Understanding the problem - 5 Mins
	 * 		Input  - int[]
	 * 		Output - int[]
	 * 		constrains
	 * 		2 <= nums.length <= 2 * 104
    		nums.length is even.
    		Half of the integers in nums are even.
    		0 <= nums[i] <= 1000
    			 	
	 * 2. Test Data - 3 Mins
	 * 3. do you know solution ? Yes
	 * 4. Best solution / alternate solution - 2 Pointer
	 * 5. Pseudo code  - 5 Mins
	 * 6. dry run the pseudo code - 10 mins
	 * 7. write the code on notepad - 7 Mins
	 * 8. dry run the code on notepad - 2 mins
	 * 9. Write code on IDE - 3 Mins
	 * 10. Test and debug
	 * 11. Code optimization 
	 * 
	 */
	
	@Test
	public void validData() {
		int[] findTheArrayConcVal = sortArrayByParityII(new int[] {4,2,5,7});
		Assert.assertEquals(findTheArrayConcVal, new int[] {4,7,2,5});
	}
	
	@Test
	public void invalidData() {
		int[] findTheArrayConcVal = sortArrayByParityII(new int[] {4,2,5,7});
		Assert.assertEquals(findTheArrayConcVal, new int[] {4,7,2,5});		
	}
	@Test
	public void edgeData() {
		int[] findTheArrayConcVal = sortArrayByParityII(new int[] {3,2,5,4});
		Assert.assertEquals(findTheArrayConcVal, new int[] {2,3,4,5});		
	}
	
	//Pseudo Code
	// assign 2 variable odd and even with 0 and 1 index
	// iterate till the lenght of the array
	// 		check if the even index has the even number if not
	//		swap the numbers 
	//		iterate the odd value  next to even by adding Odd+2
	//		else increment even by 2 values
	
	//O(N) - Time 
	//O(1) - Space
	
	public int[] sortArrayByParityII(int[] nums) {
        int odd = 1, even = 0;
        while(odd<nums.length && even<nums.length){
             if(nums[even]%2!=0){
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even]=temp;
                odd+=2;
            }else even+=2;
        }
    return nums;
    }
}
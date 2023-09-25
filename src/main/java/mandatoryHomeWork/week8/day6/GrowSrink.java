package mandatoryHomeWork.week8.day6;

import org.junit.Assert;
import org.testng.annotations.Test;

public class GrowSrink {

	/*
		1. add the index of right, till sum is greater than k
    	2. calculate the window size
    	3. reduce the left pointer, till sum is lesser or equal to k
    	4. do step 2 & 3, till right is greater than size of the arr and sum is less than the k

 
	 */
	
	 @Test
	    private void tc1(){
	        Assert.assertEquals(3, smallestSubArray(new int[]{1,2,3,4,5}, 10));
	        Assert.assertEquals(2, smallestSubArray(new int[]{1,2,4,4,1}, 7));
	        Assert.assertEquals(-1, smallestSubArray(new int[]{1,2,3,4,5}, 22));
	        Assert.assertEquals(1, smallestSubArray(new int[]{1,2,3,4,6}, 5));
	    }

	
	public int smallestSubArray(int[] input, int k) {
		int left = 0, right = 0, output = input.length, currentSum = 0;

		while (right <= input.length) {
			if (currentSum > k) {
				output = Math.min(output, right - left);
				currentSum -= input[left];
				left++;
			} else {
				if (right == input.length)
					break;
				currentSum += input[right];
				right++;
			}
		}
		return currentSum < k && output == input.length ? -1 : Math.min(output, right - left + 1);
	}
}

package BrushUp;

import org.testng.annotations.Test;

public class LongestContinuesSubSeq {

    @Test
    public void testLongestContinuesSubSeq(){
        int[] nums = {1,3,5,4,7};
        longestContinuesSubSeq(nums);
    }

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    private void longestContinuesSubSeq(int[] nums) {
        int  right = 0, maxLength = 1, currentLength = 0;
        while (right<nums.length- 1){
            if(nums[right+1]>nums[right]){
                currentLength++;
                maxLength = Math.max(currentLength,maxLength);
                right++;
            }else if(nums[right+1]<nums[right]){
                right++;
            }
        }
        System.out.println(maxLength);
    }
}

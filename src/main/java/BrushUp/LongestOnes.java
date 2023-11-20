package BrushUp;

import org.testng.annotations.Test;

public class LongestOnes {

    @Test
    public void testLongestOnes() {
        int[] nums = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        longestOnes(nums, k);
    }

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    private int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, onesCount = 0, maxCount = 0, temp = k;
        while (right < nums.length) {
            if (k > 0 && nums[right] == 0) {
                k--;
                onesCount++;
                maxCount = Math.max(onesCount, maxCount);
                right++;
            } else if (nums[right] == 1) {
                onesCount++;
                maxCount = Math.max(onesCount, maxCount);
                right++;
            } else if (k > 0) {
                k--;
                onesCount++;
                maxCount = Math.max(onesCount, maxCount);
                right++;
            } else {
                left++;
                right = left;
                onesCount = 0;
                k = temp;
            }
        }
        System.out.println(maxCount);
        return maxCount;
    }
}

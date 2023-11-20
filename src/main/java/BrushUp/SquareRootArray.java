package BrushUp;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SquareRootArray {

    @Test
    public void testSquareRootArray() {
        int[] nums = {-4, -1, 0, 3, 10};
       // findSqrRootArray(nums);
        findSqrRootArrayTP(nums);
    }

/*
    iterate thru each element till length
    update the value of the index with square of the value
    then finally sort the array
*/


    //Time Complexity : O(N Log N)
    //Space Complexity : O(1)
    private void findSqrRootArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    private void findSqrRootArrayTP(int[] nums) {
        int left = 0, right = nums.length-1,index = right;
        int[] output = new int[nums.length];
        for (int i = nums.length-1; i >= 0 ; i--) {
            int temp1 = Math.abs(nums[left]);
            int temp2 = Math.abs(nums[right]);
            if (temp1 < temp2) {
                output[i] = temp2 * temp2;
                right--;
            } else if (temp1 > temp2) {
                output[i] = temp1 * temp1;
                left++;
            }
        }
        System.out.println(Arrays.toString(output));
    }

}

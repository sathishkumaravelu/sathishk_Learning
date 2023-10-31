package mandatoryHomeWork.week14.Day2;

import org.junit.Assert;
import org.testng.annotations.Test;

public class W14D2_MoveZero {

    /*
        Input - int array
        output - void

        Test Data:
           Positive data : [1,2,3,0,1,1,0]
           Negative data : [1,2,3,4,5,6]
           Edge data : [0]

        Pseudocode:
        1. Initialize two pointer fast and slow at the beginning
        2. iterate the fast till the last index of the array
               a. if the slow pointer has zero and fast pointer not has zero then swap
               b. if slow is not zero increment
               c. increment fast pointer

     */


    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] == 0 && nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
            }
            if (nums[slow] != 0) {
                slow++;
            }
            fast++;
        }
    }

    public int[] moveZeros(int[] nums) {
        int slow = 0; // Slow pointer to track non-zero elements
        // Move non-zero elements to the front
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                // Swap non-zero element with slow pointer
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
        }
        return  nums;
    }


    @Test
    public void testData(){
        Assert.assertArrayEquals(new int[] {1,3,12,0,0},moveZeros(new int[] {0,1,0,3,12}));
    }
}
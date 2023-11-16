package mandatoryHomeWork.Week16;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

public class W16D4_MoveZeros {

    /*
        Input - int array
        output - int array

        Test Data
        Positive Data : [0,0,0,0,1,1] - output [1,1,0,0,0,0]
        Negative Data : [1,1,0,0,0]   - output [1,1,0,0,0]
        Edge Data : [0] - output [0]

     */

    @Test
    public void positiveData() {
        int[] ints = moveNoZerosTP(new int[]{1, 1, 0, 0, 0, 0});
        System.out.println(Arrays.toString(ints));

    }
    @Test
    public void negativeData() {
        int[] ints = moveNoZerosTP(new int[]{1,1,1,1,1});
        System.out.println(Arrays.toString(ints));
    }
    @Test
    public void edgeData() {
        int[] ints = moveNoZerosTP(new int[]{0});
        System.out.println(Arrays.toString(ints));
    }

    /*
      Pseudo Code:
        Brute force:
        1. Create an empty array with size of input
        2. iterate through the input and new created array, keep the pointer at start of the both array
                when ever we see the no in put array as non zero, assign that no to the new array and increment the newarray pointer and input array pointer
                else increment the input array pointer
                when it reaches the last element return the new array
     */
    public int[] moveNoZeros(int[] nums) {
        int[] output = new int[nums.length];
        int j = 0;
        for (int num : nums) {
            if (num != 0) {
                output[j++] = num;
            }
        }

        while (j < output.length) {
            output[j++] = 0;
        }
        return output;
    }
    /*
        two pointer with inplace space

        1. Keep two pointers at the start of the index
        2. if you find element is zero keep the slow pointer as it is and move the fast pointer
                when non zero is found at fast pointer, swap the values and move the pointer
            if both the values are non zero move pointer

     */

    public int[] moveNoZerosTP(int[] nums) {
        int fast = 0, slow =0;
        while(slow<nums.length && fast<nums.length){
            if(nums[slow]==0 &&nums[fast] !=0){
                nums[slow]=nums[fast];
                nums[fast]=0;
            }else if(nums[slow]!=0){
                slow++;
                fast++;
            }else if(nums[fast]==0){
                fast++;
            }
        }
        return nums;
    }

    public void moveZeroes(int[] nums) {
        int j = 0;
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is non-zero,
            // swap it with the element at position j
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }

}

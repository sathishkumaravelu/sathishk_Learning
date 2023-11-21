package BrushUp;

import org.testng.annotations.Test;

import java.util.Arrays;

public class LC2656 {

    /*
        Sort the given array
        iterate through the k times
            keep adding the last element of the array which is the highest value
            then update the value of the last element to +1
        return the sum
     */


    @Test
    public void testMaximumSum(){
        int[] nums ={1,2,3,4,5};
        int k = 3;
        int result = maximizeSum(nums, k);
        System.out.println(result);
    }


    //TimeComplexity - O(N Log N)
    //Space complexity - O(1)
    private int maximizeSum(int[] nums, int k){
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < k; i++) {
            sum += nums[nums.length-1];
            nums[nums.length-1] +=1;
        }
        return sum;
    }
}

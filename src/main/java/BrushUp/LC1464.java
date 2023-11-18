package BrushUp;

import org.testng.annotations.Test;

import java.util.Arrays;

public class LC1464 {

    @Test
    public void testMaxProdTwoEle(){
        int[] nums = {1,5,4,5};
        System.out.println(maxProduct(nums));
    }
    /*
        keep int maxVal as Integer.MINVALUE
        keep two pointer left in 0 and right 1
        iterate the loop till the right < length of the input
            get the product of nums[left]-1 * nums[right]-1 and assign it to maxVal;
            if the product is greater then the maxVal reassign the maxVal as product
            move the left++ and right ++;
        return the maxVal
     */
    private int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int left = nums.length-2, right = nums.length-1;
        return (nums[left] - 1) * (nums[right] - 1);
    }
}

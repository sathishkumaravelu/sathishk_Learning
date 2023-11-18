package BrushUp;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2115 {

    @Test
    public void testDifferenceOfTwoArray() {
        int[] nums1 = {1,2,3,3};
        int[] nums2 = {1,1,2,2};
     //   List<List<Integer>> diffTwoArray = findDiffTwoArray(nums1, nums2);
        List<List<Integer>> diffTwoArray = findDiffTwoArrayTP(nums1, nums2);

        System.out.println(diffTwoArray);
    }

    /* BRUTE FORCE
        Pseudo Code:
        1. create a List<List<integer>>
        2. create an outer loop with the nums1 iterate through the entire value
                create an inner loop with index 0 with the nums2 through the entire value
                    if nums1[i] != nums2[j] then add the nums[i] in list1 check if the value is not already contains
                    else if nums[i] == nums2[j] break the loop
        3. now repeate the step 2 with outer loop as nums2 and inner loop as num1 and add the value to the list 2
        4. finally return the List<List<integer>>
     */

    //Time Complexity - O(N^2)
    //Space Complexity - O(N)

    private List<List<Integer>> findDiffTwoArray(int[] nums1, int[] nums2) {

        List<List<Integer>> output = new ArrayList<>();
        List<Integer> theUniqueValue = findTheUniqueValue(nums1, nums2);
        List<Integer> theUniqueValue1 = findTheUniqueValue(nums2, nums1);
        output.add(theUniqueValue);
        output.add(theUniqueValue1);
        return output;
    }

    private List<Integer> findTheUniqueValue(int[] num1, int[] num2) {
        List<Integer> output = new ArrayList<>();
        boolean temp = false;
        for (int k : num1) {
            for (int i : num2) {
                if (k != i) {
                    temp = true;
                } else {
                    temp = false;
                    break;
                }
            }
            if (!output.contains(k) && temp) {
                output.add(k);
            }
        }
        return output;
    }

    /*
        TWO POINTER
        Pseudo Code :
        left = 0, right = 0
        iterate the left and right to the length of the inputs
            if values of left == right, then increment both pointer
            else if value of left is greater than right, then add the value of left to
                list1 with condition check value is not present already
            else if value of right is greater than left, then add the value of right to
                list2 with condition check value is not present already
        finally if the left or right reaches the length add the rest of the other array value to list1
                or list 2 respectively
        return the List<List<Integer>>
    */

    public  List<List<Integer>>  findDiffTwoArrayTP(int[] nums1, int[] nums2) {
        int left = 0, right = 0;
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> unique1 = new ArrayList<>();
        List<Integer> unique2 = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (left < nums1.length && right < nums2.length)
        {
            if(nums1[left]< nums2[right]){
                if (!unique1.contains(nums1[left])) {
                    unique1.add(nums1[left]);
                }
                left++;
            } else if (nums1[left]> nums2[right]) {
                if (!unique2.contains(nums2[right])) {
                    unique2.add(nums2[right]);
                }
                right++;
            }else{
                left++;
                right++;
            }
        }

        while (left < nums1.length) {
            if (!unique1.contains(nums1[left])) {
                unique1.add(nums1[left]);
            }
            left++;
        }


        while (right < nums2.length) {
            if (!unique2.contains(nums2[right])) {
                unique2.add(nums2[right]);
            }
            right++;
        }

        output.add(unique1);
        output.add(unique2);
        return output;
    }
}

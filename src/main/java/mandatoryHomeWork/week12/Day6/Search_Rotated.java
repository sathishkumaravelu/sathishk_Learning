package mandatoryHomeWork.week12.Day6;

import org.testng.annotations.Test;

public class Search_Rotated {

    /**
     * 1. check if the given array is not empty, if return -1
     * 2. if the array length is 1 and if the given target matches return the same else -1
     * 3. assign the left and right to start - end of the array
     * 4. iterate till the left pointer and right pointer are less than or equal
     * a. assign the mid-pointer to the center of left and right
     * b. check if the left most array is less than mid value
     *     then if the target is in the range of left to then middle move the right pointer "middle-1"
     *     else left to "middle+1" which means the target is in next half
     *    else
     *     check if the target is in the right most range array
     *          then move the left "middle+1"
     *          else right to "middle-1"
     *  5. else return -1
     */


    //Time Complexity - O(Log N)
    //Space Complexity - O(1)
    public int searchRotated(int[] arr, int target) {

        if (arr.length == 0) return -1;
        if (arr.length == 1 && arr[0] == target) return 0;
        else if (arr.length == 1)
            return -1;

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[left] <= arr[mid]) {
                if (arr[left] <= target && target <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target <= arr[right] && arr[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    @Test
    public void testData() {
        int i = searchRotated(new int[]{4, 5, 6, 0, 1, 2}, 4);
        System.out.println(i);

    }
}

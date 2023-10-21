package mandatoryHomeWork.week12.Day6;

import org.testng.annotations.Test;

import java.util.Arrays;

public class Search_DivideAndConqure {

    public int divideConqure(int[] arr,int target) {
        Arrays.sort(arr);
        int left = 0;  // assign to the
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; // Calculate the middle index
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1; // Discard left half
            } else {
                right = mid - 1; // Discard right half
            }
        }
        return -1; // Target not found

    }


    @Test
    public void testData(){
        int i = divideConqure(new int[]{1, 4, 5, 3,1,1, 7, 1}, 1);
        System.out.println(i);

    }
}

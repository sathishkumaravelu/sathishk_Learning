package mandatoryHomeWork.Week16;

import org.testng.annotations.Test;

import java.util.*;

public class W16D4_IntersectionArrayII {

    /*
        input - 2 int arrays
        output - int array

        Test Data:
        Positive Data -
        Input: nums1 = [1,2,2,1], nums2 = [2,2]
        Output: [2,2]
        Edge Data -
        Input: nums1 = [4,9,5], nums2 = [9,4,9,5,4]
        Output: [4,9,5]
        Negative Data -
        Input: nums1 = [0,1,2], nums2 = [3,4,5]
        Output: []

     */
    @Test
    public void positiveData() {
        int[] num1 = new int[]{1, 2, 2, 1};
        int[] num2 = new int[]{2, 2};
        int[] intersect = intersect(num1, num2);
        System.out.println(Arrays.toString(intersect));
    }

    @Test
    public void edgeData() {
        int[] num1 = new int[]{9, 4, 9, 5, 4};
        int[] num2 = new int[]{9, 4, 9, 5, 4};
        int[] intersect = intersect(num1, num2);
        System.out.println(Arrays.toString(intersect));
    }

    @Test
    public void negativeData() {
        int[] num1 = new int[]{0, 1, 2};
        int[] num2 = new int[]{3, 4, 5};
        int[] intersect = intersect(num1, num2);
        System.out.println(Arrays.toString(intersect));
    }

    /*
         1. Create a frequency hasmap add the values as key and value as count for one the
            num1 array
         2. create a list to add the intersection values
         3. iterate thru the 2nd array, if the values is containing in the map (key) already in the
            map also check if the count is > 0
            add the value to the result list
            also reduce the value of the exist count
         4. create a result array with size of list, add the value from the list to array and return
     */

    // Time Complexity - O(n)
    // Space Complexity - O(n)
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums1) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (frequencyMap.containsKey(num) && frequencyMap.get(num) > 0) {
                list.add(num);
                frequencyMap.put(num, frequencyMap.get(num) - 1);
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}

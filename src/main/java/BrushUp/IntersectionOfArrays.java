package BrushUp;

import org.testng.annotations.Test;

public class IntersectionOfArrays {

    @Test
    public void testIntersectionArray() {
        int[] num1 = {2, 3, 4, 5};
        int[] num2 = {3, 4, 5, 6};
        findInterscetionPoints(num1, num2);
    }

    @Test
    public void testIntersectionArray1() {
        int[] num1 = {2};
        int[] num2 = {3};
        findInterscetionPoints(num1, num2);
    }

    @Test
    public void testIntersectionArray2() {
        int[] num1 = {};
        int[] num2 = {};
        findInterscetionPoints(num1, num2);
    }


    //Time - O(N)
    //Space - O(1)
    private void findInterscetionPoints(int[] num1, int[] num2) {

        int left = 0, right = 0;
        boolean isMatch = false;
        while (left < num1.length && right < num1.length) {
            if (num1[left] == num2[right]) {
                System.out.print(num1[left] + " ");
                isMatch = true;
                left++;
                right++;
            } else if (num1[left] < num2[right]) {
                left++;
            } else {
                right++;
            }
        }
        if (!isMatch) {
            System.out.println("No Matches");
        }
    }

}

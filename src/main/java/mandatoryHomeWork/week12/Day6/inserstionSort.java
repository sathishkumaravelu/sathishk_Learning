package mandatoryHomeWork.week12.Day6;

import org.testng.annotations.Test;

import java.util.Arrays;

public class inserstionSort {

    public int[] iSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    @Test
    public void testData() {
        int[] ints = iSort(new int[]{1, 7, 5, 4, 2});
        System.out.println(Arrays.toString(ints));
    }
}

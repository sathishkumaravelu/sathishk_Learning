package mandatoryHomeWork.week12.Day6;

import org.testng.annotations.Test;

import java.util.Arrays;

public class SelectedSort {

    public int[] selectedSort(int[] input) {
        int minIndex;
        for (int i = 0; i < input.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[minIndex] > input[j]) minIndex = j;
                if (minIndex != i) {
                    int temp = input[i];
                    input[i] = input[minIndex];
                    input[minIndex] = temp;
                }
            }
        }
        return input;
    }

    @Test
    public void testData() {
        int[] ints = selectedSort(new int[]{1, 7, 5, 4, 2});
        System.out.println(Arrays.toString(ints));
    }
}

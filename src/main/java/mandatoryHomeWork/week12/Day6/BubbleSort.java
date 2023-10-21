package mandatoryHomeWork.week12.Day6;

import org.testng.annotations.Test;

import java.util.Arrays;

public class BubbleSort {

    public int[] bSort(int[] input){

        for (int i = 0; i < input.length-1; i++) {
            for (int j = i+1; j < input.length; j++) {

                if(input[i]>input[j]){
                    int temp = input[j];
                    input[j]= input[i];
                    input[i] = temp;
                }

            }
        }
        return input;
    }


    @Test
    public  void testData(){
        int[] ints = bSort(new int[]{1, 7, 5, 4, 2});
        System.out.println(Arrays.toString(ints));
    }
}

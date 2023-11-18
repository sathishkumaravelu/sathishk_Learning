package BrushUp;

import org.testng.annotations.Test;

import java.util.Arrays;

public class removeDuplicateReturnK {

    @Test
    public void testRemoveDuplicate(){
        int[] num ={1,1,1,2,2,3,4,5,5};
        removeDuplicateVal(num);

    }

    /*
        1. iterate the outer loop thru the length
        2. iterate the inner loop with i+1
            if the num[i] and num[j] matches then replace the value j with _ add the i to result
            swap with j+1 and j;
            else if not matching add the value to result
     */

    /*
        Brute force:
        left pointer as zero and right pointer as num.length
        if num[left] and num
     */


    //Time - O(N)
    //Space - O(1)
    private void removeDuplicateVal(int[] num) {
        int  j = 1;
        for (int i = 1; i < num.length; i++) {
            if(num[i]!=num[i-1]){
                num[j++]=num[i];
            }
        }
        System.out.println(Arrays.toString(num));
        System.out.println("unique count" +j);
    }
}

package mandatoryHomeWork.week14.Day3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W14D3_LC925_LongPressedName {

    /*
        Test data:
        Positive data
         input : alex / aaleex
         output : true
        Edge Data:
         input : abc / aaaaaaabbbbbbbccccc
         output : true
        Negative Data:
         input : alex/xeela
         output : false

       Pseudocode:
        1. keep the pointer at name and typed at zero
        2. iterate till the length of the typed
            if the left and right values are same, then iterate both pointer
            else check if the right pointer is not matching then validate with left-1
            then move the right++
            else return false
        3. finally check if the count and the given name length are same
     */

    public boolean isLongPressedName(String name, String typed) {
        int left = 0, right = 0;
        while (right < typed.length()) {
            if (left < name.length() && name.charAt(left) == typed.charAt(right)) {
                left++;
                right++;
            } else {
                if (right != 0 && typed.charAt(right) == name.charAt(left - 1)) {
                    right++;
                } else {
                    return false;
                }
            }
        }
        return left == name.length();
    }


    @Test
    public void testData(){
        Assert.assertEquals(true,isLongPressedName("abc","aaaaabbbbbccccc"));
    }

    @Test
    public void testData1(){
        Assert.assertEquals(false,isLongPressedName("saeed","ssaaedd"));
    }
}
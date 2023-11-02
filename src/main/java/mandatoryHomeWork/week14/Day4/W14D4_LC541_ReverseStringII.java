package mandatoryHomeWork.week14.Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W14D4_LC541_ReverseStringII {

    /*
        PesudoCode:
        1. Convert the String to an Array of Characters
        2. assign two pointer i and length
        3. iterate till the length
                Start at the beginning of the string.
                For each segment of size k in the string:
                Reverse the characters in that segment calling the reverse function.
                If the segment's size is less than k, reverse the entire remaining segment.
                Move to the next segment after skipping the reversed segment.
        4. have a reverse function on the given start and end length on the char array
        5. Convert Back to String and return
     */

    //Time complexity : O(N)
    public String reverseStr(String s, int k) {
        int i=0, length = s.length();
        char[] ch = s.toCharArray();
        while(i<length){
            int j = Math.min(i+k-1,length-1);
            reverse(ch,i,j);
            i=i+(k*2);
        }
        System.out.println(new String(ch));
        return new String(ch);
    }

    private void reverse(char[] ch, int i, int j){
        while(i<j){
            char temp = ch[i];
            ch[i++]=ch[j];
            ch[j--]=temp;
        }
    }

    @Test
    public void testData(){
        Assert.assertEquals("abcdefg",reverseStr("abcdefg",8));
        Assert.assertEquals("bacd",reverseStr("abcd",2));
    }
}

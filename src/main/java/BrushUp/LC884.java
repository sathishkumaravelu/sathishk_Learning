package BrushUp;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LC884 {

    @Test
    public void testUncommonWords() {
        String s1 = "apple apple";
        String s2 = "wonderful";
        uncommonFromSentencesTP(s1, s2);
    }


    /*
        1. split the giving string into an array using the space
        2. iterate the outer loop with s1 and inner loop with s2
                keep a boolean condition to check if the word is commen as false and break;
                if the words matches then mark the boolean flag as true
                at end of inner loop if the boolean condition is false, and if the list not contains already it will add in it
        3. Repeat this for the 2nd string with outer loop as s2 and inner loop as s1

     */
    private void uncommonFromSentences(String s1, String s2) {

        String[] sa1 = s1.split(" ");
        String[] sa2 = s2.split(" ");
        List<String> list = new ArrayList<>();
        for (String outerString : sa1) {
            boolean isCommon = false;
            for (String innerString : sa2) {
                if (outerString.equals(innerString)) {
                    isCommon = true;
                    break;
                }
            }
            if (!isCommon && !list.contains(outerString)) {
                list.add(outerString);
            }
        }

        for (String innerString : sa2) {
            boolean isCommon = false;
            for (String outerString : sa1) {
                if (innerString.equals(outerString)) {
                    isCommon = true;
                    break;
                }
            }
            if (!isCommon && !list.contains(innerString)) {
                list.add(innerString);
            }
        }
        System.out.println(list);
    }

    /*
        Two Pointer
        1. split the giving string into an array using the space
        2. have two pointer left and right as zero
        3. iterate while left and right < length of s1 and s2 array
                if values are equal then increment the left and right
                else add the values to an list
        4. if the left reaches the length, then add the rest of the values from s2 array to list when if its not contains the value
            if its contains remove the value
     */

    private void uncommonFromSentencesTP(String s1, String s2) {

        String[] sa1 = s1.split(" ");
        String[] sa2 = s2.split(" ");
        List<String> list = new ArrayList<>();
        int left = 0, right = 0;

        while (left < sa1.length && right < sa2.length) {
            if (!sa1[left].equals(sa2[right])) {
                if (!list.contains(sa1[left])) {
                    list.add(sa1[left]);
                } else {
                    list.remove(sa1[left]);
                }
                if (!list.contains(sa2[right])) {
                    list.add(sa2[right]);
                } else {
                    list.remove(sa2[right]);
                }
            }
            left++;
            right++;
        }

        if (left == sa1.length) {
            while (left < sa2.length) {
                if (!list.contains(sa2[left])) {
                    list.add(sa2[left]);
                } else {
                    list.remove(sa2[left]);
                }
                left++;
            }
        }

        if (right == sa2.length) {
            while (right < sa1.length) {
                if (!list.contains(sa1[right])) {
                    list.add(sa1[right]);
                } else {
                    list.remove(sa1[right]);
                }
                right++;
            }
        }
        System.out.println(list);
    }

}

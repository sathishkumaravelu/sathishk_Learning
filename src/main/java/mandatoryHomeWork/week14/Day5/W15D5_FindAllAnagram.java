package mandatoryHomeWork.week14.Day5;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class W15D5_FindAllAnagram {

    /*
        Pesudo code:
        1. create a list of integer for output
        2. if the p length is greater than s return empty list
        3. have two char array of size 26
        4. iterate till the length of p and add char in both sArray and pArray
        5. if the both arrays are equal all the index 0
        6. slid the window by adding one char next and remove the one char previous
            check if the char array are equal, add the beginning index
     */

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length()>s.length()) return ans;
        char[] sArray = new char[26];
        char[] pArray = new char[26];

        for (int i = 0; i < p.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
            pArray[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sArray, pArray)) {
            ans.add(0);
        }

        int start = 0;
        for (int i = p.length(); i < s.length(); i++) {
            sArray[s.charAt(start) - 'a']--; // Remove previous character from the window
            sArray[s.charAt(i) - 'a']++; // Add the new character to the window
            if (Arrays.equals(sArray, pArray)) {
                ans.add(start + 1);
            }
            start++;
        }
        return ans;
    }

    @Test
    public void testData(){
        System.out.println(findAnagrams("cbaebabacd","abc"));
    }
}

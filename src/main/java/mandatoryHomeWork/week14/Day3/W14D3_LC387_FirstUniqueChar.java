package mandatoryHomeWork.week14.Day3;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W14D3_LC387_FirstUniqueChar {

    //Time complexity - O(N)
    //Space complexity - O(1)
    public int firstUniqChar(String s) {
        int[] charCount = new int[26];
        for (char ch : s.toCharArray()) {
            charCount[ch - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    //Time Complexity - O(N^2)
    //Space Complexity - O(1)
    public int firstUniqCharDefinedMethod(String s) {
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);
            if (i == s.lastIndexOf(c) && i == s.indexOf(c)) return i;
        }
        return -1;
    }

    @Test
    public void testData(){
        Assert.assertEquals(-1,firstUniqChar("aaaaabbbbbccccc"));
        Assert.assertEquals(0,firstUniqCharDefinedMethod("abc"));
    }


}

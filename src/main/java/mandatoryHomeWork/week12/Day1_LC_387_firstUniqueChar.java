package mandatoryHomeWork.week12;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Day1_LC_387_firstUniqueChar {


    //Pesudo Code:
    /*
        1. iterate thru the given string
            check if the first index and last index matching then retun the index
            if not return -1 at end
     */

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public int firstUniqChar(String s) {
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (s.indexOf(currentChar) == s.lastIndexOf(currentChar)) {
                return i;
            }
        }
        return -1;
    }


    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public int firstUniqueMap(String s){
        HashMap<Character,Integer> charMap = new HashMap<>();
        for (char ch:s.toCharArray()) {
            charMap.put(ch,charMap.getOrDefault(ch,0)+1);
        }
        int firstIndex = Integer.MAX_VALUE;
        for (Map.Entry<Character,Integer> eachSet:charMap.entrySet()) {
            if(eachSet.getValue()==1){
                int i = s.indexOf(eachSet.getKey());
                if(i<firstIndex){
                    firstIndex=i;
                }
            }
        }
        if(firstIndex==0x7fffffff) return -1;
        return firstIndex;
    }

    //Time Complexity - O(N)
    //Space Complexity - O(1)
    public int fistCharFrequencyArray(String s){
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
    @Test
    public void testData(){
        int index = firstUniqueMap("aabbcc");
        System.out.println(index);
    }
}

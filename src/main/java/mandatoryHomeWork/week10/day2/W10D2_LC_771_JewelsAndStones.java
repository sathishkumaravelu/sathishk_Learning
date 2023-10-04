package mandatoryHomeWork.week10.day2;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class W10D2_LC_771_JewelsAndStones {
    /*
    https://leetcode.com/problems/jewels-and-stones/description/
     */

    /*
        1. Problem understanding - 1 Min
        2. Test Data - 2 Min
        3. Solution - Yes
        4. Alternate solution - Yes
        5. Pseudo Code - 2 Mins
	    6. dry run - pseudo code - 2 mins
 	    7. write the code on paper - 2 mins
 	    8. test code - 2 mins
 	    9. code on IDE - 2 Mins
 	    10. test nd debug - 1 mins
 	    11. optimize
     */

    @Test
    public void validTest() {
        int i = numJewelsInStones("aA", "aAAbbbb");
        System.out.println(i);
    }


    //Pesudo Code
    //1. create a hashmap for stones
    //2. iterate thru the length of the stones
    //      add the stones char in the key and in value add the count
    //3. Keep a counter variable
    //4. iterate thru the length of the jewels again
    //   get the value from the stone map for each jewels, if the jewels is not available return zero
    //5. Finally return the count

    //Time Complexity - O(N+M) -> O(N)
    //Space Complexity - O(N)
    public int numJewelsInStones(String jewels, String stones) {
        HashMap<Character, Integer> stoneMap = new HashMap<>();
        for (char s : stones.toCharArray()) {
            stoneMap.put(s, stoneMap.getOrDefault(s, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            count += stoneMap.getOrDefault(jewels.charAt(i),0);
        }
        return count;
    }
}

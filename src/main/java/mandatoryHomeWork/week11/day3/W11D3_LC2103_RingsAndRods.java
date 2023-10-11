package mandatoryHomeWork.week11.day3;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class W11D3_LC2103_RingsAndRods {
    /*
     * 1. Understanding the problem - 5 Mins
     * 		Input  - String
     * 		Output - Int
     * 		constrains
     *
     *
     * 2. Test Data - 2 Mins
     * 3. do you know solution ? Yes
     * 4. Best solution / alternate solution - Yes
     * 5. Pseudo code -15 Mins
     * 6. dry run the pseudo code - 5 Mins
     * 7. write the code on notepad - 5 Mins
     * 8. dry run the code on notepad - 2 Mins
     * 9. Write code on IDE - 5 Mins
     * 10. Test and debug - 1 Mins
     * 11. Code optimization - 3 Mins
     *
     */

    @Test
    public void validData() {
        int count = countPoints("B0B6G0R6R0R6G9");
        System.out.println("Valid data :" + count);
    }

    @Test
    public void invalidData() {

        System.out.println("Invalid data :" + countPoints("B0"));
    }

    @Test
    public void edgeData() {
        System.out.println(countPoints("B0G0R0B1G1R1B2G2R2B3G4R4B5G5R5B6G6R6B7G7R7B8G8R8B9G9R9"));
    }

    /*
        1. Create a Map with Character for Key and Set of characters as value
        2. Iterate thru the input string length
                at the odd index values are fetched and even index key (rods) are fetched
        3. check in the map if the key is already available in the map
                if its not having the value then create a new set
           get the set for each rod and add the value to set
        4. finally iterate thru the values, check which set has size as 3 (RBG) increment the counter
        5. return the counter
     */


    //Time complexity - O(N)
    //Space Complexity - O(M)
    public int countPoints(String rings) {

        Map<Character, Set<Character>> map = new HashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < rings.length() - 1; i = i + 2) {
            char rod = rings.charAt(i + 1);
            char colorValue = rings.charAt(i);
            if (!map.containsKey(rod)) {
                map.put(rod, new HashSet<>());
            }
            map.get(rod).add(colorValue);
        }
        int count = 0;
        for (Set<Character> colors : map.values()) {
            if (colors.size() == 3) count++;
        }
        return count;
    }
}

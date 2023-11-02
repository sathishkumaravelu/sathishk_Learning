package mandatoryHomeWork.week14.Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class W14D4_LC2103RingAndRods {
    /*
        1. Create a map with Character and set<Character>
        2. iterate thru the given string
            get the rod from the odd and color of ring from even position
            check if the map has rod already created in map else put rod in key and new set in with it
            if the map already contains a rod and set of colors if so add the color to it
        3. iterate thru the values of the map, get the set size of the values in map
            if its size is 3 that is (RBG) then have a counter
        4. Finally return the counter.
     */

    //Time complexity - O(N)
    //Space complexity - O(N)
    public int countPoints(String rings) {
        Map<Character, Set<Character>> map = new HashMap<>();
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


        public int countPoints_BF(String rings) {
            int r[] = new int[10];
            int g[] = new int[10];
            int b[] = new int[10];

            int n = rings.length();
            for (int i = 0; i < n; i += 2) {
                //convert char to integer
                int a = rings.charAt(i + 1) - '0';
                //wherever rings are present add it in that colour array
                if (rings.charAt(i) == 'R') {
                    r[a]++;
                } else if (rings.charAt(i) == 'G') {
                    g[a]++;
                } else if (rings.charAt(i) == 'B') {
                    b[a]++;
                }
            }
            //if all three rings are present increase count
            int count = 0;
            for (int j = 0; j < 10; j++) {
                if (r[j] > 0 && g[j] > 0 && b[j] > 0)
                    count++;
            }
            return count;
        }

    @Test
    public void testData() {
        Assert.assertEquals(1, countPoints("B0B6G0R6R0R6G9"));
        Assert.assertEquals(1, countPoints_BF("B0R0G0R9R0B0G0"));
    }
}

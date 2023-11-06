package mandatoryHomeWork.week15.Day1;

import java.util.HashMap;

public class W15D1_LC1207_UniqueNoOccurance {

    /*
        input - int array
        output - boolean

        Test Data
        [1,2,2,1,1,3] - true
        [1,2] - false
        [-3,0,1,-3,1,1,1,-3,10,0] - true

        1. Add all the value to a HashMap
        2. iterate thru the values of the map
            add it to a set
        3. check if the size of the map and set equal return true
           else return false
     */

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public boolean isUniqueOccurance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i : map.values()) {
            if (map.containsValue(i)) {
                return false;
            }
        }
        return true;
    }
}

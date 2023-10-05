package mandatoryHomeWork.week10.day3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class W10D3_LC_1748_SumOfUnique {

    public void testData(){
        System.out.println( sumOfUnique(new int[] {1,2,3,2}));
    }
    public int sumOfUnique(int[] nums) {
        HashMap<Integer,Integer> uniqueMap = new HashMap<>();
        for (int i: nums) {
            uniqueMap.put(i, uniqueMap.getOrDefault(i,0)+1);
        }
        int result = 0;
        for (Map.Entry<Integer,Integer> eachEntry: uniqueMap.entrySet()) {
            if(eachEntry.getValue()==1) {
                result += eachEntry.getKey();
            }
        }
        return result;
    }
}


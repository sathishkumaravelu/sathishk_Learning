package mandatoryHomeWork.week15.Day1;

import java.util.HashMap;
import java.util.Map;

public class W15D1_LC169_MajorityElement {

    /*
        Input - int array
        output - int
        Test Data:
        [3,2,1,3,3,2,3] - 3
        [0,0,0,0,0] - 0
        [2,2,1,1,1,2,2] - 2

        Pseudo code :
        1. add the values in a HashMap
        2. iterate thru entry set, check if the value is >n/2 then return the key

     */


    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public int findMajorityEle(int[] arr){
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num:arr) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer,Integer> eachSet:map.entrySet()) {
            if(eachSet.getValue()>n/2){
                return eachSet.getKey();
            }
        }
        return -1;
    }

}

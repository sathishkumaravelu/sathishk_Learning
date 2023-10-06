package mandatoryHomeWork.week10.day4;

import org.junit.Test;

import java.util.*;

public class W10D4_LC448_disappearedNumbers {

    @Test
    public void validdata(){
        List<Integer> disappearedNumbers = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(disappearedNumbers);
    }

    //Time Complexity - O(N)
    //Space Complexity - O(N)
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int sizeOfInput = nums.length;
        List<Integer> out = new LinkedList<>();
        HashSet<Integer> disapperSet = new HashSet<>();
        for (int i:nums) {
            disapperSet.add(i);
        }

        for (int i = 1; i <= sizeOfInput; i++) {
            if(!disapperSet.contains(i)) out.add(i);
        }
        return out;
    }
}

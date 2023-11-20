package BrushUp;

import org.testng.annotations.Test;

import java.util.HashMap;

public class LC2342 {

    @Test
    public void testMaxSumPair() {
        int[] nums = {18, 43, 36, 13, 7};
        System.out.println(maximumSum(nums));
    }

    //Time complexity - O(N)
    //Space Complexity - O(N)
    private int maximumSum(int[] nums) {
        int res = -1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = sumValue(num);
            if (map.containsKey(key)) {
                res = Math.max(res, num + map.get(key));
                if (num > map.get(key)) {
                    map.put(key, num);
                }
            } else {
                map.put(key, num);
            }
        }
        return res;
    }

    private int sumValue(int num) {
        int temp = 0;
        while (num != 0) {
            temp += num % 10;
            num /= 10;
        }
        return temp;
    }
}

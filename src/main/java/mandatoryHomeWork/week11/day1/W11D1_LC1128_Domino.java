package mandatoryHomeWork.week11.day1;

import org.junit.Test;

import java.util.*;

public class W11D1_LC1128_Domino {

    @Test
    public void testData(){
        numEquivDominoPairs(new int[][] {{1,2},{2,1},{3,4},{5,6}});
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        for (int i = 0; i < dominoes.length; i++) {
            Arrays.sort(dominoes[i]);
        }
        int pair = 0;
        Map<List<Integer>,Integer> map = new HashMap<>();
        for (int[] dominoe : dominoes) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                list.add(dominoe[j]);
            }
            if (map.containsKey(list)) {
                map.replace(list, 1 + map.get(list));
                pair += map.get(list);
            } else {
                map.put(list, 0);
            }
        }
        return pair;
    }
}

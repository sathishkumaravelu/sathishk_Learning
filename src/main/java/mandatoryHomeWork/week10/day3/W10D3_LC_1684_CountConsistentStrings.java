package mandatoryHomeWork.week10.day3;

import org.junit.Test;
import org.testng.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class W10D3_LC_1684_CountConsistentStrings {

    @Test
    public void testData() {
        int ab = countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"});
        System.out.println(ab);
    }

    public int countConsistentStrings(String allowed, String[] words) {

        int count = 0;
        for (String element : words) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char ch : element.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            int counter = map.size();
            for (char ch : allowed.toCharArray()) {
                if (map.containsKey(ch)) counter--;
            }
            if (counter == 0) count++;
        }
        return count;
    }
}

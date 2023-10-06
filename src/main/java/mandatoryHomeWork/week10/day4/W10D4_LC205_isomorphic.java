package mandatoryHomeWork.week10.day4;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class W10D4_LC205_isomorphic {

    @Test
    public void validdata(){
        boolean isomorphic = isIsomorphic("egg", "add");
        System.out.println(isomorphic);
    }

    @Test
    public void invaliddata(){
        boolean isomorphic = isIsomorphic("bbbaaaba", "ababbbba");
        System.out.println(isomorphic);
    }

    //Time Complexity - O(N)
    //space Complexity - O(N)
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(!sMap.containsKey(s.charAt(i))){
               if(!sMap.containsValue(t.charAt(i))){
                    sMap.put(s.charAt(i),t.charAt(i));
               }else return false;
            }else{
                if(sMap.get(s.charAt(i))!=t.charAt(i)){
                    return  false;
                }
            }
        }
        return true;
    }
}

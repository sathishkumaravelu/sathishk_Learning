package mandatoryHomeWork.week14.Day4;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class W14D4_LC187_DNA {

    public List<String> findRepeatedDnaSequences(String s) {

        List<String> list = new ArrayList<String>();
        if(s.length()<=10){
            return list;
        }
        HashMap<String,Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();
        int pointer = 0;
        while (pointer<10){
            str.append(s.charAt(pointer));
            pointer++;
        }
        map.put(String.valueOf(str),map.getOrDefault(String.valueOf(str),0)+1);
        int n = s.length();
        while (pointer<n){
            str.deleteCharAt(0);
            str.append(s.charAt(pointer));
            map.put(String.valueOf(str),map.getOrDefault(String.valueOf(str),0)+1);
            pointer++;
        }

        System.out.println(map);


        for (Map.Entry<String, Integer> entry: map.entrySet())
            if (entry.getValue() > 1)
                list.add(entry.getKey());

        return list;
    }

    @Test
    public void testData(){
        findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
    }
}

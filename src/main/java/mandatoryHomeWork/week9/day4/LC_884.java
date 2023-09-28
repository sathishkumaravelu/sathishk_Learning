package mandatoryHomeWork.week9.day4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class LC_884 {

	@Test
	public void testData() {
		String[] uncommonFromSentences = uncommonFromSentences("fd kss fd","fd fd kss");
		System.out.println(Arrays.toString(uncommonFromSentences));
	}
	
	
	
	public String[] uncommonFromSentences(String s1, String s2) {
		String[] s1Split = s1.split(" ");
		String[] s2Split = s2.split(" ");
		String output="";
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i =0; i<s1Split.length;i++) {
			if(!(map.containsKey(s1Split[i]))){
				map.put(s1Split[i], 1);
			}else {
				map.put(s1Split[i], (map.get(s1Split[i]))+1);
			}
		}
		
		for(int i =0; i<s2Split.length;i++) {
			if(!(map.containsKey(s2Split[i]))){
				map.put(s2Split[i], 1);
			}else {
				map.put(s2Split[i],(map.get(s2Split[i]))+1);
			}
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			if(entry.getValue()==1) {
				output+=entry.getKey()+" ";
			}
		}
		String[] split = output.split(" ");
		if(output.isEmpty()) {
			return new String[] {};
		}else return split;
	}
}

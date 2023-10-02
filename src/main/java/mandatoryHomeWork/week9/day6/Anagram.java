package mandatoryHomeWork.week9.day6;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.testng.annotations.Test;

public class Anagram {

	@Test
	public void testData() {
		boolean anagram = isAnagram_ConcurrentMap("anagram", "nagaram");
		System.out.println(anagram);
	}
	
	@Test
	public void testData1() {
		boolean anagram = isAnagram_SingleMap("", "a");
		System.out.println(anagram);
	}
	
	public boolean isAnagram(String s, String t) {
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		HashMap<Character, Integer> tMap = new HashMap<Character, Integer>();
		for (int j = 0; j <= s.length()-1; j++) {
			sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0)+1);
		}
		
		for (int j = 0; j <= t.length()-1; j++) {
			tMap.put(t.charAt(j), tMap.getOrDefault(t.charAt(j), 0)+1);
		}
		return sMap.equals(tMap);	
	}
	
	
	public boolean isAnagram_SingleMap(String s, String t) {
		HashMap<Character, Integer> sMap = new HashMap<Character, Integer>();
		if(s.length()!=t.length()) return false;
		for (int j = 0; j <= s.length()-1; j++) {
			sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0)+1);
			sMap.put(t.charAt(j), sMap.getOrDefault(t.charAt(j), 0)-1);			
		}
		for (Map.Entry<Character, Integer> eachSet: sMap.entrySet()) {
			if(eachSet.getValue()!=0) return false;
		}
		return true;		
	} 
	
	
	public boolean isAnagram_ConcurrentMap(String s, String t) {
		ConcurrentMap<Character, Integer> sMap = new ConcurrentHashMap<>();
		if(s.length()!=t.length()) return false;
		for (int j = 0; j <= s.length()-1; j++) {
			sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0)+1);
			sMap.put(t.charAt(j), sMap.getOrDefault(t.charAt(j), 0)-1);			
		}
		for (Map.Entry<Character, Integer> eachSet: sMap.entrySet()) {
			if(eachSet.getValue()==0) {
				sMap.remove(eachSet.getKey(),0);
			}
		}
		return sMap.isEmpty();		
	} 
	
	
}

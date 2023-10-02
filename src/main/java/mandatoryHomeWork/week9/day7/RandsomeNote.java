package mandatoryHomeWork.week9.day7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RandsomeNote {
	/*
	 * Given two strings ransomNote and magazine, return true if ransomNote can be
	 * constructed by using the letters from magazine and false otherwise.
	 * 
	 * Each letter in magazine can only be used once in ransomNote.
	 * 
	 * 
	 * randsome note: aa magazine map : b  return false
	 * randsome note: aa magazine map : a  return false
	 * 
	 * Pesudo Code:
	 * 
	 * 1. create a map for magazine 
	 * 2. add all the char of magazine to the map 
	 * 3. iterate thru the map check if the randsome note all char are available in mMap and values are matching
	 * 4. return true else if its not available return false
	 */
	
	
	@Test
	public void validData() {
		boolean isRandsomeNote = randsomeNoteCharArray("fihjjjjei", "hjibagacbhadfaefdjaeaebgi");
		Assert.assertEquals(isRandsomeNote, false);
	}
//
//	@Test
//	public void validData1() {
//		boolean isRandsomeNote = randsomeNoteCheck_Map("code", "doec");
//		Assert.assertEquals(isRandsomeNote, true);
//	}
//
//	@Test
//	public void validData2() {
//		boolean isRandsomeNote = randsomeNoteCheck_Map("muug", "mug");
//		Assert.assertEquals(isRandsomeNote, false);
//	}
//
//	@Test
//	public void validData3() {
//		boolean isRandsomeNote = randsomeNoteCheck_Map("code", "codee");
//		Assert.assertEquals(isRandsomeNote, true);
//	}
//	
//	@Test
//	public void validData4() {
//		boolean isRandsomeNote = randsomeNoteCheck_Map("codeee", "codxee");
//		Assert.assertEquals(isRandsomeNote, false);
//	}

	public boolean randsomeNoteCheck_Map(String randsomeNote, String magazine) {
		HashMap<Character, Integer> magazineMap = new HashMap<Character, Integer>();
		for (Character ch : magazine.toCharArray()) {
			magazineMap.put(ch,magazineMap.getOrDefault(ch,0)+1);
		}
		for (Character ch : randsomeNote.toCharArray()) {
			magazineMap.put(ch,magazineMap.getOrDefault(ch,0)-1);
		}	
		for (Map.Entry<Character, Integer> eachSet: magazineMap.entrySet()) {
			if(eachSet.getValue()<0) {
				return false;
			}
		}
		return true;
	}
	
	public boolean randsomeNoteCheck_ConcurrentMap(String randsomeNote, String magazine) {
		ConcurrentMap<Character, Integer> magazineMap = new ConcurrentHashMap<>();
		if(magazine.length()<randsomeNote.length())return false;
		for (int i = 0; i < magazine.length(); i++) {
			magazineMap.put(magazine.charAt(i),magazineMap.getOrDefault(magazine.charAt(i),0)+1);
			if(i<randsomeNote.length()) {
				magazineMap.put(randsomeNote.charAt(i),magazineMap.getOrDefault(randsomeNote.charAt(i),0)-1);
			}
		}
		for (Map.Entry<Character, Integer> eachSet: magazineMap.entrySet()) {
			if(eachSet.getValue()<0) {
				return false;
			}
		}
		return magazineMap.isEmpty();		
	}
	

	public boolean randsomeNoteCharArray(String randsomeNote, String magazine) {
		int[] magazineArr = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			magazineArr[magazine.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < randsomeNote.length(); i++) {
			magazineArr[randsomeNote.charAt(i) - 'a']--;
		}
		for (int c : magazineArr) {
			if (c < 0)return false;
		}
		 return true;
	}
	
}

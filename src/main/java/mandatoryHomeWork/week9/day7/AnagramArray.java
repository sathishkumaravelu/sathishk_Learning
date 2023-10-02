package mandatoryHomeWork.week9.day7;

import java.util.Arrays;
import java.util.HashSet;

import org.testng.annotations.Test;

public class AnagramArray {

	@Test
	public void testData() {
		boolean anagram = isAnagram("aa", "aa");
		System.out.println(anagram);
	}

	public boolean isAnagram(String s, String t) {
		if(s.length()!=t.length())return false;
		char[] sChar = new char[26];
		
		for (int i = 0; i < s.length(); i++) {
			sChar[s.charAt(i) - 'a']++;
			sChar[t.charAt(i) - 'a']--;
		}
		/*
		 * for (int i = 0; i < t.length(); i++) { sChar[t.charAt(i) - 'a']--; }
		 */

		for (char c : sChar) {
			if (c != 0)return false;
		}
		return true;
	}
	
	
}

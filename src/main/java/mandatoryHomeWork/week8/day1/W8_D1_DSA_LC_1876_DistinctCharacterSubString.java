package mandatoryHomeWork.week8.day1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W8_D1_DSA_LC_1876_DistinctCharacterSubString {



	/*
	 * Problem Statement:
	 * https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
	 * 
	 */
	
	
	/*
	 * 1. Understanding the problem - 2 Mins
	 * 		Input  - String
	 * 		Output - Int
	 * 		constrains
	 * 	
	 * 
	 * 2. Test Data - Yes
	 * 3. do you know solution ?  - Yes
	 * 4. Best solution / alternate solution - Brute force / Sliding window
	 * 5. Pseudo code - Brute force  5 Mins 
	 * 6. dry run the pseudo code - 5 Mins
	 * 7. write the code on notepad - 10 Mins
	 * 8. dry run the code on notepad - 2 Mins
	 * 9. Write code on IDE - 3 Mins
	 * 10. Test and debug - 1 min 
	 * 11. Code optimization 
	 * 
	 */
	
	
	//
	@Test
	public void validData() {
		int countGoodSubstrings = countGoodSubstrings("aababcabc");
		System.out.println(countGoodSubstrings);
		Assert.assertEquals(countGoodSubstrings, 4);
	}

	public void invalidData() {
		
		int countGoodSubstrings = countGoodSubstrings("xyzzaz");
		System.out.println(countGoodSubstrings);
		Assert.assertEquals(countGoodSubstrings, 1);
	}
	public void edgeData() {
	
		int countGoodSubstrings = countGoodSubstrings("xyzzaz");
		System.out.println(countGoodSubstrings);
		Assert.assertEquals(countGoodSubstrings, 1);
	}

	public int countGoodSubstrings(String word) {
		int nonDuplicateCount = 0;
		for (int i = 0; i < word.length() - 2; i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			List<Character> list = new LinkedList<Character>();
			for (int j = i; j < i + 3; j++) {
				list.add(word.charAt(j));
				int count = 1;
				if (!map.containsKey(word.charAt(j))) {
					map.put(word.charAt(j), count);
					count = 0;
				} else {
					map.put(word.charAt(j), count + 1);
				}
			}
			if (map.size() == list.size()) {
				nonDuplicateCount++;
			}

		}
		return nonDuplicateCount;
	}
}

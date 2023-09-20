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
		int countGoodSubstrings = countGoodSubstrings("aababcabc","SW");
		System.out.println(countGoodSubstrings);
		Assert.assertEquals(countGoodSubstrings, 4);
	}

	@Test
	public void invalidData() {
		
		int countGoodSubstrings = countGoodSubstrings("xyzzaz","SW");
		System.out.println(countGoodSubstrings);
		Assert.assertEquals(countGoodSubstrings, 1);
	}
	@Test
	public void edgeData() {
	
		int countGoodSubstrings = countGoodSubstrings("aaaaa","SW");
		System.out.println(countGoodSubstrings);
		Assert.assertEquals(countGoodSubstrings, 0);
	}

	//Time Complexity - O(n)
	// Space Complexity - O(N)
	
	public int countGoodSubstrings(String word) {
		int nonDuplicateCount = 0;
		for (int i = 0; i < word.length() - 2; i++) { //o(n)
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			//List<Character> list = new LinkedList<Character>();
			for (int j = i; j < i + 3; j++) { //O(1)
				//list.add(word.charAt(j));
				int count = 1;
				if (!map.containsKey(word.charAt(j))) {
					map.put(word.charAt(j), count);
					count = 0;
				} else {
					map.put(word.charAt(j), count + 1);
				}
			}
			if (map.size() == 3) {
				nonDuplicateCount++;
			}

		}
		return nonDuplicateCount;
	}
	
	
	
	
	public int countGoodSubstrings(String word,String logic) {
		int nonDuplicateCount = 0;
		int pointer =0, k=3;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		 while(pointer < k) {
			 int count = 1;
			 if (!map.containsKey(word.charAt(pointer))) {
					map.put(word.charAt(pointer), count);
					count = 0;
				} else {
					map.put(word.charAt(pointer), count + 1);
				}
			 pointer++;
		 }
		 if(map.size()==3) {
			 nonDuplicateCount++;
		 }
		
		 while(pointer < word.length()) {
			 int count=1;
			 int temp = pointer-k;

			if(map.get(word.charAt(temp))==1){
				map.remove(word.charAt(temp));
			}else {
				map.replace(word.charAt(temp), (map.get(word.charAt(temp)))-1);
			}
			
			if (!map.containsKey(word.charAt(pointer))) {
					map.put(word.charAt(pointer), count);
					count = 0;
				} else {
					map.put(word.charAt(pointer), count + 1);
				}
			 pointer++;
			 
			 if(map.size()==3) {
				 nonDuplicateCount++;
			 }
		 }
		 
		return nonDuplicateCount;
		
	}
}

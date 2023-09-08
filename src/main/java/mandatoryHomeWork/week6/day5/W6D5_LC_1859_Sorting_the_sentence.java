package mandatoryHomeWork.week6.day5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W6D5_LC_1859_Sorting_the_sentence {

	/*
	 Problem Statement: 1859. Sorting the Sentence
	 https://leetcode.com/problems/sorting-the-sentence/

	 A sentence is a list of words that are separated by a single space with no leading or trailing spaces. 	       	 Each word consists of lowercase and uppercase English letters.

	 A sentence can be shuffled by appending the 1-indexed word position to each word then rearranging the 	 	 	 words in the sentence.

	 For example, the sentence "This is a sentence" can be shuffled as "sentence4 a3 is2 This1" or "is2  	 	   	 sentence4 This1 a3".
	 Given a shuffled sentence s containing no more than 9 words, reconstruct and return the original 	  	  	 	 sentence.

 	 1. Understanding the problem: 1 Mins	
	 		Input -> String s
	 		Output-> String value
	 2. Test data - 2 Mins
	 3. Do you know the Solution? - Yes
	 4. Do you have any alternate approaches? - No
	 5. Pesudo code - 5 Mins (Hint)
	 6. Dry run the pseudo code - 3 Min
	 7. Write the code on notepad - 5 Mins
	 ArrayList<String> dynamicArray = new ArrayList<>();
	 String temp ="";
	 for(int i=0;i<input.length();i++){ 
	 if(input.charAt(i)==' '){
     temp+=input.charAt(i);
     }
	 dynamicArray[temp.chartAt(input.length()-1)] = temp;
     temp="";
     }
     syso(Array.toString(dyanamicArray));
     
	 8. Dry run the code with all test data - 2 Mins
	 9. Write code on IDE - 1 Min
	 10. Test the code + Debug the code - 3 Min
	 11. Check for any gaps of code optimization - NA

	 */
	
	
	@Test
	public void validData() {
		String value = sortSentence("is2 sentence4 This1 a3"); 
		Assert.assertEquals(value,"this is a sentence");
	}
	
	@Test
	public void validData1() {
		String value = sortSentence("Myself2 Me1 I4 and3"); 
		Assert.assertEquals(value,"Me Myself and I");
	}

	
	//Pseudo code 
//	create an array list
//	for length of string iterate
//	 - check if a ' ' occurs 
//	till then add a char to a word
//	get the last index of the word, give that value to the array[last index] = word.replace['number']
//	finally convert the list into an string and return 
	
	private String sortSentence(String s) {
		
		s=s+" ";
		String[] words = s.split("\\s+");
		  int wordCount = words.length;
		  String[] dynamicArray= new String[wordCount]; 
		
		//ArrayList<String> dynamicArray = new ArrayList<>();
		String temp ="";
		for(int i=0;i<s.length();i++){  //O(N)
		if(s.charAt(i)!=' '){
		 temp+=s.charAt(i);
		}else {
			char charAt = temp.charAt(temp.length()-1);
			int index = charAt-'0';
			dynamicArray[index-1]=temp.replaceAll("[0-9]", "");
			temp="";
		}

		}
		 StringBuilder result = new StringBuilder();
	        for (int i = 0; i < dynamicArray.length; i++) {
	            result.append(dynamicArray[i]);
	            if (i < dynamicArray.length - 1) {
	                result.append(" "); 
	            }
	        }

		return result.toString();
		

	}
	
	
	
	
	
}

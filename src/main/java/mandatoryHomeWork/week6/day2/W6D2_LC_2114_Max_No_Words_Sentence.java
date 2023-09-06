package mandatoryHomeWork.week6.day2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W6D2_LC_2114_Max_No_Words_Sentence {
/*
 2114. Maximum Number of Words Found in Sentences
 
 	A sentence is a list of words that are separated by a single space with no leading or trailing spaces.
	You are given an array of strings sentences, where each sentences[i] represents a single sentence.
	Return the maximum number of words that appear in a single sentence.
 
 
	1.Understanding the problem  - Yes : 2 Mins
		Input - String of words
		output - int
		constrain - 
		1 <= sentences.length <= 100
		1 <= sentences[i].length <= 100
		sentences[i] consists only of lowercase English letters and ' ' only.
		sentences[i] does not have leading or trailing spaces.
		All the words in sentences[i] are separated by a single space.

	2.Frame Test data (valid, invalid, complex and edge cases) - 3 Mins

	3.Do you know the Solution? - Yes

	4.Do you have any alternate approaches? (Thing of alternate approaches) - No

	5. Derive Pseudo code in paper (for the best chosen approach) - Yes - 3 Mins
     
	6. Dry run the pseudo code with all test data from step #2

	7.Write the code on notepad - 2 Min
	
	int max = 0;
		for (int i = 0; i < inputSentence.length; i++) {
			int count =0;
			for (int j = 0; j < inputSentence[i].length(); j++) {
				if(inputSentence[i].charAt(j)==' '&&inputSentence[i].charAt(j+1)!=' ') {
					count++;
				}
			}
			if(max<=count) {
				max=count;
			}
		}
		
		return max;
	}

	8. Dry run the code with all test data from step #2 - 1 Min

	9. Write code on IDE (remember to add comments and practice coding standards) - 2 Min

	10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE - 2 Min

	11. Check for any gaps of code optimization (if not optimized already in Step #9)

 
 */
	
	
	//Test Data - 3 Mins
	
	@Test
	public void validData() {
		String inputSentence[] = {"Michale Jackson was a classy ever","TS was sassy","SelenaGomez rocks"};
		int noOfWords = findNoOFWords(inputSentence);
		Assert.assertEquals(noOfWords, 6);
	}
	@Test
	public void inValidData() {
		String inputSentence[] = {"MichaleJacksonwasaclassy","TSwassassy","SelenaGomezrocks"};
		int noOfWords = findNoOFWords(inputSentence);
		Assert.assertEquals(noOfWords, 1);
	}
	@Test
	public void edgeData() {
		String inputSentence[] = {"Michale Jackson was a classy","TS was sassy as always","Selena Gomez rocks with vocal"};
		int noOfWords = findNoOFWords(inputSentence);
		Assert.assertEquals(noOfWords, 5);
	}
	@Test
	public void edgeData1() {
		String inputSentence[] = {"Michale  Jackson was a classy","TS was sassy as always","Selena Gomez rocks with vocal"};
		int noOfWords = findNoOFWords(inputSentence);
		Assert.assertEquals(noOfWords, 5);
	}

	//Pseudo code - 3 Min
	/*
	 1. initalize max varaiable
	 2. iterate thru the length of the array to access the each element 
	 3. initalize the counter variable 
	 4. iterate thru the length of the each element from the array
            - check for ' ' if its present increase the counter
       		- at end assign the count to max
       		- iterate to the next element of the array
       		- iterate thru the length 
	 5. check if the counter value of element is greater than the max value, then update the max 
	 6. return max+1 as we calculate the words not space actually
	 */
	
	private int findNoOFWords(String[] inputSentence) {
		
		int max = 0;
		for (int i = 0; i < inputSentence.length; i++) {
			int count =0;
			for (int j = 0; j < inputSentence[i].length(); j++) {
				if(inputSentence[i].charAt(j)==' '&&inputSentence[i].charAt(j+1)!=' ') {
					count++;
				}
			}
			if(max<=count) {
				max=count;
			}
		}
		
		return max+1;
	}
	
	
}

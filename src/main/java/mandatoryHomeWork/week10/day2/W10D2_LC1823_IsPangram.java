package mandatoryHomeWork.week10.day2;

import org.junit.Assert;
import org.junit.Test;

public class W10D2_LC1823_IsPangram {
     /*
       https://leetcode.com/problems/check-if-the-sentence-is-pangram/description/
     */

    /*
        1. Problem understanding - 1 Min
        2. Test Data - 2 Min
        3. Solution - Yes
        4. Alternate solution - Yes
        5. Pseudo Code - 2 Mins
	    6. dry run - pseudo code - 2 mins
 	    7. write the code on paper - 2 mins
 	    8. test code - 2 mins
 	    9. code on IDE - 2 Mins
 	    10. test nd debug - 1 mins
 	    11. optimize
     */
    @Test
    public void validData(){
        Assert.assertTrue(checkIfPangramFrequency("thequickbrownfoxjumpsoverthelazydog"));
    }

    @Test
    public void invalidData(){
        Assert.assertFalse(checkIfPangramFrequency("leetcode"));
    }

    public boolean checkIfPangram(String sentence) {
        for(char a='a';a<='z';a++) {
            if(sentence.indexOf(a)==-1) {
                return false;
            }
        }
        return true;
    }

    public boolean checkIfPangramFrequency(String sentence) {
        int[] freqArray = new int[26];
        for (char c: sentence.toCharArray()) {
            freqArray[c-'a']++;
        }
        for (int i: freqArray) {
            if(i==0) return false;
        }
        return true;
    }


}

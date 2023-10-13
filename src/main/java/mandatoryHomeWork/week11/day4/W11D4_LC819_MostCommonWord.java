package mandatoryHomeWork.week11.day4;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class W11D4_LC819_MostCommonWord {

    /*
         1. convert the given paragraph into to lowercase, replace all the special character with " "
         2. create a map for adding the words in the paragraph
         3. create a set to add all the words in the banned words, so we can check is it contains for comparision in one's
         4. convert the paragraph into String array
         5. initalize maxKey and maxValue
         6. iterate thru the length of the paragraph
                if the word is already available in the banned set, not need to add in map
                else, we can add the string in key and count
                check the count of the string is max or not, if its max assign the respective key to String maxKey

         7. finally return maxKey.

     */

    //Time Complexity  - O(N+M*B)
    //Space Complexity - O(N)
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase(); //O(N)
        HashMap<String, Integer> map = new HashMap<>(); //O(1)
        HashSet<String> setBannedWord = new HashSet<>(Arrays.asList(banned));//O(M)
        String maxKey = "";
        int maxValue = 0;
        String[] wordsArr = paragraph.split(" ");
        for (String word : wordsArr) { //O(B)
            if (setBannedWord.contains(word) && !word.isEmpty()) {
                int count = map.getOrDefault(word, 0) + 1;
                map.put(word, count);
                if (count > maxValue) {
                    maxValue = count;
                    maxKey = word;
                }
            }
        }
        return maxKey;
    }

    @Test
    public void testData() {
        String s = mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"});
        System.out.println(s);
    }
}

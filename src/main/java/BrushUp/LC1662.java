package BrushUp;

import org.testng.annotations.Test;

public class LC1662 {

    @Test
    public void testArrayStringsAreEqual(){
        String[] word1 = {"a", "cb"};
        String[] word2 = {"ab", "cb"};
        boolean b = arrayStringsAreEqual(word1, word2);
        System.out.println(b);

    }
    /*
        1. iterate thru the given string1 array and create a string by concat all the values
        2. repeat step 1 for string 2
        3. check if string 1 and string 2 are equal then return true else return false
     */

    //Time - O(N)
    //Space - O(N)
    private boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        return (formString(word1).equals(formString(word2)));
    }
    private String formString(String[] word){
        StringBuilder temp = new StringBuilder();
        for (String s: word) {
            temp.append(s);
        }
        return temp.toString();
    }
}

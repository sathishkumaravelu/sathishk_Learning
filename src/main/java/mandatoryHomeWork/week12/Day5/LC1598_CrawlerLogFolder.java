package mandatoryHomeWork.week12.Day5;

import org.testng.annotations.Test;

import java.util.Stack;

public class LC1598_CrawlerLogFolder {

    /*
        pseudo code:
        1. create a stack
        2. iterate thru the given string array
             a.) if the stack wasn't empty and if the string is "../"
                 then remove the value from stack
             b.) if the string was not equal to "./" and "../" then push
        3. finally return the size of the stack
     */

    //Time complexity - O(N)
    //Space complexity - O(N)
    public int minOperations(String[] logs) {
        Stack<String> st = new Stack<>();
        for (String log : logs) {
            if (!st.isEmpty() && log.equals("../")) st.pop();
            else if (!log.equals("./") && !log.equals("../")) st.push(log);
        }
        return st.size();
    }

    @Test
    public void testData() {
        int i = minOperations(new String[]{"d1/", "d2/", "../", "d21/", "./"});
        System.out.println(i);

    }

}

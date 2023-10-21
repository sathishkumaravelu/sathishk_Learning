package mandatoryHomeWork.week12.Day6;

import org.testng.annotations.Test;

import java.util.Stack;

public class LC_394_DecodeString {

    public String decodeString(String s) {

        Stack characterStack = new Stack();
        Stack numberStack = new Stack();
        StringBuilder str = new StringBuilder();
        int num = 0;
        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if (ch == '[') {
                characterStack.push(str);
                str = new StringBuilder();
                numberStack.push(num);
                num = 0;
            } else if (ch == ']') {
                StringBuilder temp = str;
                str = (StringBuilder) characterStack.pop();
                int count = (int) numberStack.pop();
                while (count-- > 0) {
                    str.append(temp);
                }
            } else {
                str.append(ch);
            }

        }
        return str.toString();
    }


    @Test
    public void testData() {
        String s = decodeString("3[a]2[bc]");
        System.out.println(s);
        String s1 = decodeString("3[a2[c]]");
        System.out.println("S1: -> "+s1);
    }
}

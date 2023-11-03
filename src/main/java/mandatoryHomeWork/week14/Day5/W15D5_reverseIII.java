package mandatoryHomeWork.week14.Day5;

import org.testng.annotations.Test;

import java.util.Stack;

public class W15D5_reverseIII {

    public String reverseWords(String s) {
        StringBuilder output = new StringBuilder();
        if (!s.contains(" ")) {
            return reverseString(s);
        }
        String[] s1 = s.trim().split(" ");
        for (String str : s1) {
            String s2 = reverseString(str);
            output.append(s2).append(" ");
        }
        return output.toString().trim();
    }

    private String reverseString(String s) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        for (int i = 0; i < length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[length - i - 1];
            charArray[length - i - 1] = temp;
        }
        return new String(charArray);
    }


    public String reverseWordsStack(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char ch : charArray) {
            if (ch != ' ') {
                stack.push(ch);
            } else {
                while (!stack.isEmpty()) {
                    str.append(stack.pop());
                }
                str.append(' ');
            }
        }

        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.toString();
    }

    @Test
    public void testData() {
        // System.out.println(reverseWords("Sathish Sathish"));
        System.out.println(reverseWordsStack("Sathish Sathish"));
        System.out.println(reverseWordsStack("Sathish"));

    }
}

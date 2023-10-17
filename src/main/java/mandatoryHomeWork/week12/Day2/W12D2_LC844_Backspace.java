package mandatoryHomeWork.week12.Day2;

import org.testng.annotations.Test;

import java.util.Stack;

public class W12D2_LC844_Backspace {
    public boolean backspaceCompare(String s, String t) {
        Stack stack1 = addValuesToStack(s);
        Stack stack2 = addValuesToStack(t);

        if (stack1.equals(stack2) || (stack1.isEmpty() && stack2.isEmpty())){
            return  true;
        }else {
            return false;
        }
    }

    private Stack addValuesToStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '#'&&(!stack.isEmpty())) {
                stack.pop();
            } else if(ch != '#'){
                stack.push(ch);
            }
        }
        return stack;
    }


    @Test
    public void testData(){
        backspaceCompare("y#fo##f","y#f#o##f");
    }
}

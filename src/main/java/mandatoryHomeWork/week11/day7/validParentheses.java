package mandatoryHomeWork.week11.day7;

import org.testng.annotations.Test;

import java.util.Stack;

public class validParentheses {

    /*
        1. input - string
            output - boolean


        Pseudo code:
        1. create a stack
        2. iterate thru the string
            add the first value in to the stack
                now peek the value of the added one if its same then remove
                if not return false
        3. check if the stack size is zero return true


     */


    public boolean isValid1(String s) {

        Stack<Character> parantesesStack = new Stack<>();

        for (char ch:s.toCharArray()) {
            if(parantesesStack.isEmpty()){
                parantesesStack.add(ch);
            }else if(parantesesStack.peek() == ch){
                parantesesStack.removeAllElements();
            } else if (!parantesesStack.isEmpty() &&(int) parantesesStack.peek() != ch) {
                return false;
            }
        }
        return  parantesesStack.isEmpty();
    }


    public boolean isValid(String s) {

        Stack<Character> parantesesStack = new Stack<>();
        {
            
        }
        return  parantesesStack.isEmpty();
    }

        @Test
    public  void  testData(){
            boolean valid = isValid("()[]{}");
            System.out.println(valid);
        }
}

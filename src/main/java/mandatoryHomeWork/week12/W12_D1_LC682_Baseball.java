package mandatoryHomeWork.week12;

import org.testng.annotations.Test;

import java.util.Stack;

public class W12_D1_LC682_Baseball {

    //Pseudo code
    /*
        1. Create a Stack
        2. iterate thru the given string
            check if has + then get the value by pop() the last added and add it to new one,
            then add the initial pop value and new value into the stack back
            if its "C" then remove the value by pop
            if its "D" then peek the value and multiply by 2
            else push the given value
        3. iterate thru the stack size and add the value to sum variable and return

     */

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for (String str : operations) {
            switch (str) {
                case "+":
                    int top = stack.pop();
                    int newTop = top + stack.peek();
                    stack.push(top);
                    stack.push(newTop);
                    break;
                case "C":
                    stack.pop();
                    break;
                case "D":
                    Integer peek = stack.peek();
                    stack.push(peek * 2);
                    break;
                default:
                    stack.push(Integer.parseInt(str));
                    break;
            }
        }
        int sum = 0;
        for (Integer integer : stack) {
            sum += integer;
        }
        return sum;
    }


    @Test
    public void test() {
        String[] input = new String[]{"5", "2", "C", "D", "+"};
        int i = calPoints(input);
        System.out.println(i);
    }
}

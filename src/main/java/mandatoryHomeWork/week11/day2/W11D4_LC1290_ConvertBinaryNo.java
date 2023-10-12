package mandatoryHomeWork.week11.day2;

import org.testng.annotations.Test;

public class W11D4_LC1290_ConvertBinaryNo {

    /*
     * 1. Understanding the problem - 1 Mins
     * 		Input  - LinkedList Head
     * 		Output - Int
     * 		constrains
     *
     *
     * 2. Test Data - 1 Mins
     * 3. do you know solution ? Yes
     * 4. Best solution / alternate solution - Yes
     * 5. Pseudo code -5 Mins
     * 6. dry run the pseudo code - 5 Mins
     * 7. write the code on notepad - 3 Mins
     * 8. dry run the code on notepad - 2 Mins
     * 9. Write code on IDE - 5 Mins
     * 10. Test and debug - 1 Mins
     * 11. Code optimization - 1 Mins
     *
     */

    @Test
    public void testData() {
        ListNode head1 = new SingleLinkedList().add(new int[]{1, 0, 1});
        int decimalValue = getDecimalValue(head1);
        System.out.println(decimalValue);
    }

    //Pesudo Code
    /*
        1. create temp node assign to head
        2. create a String builder object  as result
        3. Iterate till my current node is null which is tail
                get the value of the node and store it to the stringBuilder
                iterate the currentNode to the next
        4. return the consider String value as binary, convert it to decimal by giving parseInt
     */

    //Time Complixity - O(N^2)
    //Space Complixity - O(N)
    public int getDecimalValue(ListNode head) {
        ListNode currentNode = head;
        StringBuilder result = new StringBuilder();
        while (currentNode != null) {
            result.append(currentNode.data);
            currentNode = currentNode.next;
        }
        return Integer.parseInt(result.toString(),2);
    }
}

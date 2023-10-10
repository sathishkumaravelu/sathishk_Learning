package mandatoryHomeWork.week11.day2;

import org.testng.annotations.Test;

public class TestCase {

    @Test
    public void testData(){
    int[]  input =new int[] {1,2,3,4,5};
    SingleLinkedList list = new SingleLinkedList();
        ListNode add = list.add(input);
        ListNode listNode = list.middleNode_1();
        list.display(listNode);

    }


}

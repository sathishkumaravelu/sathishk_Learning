package mandatoryHomeWork.week11.day6;

import org.testng.annotations.Test;

import java.util.List;

public class reverseLL {
    @Test
    public void testData(){
        ListNode head = new SingleLinkedList().add(new int[]{4,  1, 8, 4, 5});
        ListNode revesedNode = reverseList(head);
        new SingleLinkedList().display(revesedNode);
    }
    public ListNode reverseList(ListNode head) {
        ListNode currentNode = head; //4
        ListNode previousNode = null;//null

        while(currentNode != null) {
            ListNode next = currentNode.next; // next = 1
            currentNode.next = previousNode;  // currentNode.next = null
            previousNode = currentNode;  // 4
            currentNode = next; // 1
        }
        return previousNode;
    }
}

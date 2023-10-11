package mandatoryHomeWork.week11.day2;

import mandatoryHomeWork.week11.day2.ListNode;
import mandatoryHomeWork.week11.day2.SingleLinkedList;
import org.testng.annotations.Test;

public class W11D3_RemoveDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode previousNode = head;
        ListNode temp = previousNode.next;
        while (temp != null) {
            if (temp.data == previousNode.data) {
                temp = temp.next;
                continue;
            }
            previousNode.next = temp;
            previousNode = temp;
            temp = temp.next;
        }
        previousNode.next = null;
        return head;
    }

    @Test
    public void testData() {
        ListNode head1 = new SingleLinkedList().add(new int[]{1, 2, 2, 3, 3, 4, 4, 4});
        ListNode listNode = deleteDuplicates(head1);
        SingleLinkedList obj = new SingleLinkedList();
        obj.display(listNode);

    }

}

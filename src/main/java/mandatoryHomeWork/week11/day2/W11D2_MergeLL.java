package mandatoryHomeWork.week11.day2;

import org.testng.annotations.Test;

public class W11D2_MergeLL {
    public ListNode mergeTwoList(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(0);
        ListNode current = result;

        ListNode currentNode1 = head1;
        ListNode currentNode2 = head2;

        while (currentNode1 != null && currentNode2 != null) {
            if (currentNode1.data <= currentNode2.data) {
                current.next = currentNode1;
                currentNode1 = currentNode1.next;
            } else {
                current.next = currentNode2;
                currentNode2 = currentNode2.next;
            }
            current = current.next;
        }

        if (currentNode1 != null) {
            current.next = currentNode1;
        } else {
            current.next = currentNode2;
        }
        return result.next;
    }

    @Test
    public void test() {
        ListNode head1 = new SingleLinkedList().add(new int[] {1, 2, 4});
        ListNode head2 = new SingleLinkedList().add(new int[] {1, 3, 4});
        ListNode mergeTwoList = mergeTwoList(head1,head2);
        SingleLinkedList obj = new SingleLinkedList();
        obj.display(mergeTwoList);
    }

}

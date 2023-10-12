package mandatoryHomeWork.week11.day2;

import org.testng.annotations.Test;

public class W11D4_LC160_IntersectionLL {


    @Test
    public void testData() {
        ListNode head1 = new SingleLinkedList().add(new int[]{4, 1, 8, 4, 5});
        ListNode head2 = new SingleLinkedList().add(new int[]{5, 6, 1, 8, 4, 5});

        ListNode intersectionNode = getIntersectionNode(head1, head2);
        System.out.println(intersectionNode.data);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int lengthA = sizeDynamic(headA);
        int lengthB = sizeDynamic(headB);
        int startNodeIndex = Math.abs(lengthA - lengthB);

        if (lengthA > lengthB) {
            while (startNodeIndex > 0) {
                headA = headA.next;
                startNodeIndex--;
            }
        } else {
            while (startNodeIndex > 0) {
                headB = headB.next;
                startNodeIndex--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
            if (headA == null || headB == null) return null;
        }
        return headA;
    }

    public int sizeDynamic(ListNode head) {
        ListNode currentNode = head;
        int size = 0;
        while (currentNode != null) {
            size++;
            currentNode = currentNode.next;
        }
        return size;
    }
}

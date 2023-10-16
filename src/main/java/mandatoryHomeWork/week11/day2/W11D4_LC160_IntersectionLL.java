package mandatoryHomeWork.week11.day2;

import org.testng.annotations.Test;

public class W11D4_LC160_IntersectionLL {

    /*
     * 1. Understanding the problem - 10 Mins
     * 		Input  - 2 LinkedList Head
     * 		Output - Head
     * 		constrains
     *
     * 2. Test Data - 3 Mins
     * 3. do you know solution ? Yes
     * 4. Best solution / alternate solution - Yes
     * 5. Pseudo code -15 Mins
     * 6. dry run the pseudo code - 5 Mins
     * 7. write the code on notepad - 5 Mins
     * 8. dry run the code on notepad - 2 Mins
     * 9. Write code on IDE - 5 Mins
     * 10. Test and debug - 1 Mins
     * 11. Code optimization - 1 Mins
     *
     */

    @Test
    public void testData() {
        SingleLinkedList list1 = new SingleLinkedList();
        list1.add(new int[]{4,1,8,4,5});
        ListNode head1 = list1.head;
        SingleLinkedList list2 = new SingleLinkedList();
        list2.add(new int[]{5, 6, 1, 8, 4, 5});
        ListNode head2 = list1.head;
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

package mandatoryHomeWork.week11.day2;

import org.testng.annotations.Test;

public class W11D5_LC61_RotateLL {

    /**
    1. Assign the head to a new current node and create previous node = null.
    2. If current node == null, return null.
    3. If current node.next == null or k == 0, return current node.
    4. Iterate k times.
        a. Iterate until currentNode is not null.
            i.   Create a temporary head node (tempHead) and assign it the value of the current node.
            ii.  If currentNode.next is not null:
                 - Update the previousNode to be the current node.
                 - Update the current node to be the next node.
            iii.
                 - Connect the currentNode's next to the head.
             - update head equal to currentNode
                 - Update the previousNode's next to be null.
    5. Return the current node.
     */

    /**
     * Time complexity - O(K*N)
     * Space Complexity - O(1)
     */
    public ListNode rotateRight(ListNode head, int k) {
        ListNode currentNode = head;
        ListNode previousNode = null;
        if (currentNode == null) return null;
        else if (currentNode.next == null || k == 0) return currentNode;
        for (int i = 0; i < k; i++) {
            while (currentNode.next != null) {
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
            currentNode.next = head;
            head = currentNode;
            previousNode.next = null;
        }
        return currentNode;
    }

    @Test
    public void testData() {
        ListNode head = new SingleLinkedList().add(new int[]{4, 1, 8, 4, 5});
        ListNode listNode = rotateRight(head, 1);
        new SingleLinkedList().display(listNode);
    }

}

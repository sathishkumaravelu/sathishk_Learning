package mandatoryHomeWork.week11.day6;


import org.testng.annotations.Test;

public class rotateLL {

    public ListNode rotateRight(ListNode head, int k) {
        int length = dynamicSize(head);
        int rotate = k%length;
        ListNode currentNode = head;
        ListNode previousNode = null;
        if (currentNode == null) return null;
        else if (currentNode.next == null || k == 0) return currentNode;
        for (int i = 0; i < rotate; i++) {
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

    public int dynamicSize(ListNode head){
        ListNode temp = head;
        int size = 0;
        while (temp != null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    @Test
    public void testData(){
        ListNode head = new SingleLinkedList().add(new int[]{4, 1, 8, 4, 5});
        ListNode listNode = rotateRight(head, 1);
        new SingleLinkedList().display(listNode);
    }

}

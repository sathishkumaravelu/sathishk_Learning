package mandatoryHomeWork.week11.day6;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class cyclicImplementation {
    public ListNode createCyclicLL(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode currentNode = head;
        ListNode previous = null;
        List<ListNode> existingNode = new ArrayList<>();

        int size = 0;
        while (currentNode != null) {
            size++;
            existingNode.add(currentNode);
            previous = currentNode;
            currentNode = currentNode.next;
        }
        Random rnd = new Random();
        int i = rnd.nextInt(size - 2) + 1;
        previous.next = existingNode.get(i);
        return head;
    }

    @Test
    public void testData() {
        SingleLinkedList list1 = new SingleLinkedList();
        list1.add(new int[]{4, 1, 8, 4, 5});
        ListNode head1 = list1.head;
        ListNode cyclicLL = createCyclicLL(head1);
        list1.display(cyclicLL);
    }


}

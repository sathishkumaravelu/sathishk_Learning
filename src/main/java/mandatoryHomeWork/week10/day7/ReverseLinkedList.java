package mandatoryHomeWork.week10.day7;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null) return  null;
        if(head.next == null) return head;

        ListNode currentHead = null;

        while(head != null){
            currentHead = new ListNode(head.val, currentHead);
            head = head.next;
        }

        return currentHead;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null) return  null;
        if(head.next == null) return head;

        ListNode currentHead = null, previousNode = null;

        while(head != null){
            currentHead = new ListNode(head.val);
            currentHead.next = previousNode;
            previousNode= currentHead;
            head = head.next;
        }

        return currentHead;
    }

    @Test
    private void test(){
        ListNode head = reverseList(new SinglyLinkedList().add(new int[]{1,2,3,4}));
        String a = new SinglyLinkedList().print(head);
        System.out.println(a);
        Assert.assertEquals("[4,3,2,1,]", a);
    }
    @Test
    private void test1(){
        ListNode head = reverseList(new SinglyLinkedList().add(new int[]{1}));
        String a = new SinglyLinkedList().print(head);
        System.out.println(a);
        Assert.assertEquals("[1]", a);
    }
}
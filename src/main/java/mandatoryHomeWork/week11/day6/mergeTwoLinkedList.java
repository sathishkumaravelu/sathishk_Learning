package mandatoryHomeWork.week11.day6;

import org.testng.annotations.Test;

public class mergeTwoLinkedList {


    @Test
    public void testData() {

        SingleLinkedList list1 = new SingleLinkedList();
        ListNode node1 = list1.add(new int[]{4, 1});
        SingleLinkedList list2 = new SingleLinkedList();
        ListNode node2 = list2.add(new int[]{5, 6, 1});

        SingleLinkedList temp = new SingleLinkedList();
        ListNode tempNode = temp.add(new int[]{8, 4, 5});

        SingleLinkedList list3 = new SingleLinkedList();
        SingleLinkedList list4 = new SingleLinkedList();

        ListNode head1 = list3.addSecondListToFirstNodeTail(node1, tempNode);
        ListNode head2 = list4.addSecondListToFirstNodeTail(node2, tempNode);

        ListNode listNode = intersectionNode(head1, head2);
        //new SingleLinkedList().display(listNode);
        System.out.println(listNode.data);
    }


    public ListNode intersectionNode(ListNode headA, ListNode headB){

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        int lengthA = dynamicSize(temp1);
        int lengthB = dynamicSize(temp2);
        int startIndex = Math.abs(lengthA-lengthB);
        temp1 = headA;
        temp2 = headB;
        if (lengthA>lengthB){
            while (startIndex>0){
                temp1 = temp1.next;
                startIndex--;
            }
        }else {
            while (startIndex>0){
                temp2 = temp2.next;
                startIndex--;
            }
        }

        while(temp1 != temp2){
            temp1 = temp1.next;
            temp2 = temp2.next;
            if (temp1==null && temp2==null) return null;
        }
        return temp1;

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

}

package mandatoryHomeWork.week11.day6;

public class Intersection_LL {

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


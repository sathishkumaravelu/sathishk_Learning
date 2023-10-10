package mandatoryHomeWork.week10.day7;

public class ListNode {
    ListNode next;
    int val;

    ListNode(int value) {
        this.val = value;
        next = null;
    }

    //14 ,null
    //20, node4
    ListNode(int value, ListNode next) {
        this.val = value;
        this.next = next;
    }
}
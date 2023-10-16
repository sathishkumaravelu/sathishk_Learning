package mandatoryHomeWork.week11.day6;

public class ListNode {
    int data;
    ListNode next;

    public ListNode(int value) {
        this.data = value;
    }
    public ListNode(int value, ListNode listNode) {
        this.data = value;
        this.next = listNode;
    }
}

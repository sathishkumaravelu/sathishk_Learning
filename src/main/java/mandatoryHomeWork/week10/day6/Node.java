package mandatoryHomeWork.week10.day6;

import org.testng.annotations.Test;

public class Node {

    public static void main(String[] args) {
        Node head = addData(11);
        head.next = addData(43);
        head.next.next = addData(23);
        head.next.next.next = addData(90);
        head.next.next.next.next = addData(80);


        Node current = head;
        while (current!= null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    public static Node addData(int data) {
        return new Node(data);
    }
    public void test(){
        System.out.println();
    }

}

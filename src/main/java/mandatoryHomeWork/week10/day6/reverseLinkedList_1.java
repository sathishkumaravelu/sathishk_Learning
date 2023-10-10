package mandatoryHomeWork.week10.day6;

import org.testng.annotations.Test;

public class reverseLinkedList_1 {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;
    private int size = 0;

    public Node addData(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
        return null;
    }

    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else if (size <= index) {
            return;
        } else {
            int currentIndex = 0;
            Node currentNode = head, previousNode = head;
            while (currentNode != null) {
                if (currentIndex++ == index) {
                    previousNode.next = currentNode.next;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        size--;
    }

    public void displayValues(){
        Node current = head;
        while (current != null) {
            size++;
            System.out.println(current.data);
            current = current.next;
        }

    }
    @Test
    public void testData(){
        reverseLinkedList_1 list1 = new reverseLinkedList_1();
        int[] data = {11, 43, 90, 23, 11};
        for (int data1 : data) {
            list1.addData(data1);
        }

        reverseLinkedList_1 reverseLinkedList = reverseList(list1);
        reverseLinkedList.displayValues();
    }

    private reverseLinkedList_1 reverseList(reverseLinkedList_1 list1) {
        reverseLinkedList_1 outList = new reverseLinkedList_1();
        Node currentNode = list1.head, temp  ;
        Node previousNode = null;
        Node nextNode = currentNode.next;
        int size = 0;
        for (int i = 0; i < list1.size; i++) {
        while (currentNode != null) {
            if(currentNode.next==null){
            size++;
            outList.addData(currentNode.data);
            list1.remove(size);
            size=0;
        }
            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        }
        return outList;
    }



    public Node reverseList1(Node head){
        Node currentNode = head;
        Node previousNode = null;
        Node nextNode = currentNode.next;
        while(currentNode!=null){
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return previousNode;
    }

}

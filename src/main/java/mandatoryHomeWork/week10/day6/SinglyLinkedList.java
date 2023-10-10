package mandatoryHomeWork.week10.day6;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class SinglyLinkedList {
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

    public int size() {
        size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
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
    public void removeAll() {
        head = null;
        tail = null;
        size =0;
    }

    public Node insertAtBeginning(int value){
        Node newNode = new Node(value);
        if(head==null){
            head = tail = newNode;
        }else {
            newNode.next = head;
            head = newNode;
        }
        return newNode;
    }

    public void insertAtPosition(int index, int value){
        Node newNode = new Node(value);
        if(index==0){
            insertAtBeginning(value);
            return;
        }
        Node currentNode = head;
        for (int i = 1; i < index; i++) {
            currentNode= currentNode.next;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
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
    public void testData() {
        int[] data = {11, 43, 90, 23, 11};
        for (int data1 : data) {
            addData(data1);
        }
        System.out.println(size);
    /*    for (int i = size; i >=0; i--) {
            remove(i);
            System.out.println("after removing "+i+" index : Size is "+ size);
        }*/

        remove(1);
        removeAll();
        System.out.println("after remove all the values:"+size());
        addData(1);
        System.out.println("after adding one value to empty list:"+size());
        removeAll();
        Node node = insertAtBeginning(100);
        System.out.println(node.data);
        insertAtPosition(0,15);
        displayValues();

    }
}
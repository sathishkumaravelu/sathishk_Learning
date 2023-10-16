package mandatoryHomeWork.week11.day7;

import mandatoryHomeWork.week11.day6.ListNode;

public class DoublyLinkedList {

    public Nodes head;
    public Nodes tail;

    private int size = 0;
    public void add(int value){
        if(head == null){
            head = tail = new Nodes(value);
            head.previous = null;
        }else{
            tail.next = new Nodes(value);
            tail.previous = head;
            tail= tail.next;
        }
        size++;
    }

    public void add(int[] values){
        for (int value:values) add(value);
    }

    public void addLast(int value){
        if(head==null) {
            add(value);
            return;
        }
        Nodes newNode = new Nodes(value, tail, null);
        tail.next = newNode;
        tail = newNode;

        size++;
    }

    public void addBeginning(int value){
        Nodes newListNode = new Nodes(value);
        newListNode.next = head;
        head = newListNode;
        head.previous = null;
        if (tail == null) {
            head = tail = new Nodes(value);
            head.previous = null;
        }
        size++;
    }

    public void removeAll(){
        head.previous = null;
        head = tail = null;
    }

    public void removeFirst(int value){
        Nodes currentNode = head;
        Nodes PreviousNode = null;
        while (currentNode!=null){
            PreviousNode = currentNode;
            if(currentNode.data == value){
                currentNode = currentNode.next.next;
            }
            currentNode = currentNode.next;
        }
    }


    public void display(){
        Nodes currentNode = head;
        System.out.print("null");
        while (currentNode!=null){
            System.out.print("<-->"+currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.print("<-->null");
    }


}

package mandatoryHomeWork.week10.day7;

import org.testng.annotations.Test;

public class SinglyLinkedList {


    ListNode head , tail;
    private int size = 0 ;

    /*

    11,43,28,11,90

    11 -> 43

    step1 : h & t -> 11
    step2:  11.next = 43 = tail
    step3:  43.next = 28 = tail   => head -> 11, tail -> 28



       11,43,28,11,90

       head -> 11
       tail -> 90
       size -> 5


       1. index = 0         => head = head.next  => 43
       2. index > size  (12)=> nothing will happen
       3. index < size  (2) => {
            expected o/p -> 11,43,11,90
            1. temp variable for index (currentIndex)
            2. variable for previous node
            3. loop till index == currentIndex    => previousNode => 43, currentNode => 28
                previousNode .next = currentNode.next; ( 43.next == 28.next)
       }
     */

    public void add(int value){
        if(head == null)  // we are trying to add the first element
            head = tail = new ListNode(value);
        else{
//          tail = tail.next = new Node(value);
            tail.next = new ListNode(value);  // 11 -> 43
            tail = tail.next;
        }
        size++;
    }

    public ListNode add(int[] value){
        for(int each : value) add(each);
        return head;
    }

    public String print(ListNode node){
        StringBuffer buff = new StringBuffer("[");
        while(node != null){
            buff.append(node.val).append(",");
            node = node.next;
        }

        return buff.append(']').toString();
    }


    public int size(){
        return size;
    }

    public void remove(int index){
        if(size <= index) return;
        else if(index ==0) head = head.next;
        else {
            int currentIndex = 0;
            ListNode currentNode = head, previousNode = head;
            while (currentNode != null) {
                if (currentIndex++ == index){
                    previousNode.next = currentNode.next;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        size--;
    }


    /*
    removeAll ->
    addAll
    insert ->
    lastIndexOf ->
    clone
     */
/*
1. A temp node for the traversal, and previousNode as well
2. iterate over the list
    if value matches, previousNode.next will be the currentNode.next
    else previousNode = currentNode & currentNode = currentNode.next
1,3,5,3,1
1,5,1
todo - add the explaination for all the methods implemented
 */
    public void removeAll(int value){
        ListNode currentNode = head, previousNode = null;

        while(currentNode != null){
            if(currentNode.val == value){
                if(previousNode == null) head = head.next;
                else if(currentNode.next == null) {
                    tail = previousNode;
                    previousNode.next = null;
                }
                else previousNode.next = currentNode.next;
                currentNode = currentNode.next;
                size--;
            }else{
                previousNode = currentNode;
                currentNode = currentNode.next;
            }
        }

    }

    @Test
    private void test(){
        SinglyLinkedList list1 = new SinglyLinkedList();
        for(int each : new int[]{11,43,27,11,90})
            list1.add(each);

        System.out.println(list1.print(list1.head)+"\nsize of the list : "+ list1.size());
//
//        list1.remove(2);
//        System.out.println(list1.print(list1.head)+"\nsize of the list : "+ list1.size());
//        Assert.assertEquals("[11,43,11,90,]", list1.print(list1.head));
//        list1.remove(0);
//        System.out.println(list1.print(list1.head)+"\nsize of the list : "+ list1.size());
//        Assert.assertEquals("[43,11,90,]", list1.print(list1.head));
//        list1.remove(10);
//        System.out.println(list1.print(list1.head)+"\nsize of the list : "+ list1.size());
//        Assert.assertEquals("[43,11,90,]", list1.print(list1.head));



//
//        SinglyLinkedList obj2 = new SinglyLinkedList();
//
//        System.out.println(obj2.print(obj2.head));
    }
}
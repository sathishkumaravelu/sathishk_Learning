package mandatoryHomeWork.week11.day7;

import mandatoryHomeWork.week11.day6.ListNode;

import java.util.LinkedList;

public class Nodes {

   int data ;
   Nodes next;
   Nodes previous;

   public Nodes(int data){
       this.data = data;
       previous = null;
       next = null;
   }

    public Nodes(int value, Nodes previous,Nodes next) {
        this.data = value;
        this.previous = previous;
        this.next = next;
    }
}

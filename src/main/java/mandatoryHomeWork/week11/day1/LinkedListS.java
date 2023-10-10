package mandatoryHomeWork.week11.day1;

import mandatoryHomeWork.week10.day6.Node;
import mandatoryHomeWork.week10.day7.ListNode;

public class LinkedListS {
    public static void main(String[] args) {
        int[]  input =new int[] {1,2,3,4,5};
        LL list = new LL();
//        for (int i: input) {
//            list.add(i);
//        }
//        list.middleNode(list);
//        list.display();

        LL.ListNode add1 = list.add(input);
        LL.ListNode slowValue = list.middleNode_1();


    }
}


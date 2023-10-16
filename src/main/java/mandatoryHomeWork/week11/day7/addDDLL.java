package mandatoryHomeWork.week11.day7;

import org.testng.annotations.Test;

public class addDDLL {

    @Test
    public void testData(){
        DoublyLinkedList dd = new DoublyLinkedList();
//        dd.add(5);
//        dd.add(6);
//        dd.add(8);
        dd.add(new int[] {1,2,3,4,5});
        //dd.display();
//        dd.addLast(100);
        //dd.display();
        dd.removeAll();
        dd.display();


    }
}

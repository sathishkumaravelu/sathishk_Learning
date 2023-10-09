package mandatoryHomeWork.week11.day1;

public class LinkedListS {
    public static void main(String[] args) {
        LL list = new LL();
        int[] arr = {1,7,8,9,5,7};
        for (int num:arr) {
            list.insertAtBeginning(num);
        }
        list.removeAllValue(7);
        list.display();
        System.out.println(list.size());
    }
}


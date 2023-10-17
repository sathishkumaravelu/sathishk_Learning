package mandatoryHomeWork.week12.Day2;

import org.testng.annotations.Test;

import java.util.LinkedList;
import java.util.Queue;

public class W12D2_LC2073_Ticket {

    @Test
    public void testData(){
        int seconds = timeRequiredToBuy(new int[]{84,49,5,24,70,77,87,8}, 3);
        System.out.println(seconds);
    }

    //Time complexity - O(N)
    //Space Complexity - O(N)
    public int timeRequiredToBuy(int[] tickets, int k) {
        int seconds=0;
        while (tickets[k]!=0){
            for (int i = 0;i<tickets.length;i++){
                if(tickets[i]!=0&&tickets[k]!=0){
                    tickets[i]--;
                    seconds++;
                }
            }
        }
        return seconds;
    }

    public int timeRequiredToBuyQueue(int[] tickets, int k){
        Queue<Integer> q = new LinkedList<>();
        int i=0;
        for (int ignored :tickets) q.add(i++);
        int seconds=0;
        while(!q.isEmpty()){
            Integer index = q.poll();
            tickets[index]--;
            seconds++;
            if (tickets[index] == 0 && index == k) return seconds;
            if(tickets[index]>0) q.add(index);
        }
        return seconds;
    }

    @Test
    public void test(){
        int second = timeRequiredToBuyQueue(new int[]{5,1,1,1,1}, 0);
        System.out.println(second);
    }

}

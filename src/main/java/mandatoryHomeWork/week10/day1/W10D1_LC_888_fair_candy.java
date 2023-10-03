package mandatoryHomeWork.week10.day1;

import java.util.Arrays;

import org.junit.Test;

public class W10D1_LC_888_fair_candy {

	/*
	   1. Problem understanding - 4 Mins
	   		Input - int[],int[]
	   		Output- int[] 
	   		Constrain 
	   2. Test Data - 4 Mins
	   3. Solution - Yes 
	   4. Best solution / alternate solution - No
	   5. Pesudo Code - Yes - 8 Mins 
	   6. dry run - pseudo code - 3 mins
 	   7. write the code on paper - 6 mins 
 	   8. test code - 5 mins
 	   9. code on IDE - 5 Mins
 	   10. test and debug - 2 mins
 	   11. optimize
	 */
	
	@Test
	public void testData() {
		int[] fairCandy = fairCandy(new int[] { 1, 1 }, new int[] { 2, 2 });
		System.out.println(Arrays.toString(fairCandy));
	}

	@Test
	public void testData1() {
		int[] fairCandy1 = fairCandy(new int[] { 2 }, new int[] { 1, 3 });
		System.out.println(Arrays.toString(fairCandy1));
	}
	
	public int[] fairCandy(int[] alice, int[] bob) {

		int bobSum = 0, aliceSum = 0;
		for (int i : bob) {
			bobSum += i;
		}
		for (int i : alice) {
			aliceSum += i;
		}
		for(int i = 0; i< alice.length; i++){
            for(int j = 0; j< bob.length; j++){
                int aliceExchange = aliceSum - alice[i] + bob[j];
                int bobExchange = bobSum - bob[j] + alice[i];
                if(aliceExchange == bobExchange){
                    return new int[]{alice[i], bob[j]};
                }
            }
        }
        return new int[0];
		
	}
}

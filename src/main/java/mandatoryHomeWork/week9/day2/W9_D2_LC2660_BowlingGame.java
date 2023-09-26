package mandatoryHomeWork.week9.day2;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W9_D2_LC2660_BowlingGame {

	/*
	   https://leetcode.com/problems/determine-the-winner-of-a-bowling-game/description/	    
	 */
	
	/*
	   Problem understanding - Yes
	   Input - int [], int[]
	   Output - int
	   constrain 
    	n == player1.length == player2.length
    	1 <= n <= 1000
    	0 <= player1[i], player2[i] <= 10
	   do you know solution ? Yes - Two Pointer
	   Best solution - Yes 
	   Pseudo code - Yes -- 10 mins 
	   dry run the pseudo code -- 2 Hrs 
	   write the code on notepad - 5 Mins 
	   dry run the code on notepad - 5 Mins 
	   Write code on IDE - 5 Mins 
	   Test and debug - 5 Mins
	   Code optimization - NA
	   
	 */
	
	@Test
	public void validData() {
		int result = isWinner(new int[] {10,2,2,3},new int[] {3,8,4,5});		
		Assert.assertEquals(result, 2);
	}
	
	@Test
	public void invalidData() {
		int result = isWinner(new int[] {3,5,7,6},new int[] {8,10,10,2});	
		Assert.assertEquals(result, 2);
	}
	
	@Test
	public void edgeData() {
		int result = isWinner(new int[] {5,6,1,10},new int[] {5,1,10,5});
		Assert.assertEquals(result, 1);
	}
	
	//Pseudo code
	// 1. assign indicator and right 0
	// 2. iterate thru the length of the array 
	// 		if the element is not zero and previous 2 elements are zero add as it is 
	//		else check if the element contains 10 then move the indicator to the right 
	//		add the value to  the sum value as it is 
	//		iterate  thru the rest of the length and check if the right - indicator lies within the range of last two 10 value 
	//         if the new iterated value contains 10 then move the indicator to the right and sum with multiple of 2's 
	//		   else keep moving the right tilll the next 10 value index
	// 3. finally return the sum to the main function 
	// 4. check the condition between the two points and based on that if the point 1 is greater return 1, else if point 2 is greater return 2 
	//    else return 0
	
	

	//O(N)
	public int isWinner(int[] player1, int[] player2){		
		int bolwerPoint1 = bolwerPoint(player1);
		int bolwerPoint2 = bolwerPoint(player2);
		if(bolwerPoint1>bolwerPoint2) {
			return 1;
		}else if(bolwerPoint1<bolwerPoint2) {
			return 2;
		}else return 0;

	}

	private int bolwerPoint(int[] player) {
		int indicator = 0, right = 0;
		int sum = 0;
		while (right < player.length) {
			if (player[right] != 10) {
				sum += player[right++];
			} else {
				if (player[right] == 10) {
					indicator = right;
					sum += player[right++];
					while (right < player.length && right - indicator < 3) {
						if (player[right] != 10) {
							sum += 2 * player[right++];
						} else {
							indicator = right;
							sum += 2 * player[right++];
						}
					}
				}
			}
		}

		return sum;
	}
}

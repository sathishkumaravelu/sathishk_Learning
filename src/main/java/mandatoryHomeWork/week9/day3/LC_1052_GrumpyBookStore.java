package mandatoryHomeWork.week9.day3;

import org.testng.annotations.Test;

public class LC_1052_GrumpyBookStore {

	@Test
	public void validData() {
		int maxSatisfied = maxSatisfied(new int[] {1,0,1,2,1,1,7,5},new int[] {0,1,0,1,0,1,0,1}, 3); 
		System.out.println(maxSatisfied);
	}

	@Test
	public void validData1() {
		int maxSatisfied = maxSatisfied(new int[] {6,4,8,5,3,2,7,9},new int[] {0,0,0,0,0,0,0,0}, 2); 
		System.out.println(maxSatisfied);
	}

	//Pesudo code:
	/*
	 * 
	 * keep start 0 and minute 
	 * keep variables existingSatisfiedCustomer, nonSatified, tempUnsatisfied 
	 * iterate thru length of the customer if the
	 *      customer is already satisfied add to the existingSatisfied customer
	 * 		else add the unsatified customer and keep it in temp 
	 * check if the max between temp unsatified and unsatfied then store it in non statisfied
	 * finally add the existingSatisifedCustomer and maxConvsatisfied customer
	 * 
	 * 
	 */
	
	//Time : O(N)
	// Space : O(4) -> O(1)
	private int maxSatisfied(int[] customer, int[] grumpy, int min) {
		int pointer = 0, existingSatified = 0, nonSatified = 0,temp = 0;		
		while(pointer<min) {
			if(grumpy[pointer]==0) {
				existingSatified+=customer[pointer++];
			}else{
				temp+=customer[pointer++];
			}
		}
		nonSatified = Math.max(nonSatified, temp);
		while (pointer<customer.length) {
			if(grumpy[pointer-min]!=0) temp-=customer[pointer-min];			
			if(grumpy[pointer]==0)existingSatified+=customer[pointer];
			else temp+=customer[pointer];
			pointer++;
			nonSatified = Math.max(nonSatified, temp);
		}
		return existingSatified+nonSatified;
		}
}

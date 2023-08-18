package mandatoryHomeWork.week3.day5;

import org.junit.Test;

import junit.framework.Assert;

public class W3D1_SpyNo {

	
	/*
	 * Problem Statement : [1 Min]
	 * 	Find  if no is spy number, A number whose sum of the digits of is equal to the product of its digits 		is called syp number 
	 * 
	 * 1. Understanding the problem to detailed level (clarity on input and output, constraints) - Yes 
	 * 		Input - number -----> int
	 * 		Output - word ------> boolean
	 * 2 Test data enumuration 
	 * 
	 * Valid data: [3 Mins]
	 * 
	 * 1.) 321
	 * Product : 3*2*1 : 6
	 * Sum : 3+2+1 : 6
	 * product = sum  : True 
	 * 
	 * 2.) 9 
	 * product : 9
	 * Sum : 9
	 * product = sum : True 
	 * 
	 * Invalid data:
	 * 1.) 11
	 * product : 1*1 - 1
	 * Sum : 1+1 - 2 
	 * product != sum : False
	 * 2. 101
	 * product : 1*0*1 - 0
	 * Sum : 1+1 -2 
	 * 
	 * Product != sum  : False
	 * 
	 * Edge data:
	 * 1.) 0
	 * product : 0
	 * Sum : 0
	 * product = sum :true 
	 * 
	 * 3. Do you know the Solution? Yes 
	 * 4.Do you have any alternate approaches? (Thing of alternate approaches) - As of now no
	 * 5. Derive Pseudo code in paper (for the best chosen approach)  [ 3 Mins ]
	 * 
	 * 		a.) any number below 10, true
	 * 		b.) when number above 10, split the number by digits store it in temp 1 and temp 2
	 * 		c.) keep adding the digits to the temp1 (sum) till number is greater than 10
	 * 		d.) keep multiplying the digits to the temp2 (product) till number is greater than 10
	 * 		e.) finaly check the resultSum and resultProduct if match return true
	 * 
	 * 6. Dry run the pseudo code with all test data from step #2  -- yes
	 * 7. Write the code on notepad [5 Mins ]
	 * 
	 * public boolean vaidatSky(int input){
	 * 
	 * 	if(input<10){
	 * return true;
	 * }
	 * 	while(input>10){
	 * 301
	 * 	temp1= input%10;
	 * 	temp2 = input%10;
	 * 	input = input/10;
	 * 
	 * 	resultSum = resultSum+temp1;
	 * 
	 * 	resultProduct = resultProduct*temp2;
	 * }
	 * 
	 * if(resultSum+input==resultProduct*input){
	 * return true;
	 *}else{
	 * return false;
	 *}
	 *}
	 * 8. Dry run the code with all test data from step #2  [3 Mins]
	 * 9. Write code on IDE (remember to add comments and practice coding standards) [1 min since i copied the dry code as it is . lol !!!)
	 * 10.  Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE [ 2 mins - logical issue by mistake in place of % , / i used so only in ide when data failed i noticed that]
	 * 11. code optimization - 1 min : removed the duplicate code
	 */
	
	@Test
	public void validTestData() {
		Assert.assertEquals(true, vaidatSky(22));
		Assert.assertEquals(true, vaidatSky(321));
		Assert.assertEquals(true, vaidatSky(9));
	}
	@Test
	public void invalidTestData() {
		Assert.assertEquals(false, vaidatSky(11));
		Assert.assertEquals(false, vaidatSky(101));
	}	
	@Test
	public void edgeData() {
		Assert.assertEquals(true, vaidatSky(0));
	}
	

	public boolean vaidatSky(int input) {

		int temp1;
		//int temp2; after code optimization 
		int resultSum = 0;
		int resultProduct=1;
	    if (input < 10) {
	        return true;
	    }
	    while (input > 10) {

	        temp1 = input % 10;
	        //temp2 = input % 10;  after code optimization 
	        input = input / 10;

	        resultSum = resultSum + temp1;

	        resultProduct = resultProduct * temp1;
	    }

	    if (resultSum + input == resultProduct * input) {
	        return true;
	    } else {
	        return false;
	    }
	}
}

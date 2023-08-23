package mandatoryHomeWork.week4.day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class W4D1_LC_605_CanPlaceFlower {

	/*
	 * /**
 * Problem statement:
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.

Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
	
1.Understanding the problem  - Yes [3 Mins]

	> input  - int array
	> output - boolean 
	> constrain - There are no two adjacent flowers in flowerbed.

2.Frame Test data (valid, invalid, complex and edge cases) -3 mins

	- Valid data 
		- [0,0,1,0] - 1 --> true
		- [1,0,0,0] - 1 --> true
		- [1,0,1,0,0] -1 -> true 
		- [0,0,0,0,0] - 3 --> true
	- Invalid data 
		- [0,0,1,0] - 3 --> false
		- [1,0,0,0] - 2 --> false

	- Edge date
		- [0,0,0,0] - 0 --> true
		- [1,0,1,0] - 1 --> false		
		 

3.Do you know the Solution? Yes

4.Do you have any alternate approaches? - No

5. Derive Pseudo code in paper [30 - Mins : logic keep breaking for different data]

6. Dry run the pseudo code with all test data from step #2

7.Write the code on notepad

8. Dry run the code with all test data from step #2

9. Write code on IDE (remember to add comments and practice coding standards)

10. Test the code + Debug the code (if any failures) Debug like a pro using debugging options of IDE

11. Check for any gaps of code optimization (if not optimized already in Step #9)


 */

	//@Test
	public void test() {
		System.out.println(flowerPlot(new int [] {1,0,1,0,1,0}, 0));
	}
	
	
	
	/**
	 * pseudo code : [9 mins ]
	 * 1. if the inputVal is zero, return true 
	 * 2. check if, array length is less than or equal to inputVal / 2 else return false
	 * 3. check the first digit is 0 or 1,
	 * 		-  if its zero, add '1' till the length of inputVal on even digits on same time check if 1 is already present, 
	 * 		move to the next element check the same, replace 1, if not then return false
	 * 		-  if its one, add '1' till the length of inputVal on odd digits on same time check if 1 is already present, 
	 * 		move to the next element check the same, replace 1, if not then return false
	 * 4. return true;
	 */
	@Test
	public void tests() {
		Assert.assertTrue(flowerPlot1(new int[] {1,0,1,0}, 0));
	}
	
	@Test
	public void tests1() {
		Assert.assertTrue(!flowerPlot1(new int[] {1,0,1,0}, 1));
	}
	
	@Test
	public void tests2() {
		Assert.assertTrue(flowerPlot1(new int[] {1,0,0,0}, 1));
	}
	
	@Test
	public void tests3() {
		Assert.assertTrue(flowerPlot1(new int[] {0,0,0,0}, 1));
	}
	@Test
	public void tests4() {
		Assert.assertTrue(flowerPlot1(new int[] {0,1,0,0}, 1));
	}
	
	
	public boolean flowerPlot(int [] plotArr, int intVal) {

		//check if, array length is less than or equal to inputVal / 2 else return false
		if(intVal/2 >= plotArr.length) {
			return false;
		}else if(intVal==0) {
			return true;
		}
		if(plotArr[0]==0) {
			for(int i= 0;i<=plotArr.length;i++) {
				if(i%2==0&&intVal!=0) {
					if(plotArr[i]==0) {
						plotArr[i]=1;
						intVal--;
					}else {
						if(plotArr[i]==1) {
							return false;
						}
					}
				}
				
			}
		}else if(plotArr[0]==1){
			for(int i= 0;i<plotArr.length-1;i++) {
				if(i%2!=0&&intVal!=0) {
					if(plotArr[i]==0) {
						plotArr[i]=1;
						intVal--;
					}else {
						if(plotArr[i]==1) {
							return false;
						}
					}
				}
				
			}
		}
		
		int length = plotArr.length;
		
		return true;
		
	}

	
	public boolean flowerPlot2(int [] plotArr, int intVal) {
		
		if(intVal==0) {
			return true;
		}else if(intVal > plotArr.length) {
			return false;
		}
		
		
		if(plotArr[0]==0) {
			
			for(int i=1;i<=intVal;i++) {
				
				if(i%2==0) {
					if(plotArr[i]==1) {
						return false;
					}
				}else if(plotArr[i]==0) {
					intVal--;
				}
			}
			
		}else if(plotArr[0]==1) {
			
			for(int i=1;i<=intVal;i++) {
				
				if(i%2==0) {
					if(plotArr[i]==0) {
						intVal--;
						
					}
				}else if(plotArr[i]==1) {
					return false;
				}
				
			}
		}

return intVal==0;
		
		
		
	}

	/*
	 * check if input value is zero return zero
	 * if input value greater than array length return false
	 * 
	 * if 1st element is zero and second element is also zero
	 * for all the event digits add '1' and reduce inputvalue by 1, if digist contain '1' already ignore
	 * check if the odd digits contains 1 then return false
	 * 
	 * if 1st element is one and second element is also zero
	 * for all the event digits add '1' and reduce inputvalue by 1, if digist contain '1' already ignore
	 * check if the odd digits contains 1 then return false
	 */
	
	public boolean flowerPlot1(int[] plotArr, int intVal) {
	    if (intVal == 0) {
	        return true;
	    } else if (intVal > plotArr.length) {
	        return false;
	    }

	    if (plotArr[0] == 0) {
	        for (int i = 0; i < plotArr.length && intVal > 0; i++) {
	            if (plotArr[i] == 0) {
	                if ((i == 0 || plotArr[i - 1] == 0) && (i == plotArr.length - 1 || plotArr[i + 1] == 0)) {
	                    plotArr[i] = 1;
	                    intVal--;
	                }
	            }
	        }
	    } else {
	        for (int i = 0; i < plotArr.length && intVal > 0; i++) {
	            if (plotArr[i] == 0) {
	                if (i > 0 && plotArr[i - 1] == 0 && (i == plotArr.length - 1 || plotArr[i + 1] == 0)) {
	                    plotArr[i] = 1;
	                    intVal--;
	                }
	            }
	        }
	    }
	    
	    return intVal == 0;
	}

}

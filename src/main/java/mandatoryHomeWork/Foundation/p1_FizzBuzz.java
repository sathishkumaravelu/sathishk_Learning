package mandatoryHomeWork.Foundation;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class p1_FizzBuzz {

	@Test
	public void test() {
		
		 String[] checkFizzBuzz = checkFizzBuzz(15);
		 System.out.println(Arrays.toString(checkFizzBuzz));
		 Assert.assertArrayEquals(new String[]{"1","2","Fizz", "4", "Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"}
, checkFizzBuzz);
	}
	
	@Test
	public void test1() {
		
		 String[] checkFizzBuzz = checkFizzBuzz(0);
		 System.out.println(Arrays.toString(checkFizzBuzz));
		 Assert.assertArrayEquals(new String[]{"enter the value greater than zero"}, checkFizzBuzz);
	}
	
	
	
	
	public String[] checkFizzBuzz(int n) {
		
		String[] result = new String[n];
		
		if(n>1) {
			
			for (int i = 1; i <= n; i++) {
				
				if(i%3==0 && i%5==0) {
					result[i-1]="FizzBuzz";
				}else if(i%3==0 ) {
					result[i-1]="Fizz";
				}else if(i%5==0 ) {
					result[i-1]="Buzz";
				}else {
					result[i-1]=i+"";
				}
			}
			
		}else {
			
			String[] result1 = new String[1];
			System.out.println("enter the value greater than zero");
			 result1[0]="enter the value greater than zero";
			return result1;
		}
		
		
		
		return result;
	}
	
	
	
}

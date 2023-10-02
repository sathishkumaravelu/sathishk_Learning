package mandatoryHomeWork.Foundation;

import org.junit.Assert;
import org.junit.Test;

public class Day5_PowerOfThree {

	@Test
	public void test1() {
		
		int nums =27;
		boolean checkPower = checkPower(nums);
		System.out.println("Test 1 :"+checkPower);
		Assert.assertEquals(true,checkPower);
	}
	
	@Test
	public void test2() {
		
		int nums =26;
		boolean checkPower = checkPower(nums);
		System.out.println("Test 2 :"+checkPower);
		Assert.assertEquals(false,checkPower);
	}
	
	@Test
	public void test3() {
		
		int nums =0;
		boolean checkPower = checkPower(nums);
		System.out.println("Test 3 :"+checkPower);
		Assert.assertEquals(false,checkPower);
	}
	
	
	public boolean checkPower(int num) {
		//System.out.println(num);
		while(num>=3) {
			if(num%3 != 0) {
				return false;
			}
				num = num/3;	
		}
		
		if(num==1) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
}

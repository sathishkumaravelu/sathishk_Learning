package mandatoryHomeWork.Foundation;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class p01_containsDuplicate {


	@Test
	public void test1() {
		int[] input = {1,2,1,4};
		Boolean checkDuplicate = checkDuplicate(input);
		System.out.println(checkDuplicate);
		Assert.assertEquals((Boolean)true, checkDuplicate);
	}
	
	@Test
	public void test2() {
		int[] input = {1,2,3,4};
		Boolean checkDuplicate = checkDuplicate(input);
		System.out.println(checkDuplicate);
		Assert.assertEquals((Boolean)false, checkDuplicate);
		
	}
	
	@Test
	public void test3() {
		int[] input = {1,1,1,3,3,4,3,2,4,2};
		Boolean checkDuplicate = checkDuplicate(input);
		System.out.println(checkDuplicate);
		Assert.assertEquals((Boolean)true, checkDuplicate);
	}
	
	
	
	public boolean checkDuplicate(int[] input) {
		
		Arrays.sort(input);
		for (int i = 0; i < input.length-1; i++) {
			for (int j = i+1; j < input.length; j++) {
				if(input[i]==input[j]) {
					return true;
				}
			}
		}
		
		return false;
	}
	
}

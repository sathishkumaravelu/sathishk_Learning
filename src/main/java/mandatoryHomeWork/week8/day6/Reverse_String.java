package mandatoryHomeWork.week8.day6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Reverse_String {

	//@Test
	public void validData() {
		System.out.println(isReverseString("malayalam"));
		Assert.assertEquals(isReverseString("malayalam"),true );
	}
	//@Test
	public void invalidData() {
		System.out.println(isReverseString("test"));
		Assert.assertEquals(isReverseString("test"),false );
	}
	//@Test
	public void edgeData() {
		System.out.println(isReverseString(""));
		Assert.assertEquals(isReverseString(""),false );
	}

	
	@Test
	public void validData_1() {
		System.out.println(isPalidoromInt(121));
		Assert.assertEquals(isPalidoromInt(121),true );
	}
	@Test
	public void invalidData_1() {
		System.out.println(isPalidoromInt(1212));
		Assert.assertEquals(isPalidoromInt(1211),false );	}
	@Test
	public void edgeData_1() {
		System.out.println(isPalidoromInt(1));
		Assert.assertEquals(isPalidoromInt(1),true );	}
	
	
	
	
	public boolean isReverseString_1(String s) {
		int start = 0, end = s.length()-1;
		if (s.length()==0) return false;
		while(start<end) {
			if(s.charAt(start)!=s.charAt(end)) {
				return false;
			}else {
				start++;
				end--;
			}
		}
		return true;
	}

	public boolean isReverseString(String s) {
		int left = s.length()/2-1, right;
		if (s.length()==0) return false;
		if(s.length()%2==0) {
			right = s.length()/2;
		}
		else right=s.length()/2+1;
		while(right<s.length()) {
			if(s.charAt(left)!=s.charAt(right)) return false;
			left--;
			right++;
		}
		return true;
	}
	
	
	public boolean isPalidoromInt_tem(int num) {
		String s = ""+num;
		int left = s.length()/2-1, right;
		if (s.length()<=1) return false;
		if(s.length()%2==0) {
			right = s.length()/2;
		}
		else right=s.length()/2+1;
		while(right<s.length()) {
			if(s.charAt(left)!=s.charAt(right)) return false;
			left--;
			right++;
		}
		return true;
	}
	
	
	
	public boolean isPalidoromInt(int num) {
		int org=num;
		int rev = 0;
		while (num != 0) {
			int digit = num % 10; // Get the last digit
			rev = rev * 10 + digit; // Build the reversed number
			num /= 10; // Remove the last digit
		}
		return org == rev;
	}

}

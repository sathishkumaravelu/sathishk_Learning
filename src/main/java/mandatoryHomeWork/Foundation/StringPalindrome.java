package mandatoryHomeWork.Foundation;

import org.junit.Assert;
import org.junit.Test;

public class StringPalindrome {

	/*
	 * input : string output : boolean Constrain : Remove the alpha-numeric
	 * 
	 * pseudo code:
	 * 
	 * remove all alphanumeric from the string using replaceAll
	 * str.replaceAll("^a-zA-Z0-9") convert to lower case have a orginal string =
	 * str create a rev variable from the last value of the string iterate the loop
	 * and store the value in the rev compare rev== original
	 */

	@Test
	public void test() {

		boolean checkPalindrome = checkPalindrome("A man, a plan, a canal: Panama");
		Assert.assertEquals(true, checkPalindrome);
	}

	@Test
	public void test1() {

		boolean checkPalindrome = checkPalindrome("race a car");
		Assert.assertEquals(false, checkPalindrome);
	}
	
	public boolean checkPalindrome(String input) {

		String str = input.toLowerCase().replaceAll("[^a-z0-9]", "");
		String rev = "";
		String orginal = str;
		System.out.println(orginal);

		for (int i = str.length()-1; i >= 0; i--) {
			rev = rev + str.charAt(i);
		}
		System.out.println(rev);
		
		return rev.equals(orginal);
	}

}

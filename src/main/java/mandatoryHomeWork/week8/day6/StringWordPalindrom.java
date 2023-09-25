package mandatoryHomeWork.week8.day6;

import java.util.Arrays;

import org.testng.annotations.Test;

public class StringWordPalindrom {
	
	@Test
	public void testData() {
		System.out.println(Arrays.toString(checkPalindromArray("this is a tst")));
	}
	
	@Test
	public void testData1() {
		System.out.println(Arrays.toString(checkPalindromArray("this is a tsts")));
	}
	
	@Test
	public void testData2() {
		System.out.println(Arrays.toString(checkPalindromArray("thisss is a tst")));
	}

	public boolean[] checkPalindromArray(String input) {
		input.toLowerCase();
		String[] str = input.split(" ");
		boolean[] outputArr = new boolean[str.length];
		
		for(int i=0; i<str.length;i++) {{
			outputArr[i]=isReverseString(str[i]);
		}
			
		}
		return outputArr;
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
}

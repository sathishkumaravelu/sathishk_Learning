package mandatoryHomeWork.week8.day7;

import java.util.Arrays;

import org.testng.annotations.Test;

public class ShortestDistance_Char {

	@Test
	public void testData() {
		int[] shortestToChar = shortestToChar("loveleetcode", 'e');
		System.out.println(Arrays.toString(shortestToChar));
	}

	public int[] shortestToChar(String s, char c) {

		char[] charArray = s.toCharArray();
		int[] intarr = new int[charArray.length];
		int count = 0;
		boolean flag = false;
		int temp=1;
		for (int i = 0; i < s.length() - 1; i++) {
			while(charArray[i]==c) {
				
				if(flag==false) {
					flag=true;
					for(int j=i-1;j>=0;j--) {
						intarr[j]= temp;
						temp++;
					}
					i++;
					temp=1;
				}else {
					for(int j=i+1;charArray[j]==c;j++) {
						intarr[j]= temp;
						temp++;
					}
				}
				
			}
		}

		return intarr;

	}
}

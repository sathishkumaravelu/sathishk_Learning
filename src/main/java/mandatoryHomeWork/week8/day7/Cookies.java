package mandatoryHomeWork.week8.day7;

import java.util.Arrays;

import org.testng.annotations.Test;

public class Cookies {

	@Test
	public void testData() {
		
		int value = findContentChildren(new int[] {10,9,8,7},new int[] {5,6,7,8});
		System.out.println(value);
	}
	
	
	public int findContentChildren(int[] greedChild, int[] cookies) {
		int starChild = 0, startCookies = 0;
		int count = 0;
		Arrays.sort(cookies);
		Arrays.sort(greedChild);
		//System.out.println("cookies size "+cookies.length);
		while(startCookies<cookies.length&&starChild<greedChild.length) {
			if(greedChild[starChild]<=cookies[startCookies]) {
				count++;
				starChild++;
				startCookies++;
			}else {
				startCookies++;
			}
		}
		return count;
		
	}
}

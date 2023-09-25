package mandatoryHomeWork.week8.day7;

import org.testng.annotations.Test;

public class ConsecutiveChar {

	@Test
	public void testData() {
		
		int value = consecutiveChar("leetcode");
		System.out.println(value);
	}
	
	public int consecutiveChar(String str) {
		int left = 0, right = 0, maxCount =  0, count = 0 ;
		System.out.println(str.length()-1);
		if(str.length()==right) return 0;
		while(right<=str.length()-1) {
			if(str.charAt(left)==str.charAt(right)) {
				count++;
				right++;
				if(count>maxCount) {
					maxCount=count;
				}
			}else if(str.charAt(left)!=str.charAt(right)) {
				left = right;
				count=0;
			}
		}
		return maxCount;
	}
}

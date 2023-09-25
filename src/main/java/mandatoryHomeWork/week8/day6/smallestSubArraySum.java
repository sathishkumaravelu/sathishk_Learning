package mandatoryHomeWork.week8.day6;

import org.testng.annotations.Test;

public class smallestSubArraySum {
	@Test
	public void testData() {
		int subString = subString(new int[] {1,2,3,4,5}, 12);
		System.out.println(subString);
	}
	
	public int subString(int[] num, int k) {
		int start = num.length-1, end=start-1;
		int count=0;
		while(end>0) {
			int sum=num[start];
			if(sum<k) {
				sum+=num[end];
				count++;
				end--;
			}else if(sum>k) {
				return count;
			}
		}
		return count;
	}

}

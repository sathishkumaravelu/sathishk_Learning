package mandatoryHomeWork.week9.day7;

import java.util.HashSet;

import org.testng.annotations.Test;

public class SingleNumber {
	
	@Test
	public void testData() {
		int singleNumber = singleNumber(new int[] {1,2,3,3,2});
		System.out.println(singleNumber);
	}
	
	public int singleNumber(int[] num) {
		
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < num.length; i++) {
			
			if(hs.contains(num[i])) {
				hs.remove(num[i]);
			}else {
				hs.add(num[i]);
			}
		}
		return hs.iterator().next();
		
		
	}
}

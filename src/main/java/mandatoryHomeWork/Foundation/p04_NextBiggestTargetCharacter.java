package mandatoryHomeWork.Foundation;

import org.junit.Test;

public class p04_NextBiggestTargetCharacter {

	@Test
	public void test() {
		
		char findTargetNextBigChar = findTargetNextBigChar(new char[] {'a','b','e'}, 'c');
		System.out.println(findTargetNextBigChar);
		
	}
	
	public char findTargetNextBigChar(char[] input, char target) {
		
		int asciiValue=target;
		for (int i = 0; i < input.length; i++) {
			
			if(input[i]>asciiValue) {
				
				return input[i];
			}
		}
		return target;
		
	}
	
	
	
}

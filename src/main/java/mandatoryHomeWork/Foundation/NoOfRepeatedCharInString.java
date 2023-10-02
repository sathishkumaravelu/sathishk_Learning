package mandatoryHomeWork.Foundation;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class NoOfRepeatedCharInString {

	@Test
	public void test1() {
		String text ="Testleaf";
		String lowerCase = text.toLowerCase();
		Map<Character, Integer> findNoOfRepeatedChar = findNoOfRepeatedChar(lowerCase);
		
		System.out.println(findNoOfRepeatedChar);
	}
	
	
	public Map<Character, Integer> findNoOfRepeatedChar(String input){		
		char[] charArray = input.toCharArray();
		Map<Character, Integer> newMap = new HashMap<Character, Integer>();
		
		for(int i=0;i<charArray.length;i++) {
			if(newMap.containsKey(charArray[i])) {
				
				int count = newMap.get(charArray[i]);
				newMap.put(charArray[i], count+1);
			}
			else {
				
				newMap.put(charArray[i], 1);
			}
			
		}
		return newMap;	
	}
}

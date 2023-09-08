package mandatoryHomeWork.week6.day4;

import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

public class W6D4_LC_2325_Decode_Message {

	
	/*
	 Problem Statement : 2325. Decode the Message
	 https://leetcode.com/problems/decode-the-message/
	 
	 1. Understanding the problem: 3 Mins
	 		Input -> String key, String message
	 		Output-> String value
	 2. Test data - 2 Mins
	 3. Do you know the Solution? - Yes
	 4. Do you have any alternate approaches? - No
	 5. Pesudo code - 10 Mins (Hint)
	 6. Dry run the pseudo code - 2 Min
	 7. Write the code on notepad - 6 Mins
	 	
	 	key.replace(" ", "");
	 	Hashmap map = new Hashmap();
	 	char temp='a';
	 	for(int i=0;i<key.length();i++){
	 	 if(!map.contains(key.charAt(i))){
	 	 	map.put(key.charAt(i),a);
	 	 	temp++;
	 	 }
	 	}
	 	String dumy="";
	 	for(int i=0;i<message.length();i++){
	 		if(map.containsKey(message.charAt(i)){
	 			empty+=map.get(message.charAt(i));
	 	}else empty+=message.charAt(i);
	 	retrun empty;
	 	
	 8. Dry run the code with all test data - 2 Mins
	 9. Write code on IDE - 1 Min
	 10. Test the code + Debug the code - 1 Min
	 11. Check for any gaps of code optimization - NA
	 */
	
	
	// 2 Mins
	
	@Test
	public void validData() {
		String value = decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"); 
		Assert.assertEquals(value,"this is a secret");
	}
	
	@Test
	public void validData1() {
		String value = decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"); 
		Assert.assertEquals(value,"the five boxing wizards jump quickly");
	}

	/*
	 Pseudo Code:
	 	1. Remove all the space from the key string
	 	2. create a hashmap for the key as <Key> and 
	 		add 'a' to 'z' to the as value pair <Value> 
	 	3. iterate with the length of key, 
	 	 	 assgin a temp char a
	 	 	 check if the key contains in the created map 
	 	 	 
	 	 	 if not, get the character value of the string add as key and temp as value 
	 	 	 increment the temp
	 	4. create a empty string
	 		create a iterator for the length of message 
	 			- check character of the message available in the map 
	 			- get the value of the char from the map 
	 			- add to the empty string 
	 			
	 			if character not avaiable in the map 
	 	 			- add the char to the empty string 
		5. return it finally 
	 */
	// Time Complexity - O(n)+O(n)+o(n) ----> o(3n) --> dropping the constant : o(n)
	private String decodeMessage(String key, String message) {
		String repaceKey = key.replace(" ", "");//o(n)
		HashMap<Character, Character> subtutionTab = new HashMap<Character, Character>();
		char valueTemp = 'a';
		//o(n)
		for (int i = 0; i < repaceKey.length(); i++) {
			char temp = repaceKey.charAt(i);		
			if(!subtutionTab.containsKey(temp)) {				
				subtutionTab.put(temp, valueTemp);
				valueTemp++;		
			}
		}
		System.out.println("values of map "+ subtutionTab);
		String decrypted = "";
		//o(n)
		for (int i = 0; i < message.length(); i++) {
			char temp = message.charAt(i);
			if (subtutionTab.containsKey(temp)) {
				decrypted+=subtutionTab.get(temp);
			}else {
				decrypted+=+temp;
			}
		}
		return decrypted;
	}
}

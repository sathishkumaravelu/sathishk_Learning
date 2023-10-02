package mandatoryHomeWork.Foundation;

import org.junit.Test;

import junit.framework.Assert;

/*
 * 
        word1 : length 1
        word2 : length 2

        lngth1 == length2
        for(int=0;i<length;i++){

            temp = temp+word1.charAt(i)+word2.charAt(i);
            return temp;
        }

         sathish + sat
            lngth1 > length2
        for(int=0;i<length2;i++){

            temp = temp+word1.charAt(i)+word2.charAt(i);
            return temp;
        }
        temp = temp +word2.substring(length2);

            lngth1 < length2
        for(int=0;i<length1;i++){

            temp = temp+word1.charAt(i)+word2.charAt(i);
            return temp;
        }
        temp = temp +word2.substring(lngth1);

    }
 * 
 * 
 * 
 */


public class Week2Day1_Hw1_MergeStrings {

	@Test
	public void test() {
		String word1 = "abc";
		String word2 = "pqr";
		String mergeString = mergeString(word1, word2);
		System.out.println(mergeString);
		Assert.assertEquals("apbqcr", mergeString);
		
	}
	
	@Test
	public void test1() {
		String word1 = "abcd";
		String word2 = "pq";
		String mergeString = mergeString(word1, word2);
		System.out.println(mergeString);
		Assert.assertEquals("apbqcd", mergeString);
		
	}

	@Test
	public void test2() {
		String word1 = "ab";
		String word2 = "pqrs";
		String mergeString = mergeString(word1, word2);
		System.out.println(mergeString);
		Assert.assertEquals("apbqrs", mergeString);
	}

	

	public String mergeString(String str1, String str2) {

		String mergeString = "";
		if (str1.length() == str2.length()) {

			for (int i = 0; i < str1.length(); i++) {
				mergeString = mergeString + str1.charAt(i) + str2.charAt(i);
				
			}
			return mergeString;
		}else if(str1.length() > str2.length()) {
			
			for (int i = 0; i < str2.length(); i++) {
				mergeString = mergeString + str1.charAt(i) + str2.charAt(i);
				
			}
			mergeString = mergeString+str1.substring(str2.length());
			
			return mergeString;
			
		}else if(str1.length() < str2.length()) {
			
			for (int i = 0; i < str1.length(); i++) {
				mergeString = mergeString + str1.charAt(i) + str2.charAt(i);
				
			}
			mergeString = mergeString+str2.substring(str1.length());		
			return mergeString;
			
		}	
		return mergeString;

	}
}

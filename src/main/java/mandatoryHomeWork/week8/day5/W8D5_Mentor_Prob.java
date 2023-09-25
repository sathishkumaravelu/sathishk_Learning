package mandatoryHomeWork.week8.day5;

import org.testng.annotations.Test;

public class W8D5_Mentor_Prob {
	
	@Test
	public void validData() {
		boolean subsequence = isSubsequence("abc", "ahbgdc");
		System.out.println(subsequence);
	}

	public boolean isSubsequence(String s, String t) {
		int startActual = 0, startExpected = 0;
		String temp = "";
		while (startActual <= t.length() - 1) {
			if (t.charAt(startActual) == s.charAt(startExpected)) {
				temp+=""+t.charAt(startActual);
				startActual++;
				startExpected++;
				
//				temp += String.valueOf(t.charAt(startActual));
			
			} else if (t.charAt(startActual) != s.charAt(startExpected)) {
				startActual++;
			}
		}
		System.out.println(temp);
		return temp.equals(s);

	}
}

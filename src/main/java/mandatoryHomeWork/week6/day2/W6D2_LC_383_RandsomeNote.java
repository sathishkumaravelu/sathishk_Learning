package mandatoryHomeWork.week6.day2;

import java.util.Arrays;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.annotations.Test;

public class W6D2_LC_383_RandsomeNote {

	@Test
	public void validData() {
		boolean isRandsomeNote = randsomeNoteCheck("cab", "bag");
		Assert.assertEquals(isRandsomeNote, false);
	}

	@Test
	public void validData1() {
		boolean isRandsomeNote = randsomeNoteCheck("code", "doec");
		Assert.assertEquals(isRandsomeNote, true);
	}

	@Test
	public void validData2() {
		boolean isRandsomeNote = randsomeNoteCheck("muug", "mug");
		Assert.assertEquals(isRandsomeNote, false);
	}

	@Test
	public void validData3() {
		boolean isRandsomeNote = randsomeNoteCheck("code", "codee");
		Assert.assertEquals(isRandsomeNote, true);
	}
	
	@Test
	public void validData4() {
		boolean isRandsomeNote = randsomeNoteCheck("codeee", "codxee");
		Assert.assertEquals(isRandsomeNote, false);
	}

	//Pseudo code: - 15 mins
//	sort the input  magazine and randosome value
//	if magazine is less than randsomenote length return false
//	check if the length of magazine is higher than randsomenote
//	iterate thru the length of randomeNote
//	keep a variable to check if true 
//	iterate thru the length of magazine 
//	check with the magazin and randomeNote, if matches replace the value to ' ' in array
//	break the loop and check gain if found else return true
//	go on 
//	then finaly return true outside the magazine loop 
//	else overall return false
	

	public boolean randsomeNoteCheck(String ransomenote, String magazine) {

		char[] rArray = ransomenote.toCharArray();
		Arrays.sort(rArray);
		String ransomeNote = new String(rArray);
		System.out.println(ransomeNote);

		char[] mArray = magazine.toCharArray();
		Arrays.sort(mArray);
		String magazineSort = new String(mArray);
		System.out.println(magazineSort);

		if (ransomeNote.length() > magazineSort.length())
			return false;
		if (magazineSort.contains(ransomeNote))
			return true;
		else if (magazineSort.length() > ransomeNote.length()) {
			for (int i = 0; i < rArray.length; i++) {
				boolean found = false; 
				for (int j = 0; j < mArray.length; j++) {
					if (rArray[i] == mArray[j]) { 
						mArray[j] = ' '; 
						found = true; 
						break; 
					}
				}
				if (!found) return false;
			}
			return true;
		}
		return false;
	}
	
}

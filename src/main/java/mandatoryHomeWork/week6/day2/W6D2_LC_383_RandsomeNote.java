package mandatoryHomeWork.week6.day2;

import java.util.Arrays;

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
			int count = 0;
			// cdeo
			// cdeeo
			for (int i = 0; i < magazineSort.length(); i++) {
				if (ransomenote.charAt(i) == magazineSort.charAt(i)) {
					magazineSort.replace(magazineSort.charAt(i), ' ');
					count++;
				} else {
					
				}
			}
			if(count==magazineSort.length())return true;

		} 
		return false;
	}

}

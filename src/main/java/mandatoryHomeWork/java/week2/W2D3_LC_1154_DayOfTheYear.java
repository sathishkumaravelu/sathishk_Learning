package mandatoryHomeWork.java.week2;

import org.junit.Test;

import junit.framework.Assert;


public class W2D3_LC_1154_DayOfTheYear {

	/*
	 * [time taken -> 1 Mins] Given a string date representing a Gregorian calendar
	 * date formatted as YYYY-MM-DD, return the day number of the year.
	 * 
	 * Example: Input: date = "2019-02-10" Output: 41
	 * 
	 * 
	 * 1. Did I understand the problem? Yes What is the input(s)? String What is the
	 * expected output? int Do I have any constraints to solve the problem? O(n) Do
	 * I have all the information to go to the next steps How big is your test data
	 * set will be?
	 * 
	 * Time Taken : 4 Mins 2. Test data set Minimum 3 data set including positive,
	 * negative and edge
	 * 
	 * I) 2023-06-30 - output: 180 // +ve case II) 2023-02-30 - invalid input //edge
	 * case III) 2023-11-35 - invalid input // -ve case
	 * 
	 * 3. Do I know to solve it? No can I break the problem into sub problems? --Yes
	 * 
	 * 4. Ask for hint ( String to Int converstion googled) 5. Do I know alternate
	 * solutions as well Approach 1 : Bruteforce
	 * 
	 * 
	 * Psudeo :
	 * 
	 * 1. using substring split the year month date and convert into int
	 * 2. do the basic validation of year month date from input, return invalid input if incorrect
	 * 3. if month is 01, return actual date as it is
	 * 4. if month is greater than 2, multiple 31 with one month less than the current month store it in temp
	 * 5. divide the month by 2 and get the reminder, then subract the temp with (reminder+2)
	 * 6. finally return temp added with the days.
	 * 
	 */

	@Test
	public void PostiveTestData() {

		String input = "2019-01-01";
		junit.framework.Assert.assertEquals(DaysOfYear(input), 1);
		
		String input1 = "2019-09-15";
		junit.framework.Assert.assertEquals(DaysOfYear(input1), 257);

	}

	@Test
	public void negativeTestData() {
		String input = "2023-11-35";
		String output = "";
		if (DaysOfYear(input) == -1) {
			output = "invalid input";
		}
		Assert.assertEquals("invalid input", output);
	}

	@Test
	public void edgeTestData() {
		String input = "2023-02-30";
		String output = "";
		if (DaysOfYear(input) == -1) {
			output = "invalid input";
		}
		junit.framework.Assert.assertEquals("invalid input", output);
	}

	public int DaysOfYear(String input) {
		int temp = 0;
		String year = input.substring(8, 10);
		int yearInt = Integer.parseInt(year);
		String month = input.substring(5, 7);
		int monthInt = Integer.parseInt(month);
		String date = input.substring(8, 10);
		int dateInt = Integer.parseInt(date);

		if (year.length() > 4 || monthInt > 12 || monthInt < 1 || dateInt < 1 || dateInt > 31) {
			return -1;
		} else if (monthInt == 2 && dateInt > 28) {
			return -1;
		}

		if (monthInt > 1) {
			int rem = monthInt / 2;
			temp = (monthInt - 1) * 31;
			temp = temp - (rem + 2);
			return temp + dateInt;
		}
		return dateInt;

	}

}

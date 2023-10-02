package mandatoryHomeWork.Foundation;

import java.time.*;

import org.junit.Test;

public class DayOfWeek {

	@Test
	public void testData() {
		String day = dayOfTheWeek(31, 8, 2019);
		System.out.println(day);
	}

	public String dayOfTheWeek(int day, int month, int year) {
		String[] weeks = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" };
		int weekOfDay = Year.of(year).atMonth(Month.of(month)).atDay(day).getDayOfWeek().getValue() - 1;
		return weeks[weekOfDay];
	}

}

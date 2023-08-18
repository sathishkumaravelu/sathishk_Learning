package mandatoryHomeWork.week2.day5;

import java.time.LocalDate;

import org.junit.Test;

public class W2D5_LC1185_dayOfYear {

	@Test
	public void validTest() {
		
		String dayOfTheWeek = dayOfTheWeek(17, 7, 1999);
		System.out.println(dayOfTheWeek);
	}
	
	@Test
	public void validTest1() {
		
		String dayOfTheWeek = dayOfTheWeek(15, 8, 1993);
		System.out.println(dayOfTheWeek);
	}
	
    public String dayOfTheWeek(int day, int month, int year) {
        String answer = LocalDate.of(year, month, day).getDayOfWeek().toString();
        return answer.substring(0, 1).toUpperCase() + answer.substring(1).toLowerCase();
    }
	
}

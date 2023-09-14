package mandatoryHomeWork.mentorHomeWork.api.lombok;

import lombok.Data;

@Data
public class createBookingRequest {

	public String firstname;
	public String lastname;
	public String totalprice;
	public String depositpaid;
	private BookingDates bookingdates;
	public String additionalneeds;
	
	@Data
    public static class BookingDates {
        private String checkin;
        private String checkout;
    }
}

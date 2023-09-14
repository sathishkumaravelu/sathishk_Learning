package mandatoryHomeWork.mentorHomeWork.api.lombok;

import lombok.Data;

@Data
public class CreateBookingResponse {
	private String bookingid;
	private createBookingRequest booking;
	private String additionalneeds;
}

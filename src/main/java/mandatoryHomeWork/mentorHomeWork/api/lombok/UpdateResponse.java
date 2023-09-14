package mandatoryHomeWork.mentorHomeWork.api.lombok;

import lombok.Data;

@Data
public class UpdateResponse {
	private int bookingid;
	private createBookingRequest booking;
}

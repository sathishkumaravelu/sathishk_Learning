package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass;

public class CreateBookingRes {

	private int bookingid;
	private CreateBookingReq booking;
	
	public CreateBookingRes() {
     
    }
	
	public int getBookingid() {
		return bookingid;
	}
	public CreateBookingReq getBooking() {
		return booking;
	}
	public void setBookingid(int bookingid) {
		this.bookingid = bookingid;
	}
	public void setBooking(CreateBookingReq booking) {
		this.booking = booking;
	}
}

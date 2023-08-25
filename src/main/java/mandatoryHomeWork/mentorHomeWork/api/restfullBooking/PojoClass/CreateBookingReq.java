package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass;

public class CreateBookingReq {

	//sample request response:
		
	/*
	 * 
	 {
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
	 *  
	 * 	
	 */
	
	private String firstname;
	private String lastname;
	private String totalprice;
	private boolean depositpaid;
	private bookingdates bookingdates;
	private String additionalneeds;
	
	public CreateBookingReq() {
		
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getTotalprice() {
		return totalprice;
	}

	public boolean getDepositpaid() {
		return depositpaid;
	}

	public bookingdates getBookingdates() {
		return bookingdates;
	}

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}

	public void setBookingdates(bookingdates bookingdates) {
		this.bookingdates = bookingdates;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
	
}

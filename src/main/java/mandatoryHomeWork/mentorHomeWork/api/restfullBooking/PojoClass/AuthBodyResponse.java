package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass;

public class AuthBodyResponse {
//Sample response

	/*
	 * { 
	 * "token": "abc123"
	 * }
	 * 
	 */
	
	private String token;
	
	public AuthBodyResponse() {
		
	}
	
	public String gettoken()
	{
		return token;
	}
	

	public void settoken(String token) {
		 this.token = token;
	}  
	
}

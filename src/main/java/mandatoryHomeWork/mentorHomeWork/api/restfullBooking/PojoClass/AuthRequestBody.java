package mandatoryHomeWork.mentorHomeWork.api.restfullBooking.PojoClass;

public class AuthRequestBody {

	// Sample Request response
	/*
	 * { 
	 * "username" : "admin", 
	 * "password" : "password123" 
	 * }
	 * 
	 * 
	 * 
	 */
	
	private String username;
	private String password;

	public AuthRequestBody() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}

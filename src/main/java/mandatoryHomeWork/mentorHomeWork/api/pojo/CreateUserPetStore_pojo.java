package mandatoryHomeWork.mentorHomeWork.api.pojo;


/**
 * This is a CreateUser pojo Class for the request body json
 * @author sathish
 * 
 */
public class CreateUserPetStore_pojo {

	/*
	 * Sample Response : 
	 * 
[
  {
    "id": 0,
    "username": "string",
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "password": "string",
    "phone": "string",
    "userStatus": 0
  }
]
	 * 
	 * 
	 */
	
	
	private int id;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String phone;
	private int userstatus;
	
	
	/**
	 * This is a CreateUser pojo method for the request body json
	 * @author sathish
	 * 
	 */
	public CreateUserPetStore_pojo(int idValue,String usernameValue,String firstnameValue, String lastnameValue,String 				
			emailValue,String passwordValue,String phoneValue, int userstatusValue) {
	
		this.id = idValue;
		this.username=usernameValue;
		this.firstname=firstnameValue;
		this.lastname=lastnameValue;
		this.email=emailValue;
		this.password=passwordValue;
		this.phone = phoneValue;
		this.userstatus=userstatusValue;
	}
	
	public int getId() {
		return id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getPhone() {
		return phone;
	}
	public int getUserstatus() {
		return userstatus;
	}

}

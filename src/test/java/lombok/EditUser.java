package lombok;

@Data
@Builder
public class EditUser {
	
	String nickname;
	String fullname;
	String dob;
	String gender;
	String phone_code;
	String country_code;
	String phone_number;
	String email;
	int otp;
}

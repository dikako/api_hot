package lombok;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Login {
	
	String username;
	String password;
	String device_id;
	String platform;

}

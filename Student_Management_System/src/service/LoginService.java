package service;

public class LoginService {
	private final String USERNAME = "Admin";
	private final String PASSWORD = "redhat@123";
	
	public boolean login(String user, String pass) {
		return user.equals(USERNAME) && pass.equals(PASSWORD);
	}
}


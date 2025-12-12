package service;


//This class handles user authentication logic for the application
public class LoginService {
	
	// Hard coded user name and password for login
    // 'final' ensures these values cannot be changed
	private final String USERNAME = "Admin";
	private final String PASSWORD = "redhat@123";
	
	/**
     * This method validates the login credentials.
     *
     * @param user - the user name entered by the user
     * @param pass - the password entered by the user
     * @return true if both user name and password match the stored values
     *         false otherwise
     */
	
	public boolean login(String user, String pass) {
		// Checks whether both user and pass match the stored credentials
		return user.equals(USERNAME) && pass.equals(PASSWORD);
	}
}


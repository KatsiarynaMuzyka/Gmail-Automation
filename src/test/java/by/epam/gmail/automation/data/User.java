package by.epam.gmail.automation.data;

public class User {
	private static String message = "hellodjkfhjkfh";
	private static String nameForCheck = "Anatoly Anatolyev";
	
	private String login;
	private String password;
	
	
	public static String getMessage() {
		return message;
	}

	public static void setMessage(String message) {
		User.message = message;
	}

	public static String getNameForCheck() {
		return nameForCheck;
	}

	public static void setNameForCheck(String nameForCheck) {
		User.nameForCheck = nameForCheck;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	
}

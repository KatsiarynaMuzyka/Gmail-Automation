package by.epam.gmail.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.epam.gmail.automation.data.User;
import by.epam.gmail.automation.property.PropertyProvider;

public class ShouldCheckMessageInSpamFolder extends BaseTest {
	
	@BeforeTest
	private void setUp() {
		user1 = new User();
		user1.setLogin(PropertyProvider.getProperty("user1"));
		user1.setPassword(PropertyProvider.getProperty("password1"));
		
		user2 = new User();
		user2.setLogin(PropertyProvider.getProperty("user2"));
		user2.setPassword(PropertyProvider.getProperty("password2"));
	}

	@Test
	public void checkMessageFromUser1InSpamFolder() {
		
		Assert.assertTrue(loginPage
				.goToLoginPage()
				.authorization(user1.getLogin(), user1.getPassword())
				.sendMessage(user2.getLogin(), User.getMessage())
				.switchToDefaultWindow()
				.logOut()
				.addAndSwitchUser()
				.authorization(user2.getLogin(), user2.getPassword())
				.markMessageAsSpam()
				.logOut()
				.switchUser()
				.authorization(user1.getLogin(), user1.getPassword())
				.sendMessage(user2.getLogin(), "second msg")
				.switchToDefaultWindow()
				.logOut()
				.switchUser()
				.authorization(user2.getLogin(), user2.getPassword())
				.goToSpamPage()
				.checkSenderName(User.getNameForCheck()));
	}

}

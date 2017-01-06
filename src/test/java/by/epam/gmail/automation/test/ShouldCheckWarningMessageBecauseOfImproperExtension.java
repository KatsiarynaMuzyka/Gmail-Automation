package by.epam.gmail.automation.test;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.epam.gmail.automation.data.User;
import by.epam.gmail.automation.property.PropertyProvider;

public class ShouldCheckWarningMessageBecauseOfImproperExtension extends BaseTest {
	
	@BeforeTest
	private void setUp() {
		user2 = new User();
		user2.setLogin(PropertyProvider.getProperty("user2"));
		user2.setPassword(PropertyProvider.getProperty("password2"));
	}
	
	@Test
	public void checkWarningMessageBecauseOfImproperExtensionWhileChangingBackgroundImageInCustomThemesSettings() {
		Assert.assertTrue(loginPage
				.goToLoginPage()
				.authorization(user2.getLogin(), user2.getPassword())
				.goToSettingsPage()
				.goToThemesPage()
				.selectPhotosFromComputer("EPAM Toolkit")
				.checkWarningMessage());

	}
}

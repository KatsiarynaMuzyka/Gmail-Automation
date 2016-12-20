package by.epam.gmail.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ShouldCheckWarningMessageBecauseOfImproperExtension extends BaseTest {

	@Test
	public void checkWarningMessageBecauseOfImproperExtensionWhileChangingBackgroundImageInCustomThemesSettings() {
		Assert.assertTrue(loginPage.goToLoginPage().authorization("automationEpamUser2@gmail.com", "user212345678").goToSettingsPage()
				.goToThemesPage().selectPhotosFromComputer("EPAM Toolkit").checkWarningMessage());

	}
	
	@AfterClass
	public void afterClass() {
		driver.close();
	}
}

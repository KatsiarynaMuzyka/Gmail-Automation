package by.epam.gmail.automation.test;

import org.testng.annotations.Test;

import by.epam.gmail.automation.data.UserData;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ShouldCheckMessageInSpamFolder extends BaseTest {

	@Test
	public void checkMessageFromUser1InSpamFolder() {
		Assert.assertTrue(loginPage.goToLoginPage().authorization("automationEpamUser1@gmail.com", "user112345678")
				.sendMessage("automationEpamUser2@gmail.com", UserData.getMessage()).switchToDefaultWindow().logOut()
				.addAndSwitchUser().authorization("automationEpamUser2@gmail.com", "user212345678").markMessageAsSpam()
				.logOut().switchUser().authorization("automationEpamUser1@gmail.com", "user112345678")
				.sendMessage("automationEpamUser2@gmail.com", "second msg").switchToDefaultWindow().logOut()
				.switchUser().authorization("automationEpamUser2@gmail.com", "user212345678").goToSpamPage()
				.checkSenderName("Anatoly Anatolyev"));
	}

	@AfterClass
	public void afterClass() {
		//driver.close();
	}

}

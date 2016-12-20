package by.epam.gmail.automation.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class ShouldCheckPossibilityOfAttachingBigFileToMessage extends BaseTest {

	@Test
	public void checkPossibilityOfAttachingFileOver25MBToMessage() {
		Assert.assertTrue(loginPage.goToLoginPage().authorization("automationEpamUser2@gmail.com", "user212345678")
				.sendMessageWithAttach("automationEpamUser1@gmail.com", "For3Test.MOV")
				.checkWarningMessageThatSizeOfFileIsOver25MB());
	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}
}

package by.epam.gmail.automation.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;

import by.epam.gmail.automation.pages.MessagePage;

public class ShouldCheckLetterFromUser1 extends BaseTest{
	MessagePage messagePage;

	@Test
	public void checkForwardedLetterFromUser1() {
		
	messagePage = loginPage.goToLoginPage().authorization("automationEpamUser2@gmail.com", "user212345678").goToSettingsPage()
				.goToPopImapSettingsPage().addAddressForForwarding("automationEpamUser3@gmail.com").goToHomePage()
				.logOut().addAndSwitchUser().authorization("automationEpamUser3@gmail.com", "user312345678")
				.goToMessagePage().goToConfirmation().confirmation().goToHomePage().logOut().switchUser()
				.authorization("automationEpamUser2@gmail.com", "user212345678").goToSettingsPage()
				.goToPopImapSettingsPage().filterSettings("automationEpamUser1@gmail.com").logOut()
				.switchUser().authorization("automationEpamUser1@gmail.com", "user112345678")
				.sendMessageWithAttach("automationEpamUser2@gmail.com", "ForAttach.txt")
				.sendMessage("automationEpamUser2@gmail.com", "message without attach").logOut().switchUser()
				.authorization("automationEpamUser2@gmail.com", "user212345678").goToTrashPage().goToMessagePage();

		Assert.assertTrue(
				messagePage.checkTheLetterWithAttachIsInTrashAndMarkAsImportant("Anatoly Anatolyev", "ForAttach.txt"));
		Assert.assertTrue(messagePage.goToHomePage().goToMessagePage()
				.checkTheLetterWithoutAttachIsInInboxAndNotMarkAsImportant("Anatoly Anatolyev"));
		Assert.assertTrue(messagePage.goToHomePage().logOut().switchUser()
				.authorization("automationEpamUser3@gmail.com", "user312345678").goToMessagePage()
				.checkTheLetterWithoutAttachIsInInbox("Anatoly Anatolyev"));
		
	}

	@AfterClass
	public void afterClass() {
		//driver.close();
	}
}

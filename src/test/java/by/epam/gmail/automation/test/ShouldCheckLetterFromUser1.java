package by.epam.gmail.automation.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import by.epam.gmail.automation.data.User;
import by.epam.gmail.automation.pages.MessagePage;
import by.epam.gmail.automation.property.PropertyProvider;

public class ShouldCheckLetterFromUser1 extends BaseTest{
	MessagePage messagePage;
	SoftAssert softAssert = new SoftAssert();
	
	@BeforeTest
	private void setUp() {
		user1 = new User();
		user1.setLogin(PropertyProvider.getProperty("user1"));
		user1.setPassword(PropertyProvider.getProperty("password1"));
		
		user2 = new User();
		user2.setLogin(PropertyProvider.getProperty("user2"));
		user2.setPassword(PropertyProvider.getProperty("password2"));
		
		user3 = new User();
		user3.setLogin(PropertyProvider.getProperty("user3"));
		user3.setPassword(PropertyProvider.getProperty("password3"));
	}
	
	@Test
	public void checkForwardedLetterFromUser1() {
		
	messagePage = loginPage
			.goToLoginPage()
			.authorization(user2.getLogin(), user2.getPassword())
			.goToSettingsPage()
			.goToPopImapSettingsPage()
			.addAddressForForwarding(user3.getLogin())
			.goToHomePage()
			.logOut()
			.addAndSwitchUser()
			.authorization(user3.getLogin(), user3.getPassword())
			.goToMessagePage()
			.goToConfirmation()
			.confirmation()
			.goToHomePage()
			.logOut()
			.switchUser()
			.authorization(user2.getLogin(), user2.getPassword())
			.goToSettingsPage()
			.goToPopImapSettingsPage()
			.filterSettings(user1.getLogin())
			.logOut()
			.switchUser()
			.authorization(user1.getLogin(), user1.getPassword())
			.sendMessageWithAttach(user2.getLogin(), "ForAttach.txt")
			.sendMessage(user2.getLogin(), "message without attach")
			.logOut()
			.switchUser()
			.authorization(user2.getLogin(), user2.getPassword())
			.goToTrashPage()
			.goToMessagePage();
	
	softAssert.assertTrue(messagePage
			.checkTheLetterWithAttachIsInTrashAndMarkAsImportant("Anatoly Anatolyev", "ForAttach.txt"), "Waiting for important message with attach");
	
	softAssert.assertTrue(messagePage
			.goToHomePage()
			.goToMessagePage()
			.checkTheLetterWithoutAttachIsInInboxAndNotMarkAsImportant("Anatoly Anatolyev"), "Waiting for not important message without attach");
	
	softAssert.assertTrue(messagePage
			.goToHomePage()
			.logOut().switchUser()
			.authorization(user3.getLogin(), user3.getPassword())
			.goToMessagePage()
			.checkTheLetterWithoutAttachIsInInbox("Anatoly Anatolyev"), "Waiting for message without attach");

	softAssert.assertAll();
	
	}

}

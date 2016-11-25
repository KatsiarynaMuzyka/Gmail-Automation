package by.epam.gmailAutomation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import by.epam.gmailAutomation.data.UserData;
import by.epam.gmailAutomation.pages.LoginPage;
import by.epam.gmailAutomation.utils.ThreadSleep;

public class ShouldCheckLetterFromUser1 {
	private WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "../GmailAutomation/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
	}

	@Test
	public void popImapSettings() {
		loginPage.goToLoginPage().fillEmailForm(UserData.getUser2Name()).fillPasswdForm(UserData.getUser2Password())
				.goToSettingsPage().goToPopImapSettingsPage().addAddressForForwarding(UserData.getUser3Name())
				.goToHomePage().logOut().addAndSwitchUser().fillEmailForm(UserData.getUser3Name())
				.fillPasswdForm(UserData.getUser3Password()).goToConfirmMsg().goToConfirmation().confirmation()
				.goToHomePage().logOut().switchUser().fillEmailForm(UserData.getUser2Name())
				.fillPasswdForm(UserData.getUser2Password()).goToSettingsPage().goToPopImapSettingsPage()
				.filterSettings(UserData.getUser1Name()).goToHomePage().logOut().switchUser()
				.fillEmailForm(UserData.getUser1Name()).fillPasswdForm(UserData.getUser1Password());
	}

	@AfterClass
	public void afterClass() {
		ThreadSleep.waitElement(2000);
		// driver.close();
	}
}

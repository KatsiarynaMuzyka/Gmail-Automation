package by.epam.gmailAutomation.test;

import org.testng.annotations.Test;

import by.epam.gmailAutomation.data.UserData;
import by.epam.gmailAutomation.pages.LoginPage;
import by.epam.gmailAutomation.utils.ThreadSleep;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class ShouldCheckMessageInSpamFolder extends Assert {

	private WebDriver driver;
	LoginPage loginPage;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "../GmailAutomation/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
	}

	@Test
	public void signIn() {
		assertTrue(loginPage.goToLoginPage().fillEmailForm(UserData.getUser1Name())
				.fillPasswdForm(UserData.getUser1Password())
				.sendMsg(UserData.getUser2Name(), UserData.getSubject(), UserData.getMessage()).switchToDefaultWindow()
				.logOut().addAndSwitchUser().fillEmailForm(UserData.getUser2Name())
				.fillPasswdForm(UserData.getUser2Password()).markMsgAsSpam().logOut().switchUser()
				.fillEmailForm(UserData.getUser1Name()).fillPasswdForm(UserData.getUser1Password())
				.sendMsg(UserData.getUser2Name(), UserData.getSubject(), UserData.getMessage()).switchToDefaultWindow()
				.logOut().switchUser().fillEmailForm(UserData.getUser2Name())
				.fillPasswdForm(UserData.getUser2Password()).goToSpamPage()
				.checkSenderName(UserData.getNameForCheck()));
	}

	@AfterClass
	public void afterClass() {
		ThreadSleep.waitElement(2000);
		// driver.close();
	}

}

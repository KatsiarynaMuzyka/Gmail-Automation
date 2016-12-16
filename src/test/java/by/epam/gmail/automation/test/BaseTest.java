package by.epam.gmail.automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import by.epam.gmail.automation.pages.LoginPage;

public class BaseTest {

	protected WebDriver driver;
	protected LoginPage loginPage;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "../GmailAutomation/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
	}

	
}

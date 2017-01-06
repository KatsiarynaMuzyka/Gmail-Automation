package by.epam.gmail.automation.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import by.epam.gmail.automation.data.User;
import by.epam.gmail.automation.pages.LoginPage;
import by.epam.gmail.automation.property.PropertyProvider;

public class BaseTest {

	protected WebDriver driver;
	protected LoginPage loginPage;
	protected User user1;
	protected User user2;
	protected User user3;
	
	@BeforeClass
	public void beforeClass() {
		System.setProperty(PropertyProvider.getProperty("chrome_driver"), PropertyProvider.getProperty("chrome_driver_exe"));
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		
	}

	@AfterClass
	public void afterClass() {
		// driver.close();
	}

}

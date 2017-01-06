package by.epam.gmail.automation.test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import by.epam.gmail.automation.data.User;
import by.epam.gmail.automation.property.PropertyProvider;
import by.epam.gmail.automation.utils.JavaRobot;

public class ShouldCheckPossibilityOfAttachingBigFileToMessage extends BaseTest {
	private static final String filepath = PropertyProvider.getProperty("filepath");
	private static final String filename = PropertyProvider.getProperty("filename");

	@BeforeTest
	private void setUp() {
		user1 = new User();
		user1.setLogin(PropertyProvider.getProperty("user1"));
		
		user2 = new User();
		user2.setLogin(PropertyProvider.getProperty("user2"));
		user2.setPassword(PropertyProvider.getProperty("password2"));
		
		JavaRobot.createFileOver25MB(filepath, filename);
	}
	
	@Test
	public void checkPossibilityOfAttachingFileOver25MBToMessage() {
		Assert.assertTrue(loginPage
				.goToLoginPage()
				.authorization(user2.getLogin(), user2.getPassword())
				.sendMessageWithAttach(user1.getLogin(), filepath + "\\" + filename)
				.checkWarningMessageThatSizeOfFileIsOver25MB());
	}
	
	@AfterMethod(alwaysRun = true)
	private void tearDown() {
		JavaRobot.deleteFile(filepath, filename);
	}
}

package by.epam.gmailAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends AbstractPage {

	public PasswordPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Passwd")
	private WebElement passwordField;
	
	@FindBy(id = "signIn")
	private WebElement signInButton;
	
	public void fillPasswdField(String passwd) {
		wait.waitForElementIsClickable(passwordField);
		passwordField.click();
		passwordField.sendKeys(passwd);
	}
	
	public HomePage clickSignIn(){
		signInButton.click();
		return new HomePage(driver);
	}
	
	public HomePage fillPasswdForm(String passwd) {
		fillPasswdField(passwd);
		clickSignIn();
		return new HomePage(driver);	
	}
	
}

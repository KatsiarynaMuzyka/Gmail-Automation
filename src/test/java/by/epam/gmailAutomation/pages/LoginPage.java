package by.epam.gmailAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.javascript.host.Window;
public class LoginPage extends AbstractPage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Email")
	private WebElement loginField;
	
	@FindBy(id = "next")
	private WebElement nextButton;
	
	public void fillEmailField(String email) {
		loginField.click();
		loginField.clear();
		loginField.sendKeys(email);
		}
	
	public PasswordPage clickSubmitButton(){
		nextButton.click();
		return new PasswordPage(driver);
	}
	
	public PasswordPage fillEmailForm(String email) {
		fillEmailField(email);
		clickSubmitButton();
		return new PasswordPage(driver);
	}
	
	public LoginPage goToLoginPage(){
		//driver.manage().window().maximize();
		driver.get("https://gmail.com");
		return this;
	}
}

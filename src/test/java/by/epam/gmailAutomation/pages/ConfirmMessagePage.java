package by.epam.gmailAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmMessagePage extends AbstractPage {

	public ConfirmMessagePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class='gs']/div/div/a[4]")
	private WebElement confirmLink;
	
	@FindBy(xpath = "//div[@class = 'aim ain']/div/div")
	private WebElement inboxMsgButton;
	
	public ConfirmationPage goToConfirmation() {
		wait.waitForElementIsClickable(confirmLink);
		confirmLink.click();
		return new ConfirmationPage(driver);
	}
	
	public HomePage goToHomePage() {
		wait.waitForElementIsClickable(inboxMsgButton);
		inboxMsgButton.click();
		return new HomePage(driver);
	}
}

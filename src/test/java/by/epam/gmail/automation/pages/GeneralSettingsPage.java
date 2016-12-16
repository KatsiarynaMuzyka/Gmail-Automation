package by.epam.gmail.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralSettingsPage extends AbstractPage {

	@FindBy(xpath = "//a[text() = 'Forwarding and POP/IMAP']")
	private WebElement popImapSettingsButton;
	
	public GeneralSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	public ForwardPopImapSettingsPage goToPopImapSettingsPage() {
		wait.waitForElementIsClickable(popImapSettingsButton);
		popImapSettingsButton.click();
		return new ForwardPopImapSettingsPage(driver);
	}
}

package by.epam.gmailAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GeneralSettingsPage extends AbstractPage {

	public GeneralSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//a[text() = 'Пересылка и POP/IMAP']")
	private WebElement popImapSettingsButton;
	
	public ForwardPopImapSettingsPage goToPopImapSettingsPage() {
		wait.waitForElementIsClickable(popImapSettingsButton);
		popImapSettingsButton.click();
		return new ForwardPopImapSettingsPage(driver);
	}
}

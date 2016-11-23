package by.epam.gmailAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SwitchUserPage extends AbstractPage {

	public SwitchUserPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "account-chooser-link")
	private WebElement swichUserButton;

	@FindBy(id = "account-chooser-add-account")
	private WebElement addUserButton;

	public LoginPage switchUser() {
		wait.waitForElementIsClickable(addUserButton);
		addUserButton.click();

		return new LoginPage(driver);
	}

	public LoginPage addAndSwitchUser() {

		wait.waitForElementIsClickable(swichUserButton);
		swichUserButton.click();
		wait.waitForElementIsClickable(addUserButton);
		addUserButton.click();

		return new LoginPage(driver);
	}

}

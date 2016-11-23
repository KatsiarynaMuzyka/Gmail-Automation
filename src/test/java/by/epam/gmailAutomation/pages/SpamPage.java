package by.epam.gmailAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpamPage extends AbstractPage {
	
	public SpamPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//div[@class='yW']/span")
	private WebElement senderName;

	public boolean checkSenderName(String name) {
		wait.waitForElementIsClickable(senderName);
		return name.equals(senderName.getText());
	}
}

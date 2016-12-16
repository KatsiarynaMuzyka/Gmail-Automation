package by.epam.gmail.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpamPage extends AbstractPage {
	
	@FindBy(xpath = "//div[@class='yW']/span")
	private WebElement senderName;
	
	public SpamPage(WebDriver driver) {
		super(driver);
	}

	public boolean checkSenderName(String name) {
		wait.waitForElementIsClickable(senderName);
		return name.equals(senderName.getText());
	}
}

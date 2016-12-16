package by.epam.gmail.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrashPage extends AbstractPage {
	
	@FindBy(xpath = "//img[@class = 'yE']")
	private WebElement attachIcon;
	
	public TrashPage(WebDriver driver) {
		super(driver);
	}

	public MessagePage goToMessagePage() {
		wait.waitForElementIsClickable(attachIcon);
		attachIcon.click();
		return new MessagePage(driver);
	}
}

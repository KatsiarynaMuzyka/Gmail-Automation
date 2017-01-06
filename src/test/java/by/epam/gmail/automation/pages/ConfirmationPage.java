package by.epam.gmail.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractPage {
	
	@FindBy(xpath = "//input[@type = 'submit']")
	private WebElement submitButton;
	
	@FindBy(xpath = "//td[@class = 'bubble']")
	private WebElement checkText;

	private String thisWindow;
	
	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}
		
	public MessagePage confirmation() {
		log.info("Forwarding confirmation");
		thisWindow = driver.getWindowHandle();
		switcher.winSwitcher();
		wait.waitForElementIsClickable(submitButton);
		submitButton.click();
		wait.waitForElementIsVisible(checkText);
		driver.close();
		driver.switchTo().window(thisWindow);
		return new MessagePage(driver);
	}
}

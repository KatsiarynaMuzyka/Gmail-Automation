package by.epam.gmail.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
		thisWindow = driver.getWindowHandle();
		switcher.winSwitcher();
		wait.waitForElementIsClickable(submitButton);
		submitButton.click();
		checkText = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(checkText));
		driver.close();
		driver.switchTo().window(thisWindow);
		return new MessagePage(driver);
	}
}

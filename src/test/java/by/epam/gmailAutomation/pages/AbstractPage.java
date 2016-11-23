package by.epam.gmailAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import by.epam.gmailAutomation.utils.ExplicitWait;

public abstract class AbstractPage {
	protected WebDriver driver;
	protected ExplicitWait wait;

	public AbstractPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new ExplicitWait(driver, 15);
	}
}

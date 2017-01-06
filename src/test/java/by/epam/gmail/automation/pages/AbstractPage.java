package by.epam.gmail.automation.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import by.epam.gmail.automation.utils.ExplicitWait;
import by.epam.gmail.automation.utils.WindowSwitcher;

public abstract class AbstractPage {
	
	protected WebDriver driver;
	protected ExplicitWait wait;
	protected WindowSwitcher switcher;
	protected final Logger log;
	
	public AbstractPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new ExplicitWait(driver);
		switcher = new WindowSwitcher(driver);
		log = LogManager.getRootLogger();
	}
	
	
	
}

package by.epam.gmail.automation.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	private WebDriver driverWait;
	private Wait<WebDriver> wait;

	public ExplicitWait(WebDriver driver) {
		this.driverWait = driver;
		wait = new WebDriverWait(this.driverWait, 15)
				.ignoring(StaleElementReferenceException.class, WebDriverException.class)
				.withMessage("Element was not found by locator ");
	}

	public ExplicitWait(WebDriver driver, int time) {
		this.driverWait = driver;
		wait = new WebDriverWait(driver, time).ignoring(StaleElementReferenceException.class, WebDriverException.class)
				.withMessage("Element was not found by locator ");
	}

	public void waitForElementIsClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForElementIsVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	
	
}

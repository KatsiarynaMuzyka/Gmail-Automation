package by.epam.gmail.automation.utils;

import org.openqa.selenium.WebDriver;

public class WindowSwitcher {

	WebDriver driver;
	
	public WindowSwitcher(WebDriver driver) {
		this.driver = driver;
	}

	public void winSwitcher() {
		String thisWindow = driver.getWindowHandle();
		for (String windNames : driver.getWindowHandles()) {
			if (!windNames.equals(thisWindow)) {
				driver.switchTo().window(windNames);
			}
		}

	}

}
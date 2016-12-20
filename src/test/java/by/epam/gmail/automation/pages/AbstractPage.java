package by.epam.gmail.automation.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

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
	protected Robot robot;
	protected final Logger log;
	
	public AbstractPage(WebDriver driver) {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new ExplicitWait(driver);
		switcher = new WindowSwitcher(driver);
		log = LogManager.getRootLogger();
	}
	
	public void javaRobot(String fileName) {
		String file = fileName; 
		try { 
		Thread.sleep(5000); 
		} catch (InterruptedException e) { 
		e.printStackTrace(); 
		} 

		for (char c : file.toUpperCase().toCharArray()) { 

		if (c != '.') { 
		robot.keyPress(c); 
		robot.keyRelease(c); 
		} else { 
		robot.keyPress(KeyEvent.VK_PERIOD); 
		} 
		} 

		robot.keyPress(KeyEvent.VK_ENTER);
	}
}

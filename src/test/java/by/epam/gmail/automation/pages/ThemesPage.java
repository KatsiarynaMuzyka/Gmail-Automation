package by.epam.gmail.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThemesPage extends AbstractPage {

	@FindBy(xpath = "//a[@class = 'e NvzLyc']")
	private WebElement setThemeButton;

	@FindBy(xpath = "//div[contains(text(), 'My Photos')]")
	private WebElement myPhotosButton;

	@FindBy(xpath = "//div[contains(text(), 'Upload a photo')]")
	private WebElement uploadAPhotoButton;

	@FindBy(xpath = "//div[contains(text(), 'Select a photo')]")
	private WebElement selectAPhotoFromComputerButton;

	@FindBy(xpath = "//iframe[@class = 'KA-JQ']")
	private WebElement newFrame;

	@FindBy(xpath = "//div[contains(text(), 'is not supported for upload')]")
	private WebElement warningMessage;
	
	public ThemesPage(WebDriver driver) {
		super(driver);
	}

	public ThemesPage selectPhotosFromComputer(String fileName) {
		wait.waitForElementIsClickable(setThemeButton);
		setThemeButton.click();
		wait.waitForElementIsClickable(myPhotosButton);
		myPhotosButton.click();
		wait.waitForElementIsVisible(newFrame);
		driver.switchTo().frame(newFrame);
		wait.waitForElementIsClickable(uploadAPhotoButton);
		uploadAPhotoButton.click();
		wait.waitForElementIsClickable(selectAPhotoFromComputerButton);
		selectAPhotoFromComputerButton.click();
		javaRobot(fileName);
		return this;
	}

	public boolean checkWarningMessage() {
		wait.waitForElementIsVisible(warningMessage);
		if (warningMessage.isDisplayed()) {
			return true;
		}
		return false;
	}
}

package by.epam.gmail.automation.pages;

import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

	@FindBy(xpath = "//div[@class ='z0']/div")
	private WebElement writeMessageButton;

	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement destinationField;

	@FindBy(xpath = "//div[@class = 'Am Al editable LW-avf']")
	private WebElement messageField;

	@FindBy(xpath = "//div[text() = 'Send']")
	private WebElement sendButton;

	@FindBy(xpath = "//span[@class = 'gb_8a gbii']")
	private WebElement userIcon;

	@FindBy(xpath = "//a[text() ='Sign out']")
	private WebElement logOutButton;

	@FindBy(xpath = "//div[@class = 'am']/b")
	private WebElement popUpWindow;

	@FindBy(xpath = "//div[@class = 'T-Jo-auh']")
	private WebElement checkBox;
	
	@FindBy(xpath = "//div[@data-tooltip = 'Move to']")
	private WebElement folderListButton;
	
	@FindBy(xpath = "//div[text() = 'Spam']")
	private WebElement spamChoiseButton;

	@FindBy(xpath = "//span[text() = 'More']")
	private WebElement moreButton;

	@FindBy(xpath = "//a[contains(text(), 'Spam')]")
	private WebElement spamButton;

	@FindBy(xpath = "//div[@class='aos T-I-J3 J-J5-Ji']")
	private WebElement settingsButton;

	@FindBy(xpath = "//div[@class='J-N aMS']")
	private WebElement settingsButtonInPopUpWindow;

	@FindBy(xpath = "//div[@class='y6']")
	private WebElement messageButton;

	@FindBy(xpath = "//div[@class='a1 aaA aMZ']") 
	private WebElement attachmentButton;

	@FindBy(xpath = "//div[@class = 'vI']")
	private WebElement attachFile;
	
	@FindBy(xpath = "//div[@class = 'dQ']")
	private WebElement loadLine;
	
	@FindBy(xpath = "//a[contains(text(), 'Trash')]")
	private WebElement trashButton;
	
	@FindBy(xpath = "//div[contains(text(), 'Attachments larger than 25MB')]")
	private WebElement warningText;
	
	public HomePage(WebDriver driver) {
		super(driver);
	}

	private HomePage goToSendMessageForm() {
		wait.waitForElementIsClickable(writeMessageButton);
		writeMessageButton.click();
		return this;
	}

	public HomePage switchToDefaultWindow() {
		driver.switchTo().defaultContent();
		return this;
	}

	private HomePage switchToNewWindow() {
		driver.switchTo().activeElement();
		return this;
	}

	private HomePage fillDestinationField(String destination) {
		wait.waitForElementIsClickable(destinationField);
		destinationField.click();
		destinationField.sendKeys(destination);
		wait.waitForElementIsClickable(popUpWindow);
		popUpWindow.click();
		return this;
	}

	private HomePage fillMessageField(String message) {
		messageField.click();
		messageField.sendKeys(message);
		return this;
	}

	private HomePage clickSendButton() {
		sendButton.click();
		return this;
	}

	public HomePage sendMessageWithAttach(String destination, String fileName) { 
		goToSendMessageForm(); 
		switchToNewWindow(); 
		fillDestinationField(destination); 
		wait.waitForElementIsClickable(attachmentButton); 
		attachmentButton.click(); 
		javaRobot(fileName);
		sendButton.click();
		driver.switchTo().alert().accept();
		return this;
	}

	public HomePage sendMessage(String destination, String message) {
		goToSendMessageForm();
		switchToNewWindow();
		fillDestinationField(destination);
		fillMessageField(message);
		clickSendButton();
		return this;
	}

	private HomePage clickUserIcon() {
		wait.waitForElementIsClickable(userIcon);
		userIcon.click();
		return this;
	}

	private SwitchUserPage clickLogOutButton() {
		wait.waitForElementIsClickable(logOutButton);
		logOutButton.click();
		return new SwitchUserPage(driver);
	}

	public SwitchUserPage logOut() {
		wait.waitForElementIsClickable(userIcon);
		clickUserIcon();
		wait.waitForElementIsClickable(logOutButton);
		clickLogOutButton();
		return new SwitchUserPage(driver);
	}

	public HomePage markMessageAsSpam() {
		wait.waitForElementIsClickable(checkBox);
		checkBox.click();
		wait.waitForElementIsClickable(folderListButton);
		folderListButton.click();
		wait.waitForElementIsClickable(spamChoiseButton);
		spamChoiseButton.click();
		return this;
	}

	public SpamPage goToSpamPage() {
		wait.waitForElementIsClickable(moreButton);
		moreButton.click();
		wait.waitForElementIsClickable(spamButton);
		spamButton.click();
		return new SpamPage(driver);
	}

	public GeneralSettingsPage goToSettingsPage() {
		wait.waitForElementIsClickable(settingsButton);
		settingsButton.click();
		switchToNewWindow();
		wait.waitForElementIsClickable(settingsButtonInPopUpWindow);
		settingsButtonInPopUpWindow.click();
		return new GeneralSettingsPage(driver);
	}

	/*public ThemesPage goToThemesPage() {
		wait.waitForElementIsClickable(settingsButton);
		settingsButton.click();
		switchToNewWindow();
		wait.waitForElementIsClickable(themesButtonInPopUpWindow);
		themesButtonInPopUpWindow.click();
		return new ThemesPage(driver);
	}
	*/
	public MessagePage goToMessagePage() {
		wait.waitForElementIsClickable(messageButton);
		messageButton.click();
		return new MessagePage(driver);
	}

	public TrashPage goToTrashPage() {
		wait.waitForElementIsClickable(moreButton);
		moreButton.click();
		wait.waitForElementIsClickable(trashButton);
		trashButton.click();
		return new TrashPage(driver);
	}
	
	public boolean checkWarningMessageThatSizeOfFileIsOver25MB() {
		wait.waitForElementIsVisible(warningText);
		if (warningText.isDisplayed()) {
			return true;
		}
		return false;
	}
}

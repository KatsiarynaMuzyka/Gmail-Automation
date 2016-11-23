package by.epam.gmailAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import by.epam.gmailAutomation.utils.ThreadSleep;

public class HomePage extends AbstractPage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//div[@class ='z0']/div")
	private WebElement writeMsgButton;
	
	@FindBy(xpath = "//textarea[@name='to']")
	private WebElement destinationField;
	
	@FindBy(xpath = "//input[@name = 'subjectbox']")
	private WebElement subjectField;
	
	@FindBy(xpath = "//div[@class = 'Am Al editable LW-avf']")
	private WebElement msgField;
	
	@FindBy(xpath = "//div[text() = 'Отправить']")
	private WebElement sendButton;
	
	@FindBy(xpath = "//span[@class = 'gb_8a gbii']")
	private WebElement userIcon;
	
	@FindBy(xpath = "//div[@class = 'gb_xb']/div[2]")
	private WebElement logOutButton;
	
	@FindBy(xpath = "//div[@class = 'am']/b")
	private WebElement popUpWindow;
	
	@FindBy(xpath = "//div[@class = 'T-Jo-auh'][1]")
	private WebElement checkBox;//иконка для галочки
	
	@FindBy(xpath = "//div[@class = 'G-tF']/div[3]/div[1]")
	private WebElement folderListButton;//кнопка с выбором опций для отмеченных галочкой
	
	@FindBy(xpath = "//div[text() = 'Спам']")
	private WebElement spamChoiseButton;
	
	@FindBy(xpath = "//span[text() = 'Ещё']")
	private WebElement moreButton;
	
	@FindBy(xpath = "//div[@class='aim'][4]/div")
	private WebElement spamButton;	
	
	public HomePage goToSendMsgForm() {
		wait.waitForElementIsClickable(writeMsgButton);
		writeMsgButton.click();
		return this;
	}
	
	public HomePage switchToDefaultWindow(){	
		driver.switchTo().defaultContent();	
		return this;
	}
	
	public HomePage switchToNewWindow(){		
		driver.switchTo().activeElement();		
		return this;
	}
	
	public HomePage fillDestinationField(String destination) {
		wait.waitForElementIsClickable(destinationField);
		destinationField.click();
		destinationField.sendKeys(destination);
		wait.waitForElementIsClickable(popUpWindow);
		popUpWindow.click();
		return this;
	}
	
	public HomePage fillSubjectField(String subject) {
		subjectField.click();
		subjectField.sendKeys(subject);
		return this;
	}
	
	public HomePage fillMsgField(String msg) {
		msgField.click();
		msgField.sendKeys(msg);
		return this;
	}
	
	public HomePage clickSendButton() {
		sendButton.click();
		return this;
	}
	
	public HomePage sendMsg(String destination, String subject, String msg) {
		goToSendMsgForm();
		switchToNewWindow();
		fillDestinationField(destination);
		fillSubjectField(subject);
		fillMsgField(msg);
		clickSendButton();
		ThreadSleep.waitElement(2000);
		return this;
	}
	
	public HomePage clickUserIcon() {
		wait.waitForElementIsClickable(userIcon);
		userIcon.click();
		return this;
	}
	
	public SwitchUserPage clickLogOutButton() {
		wait.waitForElementIsClickable(logOutButton);
		logOutButton.click();
		return new SwitchUserPage(driver);
	}
	
	public SwitchUserPage logOut() {
		clickUserIcon();
		clickLogOutButton();
		return new SwitchUserPage(driver);
	}
	
	public HomePage markMsgAsSpam() {
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
}

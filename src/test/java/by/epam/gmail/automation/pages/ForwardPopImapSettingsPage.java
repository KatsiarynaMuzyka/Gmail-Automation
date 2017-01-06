package by.epam.gmail.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForwardPopImapSettingsPage extends AbstractPage {

	@FindBy(xpath = "//input[@act ='add']")
	private WebElement addForwardAddressButton;
	
	@FindBy(xpath = "//div[@class='PN']/input")
	private WebElement userAddressForForwardField;
	
	@FindBy(xpath = "//button[@class='J-at1-auR']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//input[@value = 'Proceed']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//button[@class='J-at1-auR']")
	private WebElement okButton;
	
	@FindBy(xpath = "//a[contains(text(), 'Inbox')]")
	private WebElement inboxMessageButton;
	
	@FindBy(xpath = "//input[@name = 'sx_em'][@value = '1']")
	private WebElement radioButton;
	
	@FindBy(xpath = "//span[text() = 'creating a filter!']")
	private WebElement filterSettingsButton;
	
	@FindBy(xpath = "//input[@class='ZH nr aQa']")
	private WebElement fromWhomField;
	
	@FindBy(xpath = "//label[text() = 'Has attachment']")
	private WebElement hasAttachmentRadioButton;
	
	@FindBy(xpath = "//div[text() = 'Create filter with this search »']")
	private WebElement createFilterButton;
	
	@FindBy(xpath = "//button[@class = 'J-at1-auR J-at1-atl']")
	private WebElement transitionConfirmationButton;
	
	@FindBy(xpath = "//label[text() = 'Delete it']")
	private WebElement deleteRadioButton;
	
	@FindBy(xpath = "//label[text() = 'Always mark it as important']")
	private WebElement markAsImportantRadioButton;
	
	@FindBy(xpath = "//div[text() = 'Create filter']")
	private WebElement doneButton;
	
	@FindBy(xpath = "//button[contains(text(), 'Save Changes')]")
	private WebElement saveChangesButton;
	
	public ForwardPopImapSettingsPage(WebDriver driver) {
		super(driver);
	}
	
	private ForwardPopImapSettingsPage switchToNewWindow(){		
		driver.switchTo().activeElement();		
		return this;
	}
	
	public ForwardPopImapSettingsPage addAddressForForwarding(String user3Address) {
		log.info("Adding address for forwarding");
		wait.waitForElementIsClickable(addForwardAddressButton);
		addForwardAddressButton.click();
		switchToNewWindow();
		wait.waitForElementIsClickable(userAddressForForwardField);
		userAddressForForwardField.click();
		userAddressForForwardField.sendKeys(user3Address);
		nextButton.click();
		String temp = driver.getWindowHandle();
		switcher.winSwitcher();
		wait.waitForElementIsClickable(continueButton);
		continueButton.click();
		driver.switchTo().window(temp);
		wait.waitForElementIsClickable(okButton);
		okButton.click();
		switchToNewWindow();
		return this;
	}
	
	public HomePage filterSettings(String fromWhom) {
		log.info("Configuring forwarding filters");
		wait.waitForElementIsClickable(radioButton);
		radioButton.click();
		wait.waitForElementIsClickable(filterSettingsButton);
		filterSettingsButton.click();
		
		switchToNewWindow();
		wait.waitForElementIsClickable(fromWhomField);
		fromWhomField.click();
		fromWhomField.sendKeys(fromWhom);
		hasAttachmentRadioButton.click();
		createFilterButton.click();
		
		switchToNewWindow();
		wait.waitForElementIsClickable(transitionConfirmationButton);
		transitionConfirmationButton.click();
		
		switchToNewWindow();
		wait.waitForElementIsClickable(deleteRadioButton);
		deleteRadioButton.click();
		markAsImportantRadioButton.click();
		doneButton.click();
		wait.waitForElementIsClickable(radioButton);
		radioButton.click();
		wait.waitForElementIsClickable(saveChangesButton);
		saveChangesButton.click();
		return new HomePage(driver);
	}
	
	public HomePage goToHomePage() {
		log.info("Opening home page");
		wait.waitForElementIsClickable(inboxMessageButton);
		inboxMessageButton.click();
		return new HomePage(driver);
	}
}

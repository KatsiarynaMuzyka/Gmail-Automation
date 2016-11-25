package by.epam.gmailAutomation.pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForwardPopImapSettingsPage extends AbstractPage {

	public ForwardPopImapSettingsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@act ='add']")
	private WebElement addForwardAddressButton;
	
	@FindBy(xpath = "//div[@class='PN']/input")
	private WebElement userAddressForForwardField;
	
	@FindBy(xpath = "//button[@class='J-at1-auR']")
	private WebElement nextButton;
	
	@FindBy(xpath = "//td[@align = 'left']/input[3]")
	private WebElement continueButton;
	
	@FindBy(xpath = "//button[@class='J-at1-auR']")
	private WebElement okButton;
	
	@FindBy(xpath = "//div[@class = 'aim'][1]/div/div/div[1]")
	private WebElement inboxMsgButton;
	
	@FindBy(xpath = "//input[@name = 'sx_em'][@value = '1']")
	private WebElement radioButton;
	
	@FindBy(xpath = "//td[@class='r9']/div/div[3]/span")
	private WebElement filterSettingsButton;
	
	@FindBy(xpath = "//input[@class='ZH nr aQa']")
	private WebElement fromWhomField;
	
	@FindBy(xpath = "//span[@class='w-Pv ZG'][1]/input")
	private WebElement hasAttachmentRadioButton;
	
	@FindBy(xpath = "//div[@class='w-Nw'][8]/div[2]") //создать фильтр в соответствии с этим запросом
	private WebElement createFilterButton;
	
	@FindBy(xpath = "//button[@class = 'J-at1-auR J-at1-atl']")
	private WebElement transitionConfirmationButton;
	
	@FindBy(xpath = "//div[@class='nH lZ'][6]/input")
	private WebElement deleteRadioButton;
	
	@FindBy(xpath = "//div[@class='nH lZ'][8]/input")
	private WebElement markAsImportantRadioButton;
	
	@FindBy(xpath = "//div[@class='ZZ']/div[5]/div")
	private WebElement doneButton;
	
	public ForwardPopImapSettingsPage switchToNewWindow(){		
		driver.switchTo().activeElement();		
		return this;
	}
	
	public ForwardPopImapSettingsPage addAddressForForwarding(String user3Address) {
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
		return this;
	}
	
	public ForwardPopImapSettingsPage filterSettings(String fromWhom) {
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
		return this;
	}
	
	public HomePage goToHomePage() {
		wait.waitForElementIsClickable(inboxMsgButton);
		inboxMsgButton.click();
		return new HomePage(driver);
	}
}

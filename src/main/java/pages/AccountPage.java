package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtilities;
import utils.ElementUtils;

public class AccountPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(linkText =  "Edit your account information")
	private WebElement loginSuccessMessage;
	
	@FindBy(xpath =  "//div[@id='content']/h1")
	private WebElement accountCreatedMessageMessage;
	
	
	
	public boolean verifyLoginSuccess() {
		//return loginSuccessMessage.isDisplayed();
		return elementUtils.isElementDisplayed(loginSuccessMessage, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
	
	public String getAccountCreatedMessageMessage() {
		//return accountCreatedMessageMessage.getText();
		return elementUtils.getTextFromElement(accountCreatedMessageMessage, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtilities;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement noEmailMatchMesssage;
	
	public void enterEmailAddress(String emailText) {
		//emailField.sendKeys(emailText);
		elementUtils.typeTextInToElement(emailField, emailText, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
	
	public void enterPassword(String passwordText) {
		//passwordField.sendKeys(passwordText);
		elementUtils.typeTextInToElement(passwordField, passwordText, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
	
	public LoginPage clickLoginButton() {
		//loginButton.click();
		elementUtils.clickOnElement(loginButton, 20);
		return new LoginPage(driver);
	}
	
	public String getNoEmailMatchMesssage() {
		//return noEmailMatchMesssage.getText();
		return elementUtils.getTextFromElement(noEmailMatchMesssage, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
	
	
	
	
}

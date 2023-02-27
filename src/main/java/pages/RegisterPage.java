package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtilities;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckBox;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name='newsletter'][@value=1]")
	private WebElement newsletterYesRadio;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement userAlreadyExistMessage;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyErrorMessage;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameErrorMessage;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameErrorMessage;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailErrorMessage;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telephoneErrorMessage;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordErrorMessage;

	public void enterFirstName(String firstName) {
		// firstNameField.sendKeys(firstName);
		elementUtils.typeTextInToElement(firstNameField, firstName, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void enterLastName(String lastName) {
		// lastNameField.sendKeys(lastName);
		elementUtils.typeTextInToElement(lastNameField, lastName, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void enterEmail(String emailText) {
		// emailField.sendKeys(emailText);
		elementUtils.typeTextInToElement(emailField, emailText, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void enterTelephone(String telephoneNumber) {
		// telephoneField.sendKeys(telephoneNumber);
		elementUtils.typeTextInToElement(telephoneField, telephoneNumber, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void enterPassword(String password) {
		// passwordField.sendKeys(password);
		elementUtils.typeTextInToElement(passwordField, password, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void enterConfirmPassword(String confirmPassword) {
		// confirmPasswordField.sendKeys(confirmPassword);
		elementUtils.typeTextInToElement(confirmPasswordField, confirmPassword, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void selectNewletterYes() {
		// newsletterYesRadio.click();
		elementUtils.clickOnElement(newsletterYesRadio, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void selectPrivacyPolicyCheckBox() {
		// privacyPolicyCheckBox.click();
		elementUtils.clickOnElement(privacyPolicyCheckBox, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void clickContinueButton() {
		// continueButton.click();
		elementUtils.clickOnElement(continueButton, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void verifyMandatoryErrorMessages() {
		Assert.assertTrue(elementUtils.getTextFromElement(privacyPolicyErrorMessage, CommonUtilities.EXPLICIT_WAIT_TIME)
				.equalsIgnoreCase("Warning: You must agree to the Privacy Policy!"));
		Assert.assertTrue(elementUtils.getTextFromElement(firstNameErrorMessage, CommonUtilities.EXPLICIT_WAIT_TIME)
				.equalsIgnoreCase("First Name must be between 1 and 32 characters!"));
		Assert.assertTrue(elementUtils.getTextFromElement(lastNameErrorMessage, CommonUtilities.EXPLICIT_WAIT_TIME)
				.equalsIgnoreCase("Last Name must be between 1 and 32 characters!"));
		Assert.assertTrue(elementUtils.getTextFromElement(emailErrorMessage, CommonUtilities.EXPLICIT_WAIT_TIME)
				.equalsIgnoreCase("E-Mail Address does not appear to be valid!"));
		Assert.assertTrue(elementUtils.getTextFromElement(telephoneErrorMessage, CommonUtilities.EXPLICIT_WAIT_TIME)
				.equalsIgnoreCase("Telephone must be between 3 and 32 characters!"));
		Assert.assertTrue(elementUtils.getTextFromElement(passwordErrorMessage, CommonUtilities.EXPLICIT_WAIT_TIME)
				.equalsIgnoreCase("Password must be between 4 and 20 characters!"));
	}

	public void verifyUserAlreadyExistMessage() {
		Assert.assertTrue(elementUtils.getTextFromElement(userAlreadyExistMessage, CommonUtilities.EXPLICIT_WAIT_TIME)
				.equalsIgnoreCase("Warning: E-Mail Address is already registered!"));
	}

}

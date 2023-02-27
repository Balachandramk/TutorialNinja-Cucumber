package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtilities;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	ElementUtils elementUtils;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	public void clickOnMyAccount() {
		
		//myAccountDropMenu.click();
		elementUtils.clickOnElement(myAccountDropMenu, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void selectRegisterOptiont() {
		//registerOption.click();
		elementUtils.clickOnElement(registerOption, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public void selectLoginOptiont() {
		//loginOption.click();
		elementUtils.clickOnElement(loginOption, CommonUtilities.EXPLICIT_WAIT_TIME);
	}

	public RegisterPage navigateToRegisterPage() {
		clickOnMyAccount();
		selectRegisterOptiont();
		return new RegisterPage(driver);
	}

	public LoginPage navigateToLoginPage() {
		clickOnMyAccount();
		selectLoginOptiont();
		return new LoginPage(driver);
	}

}

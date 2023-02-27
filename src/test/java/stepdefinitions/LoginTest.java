package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtilities;

public class LoginTest {

	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private AccountPage accountPage;
	private CommonUtilities commonUtils = new CommonUtilities();

	@Given("User navigates to login page")
	public void User_navigates_to_login_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		accountPage = new AccountPage(driver);

		loginPage = homePage.navigateToLoginPage();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Login")).click();

	}

	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText) {
		// driver.findElement(By.id("input-email")).sendKeys(emailText);
		loginPage.enterEmailAddress(emailText);
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) {
		// driver.findElement(By.id("input-password")).sendKeys(passwordText);
		loginPage.enterPassword(passwordText);
	}

	@And("User clicks on Login button")
	public void user_clicks_on_Login_button() {
		// driver.findElement(By.xpath("//input[@value='Login']")).click();
		loginPage.clickLoginButton();
	}

	@Then("User should successfully logged in")
	public void user_should_successfully_logged_in() {
		Assert.assertTrue(accountPage.verifyLoginSuccess());
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() {
		// driver.findElement(By.id("input-email")).sendKeys(emailWithTimeStamp());
		loginPage.enterEmailAddress(commonUtils.emailWithTimeStamp());
	}

	@And("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) {
		// driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
		loginPage.enterPassword(invalidPasswordText);

	}

	@Then("User should not be logged in and should display credentials mismatch error message")
	public void user_should_not_be_logged_in_and_should_display_credentials_mismatch_error_message() {
		Assert.assertTrue(loginPage.getNoEmailMatchMesssage()
				.equalsIgnoreCase("Warning: No match for E-Mail Address and/or Password."));
	}

}

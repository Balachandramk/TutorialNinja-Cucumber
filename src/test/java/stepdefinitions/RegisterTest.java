package stepdefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtilities;

public class RegisterTest {

	WebDriver driver;
	HomePage homePage;
	AccountPage accountPage;
	RegisterPage registerPage;
	private CommonUtilities commonUtils = new CommonUtilities();

	@Given("User navigates to Register page")
	public void user_navigates_to_register_page() {
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		accountPage = new AccountPage(driver);

		registerPage = homePage.navigateToRegisterPage();
		// driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// driver.findElement(By.linkText("Register")).click();

	}

	@When("User enters below details with new email")
	public void user_enters_below_details_with_new_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		// driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("First
		// Name"));
		// driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("Last
		// Name"));
		// driver.findElement(By.id("input-email")).sendKeys(dataMap.get("Email"));
		// driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("Telephone"));
		// driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
		// driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Password
		// Confirm"));

		registerPage.enterFirstName(dataMap.get("First Name"));
		registerPage.enterLastName(dataMap.get("Last Name"));
		registerPage.enterEmail(commonUtils.emailWithTimeStamp());
		registerPage.enterTelephone(dataMap.get("Telephone"));
		registerPage.enterPassword(dataMap.get("Password"));
		registerPage.enterConfirmPassword(dataMap.get("Password Confirm"));
		//FAILING ON PURPOSE
		Assert.fail("Failing deliberately on purpose");
	}

	@When("User enters below details with existing email")
	public void user_enters_below_details_with_existing_email(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		// driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("First
		// Name"));
		// driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("Last
		// Name"));
		// driver.findElement(By.id("input-email")).sendKeys(dataMap.get("Email"));
		// driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("Telephone"));
		// driver.findElement(By.id("input-password")).sendKeys(dataMap.get("Password"));
		// driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("Password
		// Confirm"));

		registerPage.enterFirstName(dataMap.get("First Name"));
		registerPage.enterLastName(dataMap.get("Last Name"));
		registerPage.enterEmail(dataMap.get("Email"));
		registerPage.enterTelephone(dataMap.get("Telephone"));
		registerPage.enterPassword(dataMap.get("Password"));
		registerPage.enterConfirmPassword(dataMap.get("Password Confirm"));
	}

	@And("User selects Privacy Policy checkbox")
	public void user_selects_privacy_policy_checkbox() {
		// driver.findElement(By.xpath("//input[@name='agree']")).click();
		registerPage.selectPrivacyPolicyCheckBox();

	}

	@And("User clicks on Continue button")
	public void user_clicks_on_continue_button() {
		// driver.findElement(By.xpath("//input[@value='Continue']")).click();

		registerPage.clickContinueButton();
	}

	@Then("User Account should get created successfully")
	public void user_account_should_get_created_successfully() {
		// Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h1")).getText().equalsIgnoreCase("Your
		// Account Has Been Created!"));

		Assert.assertTrue(
				accountPage.getAccountCreatedMessageMessage().equalsIgnoreCase("Your Account Has Been Created!"));
	}

	@And("User select Yes for newsletter")
	public void user_select_yes_for_newsletter() {
		// driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
		registerPage.selectNewletterYes();
	}

	@Then("User already exists message should be displayed")
	public void user_already_exists_message_should_be_displayed() {
		// Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().equalsIgnoreCase("Warning:
		// E-Mail Address is already registered!"));
		registerPage.verifyUserAlreadyExistMessage();
	}

	@Then("User should be displayed with error messages for mandatory fields")
	public void user_should_be_displayed_with_error_messages_for_mandatory_fields() {
		// Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().equalsIgnoreCase("Warning:
		// You must agree to the Privacy Policy!"));
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText().equalsIgnoreCase("First
		// Name must be between 1 and 32 characters!"));
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText().equalsIgnoreCase("Last
		// Name must be between 1 and 32 characters!"));
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText().equalsIgnoreCase("E-Mail
		// Address does not appear to be valid!"));
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText().equalsIgnoreCase("Telephone
		// must be between 3 and 32 characters!"));
		// Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText().equalsIgnoreCase("Password
		// must be between 4 and 20 characters!"));

		registerPage.verifyMandatoryErrorMessages();

	}

}

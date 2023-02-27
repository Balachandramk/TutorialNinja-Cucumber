package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchPage;

public class SearchTest {

	WebDriver driver;
	SearchPage searchPage;

	@When("User opens application")
	public void User_opens_application() {

		driver = DriverFactory.getDriver();
		searchPage = new SearchPage(driver);
	}

	@When("User enters valid product {string} in search field")
	public void user_enters_valid_product_in_search_field(String validProduct) {

		// driver.findElement(By.name("search")).sendKeys(validProduct);
		searchPage.enterValidSearchItem(validProduct);
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {

		driver.findElement(By.xpath("//div[@id='search']/descendant::button")).click();
		searchPage.clickOnSearchButton();
	}

	@Then("User should be displayed with valid products in search result")
	public void user_should_be_displayed_with_valid_products_in_search_result() {
		// Assert.assertTrue(driver.findElement(By.linkText("HP
		// LP3065")).isDisplayed());
		searchPage.verifyValidProductSearchResult();
	}

	@When("User enters invalid product {string} in search field")
	public void user_enters_invalid_product_in_search_field(String invalidProduct) {

		// driver.findElement(By.name("search")).sendKeys(invalidProduct);
		searchPage.enterValidSearchItem(invalidProduct);
	}

	@Then("User should not be displayed with any products")
	public void user_should_not_be_displayed_with_any_products() {
		// Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h2/following-sibling::p")).getText()
		// .equalsIgnoreCase("There is no product that matches the search criteria."));
		Assert.assertTrue(searchPage.getInvalidProductSearchResultMessage()
				.equalsIgnoreCase("There is no product that matches the search criteria."));
	}

}

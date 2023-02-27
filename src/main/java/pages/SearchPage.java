package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtilities;
import utils.ElementUtils;

public class SearchPage {
	
	WebDriver driver;
	ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(name = "search")
	private WebElement searchField;
	
	@FindBy(xpath = "//div[@id='search']/descendant::button")
	private WebElement searchButton;
	
	@FindBy(linkText = "HP LP3065")
	private WebElement validSearchResultItem;
	
	@FindBy(xpath = "//div[@id='content']/h2/following-sibling::p")
	private WebElement noSearchResultMessage;
	
	public void enterValidSearchItem(String validProductItem) {
		//searchField.sendKeys(validProductItem);
		elementUtils.typeTextInToElement(searchField, validProductItem, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
	
	public void clickOnSearchButton() {
		//searchButton.click();
		elementUtils.clickOnElement(searchButton, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
	
	public void verifyValidProductSearchResult() {
		//validSearchResultItem.isDisplayed();
		elementUtils.isElementDisplayed(validSearchResultItem, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
	
	public String getInvalidProductSearchResultMessage() {
		//return noSearchResultMessage.getText();
		return elementUtils.getTextFromElement(noSearchResultMessage, CommonUtilities.EXPLICIT_WAIT_TIME);
	}
	
	
	
	
	
	

}

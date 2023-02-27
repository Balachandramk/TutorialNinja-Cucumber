package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;
	WebElement webElement;

	public ElementUtils(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSeconds) {

		webElement = waitForElement(element, durationInSeconds);

		webElement.click();
	}

	public void typeTextInToElement(WebElement element, String textToBeTyped, long durationInSeconds) {
		clickOnElement(element, durationInSeconds);
		webElement.clear();
		webElement.sendKeys(textToBeTyped);
	}
	
	public String getTextFromElement(WebElement element, long durationInSeconds) {
		webElement = waitForElement(element, durationInSeconds);
		return webElement.getText();
	}
	
	public boolean isElementDisplayed(WebElement element, long durationInSeconds) {
		
		webElement = waitForElement(element, durationInSeconds);
		return webElement.isDisplayed();
	}
	
	

	public WebElement waitForElement(WebElement element, long durationInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return webElement;
	}

	public void selectOptionInDropdowm(WebElement element, String optionToBeSelected, long durationInSeconds) {
		webElement = waitForElement(element, durationInSeconds);
		Select select = new Select(element);
		select.selectByVisibleText(optionToBeSelected);
	}

	public Alert waitForAlert(long durationInSeconds) {
		Alert alert = null;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		try {
			alert = wait.until(ExpectedConditions.alertIsPresent());
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return alert;

	}

	public void acceptAlert(long durationInSeconds) {

		waitForAlert(durationInSeconds).accept();
		;

	}

	public void dismissAlert(long durationInSeconds) {

		waitForAlert(durationInSeconds).dismiss();

	}

	public void mouseHoverAndClick(WebElement element, long durationInSeconds) {
		webElement = waitForVisibilityOfElementy(element, durationInSeconds);
		Actions action = new Actions(driver);
		action.moveToElement(webElement).click().build().perform();
	}

	public WebElement waitForVisibilityOfElementy(WebElement element, long durationInSeconds) {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
			webElement = wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Throwable t) {
			t.printStackTrace();
		}

		return webElement;
	}

	public void javaScriptClick(WebElement element, long durationInSeconds) {
		webElement = waitForVisibilityOfElementy(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].click()", webElement);
	}

	public void javaScriptype(WebElement element, String textToBeTyped, long durationInSeconds) {
		webElement = waitForVisibilityOfElementy(element, durationInSeconds);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		jse.executeScript("arguments[0].value='" + textToBeTyped + "'", webElement);
	}

}

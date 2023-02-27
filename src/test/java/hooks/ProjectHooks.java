package hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class ProjectHooks {

	WebDriver driver;

	@Before
	public void setup() {

		Properties prop = new ConfigReader().initializeProperties();
		driver = DriverFactory.initializeBrowser(prop.getProperty("browserName"));
		driver.get(prop.getProperty("url"));

	}

	@After
	public void tearDown(Scenario scenario) {
		String scenarioName = scenario.getName().replace(" ", "_");
		
		byte[] srcScreeshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(srcScreeshot, "image/png", scenarioName);
		
		driver.quit();
	}
}

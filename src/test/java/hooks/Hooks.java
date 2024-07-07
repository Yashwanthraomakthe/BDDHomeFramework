package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.service.ExtentService;

import driver.CreateDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import pages.Dashboard;
import pages.LoginPage;

public class Hooks {
//	public LoginPage loginPage;
//	public Dashboard dashboard;
	public WebDriver driver;
	

	@Before()
	public void chromeSetUp(Scenario scenario) {
		System.out.println("I am in before scenario");
		String browser = "chrome";
		CreateDriver.getInstance().setDriver(browser);
		driver = CreateDriver.getInstance().getDriver();		
		driver.get("https://www.saucedemo.com/");
		
	}

	@After()
	public void chromeTearDown(Scenario scenario) {
		System.out.println("I am in After Scenario");
		CreateDriver.getInstance().getDriver().quit();
		scenario.getStatus();
	}

	@BeforeStep()
	public void actionBeforeEachStep() {		
//		LoginPage loginPage = new LoginPage(driver);
//		Dashboard dashboard = new Dashboard(driver);
	}

	@AfterStep()
	public synchronized void actionPostEachStep(Scenario scenario) {		
		if (!scenario.isFailed()) {
			TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
			byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", screenshot.toString());
		}
	}
}

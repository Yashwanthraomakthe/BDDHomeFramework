package stepDefs;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dependencyInjection.Context;
import driver.CreateDriver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard;
import pages.LoginPage;

public class LoginStepDef {

	public LoginPage loginPage;
	public Dashboard dashboard;
	public WebDriver driver;

	public Context context;

	public LoginStepDef(Context context) {
		driver = CreateDriver.getInstance().getDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		dashboard = new Dashboard(driver);
		this.context = context;
	}
	

	@And("user has entered username {string} and password {string}")
	public void userHasEnteredUsernameAndPassword(String username, String password) {		
		loginPage.userName.sendKeys(username);
		loginPage.password.sendKeys(password);
	}

	@Given("user has entered credentials")
	public void enterCredentials(DataTable dataTable) throws InterruptedException {
		
		Map<String, String> credentials = dataTable.asMap();

		loginPage.userName.sendKeys(credentials.get("UserName"));
		Thread.sleep(2000);
		loginPage.password.sendKeys(credentials.get("Password"));

	}

	@Given("user has entered credentials with list of map")
	public void userHasEnteredCredentialsWithListOfMap(DataTable dataTable) {
		List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);		
		loginPage.userName.sendKeys(credentials.get(0).get("UserName"));
		loginPage.password.sendKeys(credentials.get(0).get("Password"));

	}

	@Given("user has entered username <username> and password <password>")
	public void userHasEnteredUsernameUsernameAndPasswordPassword(DataTable dataTable) throws InterruptedException {
		
		List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : credentials) {
			String username = row.get("UserName");
			String password = row.get("Password");

			loginPage.userName.sendKeys(username);
			Thread.sleep(2000);
			loginPage.password.sendKeys(password);

		}
	}

	@Given("user has entered credentials data driven")
	public void enterCredentialsWithDataDriven(DataTable dataTable) throws InterruptedException {		

		List<Map<String, String>> credentials = dataTable.asMaps(String.class, String.class);
		for (Map<String, String> row : credentials) {
			String username = row.get("UserName");
			String password = row.get("Password");

			loginPage.userName.sendKeys(username);
			Thread.sleep(2000);
			loginPage.password.sendKeys(password);

		}

	}

	@Given("User click on Login")
	public void userClickOnLogin() {
		loginPage.loginButton.click();
	}

	@Then("user verify {string} on Dashboard")
	public void userVerifyOnDashboard(String string) {		
		dashboard.productsLabel.isDisplayed();
	}

	@Given("User click on menu on Dashboard")
	public void userClickOnMenuOnDashboard() {		
		dashboard.menu.click();

	}

	@Given("User click on Logout")
	public void userClickOnLogout() {
		dashboard.logout.click();

	}

	@Then("User verify title")
	public void userVerifyTitle() {
		String expectedTitle = "Swag Labs";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
	}
}

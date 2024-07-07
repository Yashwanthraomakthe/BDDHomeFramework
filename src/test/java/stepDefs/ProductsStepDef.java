package stepDefs;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import dependencyInjection.Context;
import driver.CreateDriver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard;
import pages.LoginPage;

public class ProductsStepDef {

	private WebDriver driver;
	private Context context;
	public Dashboard dashboard;
	public LoginPage loginPage;	
	
	
	public ProductsStepDef(Context context) {
		driver = CreateDriver.getInstance().getDriver();
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		dashboard = new Dashboard(driver);
		this.context = context;
	}

	@Then("user validate the following products")
	public void verifyData(List<String> products) {			
		dashboard.verifyProducts(products);

	}

	@Then("user verifies following Products and respective prices")
	public void verifyProductPrice(Map<String, String> productPriceMap) {		
		dashboard.verifyProductsWithTheirPrices(productPriceMap);
	}

	@When("User add {string} item to card")
	public void userAddItemToCard(String product) throws InterruptedException {
		WebElement addToCart = driver.findElement(
				By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='" + product
						+ "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
		context.setContext("itemName", product);
		Thread.sleep(5000);
		addToCart.click();
	}

	@Then("User remove item from cart")
	public void userRemoveItemFromCart() {
		WebElement removeCart = driver.findElement(
				By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='"
						+ context.getContext("itemName")
						+ "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
		removeCart.click();

	}

	@Then("User verify the item is removed from card")
	public void userVerifyTheItemIsRemovedFromCard() {
		WebElement addToCart = driver.findElement(
				By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='"
						+ context.getContext("itemName")
						+ "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));
		context.setContext("addToCartText", addToCart.getText());
		Assert.assertEquals(addToCart.getText(), context.getContext("addToCartText"));
	}

}

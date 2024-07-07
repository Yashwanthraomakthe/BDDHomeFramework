package pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Dashboard {

	WebDriver driver;

	public Dashboard(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Products']")
	public WebElement productsLabel;

	@FindBy(xpath = "//*[text()='Sauce Labs Backpack']")
	public WebElement backPack;

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	public WebElement menu;

	@FindBy(xpath = "//a[@id='logout_sidebar_link']")
	public WebElement logout;

	public void verifyProducts(List<String> products) {
		for (String product : products) {
			System.out.println(product);
			Assert.assertTrue(driver.findElement(By.xpath("//div[normalize-space()='" + product + "']")).isDisplayed());
		}
	}

	public void verifyProductsWithTheirPrices(Map<String, String> productPriceMap) {
		for (Map.Entry<String, String> entry : productPriceMap.entrySet()) {
			WebElement productElement = driver.findElement(
					By.xpath("//div[@class='inventory_item']//div[@class='inventory_item_label']/a/div[text()='"
							+ entry.getKey() + "']/ancestor::div/following-sibling::div[@class='pricebar']/button"));

			WebElement productPriceElement = productElement
					.findElement(By.xpath("preceding-sibling::div[@class='inventory_item_price']"));

			System.out.println(entry.getKey());
			Assert.assertTrue(productPriceElement.getText().equals(entry.getValue()));
			System.out.println(entry.getValue());
		}
	}

}

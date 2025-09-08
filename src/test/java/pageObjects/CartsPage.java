package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartsPage {
	
	public WebDriver driver;
	
	private By productNameCartsPage =  By.xpath("//p[@class='product-name']");
	
	public CartsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public String getproductNameOnCartsPage(String productNameonCartsPage)
	{
		return driver.findElement(productNameCartsPage).getText();
	}

}

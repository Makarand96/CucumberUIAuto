package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	
	WebDriver driver;

	private By search =  By.xpath("//input[@type='search']");
	
	private By productName = By.xpath("//h4[@class='product-name']");
	
	private By links = By.tagName("a");
	
	private By addProducts=  By.xpath("//a[@class='increment']");
	
	private By cartIcon = By.xpath("//img[@alt='Cart']");
	
	private By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	
	private By proceedToCheckoutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public void searchtext(String textsearch)
	{
		driver.findElement(search).sendKeys(textsearch);
	}
	
	
	public String getProductNameOnLandingPage()
	{
		return	driver.findElement(productName).getText();
	}
	
	public void switchToTopdealsPage()
	{
		List<WebElement> allLinks =driver.findElements(links);
		
		for(WebElement ele : allLinks)
		{
			if(ele.getText().equalsIgnoreCase("Top Deals"))
			{
				ele.click();
				break;
			}
		}
		
	}
	
	public void addNumberOfProducts(Integer number)
	{
		while(number>1)
		{
			driver.findElement(addProducts).click();
			number--;
		}
		
	}
	
	public void clickOnAddToCart() throws InterruptedException
	{
		driver.findElement(addToCartButton).click();
		Thread.sleep(2000);
	}
	
	public void proceedToCheckout()
	{
		driver.findElement(cartIcon).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(proceedToCheckoutButton)).click();
	}
	
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	
}

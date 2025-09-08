package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OffersPage {
	
	WebDriver driver;
	
	private By searchfield = By.xpath("//input[@id='search-field']");
	
	private By productname = By.xpath("(//tr//td)[1]");
	
	
	
	public OffersPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void sendTextinSearchfield(String shortName)
	{
		driver.findElement(searchfield).sendKeys(shortName);
	}

	public String getProductName()
	{
	 return	driver.findElement(productname).getText();
	}
	

}

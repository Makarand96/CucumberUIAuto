package pageObjects;
import org.openqa.selenium.WebDriver;

import utils.TestBase;

public class PageObjectManager {

	
	public LandingPage landingPage;
	public OffersPage offerspage;
	public CartsPage cartsPage;
	public WebDriver driver;
	public TestBase testbase;
	
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	
	public LandingPage getLandingPage()
	{
		landingPage =  new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage()
	{
		offerspage =  new OffersPage(driver);
		return offerspage;
	}
	
	public CartsPage getCartsPage()
	{
		cartsPage = new CartsPage(driver);
		return cartsPage;
	}
}

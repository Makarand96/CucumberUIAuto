package stepDefinitions;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public WebDriver driver;
	public String LandingPageproductName;
	public String OfferPageproductName;
//	public PageObjectManager pom;
	public OffersPage offerspage;
	LandingPage landingpage;
	TestContextSetup test;
	
	public OfferPageStepDefinition(TestContextSetup test)
	{
		this.test = test;
		this.landingpage = test.pom.getLandingPage();
		this.offerspage =  test.pom.getOffersPage();
	}
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		
		switchToOffersPage();
		
		offerspage.sendTextinSearchfield(shortName);
		Thread.sleep(3000);
		
		OfferPageproductName = offerspage.getProductName().trim();
		
	    System.out.println(OfferPageproductName);
	  
	}
	
	public void switchToOffersPage() throws InterruptedException
	{
		
		landingpage.switchToTopdealsPage();
		test.genericUtils.switchWindowToChild();
		Thread.sleep(3000);
	}
	
	
	@Then("Validate product name offers page matches with Landing Page")
	public void validate_product_name_offers_page_matches_with_landing_page() {
		
		 Assert.assertEquals(test.LandingPageproductName, OfferPageproductName);
		
		 test.testbase.driver.quit();
	   
	}

}

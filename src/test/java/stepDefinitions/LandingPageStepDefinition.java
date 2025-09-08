package stepDefinitions;

import java.io.IOException;
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
import pageObjects.PageObjectManager;
import utils.TestBase;
import utils.TestContextSetup;

public class LandingPageStepDefinition{
	
	public String LandingPageproductName;
	public PageObjectManager pom;
	public 	LandingPage landingpage;
	TestContextSetup test;
	
	public LandingPageStepDefinition(TestContextSetup test)
	{
		this.test=test;
		this.landingpage = test.pom.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page()throws InterruptedException {
	
		Thread.sleep(2000);
		
		Assert.assertTrue(landingpage.getTitleLandingPage().contains("GreenKart"));
	}
	
	
	@When("^user searched with shortname (.+) and extracted actual name of Product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String string) throws InterruptedException {
		
		
	//	pom =  new PageObjectManager(test.driver);
	//    LandingPage landingpage = pom.getLandingPage();
	    landingpage.searchtext(string);
		
		Thread.sleep(2000);
		
		test.LandingPageproductName = landingpage.getProductNameOnLandingPage().split("-")[0].trim();    
		
		System.out.println(test.LandingPageproductName);
		
	}
	
	
	
	

}

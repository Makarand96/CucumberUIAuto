package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CartsPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CartsPageStepDefinition {

	TestContextSetup test;
	String LandingPageProductName;
	CartsPage cartsPage;
	LandingPage landingpage;
	
	public CartsPageStepDefinition (TestContextSetup test)
	{
		this.test=test;
		this.landingpage = test.pom.getLandingPage();
		this.cartsPage= test.pom.getCartsPage();;
	}
	
	@When("Adds {int} items of the product to the cart and Proceeds to checkout from the Cart Page")
	public void adds_items_of_the_product_to_the_cart(Integer int1) throws InterruptedException {
		
		landingpage.addNumberOfProducts(int1);
		landingpage.clickOnAddToCart();
		landingpage.proceedToCheckout();
	    
	}

	@Then("^The product name (.+) should be displayed in the Cart Page$")
	public void the_product_name_should_be_displayed_in_the_cart_page(String string) {
		
		
	String productNameonCartsPage =	cartsPage.getproductNameOnCartsPage(string).split("-")[0].trim();
	
	Assert.assertEquals(productNameonCartsPage, test.LandingPageproductName);
	 
	}
	@Then("Apply and Place Order buttons should be visible on the Cart Page")
	public void apply_and_place_order_buttons_should_be_visible_on_the_cart_page() {
		
		System.out.println("Place Order");

	}
	
}

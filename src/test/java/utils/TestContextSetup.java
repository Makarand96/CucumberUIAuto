package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;

public class TestContextSetup {

	public WebDriver driver;
	public String LandingPageproductName;
	public PageObjectManager pom;
	public GenericUtils genericUtils;

	public TestBase testbase;

	public TestContextSetup() throws IOException {
		testbase = new TestBase();
		pom = new PageObjectManager(testbase.WebDriverManager()); /// Unkowingly here we are calling WebDriverManager
																	/// method , which invokes browser and launch
																	/// application, so we need not to use @Before hook as
																	/// precondition is satisfied here, also initially
																	/// in Landing Page Step definition file, we were
																	/// launching browser and application in @Given
																	/// step,so now step is empty, so from here we are
																	/// launching it.
		genericUtils = new GenericUtils(testbase.WebDriverManager());
	}

}

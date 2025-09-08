package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.devtools.v115.schema.model.Domain;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	
	TestContextSetup test;
	
	public Hooks(TestContextSetup test)
	{
		this.test=test;
	}
	
	
	@After
	public void teardown() throws IOException
	{
		 test.testbase.WebDriverManager().quit();
	}
	
	
	@AfterStep
	public void takeScreenshotforFailure(Scenario scenario) throws WebDriverException, IOException 
	{
		if (scenario.isFailed()) 
		{
		//	scenario.log(scenario.getName() + "  failed to execute");
			byte[] screenshot = ((TakesScreenshot) test.testbase.WebDriverManager()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", screenshot.toString());
		}

	}





}

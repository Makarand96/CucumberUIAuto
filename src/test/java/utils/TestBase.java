package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "//src//test//resources//global.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String browser_properties = prop.getProperty("browser");
			String browser_maven=  System.getProperty("browser");
			
			// result = testCondition ? value 1 : value2
			
				String browser =  browser_maven!=null ? browser_maven : browser_properties;
			
			if(driver==null)
			{
				if(browser.equalsIgnoreCase("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"//src//test//resources//chromedriver.exe");
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--remote-allow-origins=*");
					driver = new ChromeDriver(options);
				}
				else if(browser.equalsIgnoreCase("edge"))
				{
					System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") +"//src//test//resources//msedgedriver.exe");
					EdgeOptions options = new EdgeOptions();
					options.addArguments("--remote-allow-origins=*");
					driver = new EdgeDriver(options);
				}
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(prop.getProperty("url_qa"));
				driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
				return driver;
			}
			
			return driver;
		
		}

}
}

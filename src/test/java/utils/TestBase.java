package utils;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestBase {
	public WebDriver driver;

	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test/resources//global.properties");
		Properties properties= new Properties();
		properties.load(fis);
		String url = properties.getProperty("url_qa");
		
		
		
		if (driver == null) {
			
			if(properties.getProperty("browser").equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//src//test/resources//chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.get(url);
			driver.manage().window().maximize();
			return driver;
		}

		return driver;

	}

}

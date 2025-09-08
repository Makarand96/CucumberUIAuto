package utils;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void switchWindowToChild()
	{
		Iterator<String> it =  driver.getWindowHandles().iterator();

		String parentWindow=	it.next();
		String offerpageAdrress =it.next();
		
		driver.switchTo().window(offerpageAdrress);
	}
	
	public void switchToCartsPage()
	{
		Iterator<String> it =  driver.getWindowHandles().iterator();

		String parentWindow=	it.next();
		String offerpageAdrress =it.next();
		
		driver.switchTo().window(offerpageAdrress);
	}

}

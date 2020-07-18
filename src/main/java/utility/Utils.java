package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Utils {
	public static WebDriver driver=null;
	public static WebDriver openBrowser() {
		System.setProperty("webdriver.chrome.driver", 
				System.getProperty("user.dir")+File.separator+"chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		
		implicitWait();
		return driver;
	}
	private static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void selectFromDropDown(WebElement el,String value, String text) throws Exception {
		Select select=new Select(el);
		if(value.equals("selectByValue")) {
			select.selectByValue(text);
		}else if(value.equals("selectByIndex")) {
			int i=Integer.parseInt(text);
			select.selectByIndex(i);
		}else if(value.equals("selectByVisibleText")){
			select.selectByVisibleText(text);
		}else {
			throw new Exception("Selection from drop down parameter is incorrect!");
		}
	}
	public static void click(WebElement element) throws Exception {
		try
		{
		element.click();
		}
		catch(Exception e)
		{
			throw new Exception (e.getMessage());
		}
	}
	
	public static void setValue(WebElement element,String text) throws Exception {
		try
		{
		element.sendKeys(text);
		}
		catch(Exception e)
		{
			throw new Exception (e.getMessage());
		}
	}
	
	public static void javascriptClick(WebElement element) throws Exception {
		try
		{
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", element);  
		}
		catch(Exception e)
		{
			throw new Exception (e.getMessage());
		}
	}
	
	public static void switchWindowUsingNumber(int windowNumber) throws Exception
	{
	   if(windowNumber>=0)
	   {
	   String [] windowHandles = driver.getWindowHandles().toArray(new String [driver.getWindowHandles().size()]);
	   driver.switchTo().window(windowHandles[windowNumber]);
       }
	   else
	   {
		   throw new Exception("Window Number not provided");
	   }
	   
	}
	

}

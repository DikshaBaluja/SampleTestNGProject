package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageActions.HomePageActions;
import pageObjects.BaseClass;
import utility.Utils;
import utility.XmlReader;

public class TestCustomizeWebPage {
  WebDriver driver=null;
	@BeforeMethod
  public void openSession() throws Exception {
		driver=Utils.openBrowser();
		new BaseClass(driver);
    
		
	
  }
	
	  @Test
	  public void verifyUserIsAbleToSearchOnAmazon() throws Exception {
			
			HomePageActions.searchAmazon();
		    
		    
		    
		
	  }
	  
	  @AfterMethod
	  public void closeSession() throws Exception {
	     driver.quit();
			
		
	  }
	
   	
}

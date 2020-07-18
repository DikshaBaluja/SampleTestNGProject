package pageActions;

import pageObjects.HomePage;
import utility.Utils;
import utility.XmlReader;

public class HomePageActions {

	public static void searchAmazon () throws Exception
	{
		
		
		try {
			Utils.setValue(HomePage.AmazonSearchBox(),XmlReader.readXmlFile("SearchItem"));
		}catch(Exception e) {
			throw e;
		}
	}
}

package pom.urbanladder.testCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.urbanladder.testData.Excel_Collections;
// class to print Being at home collection Items
public class Urbanladder_Collections extends Urbanladder_Bookshelves
{
	@Test(groups="regression", priority=7)//includes regession test 
	void printCollections() throws Exception
	{
		ec=new Excel_Collections();
		driver.navigate().to(pb.URL()); //navigating back to the home page of the website
		//status for extent report
		if(driver.getTitle().equals("Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder"))
		{
			//for pass status
    			test.log(LogStatus.PASS, "Navigated to the home page of Urban Ladder successful");
		}
		else
		{ 
			//for fail status
			test.log(LogStatus.FAIL, "Navigated to the home page of Urban Ladder failed");
		}
		
		 logger.info("Navigated back to the Home Page");
		 
		 action = new Actions(driver);
		 //hover over the collections option
		 WebElement collectionHover = driver.findElement(By.xpath(pb.get_Collections()));
		 action.moveToElement(collectionHover).click().build().perform();
		 //extracting xpath of collections items
		 List<WebElement> list = driver.findElements(By.xpath(pb.get_CollectionList()));
		 Thread.sleep(2000);
		 //screenshot of being at home items
	        ss.takeSnapShot(driver, "./Screenshot/Being at home Items.jpg") ;
		 System.out.println("Total being at home collections :"+list.size());//printing the number of being at home items
		 
		 int i=1;
		 for(WebElement we : list) //for loop to extract the list of of items
		 {
			 String items = we.getText();
			 System.out.println(items);//printing the being at home items
			 ec.write_Collections(items,i++);
		 }
		 
		 
		 logger.info("13 Being at Home Collection items are displayed");
	}
	
}

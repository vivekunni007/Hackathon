package pom.urbanladder.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import pom.urbanladder.testData.Excel_Read;
import pom.urbanladder.testData.Excel_Write;
// class for printing the bookshelves
public class Urbanladder_Bookshelves extends Urbanladder_SetupDriver
{
	//method to search for the bookshelves page in the search box
	@Test(groups= {"smoke","regression"}, priority=0)
	void operationSearch() throws Exception
	{
		 logger.info("UrbanLadder Website  is opened");
		WebElement ele1 = driver.findElement(By.xpath(pb.get_Search()));
		ele1.sendKeys("bookshelves");
		driver.findElement(By.xpath(pb.get_Submit())).submit();
		ss.takeSnapShot(driver, "./Screenshot/BookShelves.jpg") ;
		
	}
	//method to choose the category as bookshelves
	@Test(groups= {"smoke","regression"}, priority=1)
	void operationCategory() throws InterruptedException
	{
		Thread.sleep(2000);
		 logger.info("BookShelf page is opened");
       action = new Actions(driver);
			 WebElement hover1 = driver.findElement(By.xpath(pb.get_Category()));
			 action.moveToElement(hover1).click().build().perform();
		
			 WebElement w1 = driver.findElement(By.xpath(pb.get_Category_select()));
			//status for extent report
			 if(w1.getText().equals("Bookshelves"))
				{//pass status
	        			test.log(LogStatus.PASS, "Category selected as Bookshelves is successful");
				}
				else
				{//fail status 
					test.log(LogStatus.FAIL, "Category selected as Bookshelves failed");
				}
			 
			 w1.click();
			 
			 
			 
			 logger.info("Category drop down is selected as bookshelves");
		
	}
	//method to set the price to maximum Rs 15,000
	@Test(groups="regression", priority=2)
	void operationPrice() throws InterruptedException
	{
			 Thread.sleep(1000);
			 WebElement hover3 = driver.findElement(By.xpath(pb.get_Price()));
			 action.moveToElement(hover3).click().build().perform();
			 Thread.sleep(2000);
			 WebElement slider = driver.findElement(By.xpath(pb.get_Price_select()));
			 Actions move = new Actions(driver);
		      //Thread.sleep(3000);
			 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   
			 Action action1 = (Action) move.dragAndDropBy(slider, -207, 0).build();
		     action1.perform();
		     
		     WebElement exPrice= driver.findElement(By.xpath("//span[contains(@class,'range-max')]"));
		     
		     //status foe Extent report
		     if(exPrice.getText().substring(1).equals("14,967"))
				{//pass status
	        			test.log(LogStatus.PASS, "Price selected as maximum Rs 15,000");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Price selection failed");
				}
		     
		     
		     logger.info("Price slider set to maximum Rs 15,000");
	}	 
	
	//method to select the storage type as 'open'
	@Test(groups="regression", priority=3)
	void operationStorage() throws InterruptedException
	{
			 
			 WebElement hover2 = driver.findElement(By.xpath(pb.get_Storagetype()));
			 action.moveToElement(hover2).click().build().perform();
			 Thread.sleep(2000);
			 WebElement w2 = driver.findElement(By.xpath(pb.get_Storage_select()));
					//status for Extent Report		 
			 if(w2.getText().equals("Open"))
				{//pass status 
	        			test.log(LogStatus.PASS, "Storage selected as Open succesful");
				}
				else
				{//fail status
					test.log(LogStatus.FAIL, "Storage selected as Open failed");
				}
			 w2.click();
			 
			 logger.info("Storage drop down is selected as open");
			
	}		
	
	//method for selecting the 'exclude ut of stock' option
	@Test(groups="regression", priority=4)// includes regression test
	void operationstock()
	{
		WebElement stock=driver.findElement(By.xpath(pb.get_Exclude_outofstock()));
		// status for extent report
		 if(stock.getText().equals("Exclude Out Of Stock"))
			{
			 //pass status
        			test.log(LogStatus.PASS, "Exclude out of stock selection successful");
			}
			else
			{
				//fail status
				test.log(LogStatus.FAIL, "Exclude out of stock selection failed");
			}
	     
		
		 stock.click();//selecting the desired option
		 logger.info("Exclude Out of stock box is selected");
	}
	
	//method to close the alert box if it pops up
	@Test(groups="regression", priority=5)
	void closePopUp() throws InterruptedException
	{
		Thread.sleep(2000);
	if(isAlertPresent(driver))
			 {
				 driver.findElement(By.xpath(pb.get_Popup())).click();
			 }
	}
	
	
	
	
	@Test(groups="regression", priority=6) //testNG annotation classified to group regression with priority 6
	void printBookShelves() throws Exception
	{
		ex=new Excel_Read();//object of the Excel_Read class to extract the xpath
		String strItems[]=ex.readFromExcel();//storing the xpath in a String array
		
		Thread.sleep(2000);
        ss.takeSnapShot(driver, "./Screenshot/Filtered Items.jpg") ; // taking a screenshot
	
        
        ew=new Excel_Write(); //object of the Excel_Read class to extract the xpath
       
	System.out.println("\n\n");
    System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    System.out.println("                                         ");
	WebElement shelf1_name = driver.findElement(By.xpath(strItems[0])); //storing the name of the bookshelf
	System.out.println("BookShelf Name : "+shelf1_name.getText()); // printing the name of the bookshelf
	WebElement shelf1_price = driver.findElement(By.xpath(strItems[1]));// storing the price of the bookshelf
	System.out.println("BookShelf Price : Rs "+shelf1_price.getText().substring(1)); //printing the price of the bookshelf
	System.out.println("                                         ");
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	
	ew.writeIntoExcel(shelf1_name.getText(),shelf1_price.getText(),1); //writing the bookshelf 1 data into excel 
	 
	
//	web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	System.out.println("\n");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	System.out.println("                                         ");
	WebElement shelf2_name = driver.findElement(By.xpath(strItems[2]));// storing the name of the bookshelf
	System.out.println("BookShelf Name  : "+shelf2_name.getText()); //printing the name of the bookshelf
	WebElement shelf2_price = driver.findElement(By.xpath(strItems[3]));//storing the price
	System.out.println("BookShelf Price : Rs "+shelf2_price.getText().substring(1));//printing the price
	System.out.println("                                         ");
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
//	web.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	ew.writeIntoExcel(shelf2_name.getText(),shelf2_price.getText(),2); // writing the bookshelf 2 data into excel
	
	
	System.out.println("\n");
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	System.out.println("                                               ");
	WebElement shelf3_name = driver.findElement(By.xpath(strItems[4]));// storing the bookshelf 3 name
	System.out.println("BookShelf Name : "+shelf3_name.getText()+""); // printing the bookshelf 3 name
	WebElement shelf3_price = driver.findElement(By.xpath(strItems[5]));//storing the price
	System.out.println("BookShelf Price : Rs "+shelf3_price.getText().substring(1));//printing the price
	System.out.println("                                               ");
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	
	ew.writeIntoExcel(shelf3_name.getText(),shelf3_price.getText(),3);// writing the bookshelf 3 data into excel
	logger.info("Bookshelf 1 is printed");
	logger.info("Bookshelf 2 is printed");
	logger.info("Bookshelf 3 is printed");
	System.out.println("\n\n");
	}
	
    
}

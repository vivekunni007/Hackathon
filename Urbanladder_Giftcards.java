package pom.urbanladder.testCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;

public class Urbanladder_Giftcards extends Urbanladder_Collections
{
	//method to choose the occasion
	@Test(groups="regression",priority=8)
	void select_GiftsCards() throws Exception
	{
		
		driver.findElement(By.xpath(pb.get_GiftCards())).click();
		//status for Extent report
		if(driver.getTitle().equals("Gift Card - Buy Gift Cards & Vouchers Online for Wedding, Birthday | Urban Ladder"))
		{//pass status
				test.log(LogStatus.PASS, "Navigated to Gift Cards page");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Navigation to Gift Cards failed failed");
		}
		//scrolling the page
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		 jse.executeScript("window.scrollBy(0,600)");
		 Thread.sleep(2000);
	        ss.takeSnapShot(driver, "./Screenshot/Giftcards.jpg") ;
		 
	        logger.info("Navigated to gift cards page");
	        
		WebElement occ=driver.findElement(By.xpath(pb.get_Occassion()));
		occ.click();
		
		if(occ.getText().equals("Gift something memorable to help them celebrate great memories!"))
			{
     			test.log(LogStatus.PASS, "Occassion selected as birthday/anniversary");
			}
			else
			{
				test.log(LogStatus.FAIL, "Occassion not selected as birthday/anniversary");
			}
		 logger.info("Occassion selected as Birthday/Anniversary");
	}
	
	
	//method to customize the gift card
	@Test(groups="regression",priority=9)//includes regression tests
	void fill_GiftsCards() throws Exception
	{
		 driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);  
		 WebElement amt=driver.findElement(By.xpath(pb.get_Amount()));//extracting the xpath to select the amount
		 amt.click();
		 //status for extent report
		 if(amt.getText().equals("₹ 5000"))
			{
			 //pass status
  			test.log(LogStatus.PASS, "Amount selected as Rs 5000");
			}
			else
			{
				//fail status
				test.log(LogStatus.FAIL, "Amount not selected as Rs 5000");
			}
		 
		 logger.info("Amount set to Rs 5000");
		 //selecting the desired date to deliver the card
		 //Select date = new Select(driver.findElement(By.xpath(pb.get_Date())));
		 //date.selectByVisibleText("25");
		 WebElement month=driver.findElement(By.xpath(pb.get_Month()));
		 //status for extent report
		 if(month.getText().equals("Nov (2020)"))
			{
			 //pass status
  			test.log(LogStatus.PASS, "Date selected as November 2020");
			}
			else
			{
				//fail status
				test.log(LogStatus.FAIL, "Date not selected as November 2020");
			}
		 
		 logger.info("Date set to November 2020");
		 //selecting the next option to proceed to the mext step
		 WebElement nxt=driver.findElement(By.xpath(pb.get_Next()));
		nxt.click();
		//status for extent report
		if(nxt.getText().equals("NEXT"))
			{
			//pass status
 			test.log(LogStatus.PASS, "Proceeded to the next step for recipient's and sender's details");
			}
			else
			{
				//fail status
				test.log(LogStatus.FAIL, "Not proceeded to the next step for recipient's and sender's details");
			}
	}
	//method to fill the gift cards form
	@Test(groups="regression",priority=10)
	void fillForm() throws Exception
	{
	 System.out.println("Form details are: ");
	 //filling the receipient's details
	 WebElement name1=driver.findElement(By.xpath(pb.get_RecipientName()));
	 name1.sendKeys("Eshani Roy");//recepient's name
	String strName1 = driver.findElement(By.xpath(pb.get_RecipientName())).getAttribute("value");
	 System.out.println("Receipient name :"+strName1);//printing recepient's name
	 //status for extent report
	 if(strName1.equals("Eshani Roy"))
		{//pass status
		test.log(LogStatus.PASS, "Recipient's name entered");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Recipient's name not entered");
		}
	 
	 
	 //filling the form starting from recepient's name
	 WebElement email1=driver.findElement(By.xpath(pb.get_RecipientEmail()));
	 email1.sendKeys("royeshani@gmail.com");//filling recepient's email id
	 String strEmail1 = driver.findElement(By.xpath(pb.get_RecipientEmail())).getAttribute("value");
	 System.out.println("Receipient's email :"+strEmail1);//printing recepient's email id
	 //status for extent report
	 if(strEmail1.equals("royeshani@gmail.com"))
		{//pass status
		test.log(LogStatus.PASS, "Recipient's email id entered");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Recipient's email id not entered");
		}
	 
	 //Sender's details
	 WebElement name2=driver.findElement(By.xpath(pb.get_Custname()));
	 name2.sendKeys("Shayoni Roy");//filling sender's name
	 String strName2 = driver.findElement(By.xpath(pb.get_Custname())).getAttribute("value");
	 System.out.println("Sender's name :"+strName2);//printing sender's name
	 //status for extent report
	 if(strName2.equals("Shayoni Roy"))
		{//pass status
		test.log(LogStatus.PASS, "Sender's name entered");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Sender's name not entered");
		}
	 
	 
	 
	 WebElement email2=driver.findElement(By.xpath(pb.get_Custemail()));
	 email2.sendKeys("shayoni@gmailcom");//filling sender's email id
	 String strEmail2 = driver.findElement(By.xpath(pb.get_Custemail())).getAttribute("value");
	 System.out.println("Sender's email :"+strEmail2);//printing sender's email id
	 //status for extent report
	 if(strEmail2.equals("shayoni@gmailcom"))
		{//pass status
		test.log(LogStatus.PASS, "Sender's email entered");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Sender's email not entered");
		}
	 
	 
	 
	 WebElement mobile=driver.findElement(By.xpath(pb.get_Mobile()));
	 mobile.sendKeys("8789782180");//filling sender's mobile number
	 String strmob = driver.findElement(By.xpath(pb.get_Mobile())).getAttribute("value");
	 System.out.println("Mobile number :"+strmob);//printing sender's mobile number
	 //status for extent report
	 if(strmob.equals("8789782180"))
		{//pass status
		test.log(LogStatus.PASS, "mobile number entered");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Mobile number not entered");
		}
	 
	 
	 
	 WebElement message=driver.findElement(By.xpath(pb.get_Msg()));
	 message.sendKeys("Happy Birthday!");//filing the message to be delivered
	 String strmsg = driver.findElement(By.xpath(pb.get_Msg())).getAttribute("value");
	 System.out.println("Message :"+strmsg);//printing the message to be delivered
	 //status for extent report
	 if(strmsg.equals("Happy Birthday!"))
		{//pass status
		test.log(LogStatus.PASS, "Message written successfully");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Message not written");
		}
	
	 logger.info("Details of the form are filled");
	 
	 ss.takeSnapShot(driver, "./Screenshot/Filled form.jpg") ;//screenshot the the filled form
	 
	 WebElement confirmation=driver.findElement(By.xpath(pb.get_Confirmation()));
	 confirmation.click();
	 //status for extent report
	 if(confirmation.getText().equals("CONFIRM"))
		{//pass status
		test.log(LogStatus.PASS, "Confirmation of form fill up successful");
		}
		else
		{//fail status
			test.log(LogStatus.FAIL, "Confirmation of form fill up not successful");
		}
	 
	 Thread.sleep(2000);
	 WebElement payment=driver.findElement(By.xpath(pb.get_Payment()));
	 payment.click();
	 
	 if(payment.getText().equals("PROCEED TO PAYMENT"))
		{
		test.log(LogStatus.PASS, "No Error: Payment Successful");
		}
		else
		{
			test.log(LogStatus.FAIL, "Error: Payment unsuccessful");
		}
	 
	 ss.takeSnapShot(driver, "./Screenshot/Error message.jpg") ; //screenshot the the error message 
	 
	String errorMessage=driver.findElement(By.xpath(pb.get_Error())).getText();
	//status for extent report
	if(errorMessage.equals("Customer email is invalid"))
	{//pass status
	test.log(LogStatus.PASS, "Error message captured");
	}
	else
	{//fail status
		test.log(LogStatus.FAIL, "No error message captured");
	}
	
	System.out.println("Error Message :"+errorMessage);//printing the error message
	
}
	
	
	//method to amend the error
	@Test(groups= "regression",priority=11)
	void rectify_GiftCards() throws Exception
	{
		driver.findElement(By.xpath(pb.get_EditButton())).click();
		 WebElement email2=driver.findElement(By.xpath(pb.get_Custemail()));
		 email2.clear();
		 email2.sendKeys("shayoni@gmail.com");//coorect email id entered
		 String strerror= driver.findElement(By.xpath(pb.get_Custemail())).getAttribute("value");
		 System.out.println("Receipient name :"+strerror);
		 //status for extent report
		 if(strerror.equals("shayoni@gmail.com"))
			{//pass status
			test.log(LogStatus.PASS, "Email id rectified");
			}
			else
			{//fail status
				test.log(LogStatus.FAIL, "Email id not rectified");
			}
		 
		 logger.info("Email id rectified");
		 
		 Thread.sleep(3000);
         driver.findElement(By.xpath(pb.get_Confirmation())).click();
		 
         Thread.sleep(2000);
		 WebElement payment2=driver.findElement(By.xpath(pb.get_Payment()));
		 payment2.click();
		 if(payment2.getText().equals("REDIRECTING TO PAYMENT GATEWAY"))
			{
			test.log(LogStatus.PASS, "No Error: Payment Successful after retesting");
			}
			else
			{
				test.log(LogStatus.FAIL, "Error: Payment still unsuccessful");
			}
		Thread.sleep(7000);
		String rectifier=driver.findElement(By.xpath(pb.get_rectifier())).getText();
	    System.out.println("Error Rectified :"+rectifier); 
		ss.takeSnapShot(driver, "./Screenshot/Rectified error.jpg") ;
	}
	//method to close the browser
	 @AfterClass(groups= {"smoke","regression"})
	  void closeBrowser() throws InterruptedException 
	  {
		  Thread.sleep(2000);
		  driver.close();
		  report.endTest(test);
		  report.flush();
		
	  }

}

package pom.urbanladder.testCases;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pom.urbanladder.testData.Excel_Collections;
import pom.urbanladder.testData.Excel_Read;
import pom.urbanladder.testData.Excel_Write;
import pom.urbanladder.utils.Urbanladder_PropertyMethods;
import pom.urbanladder.utils.Urbanladder_Screenshots;
//class to setup driver and to open the browser
public class Urbanladder_SetupDriver 
{
	Excel_Read ex; // object of the Excel_Read class
	Excel_Write ew; //object of the Excel_Write class
	Excel_Collections ec; //object of the Excel_Collections class
	 Urbanladder_PropertyMethods pb = new Urbanladder_PropertyMethods(); //creating object of Property_Methods class
	 
	 public static Logger logger; //object of Logger class
	 
	 static ExtentTest test; //object of ExtentTest class 
	 static ExtentReports report;// object of ExtentReports class
	 
	  Urbanladder_Screenshots ss = new Urbanladder_Screenshots();
	 
	public static boolean isAlertPresent(WebDriver driver)
    {
		//check whether alert box displays on the screen
        try
        {
            driver.switchTo().alert();
            return true;
        }   // try
        catch (NoAlertPresentException Ex)
        {
            return false;
        }   // catch
		
    }
	
	static WebDriver driver;
 // ******************************************************************************************** 
	
		@BeforeTest(groups= {"smoke","regression"})
		 @Parameters("browser")
		void setupDriver(String browser) throws Exception
		{
			pb.properties();
			logger=Logger.getLogger("Urbanladder_SetupDriver");
			PropertyConfigurator.configure("Log4j.properties");
			  //for firefox browser		
			if(browser.equals("firefox"))
			{
				//create firefox instance
				//for Jenkins
//				
				//setting the firefox capabilities
		    	FirefoxOptions options = new FirefoxOptions(); 
		    	options.setBinary(pb.get_mozillaPath());
		    	System.setProperty(pb.gecko_Driver(),System.getProperty("user.dir")+pb.get_geckodriverPath() );
			    driver = new FirefoxDriver(options);
			    logger.info("Firefox is opened");
//			    
			    /////////////////////////////////////////////////
			    //for Grid
//				FirefoxOptions options = new FirefoxOptions();
//			    DesiredCapabilities cap = new DesiredCapabilities();
//				cap.setBrowserName("firefox");
//				cap.setPlatform(Platform.LINUX);
//				options.merge(cap);
//				
//				String hubUrl = "http://192.168.56.102:21529/wd/hub";
//				
//				System.setProperty(pb.gecko_Driver(),System.getProperty("user.dir")+pb.get_geckodriverPath());
//			    driver = new RemoteWebDriver(new URL(hubUrl), options);
//			    
//			    logger.info("Firefox is opened");
			    
			    //**************************************
			    
				
			}
			//Check if parameter passed as 'chrome'
			//Jenkins
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				//setting the chrome capabilities
				
			ChromeOptions chromeOptions= new ChromeOptions();
		    chromeOptions.setBinary(pb.get_chromePath());

			System.setProperty(pb.chrome_Driver(),System.getProperty("user.dir")+pb.get_chromedriverPath());
			logger.info("hiiiiiii"+System.getProperty("user.dir")+pb.get_chromedriverPath());
			driver = new ChromeDriver();
		    logger.info("Google Chrome is opened");
				
				
				 
// #####################################################
				
//		For Grid		
//				DesiredCapabilities cap = new DesiredCapabilities();
//				cap.setBrowserName("chrome");
//				cap.setPlatform(Platform.LINUX);
//				
//				ChromeOptions options = new ChromeOptions();
//				options.merge(cap);
//				
//				String hubUrl = "http://192.168.56.102:24902/wd/hub";
//				
//			    driver = new RemoteWebDriver(new URL(hubUrl), options);
//				logger.info("Google Chrome is opened");
				
				//*********************************************
			}
//			//Check if parameter passed as 'opera'
			else if(browser.equalsIgnoreCase("opera")){
				//set path to chromedriver.exe
				System.setProperty(pb.opera_Driver(), System.getProperty("user.dir")+pb.get_operadriverPath());
				//OperaOptions operaOptions = new OperaOptions();
				//operaOptions.setBinary(pb.get_operaPath());
				driver = new OperaDriver();
				logger.info("Opera is opened");
			}
			
			
				else{
					//If no browser passed throw exception
					throw new Exception("Browser is not correct");//handling exceptions
				}

			//seting the extent report path
			 report = new ExtentReports(System.getProperty("user.dir")+"\\target\\ExtentReportResults.html",false);    //pb.get_ExtentReport());
			 //logging the test steps
			 test = report.startTest("Urbanladder_SetupDriver");
			 
			
			
		}
		
         //OPEN BROWSER
		static Actions action;
	    @BeforeClass(groups= {"smoke","regression"})
	   void openBrowser() throws Exception
	    {
	    	  		
			
	    	driver.get(pb.URL()); //get the web site
	   // 	driver.navigate().refresh();

	    	driver.manage().window().maximize();
	  //checking for extent report status 
	    	if(driver.getTitle().equals("Furniture Online: Buy Home Wooden Furniture Online In India At Best Price - Urban Ladder - Urban Ladder"))
			{//pass status 
	    			test.log(LogStatus.PASS, "Navigated to the home page of Urban Ladder successful");
			}
			else
			{//fail status 
				test.log(LogStatus.FAIL, "Navigated to the home page of Urban Ladder failed");
			}
	    	

	    	ss.takeSnapShot(driver, "./Screenshot/Home Page.jpg");
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	Thread.sleep(10000);
			driver.findElement(By.xpath(pb.get_Popup())).click();
			
	    }

	    
	    
		

}

package com.company.app.common;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class BaseTest {
	public static WebDriver driver = null;; 
	public static ExtentTest logger;
	static ExtentReports report;
	
	
	public static WebDriver getBrowser(String browser) {
		String driverPath = System.getProperty("user.dir")+"/servers/";
		System.out.println(driverPath);
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
			return driver = new FirefoxDriver();
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			return driver = new ChromeDriver(options);
		case "IE":
			System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
			return driver = new org.openqa.selenium.ie.InternetExplorerDriver();
		default:
			System.out.println("browser : " + browser + " is invalid, Launching Firefox as browser of choice..");
			return driver = new FirefoxDriver();
		}
	}
	
	
	@BeforeSuite
	public static void startTest()
	{
	report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	logger = report.startTest("Reporting Starts...");
	}
	
	@Parameters({ "browser", "url" })
	@BeforeClass
    public void launchBrowser(String browser,String url) throws Exception {
	
        System.out.println("launching browser..."); 
         getBrowser(browser);
         driver.get(url);
         logger.log(LogStatus.INFO, "Application is up and running");
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
	


	
	@AfterClass
    public void tearDown(){
        driver.close();
        report.endTest(logger);
        report.flush();
        
        
	}

}

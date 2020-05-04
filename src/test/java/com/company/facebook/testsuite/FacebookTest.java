package com.company.facebook.testsuite;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriverInfo;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.company.app.common.BaseTest;
import com.company.app.utility.Utility;
import com.company.facebook.pages.FBHomePage;
import com.company.facebook.pages.FBLoginPage;
import com.company.facebook.pages.FacebookConstantspage;
import com.company.wallethub.pages.HomePage;
import com.company.wallethub.pages.ProfilePage;
import com.company.wallethub.pages.TestInsuranceCompanyRatingPage;
import com.company.wallethub.pages.WalletHubConstantsPage;
import com.company.wallethub.pages.WalletHubLoginPage;
import com.relevantcodes.extentreports.LogStatus;



public class FacebookTest extends BaseTest{
	
	FBLoginPage objLogin;
	FBHomePage objHome;
	ProfilePage objProfile; 
	
	// Assignment Step -  1
	@Parameters({ "username", "password" })
	@Test(priority = 0)
	public void verifyLogin(String user, String pwd) throws InterruptedException {
		// Create Login Page object
		objLogin = new FBLoginPage(driver);

		// Verify login page title
		System.out.println("Login Page Title :: " + objLogin.getLoginTitle());
		
		Assert.assertEquals(objLogin.getLoginTitle(),FacebookConstantspage.loginPageTitle);
		logger.log(LogStatus.PASS, "FB Login Page - Title is verified");
		
		//Login to application
		objLogin.loginToApplication(user, Utility.decodePwd(pwd));
				
		// Go the next page
		objHome = new FBHomePage(driver);  
	    
		//Verify home page
		System.out.println("Home Page Title :: " +objHome.getHomePageTitle());
	    Assert.assertTrue(objHome.getHomePageTitle().equals(FacebookConstantspage.homePageTitle));  
	    logger.log(LogStatus.PASS, "Login is Successful and navigated to Home Page -Test Insurance Company");
	       
	 }
	
	
	// Assignment Step -  2
	@Test(priority = 1)
	public void postStatusMessage() throws InterruptedException, AWTException {
		// Create object
		objHome = new FBHomePage(driver);	
		
		//objHome.txtCreatePost.click();
		objHome.txtCreatePost.sendKeys(FacebookConstantspage.statusMessage);
		
		//Click on Post button
		objHome.btnPost.click();
		logger.log(LogStatus.PASS, "Status Message Posted...");
		
		//Wait
		Thread.sleep(4000);

		//Click on Account Settings
		objHome.AccountSettings.click();

		//Click on Log out button
		WebDriverWait wait = new WebDriverWait(driver, 8);
		WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out")));
		logout.click();
		logger.log(LogStatus.PASS, "Logged Out Successfully...");
		
	 }

	


}

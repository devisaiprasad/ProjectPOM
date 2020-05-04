package com.company.wallethub.testsuite;

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
import com.company.wallethub.pages.HomePage;
import com.company.wallethub.pages.ProfilePage;
import com.company.wallethub.pages.TestInsuranceCompanyRatingPage;
import com.company.wallethub.pages.WalletHubConstantsPage;
import com.company.wallethub.pages.WalletHubLoginPage;
import com.relevantcodes.extentreports.LogStatus;



public class WalletHubTest extends BaseTest{
	
	WalletHubLoginPage objLogin;
	HomePage objHome;
	TestInsuranceCompanyRatingPage objTestInsCompRating;
	ProfilePage objProfile; 
	
	// Assignment Step -  1
	@Parameters({ "username", "password" })
	@Test(priority = 0)
	public void verifyLogin(String user, String pwd) throws InterruptedException {
		// Create Login Page object
		objLogin = new WalletHubLoginPage(driver);

		objLogin.clickUserLogin();
		// Verify login page title
		System.out.println("Login Page Title :: " + objLogin.getLoginTitle());
		Assert.assertEquals(objLogin.getLoginTitle(), WalletHubConstantsPage.loginTitle);
		logger.log(LogStatus.PASS, "Login Page Title verified");
		//Login to application
		objLogin.loginToApplication(user, Utility.decodePwd(pwd));
				
		// Go the next page
		objHome = new HomePage(driver);  
	      
		//Verify home page
	    Assert.assertTrue(objHome.getHomePageTitle().equals(WalletHubConstantsPage.testInsuranceTitle));  
	    logger.log(LogStatus.PASS, "Login is Successful and navigated to Home Page -Test Insurance Company");
	       
	 }
	
	// Assignment Step -  2
	@Test(priority = 1)
	public void VerifyTestInsuranceCompanyRatingPage() throws InterruptedException {
		// Createobject
		objHome = new HomePage(driver);
		objTestInsCompRating = new TestInsuranceCompanyRatingPage(driver);
		
		//Mouseover on submit button    
        Utility.mouseHover(driver, objHome.Rating4);
		
        //Click on Rating 4
		objHome.Rating4.click();
		Assert.assertTrue(objTestInsCompRating.getTestInsuranceCompanyRatingTitle().equals(WalletHubConstantsPage.testInsuranceTitle));  
		logger.log(LogStatus.PASS, "Navigated to Test Insurance Company Rating Page...");		
	       
	 }
	
	
	// Assignment Step -  3,4,5
	@Test(priority = 2)
	public void provideRating() throws InterruptedException {
		// Create object
		objTestInsCompRating = new TestInsuranceCompanyRatingPage(driver);
		//Select Dropdown
		objTestInsCompRating.ddlPolicy.click();
		Utility.selectDropdown(objTestInsCompRating.lstPolicy, "Health Insurance");
		
		//Enter Review Comments
		objTestInsCompRating.txtWriteReview.click();
		objTestInsCompRating.txtWriteReview.sendKeys(WalletHubConstantsPage.reviewComments);
	       
		//Click on Submit button
		objTestInsCompRating.btnSubmit.click();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "Rating Submitted...");
	 }

	
	// Assignment Step -  6
	@Test(priority = 3)
	public void verifyProfile() throws InterruptedException {
		// Createobject
		objHome = new HomePage(driver);
		objProfile = new ProfilePage(driver);
		//Mouse Hover
		Utility.mouseHover(driver, objHome.ddlMyMenu);
		
		//Select Profile
		objHome.linkProfile.click();
	       
		//verify Recommendatiom
		objProfile.eleRecommendations.isDisplayed();
		logger.log(LogStatus.PASS, "Recommendatiom displayed...");
		
		}

}

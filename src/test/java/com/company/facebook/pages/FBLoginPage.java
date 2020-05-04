package com.company.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPage {
WebDriver driver;
	

	@FindBy(xpath="//input[@type='email']")
	public WebElement txtUsername;
	
	@FindBy(xpath="//input[@type='password']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Log In']")
	public WebElement btnLogin;
	
	public FBLoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
    //Set user name in textbox
    public void setUserName(String strUserName){
    	txtUsername.sendKeys(strUserName);     
    }
    
    //Set password in password textbox
    public void setPassword(String strPassword){
    	txtPassword.sendKeys(strPassword);
    }
    
  //Click on login button
    public void clickLogin(){
    	btnLogin.click();
    }  
    
    public String getLoginTitle(){
        return driver.getTitle();
      }
    
    
    public void loginToApplication(String strUserName,String strPasword) throws InterruptedException{

        //Fill user name
        setUserName(strUserName);

        //Fill password
        setPassword(strPasword);

        //Click Login button
        clickLogin();           
        Thread.sleep(5000);
    }
}

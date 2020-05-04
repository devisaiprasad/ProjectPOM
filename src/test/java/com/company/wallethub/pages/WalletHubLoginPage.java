package com.company.wallethub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WalletHubLoginPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='brgm-button brgm-signup']")
    public WebElement btnUserLogin;
	
	@FindBy(xpath="//input[@type='text' and @name='em']")
	public WebElement txtUsername;
	
	@FindBy(xpath="//input[@type='password' and @name='pw']")
	public WebElement txtPassword;
	
	@FindBy(xpath="//label[@class='toggle inline-block small']")
	public WebElement chkRememberByEmail;
	
	@FindBy(xpath="//button[@class='btn blue center reg-tabs-bt touch-element-cl']")
	public WebElement btnLogin;
	
	public WalletHubLoginPage(WebDriver driver){
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
    
    //Click on Remember my email button
    public void rememberMyEmail(){
    	chkRememberByEmail.click();
    } 

    //Click on login button
    public void clickLogin(){
    	btnLogin.click();
    }  
    
    public void clickUserLogin(){
    	btnUserLogin.click();
    }  

    public String getLoginTitle(){
      return driver.getTitle();
    }
    
    public void loginToApplication(String strUserName,String strPasword){

        //Fill user name
        setUserName(strUserName);

        //Fill password
        setPassword(strPasword);

        //Click Login button
        clickLogin();           

    }


}

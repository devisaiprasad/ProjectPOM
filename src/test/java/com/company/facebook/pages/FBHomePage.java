package com.company.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FBHomePage {
	
WebDriver driver;
	

	//@FindBy(xpath="//div[contains(@id,'placeholder-')]")
	//@FindBy(xpath="//div[contains(text(),'Write something here...')]")
	@FindBy(xpath="//textarea[@name='xhpc_message']")
	public WebElement txtCreatePost;
	
	@FindBy(xpath="//span[text()='Post']")
	public WebElement btnPost;
	
	@FindBy(xpath="//*[@id='userNavigationLabel']")
	public WebElement AccountSettings;
	
	public FBHomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
	 public String getHomePageTitle(){
	        return driver.getTitle();
	      }

}

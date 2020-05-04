package com.company.wallethub.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	WebDriver driver;
	
	@FindBy(xpath="//h1[text()='Test Insurance Company']")
	public WebElement HomePageTitle;
	
	
	@FindBy(xpath="//a[text()='Test Insurance Company']")
	public WebElement eleRecommendations;
	
	public ProfilePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }

}

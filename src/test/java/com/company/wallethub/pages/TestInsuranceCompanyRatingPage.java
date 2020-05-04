package com.company.wallethub.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestInsuranceCompanyRatingPage {
	WebDriver driver;
	
	@FindBy(xpath="//h4[text()='Test Insurance Company']")
	public WebElement TestInsuranceCompanyRatingTitle;
	
	@FindBy(xpath="//div[@class='dropdown second']")
	public WebElement ddlPolicy;
	
	@FindBy(xpath="//ul[@class='dropdown-list ng-enter-element' and @ng-reflect-hidden='false']")
	public WebElement lstPolicy;
	
	@FindBy(xpath="//textarea[@class='textarea wrev-user-input validate']")
	public WebElement txtWriteReview;
	
	@FindBy(xpath="//div[text()='Submit']")
	public WebElement btnSubmit;
	
	
	public TestInsuranceCompanyRatingPage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	public String getTestInsuranceCompanyRatingTitle(){
		      return TestInsuranceCompanyRatingTitle.getText();
	 }
	
	
	
	
	
	
}
	
	
	
	
	
	
	
	



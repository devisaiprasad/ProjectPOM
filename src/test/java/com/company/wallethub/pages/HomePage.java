package com.company.wallethub.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
	@FindBy(xpath="//h1[text()='Test Insurance Company']")
	public WebElement HomePageTitle;
	
	@FindBy(xpath="//*[@width='38'][last()-1]")
	public WebElement Rating4;
	
	@FindBy(xpath="//review-star[@class='rvs-svg' and @ng-reflect-svg_stp='1']")
	public WebElement RatingValue;
	
	@FindBy(xpath="//div[@class='brgm-button brgm-user brgm-list-box']/span")
	public WebElement ddlMyMenu;
	
	@FindBy(xpath="//a[@class='brgm-list-it' and @href='/profile/devisaiprasad']")
	public WebElement linkProfile;
	
	
	
	
	public HomePage(WebDriver driver){
        this.driver = driver;
        //This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
	
	   public String getHomePageTitle(){
		      return HomePageTitle.getText();
	 }
	
	
	
	
	
	
	
	

}

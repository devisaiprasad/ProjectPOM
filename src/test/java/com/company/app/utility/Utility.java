package com.company.app.utility;

import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map.Entry;

import java.util.Properties;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility {
	//static WebDriver driver;
	
	public static Set<Entry<Object, Object>> readPropertyFile(String fileLocation)throws Exception{  
	    FileReader reader=new FileReader(fileLocation);  
	    Properties p=new Properties();  
	    p.load(reader);   
	    
	    System.out.println(p.entrySet());
		return  p.entrySet();
		
	}  
	
	public static String decodePwd(String str) {
       // Decode a previously encoded string using decodeBase64 method and
        byte[] decoded = Base64.decodeBase64(str.getBytes());

        // Convert the decoded byte[] back to the original string and print
        String decodedString = new String(decoded);
        
       // System.out.println("Pwd = " + decodedString);
		return decodedString;
    }
	
	
	public static void selectDropdown(WebElement dropdown, String searchText){
		//dropdown.click(); // assuming you have to click the "dropdown" to open it
		List<WebElement> options = dropdown.findElements(By.tagName("li"));
		for (WebElement option : options)
		{
		    if (option.getText().equals(searchText))
		    {
		        option.click(); // click the desired option
		        break;
		    }
		}
	
	
	}
	
	public static void mouseHover(WebDriver driver, WebElement element){
		 Actions action = new Actions(driver);
	     action.moveToElement(element).perform();
	}
	
	public static void handleConfirmationAlert(WebDriver driver, String str){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		  wait.until(ExpectedConditions.alertIsPresent());
		if(str.equalsIgnoreCase("yes")) {
			driver.switchTo().alert().accept();
		}else if(str.equalsIgnoreCase("no")) {
			driver.switchTo().alert().dismiss();
		}
		 
	}

}

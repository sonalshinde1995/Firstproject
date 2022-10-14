package com.bankingproject.pageobjectclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_POM {
	
	public WebDriver ldriver;
	
	@FindBy(xpath="//input[@name='uid']")
	WebElement UserID;
	
	@FindBy(xpath="//input[@name='password']") 
	WebElement Password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement Loginbutton;
	
	@FindBy(xpath="//input[@name='btnReset']")
	WebElement Reset;
	
	
	  public LoginPage_POM(WebDriver rdriver)
	{
		this.ldriver=rdriver;
	    PageFactory.initElements(rdriver, this);
	    
	}
	
   public void setUsername(String name)
   {
	   UserID.sendKeys(name);
   }
   
   public void setpassword(String pass)
   {
	   Password.sendKeys(pass);
   }
   public void loginbutton()
   {
	   Loginbutton.click();
   }
   public void resetbutton()
   {
	   Reset.click();
   }
}

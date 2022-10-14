package com.bankingproject.testclass;



import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.bankingproject.pageobjectclass.BaseClass;
import com.bankingproject.pageobjectclass.LoginPage_POM;

public class LoginpageVerification extends BaseClass {
	@Test

	public  void Loginpage() throws IOException {
		LoginPage_POM login = new LoginPage_POM(driver);

		test = extent.createTest("Verify application Login");
		
		test.log(Status.PASS, "Application URL Open Successfully");

		login.setUsername(username);
		test.log(Status.PASS, "Username Successfully Entered");

		login.setpassword(password);
		test.log(Status.PASS, "password Successfully Entered");
		login.loginbutton();
		test.log(Status.PASS, "clicked on loginbutn");
		
		String expectedTitle = "GTPL Bank Manager Homepage";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle))
		{
			test.log(Status.PASS,"title verifird and user loggedin successfully" );
			
		}
		else
	
		{
			test.log(Status.FAIL,"Login failed");
			String screenshotpath= BaseClass.captureScreen();
			test.addScreenCaptureFromPath(screenshotpath);
		}
		
			
		}
	}



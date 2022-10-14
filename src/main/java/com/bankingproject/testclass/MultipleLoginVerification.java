package com.bankingproject.testclass;

import java.io.IOException;

import org.testng.annotations.Test;

import com.bankingproject.pageobjectclass.BaseClass;
import com.bankingproject.pageobjectclass.LoginPage_POM;
import com.bankingproject.utilities.Exceldata;

public class MultipleLoginVerification extends BaseClass {
	
	@Test
	
	public void firstLoginTest() throws IOException
	{
		
		LoginPage_POM login = new LoginPage_POM(driver);
		driver.get(baseURL);
		login.setUsername(Exceldata.getdata(1,0));
		
		login.setpassword(Exceldata.getdata(1,1));
		
		login.loginbutton();
		
	}
	@Test
	public void SecondLoginTest() throws IOException
	{
		
		LoginPage_POM login = new LoginPage_POM(driver);
		driver.get(baseURL);
		login.setUsername(Exceldata.getdata(2,0));
		
		login.setpassword(Exceldata.getdata(2,1));
		
		login.loginbutton();
		
	}
	@Test
	public void ThirdLoginTest() throws IOException
	{
		
		LoginPage_POM login = new LoginPage_POM(driver);
		driver.get(baseURL);
		login.setUsername(Exceldata.getdata(3,0));
		
		login.setpassword(Exceldata.getdata(3,1));
		
		login.loginbutton();
		
	}
	@Test
	public void FourthLoginTest() throws IOException
	{
		
		LoginPage_POM login = new LoginPage_POM(driver);
		driver.get(baseURL);
		login.setUsername(Exceldata.getdata(4,0));
		
		login.setpassword(Exceldata.getdata(1,1));
		
		login.loginbutton();
		
	}
}

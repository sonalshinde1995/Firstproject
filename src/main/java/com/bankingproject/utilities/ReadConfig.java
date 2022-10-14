package com.bankingproject.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig(){
	
	File src=new File("C:\\Users\\Sanket Shinde\\eclipse-workspace\\Project54321\\Configuration\\config.properties");
    FileInputStream file  ;
    try {
	 pro=new Properties();
	 file=new FileInputStream(src);
	pro.load(file);
    }
    catch(Exception e)
    {
    	e.printStackTrace();
    }
	 
	
}
	public String getApplicationURL()
	{
	String url =pro.getProperty("baseURL");
	return url;
	}
	public String getUserName()
	{
		String username=pro.getProperty("username");
		return username;
	}
	public String getPassword() 
	{
		String password=pro.getProperty("password");
		return password;
	}
}

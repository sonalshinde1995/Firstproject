package com.bankingproject.pageobjectclass;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bankingproject.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();

	public static WebDriver driver;
	public ExtentSparkReporter sparkreport;
	public ExtentReports extent;
	public static ExtentTest test;
    static Random r = new Random ();
    static int x = r.nextInt(10);
	@BeforeSuite
	public  void setReport() {
		sparkreport = new ExtentSparkReporter(
				"C:\\Users\\Sanket Shinde\\eclipse-workspace\\Project54321\\Report\\htmlreport.html"+x+".html");
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		extent.setSystemInfo("Opertating System", "Window");
		extent.setSystemInfo("Environment", "SIT");
		sparkreport.config().setReportName("Integration Test Execution");
		sparkreport.config().setDocumentTitle("QA Automation Testing Report");
		sparkreport.config().setTheme(Theme.STANDARD);
	}

@Parameters("browser")
	@BeforeClass
	public void setup(String str) {
		if (str.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\sonal\\Desktop\\Testing Data\\Chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(baseURL);

		}

		else if (str.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "\\C:\\Users\\sonal\\Downloads\\geckodriver.exe\\");
			driver = new FirefoxDriver();
			driver.get(baseURL);
		} else if (str.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"\\C:\\Users\\sonal\\Downloads\\IEDriverServer_Win32_4.5.0.zip\\");
			driver = new InternetExplorerDriver();

		}
	}
    
  public static String captureScreen() throws IOException
  {
	  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  String destination = "C:\\Users\\Sanket Shinde\\eclipse-workspace\\Project54321\\Screenshot"+x+".png" ;	  
	  FileUtils.copyFile(source, new File(destination));
	return destination;
  }

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}

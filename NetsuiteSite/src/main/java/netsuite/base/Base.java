package netsuite.base;

import netsuite.utilities.Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base extends Utilities {

 	@BeforeMethod
	public void driverSetup(){
 		automationProfile();
 		driver.get("http://sandbox.poppin.com");
 	}
 	/*
 	@BeforeMethod
	public void browserLaunch(){
 		driver.get("http://sandbox.poppin.com");
	}
 	/*
 	@AfterMethod
 	public void verifyIfLogin(){
 		isUserLoggin();
 	//	driver.close();
 	}
 */
	@AfterMethod
	public void tearDown(){
		driver.quit();	
	} 
	
	
	
	
	
	
	
	
	
}


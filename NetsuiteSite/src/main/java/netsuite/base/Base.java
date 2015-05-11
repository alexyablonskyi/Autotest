package netsuite.base;

import netsuite.utilities.Utilities;

import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Base extends Utilities {

 	@BeforeClass
	public void driverSetup(){
 		automationProfile();
 	}
 	
 	@BeforeMethod
	public void browserLaunch(){
 		driver.get("http://sandbox.poppin.com");
	}
 	
 	@AfterMethod
 	public void verifyIfLogin(){
 		isUserLoggin();
 	//	driver.close();
 	}
 	
	@AfterClass
	public void tearDown(){
		driver.quit();	} 

	}
	

	
	
	


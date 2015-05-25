package netsuite.base;

import java.io.File;
import java.io.IOException;
import netsuite.utilities.Utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


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
 */
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

	
	@AfterMethod
	public void setScreenshot(ITestResult result) {
		if (!result.isSuccess()) {
			try {
			WebDriver returned = new Augmenter().augment(driver);
				if (returned != null) {
					File f = ((TakesScreenshot) returned)
							.getScreenshotAs(OutputType.FILE);
				try {
						FileUtils.copyFile(f, new File("test-output/screenshots/" + result.getName() + ".png"));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			} catch (ScreenshotException se) {
				se.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
}


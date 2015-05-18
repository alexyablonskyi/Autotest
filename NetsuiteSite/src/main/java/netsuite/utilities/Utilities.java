package netsuite.utilities;

import java.util.concurrent.TimeUnit;

import netsuite.pages.Home;
import netsuite.pages.Login;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Stopwatch;


public class Utilities {
	
	public static WebDriver driver = null;
	
	

	
	// ---- This method will run firefox profile of Sage----	
	public static void automationProfile() {
		ProfilesIni profile = new ProfilesIni();
		FirefoxProfile fp = profile.getProfile("Automation");
		driver = new FirefoxDriver(fp);
		driver.manage().timeouts().implicitlyWait(30L, TimeUnit.SECONDS);
		maxWindow();

	}
	
	// ---- This method will maximize the window ----
	public static void maxWindow() {
		driver.manage().window().maximize();
	}
	
	
	
	
	// ---- Wait Methods ----
	public static void waitForElementClickable(String locator){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}
	
	public static void waitForElementVisibleX(String locator){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}
	
	public static void waitForElementVisibleCss(String locator){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
	}
	
	public static void waitForElementVisibleID(String locator){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
	}
	
	
	
	//---- Log out User - Reset Script ----
	
	public boolean isElementPresent(By by) {
		try {
	      driver.findElement(by);
	      return true;
	    } catch (NoSuchElementException e) {
	      return false;
	    }
	}
	
	public void isUserLoggin(){
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Login loginPage = new Login(driver);
		Home homePage = new Home(driver);
		if(isElementPresent(By.xpath(loginPage.getLogOutXpath()))){
			loginPage.clickLogOutLink();
			waitForElementVisibleX(homePage.getSliderWrapperXpath());
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} else {
			System.out.println("User is already logged out");
		}
	}
	
	/*
	 * Wait for Page is loaded (All JavaScript completed)
	 */
	
	public static void waitForPageLoad(WebDriver driver) {
	    ExpectedCondition <Boolean> pageLoadCondition = new
	        ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver driver) {
	                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	            }
	        };
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	/*
	 * Wait for AJAX request completed
	 */
	
    public static void waitUntilAjaxRequestCompletes() {
        new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS)
            .pollingEvery(1, TimeUnit.SECONDS).until(new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver d) {
                            JavascriptExecutor jsExec = (JavascriptExecutor) d;
                            return (Boolean) jsExec.executeScript("return jQuery.active == 0;");
                    }
            });
    }
}
package netsuite.tests;

import netsuite.base.Base;
import netsuite.pages.Home;
import netsuite.pages.Login;
import netsuite.values.Global;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests2 extends Base {

	Login loginPage;
	Home homePage;

	@Test(enabled= false, priority=0, groups = {"Navigate on Login page and verify logins elements are present"})
		public void navigateOnLoginPage() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		
		Assert.assertTrue(isElementPresent(By.xpath(loginPage.getNewCustomerSectionXpath())));
		Assert.assertTrue(isElementPresent(By.xpath(loginPage.getVerticalLineXpath())));
		Assert.assertTrue(isElementPresent(By.xpath(loginPage.getReturningSectionXpath())));
	}
	
	@Test(enabled= false, priority=1, groups = {"Login/Creating customer"})
    public void loginAsReturningCustomer() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		waitForElementVisibleX(loginPage.getLogOutXpath());
        
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	
	@Test(enabled= false, priority=2, groups = {"Login/Creating customer"})
    public void createNewInduvidualCustomer() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.createNewIndividualCustomer(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		waitForElementVisibleX(loginPage.getLogOutXpath());
        
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	
	@Test(enabled= false, priority=3, groups = {"Login/Creating customer"})
    public void createNewBusinessCustomer() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.createNewBusinessCustomer(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS, loginPage.getRandomCompanyForNewBusinessCustomer());
		waitForElementVisibleX(loginPage.getLogOutXpath());
        
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	
	@Test(enabled= false, priority=4, groups = {"Login/Creating customer"})
    public void createNewCustomer_ShoppingForBusiness() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.createNewCustomerShoppingForBusiness(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		waitForElementVisibleX(loginPage.getLogOutXpath());
        
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	
	@Test(enabled= false, priority=5, groups = {"Login/Creating customer"})
    public void createNewCustomer_ShoppingForMyself() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.createNewCustomerShoppingForMyself(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		waitForElementVisibleX(loginPage.getLogOutXpath());
        
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	
}
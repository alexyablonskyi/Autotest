package netsuite.tests;

import netsuite.base.Base;
import netsuite.pages.Home;
import netsuite.pages.Login;
import netsuite.values.Global;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;



public class LoginTests extends Base {

	Login loginPage;
	Home homePage;

	//passed
	@Test(enabled= false, priority=0, groups = {"Navigate on Login page and verify logins elements are present"}, 
			description= "Verify Login Page Exists")
	public void navigateOnLoginPage() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		
		Assert.assertTrue(isElementPresent(By.xpath(loginPage.getNewCustomerSectionXpath())));
		Assert.assertTrue(isElementPresent(By.xpath(loginPage.getVerticalLineXpath())));
		Assert.assertTrue(isElementPresent(By.xpath(loginPage.getReturningSectionXpath())));
	}
	//passed
	@Test(enabled= false, priority=1, groups = {"Login/Creating customer"}, 
			description= "Verify system allows user to log in using existing credentials") 
    public void loginAsReturningCustomer() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		waitForElementVisibleX(loginPage.getLogOutXpath());
        
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	//Pass
	@Test(enabled= false, priority=2, groups = {"Login/Creating customer"}, 
			description= "")
    public void createNewInduvidualCustomer() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.createNewIndividualCustomer(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		waitForElementVisibleX(loginPage.getLogOutXpath());
		
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
        
    }
	//pass
	@Test(enabled= false, priority=3, groups = {"Login/Creating customer"}, 
			description= "")
    public void createNewBusinessCustomer() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.createNewBusinessCustomer(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS, loginPage.getRandomCompanyForNewBusinessCustomer());
		waitForElementVisibleX(loginPage.getLogOutXpath());

        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	//pass
	@Test(enabled= false, priority=4, groups = {"Login/Creating customer"}, 
			description= "")
    public void createNewCustomer_ShoppingForBusiness() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.createNewCustomerShoppingForBusiness(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		waitForElementVisibleX(loginPage.getLogOutXpath());
        
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	//Pass
	@Test(enabled= false, priority=5, groups = {"Login/Creating customer"}, 
			description= "")
    public void createNewCustomer_ShoppingForMyself() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.createNewCustomerShoppingForMyself(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		waitForElementVisibleX(loginPage.getLogOutXpath());
        
        Assert.assertTrue(isElementPresent(By.xpath(loginPage.getLogOutXpath())));
    }
	
    @Test(enabled= false, priority=6, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "")
    public void loginFailedWithIncorrectPassword(){
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
        loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.INCORRECT_PASS);
        
        Assert.assertEquals(loginPage.getErrorMessageTextForPasswordField_ReturningCustomer(), "Oops. Something's not lining up");
    }

    @Test(enabled= false, priority=7, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "")
    public void loginFailedWithEmptyEmail(){
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
        loginPage.loginAsReturningCustomer("", Global.QA_PASS);
        
        Assert.assertEquals(loginPage.getErrorMessageTextForEmailField_ReturningCustomer(), "Please input email address.");
    }
    
    @Test(enabled= false, priority=8, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "")
    public void loginFailedWithEmptyPassword(){
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
        loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, "");
        
        Assert.assertEquals(loginPage.getErrorMessageTextForPasswordField_ReturningCustomer(), "You must provide a login password.");
    }
    
    @Test(enabled= false, priority=9, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "")
    public void loginFailedWithUnregisteredEmail(){
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
        loginPage.loginAsReturningCustomer("QA123456789@Poppinmail.com", Global.QA_PASS);
        
        Assert.assertEquals(loginPage.getErrorMessageTextForEmailField_ReturningCustomer(), "Looks like you haven't registered yet,");
    }
    
    @Test(enabled= false, priority=10, groups = {"Verifying error messages for RETURNING customer"}, 
    		description= "")
    public void loginFailedWithInvalidEmail(){
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
        loginPage.loginAsReturningCustomer("QA123456789Poppinmail.com", Global.QA_PASS);
        
        Assert.assertEquals(loginPage.getErrorMessageTextForEmailField_ReturningCustomer(), "Please enter a valid email address.");
    }

    
    @Test(enabled= false, priority=11, groups = {"Verifying error messages for NEW customer"}, 
    		description= "")
    public void invalidAllFieldsForNewCustomer(){
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
        loginPage.createNewIndividualCustomer("A", "B", "QA123456789.com", "test1");
        
        Assert.assertEquals(loginPage.getErrorMessageTextForFirstNameField_NewCustomer(), "Is that really your first");
        Assert.assertEquals(loginPage.getErrorMessageTextForLastNameField_NewCustomer(), "Hey, Professor Imistypedmyname,");
        Assert.assertEquals(loginPage.getErrorMessageTextForEmailField_NewCustomer(), "Don't use your thumbs");
        Assert.assertEquals(loginPage.getErrorMessageTextForPasswordField_NewCustomer(), "Oops. We want to keep your info safe and");
    }

    @Test(enabled= false, priority=12, groups = {"Verifying error messages for NEW customer"}, 
    		description= "")
    public void emptyAllFieldsForNewCustomer(){
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
        loginPage.createNewIndividualCustomer("", "", "", "");

        Assert.assertEquals(loginPage.getMainErrorMessage_NewCustomer(), "×\nSorry, the information you provided is either incomplete or needs to be corrected.");
        Assert.assertEquals(loginPage.getErrorMessageTextForFirstNameField_NewCustomer(), "First Name is required");
        Assert.assertEquals(loginPage.getErrorMessageTextForLastNameField_NewCustomer(), "Last Name is required");
        Assert.assertEquals(loginPage.getErrorMessageTextForEmailField_NewCustomer(), "Valid Email is required");
        Assert.assertEquals(loginPage.getErrorMessageTextForPasswordField_NewCustomer(), "Please enter a valid password");
        Assert.assertEquals(loginPage.getErrorMessageTextForPasswordConfirmField_NewCustomer(), "Confirm password is required");
    }

	//Update after bug fix EC-242
    @Test(enabled= false, priority=13, groups = {"Verifying error messages for NEW customer"}, 
    		description= "")
    public void existedEmailForNewCustomer(){
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
        loginPage.createNewIndividualCustomer(Global.FNAME, Global.LNAME, Global.QA_EMAIL_ID, Global.INCORRECT_PASS);
        waitForElementVisibleX(loginPage.getErrorMessageForEmailFieldXpath_NewCustomer());
        
        Assert.assertEquals(loginPage.getErrorMessageTextForEmailField_NewCustomer(), "A user already exists with");

    }
    
	@Test(enabled= false, priority=14, groups = {"Forgot password functionality"}, 
			description= "")
	public void successForgotPassword() throws Exception{
		driver.manage().deleteAllCookies();
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.clickForgotPasswordLink();
		waitForElementClickable(loginPage.getEmailFieldForgotPasswordXpath());
		loginPage.setEmailInForgotPasswordField(Global.QA_EMAIL_ID);
		loginPage.submitForgotPasword();
		waitForElementVisibleCss(loginPage.getForgotPasswordSuccessMessageCss());
		
		Assert.assertEquals(loginPage.getForgotPasswordSuccessMessage(), "We sent an email with instructions on how to reset your password to " + Global.QA_EMAIL_ID);
	}
	

	@Test(enabled= false, priority=15, groups = {"Forgot password functionality"}, 
			description= "")
	public void unsucessForgotPassword() throws Exception{
		homePage = new Home(driver);
		homePage.openLoginPage();	
		loginPage = new Login(driver);
		loginPage.clickForgotPasswordLink();
		waitForElementClickable(loginPage.getEmailFieldForgotPasswordXpath());
		loginPage.setEmailInForgotPasswordField("QA123456789@gmail.com");
		loginPage.submitForgotPasword();
		waitForElementVisibleCss(loginPage.getForgotPasswordErrorMessageCss());
		
		Assert.assertEquals(loginPage.getForgotPasswordErrorMessage(), "×\nThe supplied email has not been registered as a customer at our Web store.");
	}
	
}

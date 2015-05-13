package netsuite.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import netsuite.base.*;
import netsuite.pages.*;
import netsuite.utilities.*;
import netsuite.values.Global;

public class CheckoutTests extends Base {
	Login loginPage;
	ShoppingCart shoppingCart;
	Checkout checkout;
	
	@Test(enabled= false, priority=0, groups = {""}, 
			description= "Process checkout as Returning Customer")
	public void processCheckoutAsReturningCustomer() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch();
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.enterCVVcode();
		checkout.clickContinueButtonOnBillingStep();
		checkout.clickPlaceOrderButton();
		Utilities.waitForPageLoad(driver);
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getConfirmationOrderMessageXpath())));
	}


	
	@Test(enabled= false, priority=1, groups = {""}, 
			description= "Process checkout as New Customer")
	public void processCheckoutAsNewCustomer() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch();
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.createNewIndividualCustomer(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.enterShippingAddress();
		Utilities.waitForElementVisibleID(checkout.getDeleiveryOptionId());
		checkout.clickContinueButtonOnShippingStep();
		checkout.enterNewCreditCard();
		checkout.clickContinueButtonOnBillingStep();
		checkout.clickPlaceOrderButton();
		Utilities.waitForPageLoad(driver);
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getConfirmationOrderMessageXpath())));
	}
	
	@Test(enabled= true, priority=2, groups = {""}, 
			description= "Select PayPal as Payment method for Returning Customer")
	public void selectPayPalAsPaymentMethod() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch();
		shoppingCart.clickCheckoutButton();

		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.selectPayPalAsPaymentMethod();
		checkout.clickContinueToPayPalButton();
		checkout.proceedViaPayPalService();
		checkout.clickContinueButtonOnBillingStep();
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getPayPalPaymentSectionXpath())));
	}
	
	
	@Test(enabled= false, priority=3, groups = {""}, 
			description= "Process checkout as Returning Customer using PayPal as Payment method")
	public void processCheckoutAsReturningCustomerUsingPayPal() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch();
		shoppingCart.clickCheckoutButton();

		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.selectPayPalAsPaymentMethod();
		checkout.clickContinueToPayPalButton();
		checkout.proceedViaPayPalService();
		checkout.clickContinueButtonOnBillingStep();
		checkout.clickPlaceOrderButton();
		Utilities.waitForPageLoad(driver);
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getConfirmationOrderMessageXpath())));
	}
	
	@Test(enabled= false, priority=4, groups = {""}, 
			description= "Process checkout as Returning Customer using PayPal as Payment method")
	public void processCheckoutWithNonInventoryItem() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch();
		shoppingCart.clickCheckoutButton();

		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.selectPayPalAsPaymentMethod();
		checkout.clickContinueToPayPalButton();
		checkout.proceedViaPayPalService();
		checkout.clickContinueButtonOnBillingStep();
		checkout.clickPlaceOrderButton();
		Utilities.waitForPageLoad(driver);
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getConfirmationOrderMessageXpath())));
	}
	
}

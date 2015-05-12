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
		shoppingCart.clickOnMiniCart();
		shoppingCart.searchingItem();
		shoppingCart.clickAddToCartButton();
		shoppingCart.clickOnMiniCart();
		shoppingCart.clickCheckoutButton();

		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.enterCVVcode();
		checkout.clickContinueButton();
		checkout.clickPlaceOrderButton();
		Utilities.waitForPageLoad(driver);
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getConfirmationOrderMessageXpath())));
	}
	
	@Test(enabled= false, priority=0, groups = {""}, 
			description= "Process checkout as New Customer")
	public void processCheckoutAsNewCustomer() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.clickOnMiniCart();
		shoppingCart.searchingItem();
		shoppingCart.clickAddToCartButton();
		shoppingCart.clickOnMiniCart();
		shoppingCart.clickCheckoutButton();

		loginPage = new Login(driver);
		loginPage.createNewIndividualCustomer(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.enterShippingAddress();
		
		
		
		Utilities.waitForPageLoad(driver);
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getConfirmationOrderMessageXpath())));
	}
}

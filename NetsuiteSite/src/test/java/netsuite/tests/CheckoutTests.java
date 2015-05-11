package netsuite.tests;

import org.openqa.selenium.By;
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
	
	@Test(enabled= true, priority=0, groups = {""}, 
			description= "Process checkout as New Customer")
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
		Thread.sleep(10000);
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getConfirmationOrderMessageXpath())));
	}
	
}

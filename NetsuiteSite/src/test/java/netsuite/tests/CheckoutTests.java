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
	
	@Test(enabled= false, priority=0, groups = {"Returning Customer"}, 
			description= "Process checkout as Returning Customer")
	public void processCheckoutAsReturningCustomer() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
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


	@Test(enabled= false, priority=1, groups = {"New Customer"}, 
			description= "Process checkout as New Customer")
	public void processCheckoutAsNewCustomer() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
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
	

	@Test(enabled= false, priority=2, groups = {"PayPal"}, 
			description= "Select PayPal as Payment method for Returning Customer")
	public void selectPayPalAsPaymentMethod() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
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
	
	
	@Test(enabled= false, priority=3, groups = {"PayPal"}, 
			description= "Process checkout as Returning Customer using PayPal as Payment method")
	public void processCheckoutAsReturningCustomerUsingPayPal() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
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
	
	@Test(enabled= false, priority=4, groups = {"Returning Customer"}, 
			description= "Process checkout with NON-inventory item as Returning Customer")
	public void processCheckoutWithNonInventoryItem() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.NON_INVENTORY_ITEM_DROPSHIP);
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
	
	@Test(enabled= false, priority=5, groups = {"Returning Customer"}, 
			description= "Process checkout with KIT item as Returning Customer")
	public void processCheckoutWithKitItem() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.KIT_ITEM);
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
	
	@Test(enabled= false, priority=6, groups = {"Returning Customer"}, 
			description= "Process checkout with Inventory Dropship item as Returning Customer")
	public void processCheckoutWithInventoryDropshipItem() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM_DROPSHIP);
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
	
	@Test(enabled= false, priority=7, groups = {""}, 
			description= "Select different Shipping and Billing addresses for New Customer")
	public void selectDifferentShippingAndBillingAddressesForNewCustomer() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.createNewIndividualCustomer(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.enterShippingAddress();
		Utilities.waitForElementVisibleID(checkout.getDeleiveryOptionId());
		checkout.clickContinueButtonOnShippingStep();
		checkout.enterNewCreditCard();
		checkout.uncheckSameAsShippingAddressCheckbox();
		checkout.clickAddNewAddressLink();
		Utilities.waitForElementClickable(checkout.getFullNameLayoverXpath());
		checkout.addNewAddressViaLayover();
		Utilities.waitUntilAjaxRequestCompletes();
		checkout.clickUseThisAddessButton();
		checkout.enterCVVcode();
		checkout.clickContinueButtonOnBillingStep();
		
		Assert.assertNotEquals(checkout.getShippingAddressFullNameText(), checkout.getBillingAddressFullNameText());
		
	}
	
	@Test(enabled= false, priority=8, groups = {""}, 
			description= "Verify that the same as Shipping address checkbox is selected by default")
	public void checkboxTheSameAsShippingAddressSelectedByDefault() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.createNewIndividualCustomer(Global.FNAME, Global.LNAME, loginPage.getRandomEmailForNewInduvidualCustomer(), Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.enterShippingAddress();
		Utilities.waitForElementVisibleID(checkout.getDeleiveryOptionId());
		checkout.clickContinueButtonOnShippingStep();
		checkout.enterNewCreditCard();
		
		Assert.assertTrue(checkout.isChecked(By.xpath(checkout.getCheckboxSameAsShippingAddressXpath())));
	}
	
	
	@Test(enabled= false, priority=9, groups = {"Promocode"}, 
			description= "Check that there is a possibility to apply Item-Level Promocode on Payment page ")
	public void applyItemLevelPromocodeToOrderOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.applyPromocode(Global.PROMOCODE_ITEMLEVEL);
				
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getAppliedItemLevelPromocodeXpath())));
	}
	
	@Test(enabled= false, priority=10, groups = {"Promocode"}, 
			description= "Check that there is a possibility to apply Order-Level Promocode on Payment page ")
	public void applyOrderLevelPromocodeToOrderOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.changeQuantityOfItemInShoppingCart("15");
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.applyPromocode(Global.PROMOCODE_ORDERLEVEL);
			
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getAppliedOrderLevelPromocodeXpath())));
	}
	
	
	@Test(enabled= false, priority=11, groups = {"Promocode"}, 
			description= "Check error message for Invalid Promocode on Payment page")
	public void errorForInvalidPromocodeOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.applyPromocode(Global.PROMOCODE_INVALID);
				
		Assert.assertTrue(checkout.getTextOfErrorMessageForPromocode().contains("Coupon code is invalid or unrecognized"));
	}
	
	@Test(enabled= false, priority=12, groups = {"Promocode"}, 
			description= "Check error message for Expired Promocode on Payment page")
	public void errorForExpairedPromocodeOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.applyPromocode(Global.PROMOCODE_EXPIRED);
				
		Assert.assertTrue(checkout.getTextOfErrorMessageForPromocode().contains("This coupon code has expired or is invalid"));
	}
	
	@Test(enabled= false, priority=13, groups = {"Promocode"}, 
			description= "Check error message for Promocode with minimum amount of total on Payment page")
	public void errorForMinimumAmoutOfTotalPromocodeOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.applyPromocode(Global.PROMOCODE_ORDERLEVEL);
				
		Assert.assertTrue(checkout.getTextOfErrorMessageForPromocode().contains("A minimum order amount of $85.00 is required to use this coupon code."));
	}
	
	@Test(enabled= false, priority=14, groups = {"Gift certificate"}, 
			description= "Check that there is a possibility to apply Gift Cetificate on Payment page ")
	public void applyGiftCertificateToOrderOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.clickPayWithGiftCertificateLink();
		checkout.applyGiftCertificateCode(Global.GIFT_CERTIFICATE_CODE);
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getAppliedGiftCertificateXpath())));
	}
	
	
	@Test(enabled= false, priority=15, groups = {"Gift certificate"}, 
			description= "Check that there is a possibility to apply TWO Gift Cetificates on Payment page ")
	public void applyTwoGiftCertificateToOrderOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		
		
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.changeQuantityOfItemInShoppingCart("15");
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.clickPayWithGiftCertificateLink();
		checkout.applyGiftCertificateCode(Global.GIFT_CERTIFICATE_CODE);
		checkout.clickAddOtherGiftCertificateLink();
		checkout.applyGiftCertificateCode(Global.GIFT_CERTIFICATE_CODE_2);
		Utilities.waitUntilAjaxRequestCompletes();
		
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getAppliedGiftCertificateXpath()))); 
		Assert.assertTrue(isElementPresent(By.xpath(checkout.getSecondAppliedGiftCertificateXpath())));
	}
	
	@Test(enabled= false, priority=16, groups = {"Gift certificate"}, 
			description= "Check error message for Invalid Gift Certificate on Payment page ")
	public void errorForInvalidGiftCertificateOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.clickPayWithGiftCertificateLink();
		checkout.applyGiftCertificateCode(Global.GIFT_CERTIFICATE_INVALID);
		
		Assert.assertTrue(checkout.getTextOfErrorMessageForGiftCertificate().contains("Gift Certificate Invalid"));
	}
	
	
	@Test(enabled= false, priority=17, groups = {"Gift certificate"}, 
			description= "Check error message for Used Gift Certificate on Payment page ")
	public void errorForUsedGiftCertificateOnPaymentPage() throws Exception{
		shoppingCart = new ShoppingCart(driver);
		shoppingCart.addItemViaSearch(Global.INVENTORY_ITEM);
		shoppingCart.clickCheckoutButton();
		
		loginPage = new Login(driver);
		loginPage.loginAsReturningCustomer(Global.QA_EMAIL_ID, Global.QA_PASS);
		
		checkout = new Checkout(driver);
		checkout.clickPayWithGiftCertificateLink();
		checkout.applyGiftCertificateCode(Global.GIFT_CERTIFICATE_USED);
		
		Assert.assertTrue(checkout.getTextOfErrorMessageForGiftCertificate().contains("Gift certificate redemption amount exceeds available amount on the gift certificate"));
	}
	
}

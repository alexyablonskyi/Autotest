package netsuite.pages;

import netsuite.values.Global;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Checkout {
	
	WebDriver driver;
	
	public Checkout(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	/*
	 *  Continue button on Billing step
	 */
	@FindBy (xpath = "(//*[contains(text(), 'Continue')])[3]")
	WebElement continueButtonOnBillingStep;
	
	public void clickContinueButtonOnBillingStep(){
		continueButtonOnBillingStep.click();
	}
	
	/*
	 *  Continue button on  Shipping step
	 */
	@FindBy (xpath = "(.//*[@id='wizard-content']//*[contains(text(), 'Continue')])[2]")
	WebElement continueButtonOnShippingStep;
	
	public void clickContinueButtonOnShippingStep() throws InterruptedException{
		Thread.sleep(3000);
		continueButtonOnShippingStep.click();
	}
	
	/*
	 *  Place order button
	 */
	@FindBy (xpath = "(//*[contains(text(), 'Place Order')])[3]")
	WebElement placeOrderButton;
	
	public void clickPlaceOrderButton(){
		placeOrderButton.click();
	}
	
	
	
	/*
	 * Confirmation order message
	 */
	
	@FindBy (xpath = ".//*[@id='wizard-step-review-left']//h3")
	WebElement confirmationOrderMessage;
	
	public String getConfirmationOrderMessageXpath (){
		return ".//*[@id='wizard-step-review-left']//h3";
	}
	
	/* 
	 * Shipping address fields
	 */
	
	@FindBy (id = "shipaddress-fullname")
	WebElement fullName;
	
	public void enterFullNameShippingAdreess(){
		fullName.clear();
		fullName.sendKeys(Global.NAME);
	}
	
	@FindBy (id = "shipaddress-company")
	WebElement company;
	
	public void enterCompanyShippingAdreess(){
		company.clear();
		company.sendKeys(Global.COMPANY);
	}
	
	@FindBy (id = "shipaddress-addr1")
	WebElement address1;
	
	public void enterAddress1ShippingAdreess(){
		address1.clear();
		address1.sendKeys(Global.ADDRESS);
	}
	
	@FindBy (id = "shipaddress-addr2")
	WebElement address2;
	
	@FindBy (id = "shipaddress-city")
	WebElement city;
	
	public void enterCityShippingAdreess(){
		city.clear();
		city.sendKeys(Global.CITY);
	}
	
	@FindBy (id = "shipaddress-state")
	WebElement state;
	
	public void selectState(){
		Select dropdown = new Select(driver.findElement(By.id("shipaddress-state")));
		dropdown.selectByVisibleText("New York");
	}
	
	
	@FindBy (id = "shipaddress-zip")
	WebElement zip;
	
	public void enterZIPShippingAdreess(){
		zip.clear();
		zip.sendKeys(Global.ZIP_CODE);
	}
	
	@FindBy (id = "shipaddress-phone")
	WebElement phone;
	
	public void enterPhoneShippingAdreess(){
		phone.clear();
		phone.sendKeys(Global.PHONE_NUM);
	}
	
	public void enterShippingAddress() throws InterruptedException{
		enterAddress1ShippingAdreess();
		enterCityShippingAdreess();
		selectState();
		enterZIPShippingAdreess();
		enterPhoneShippingAdreess();
		clickContinueButtonOnShippingStep();
	}
	
	
	/*
	 * Delivery methods
	 */
	@FindBy (id = "delivery-options-3680")
	WebElement threeFiveBusinessDays;
	
	public void select3_5BusinessDaysMethod(){
		threeFiveBusinessDays.click();
	}
	
	@FindBy (id = "delivery-options-2740")
	WebElement secondBusinessDays;
	
	public void selectSecondBusinessDays(){
		secondBusinessDays.click();
	}
	
	@FindBy (id = "delivery-options-2741")
	WebElement nextBusinessDays;
	
	public void selectNextBusinessDays(){
		nextBusinessDays.click();
	}
	
	public String getDeleiveryOptionId(){
		return "delivery-options-3680";
	}
	
	
	/*
	 * Credit cart section
	 */
	@FindBy(id = "ccnumber")
	WebElement creditCardNumber;
	
	public void enterCreditCardNumber(){
		creditCardNumber.clear();
		creditCardNumber.sendKeys(Global.CREDIT_CARD_NUMBER);
	}
	
	@FindBy(id = "expmonth")
	WebElement expMonth;
	
	public void selectExpMonth(){
		Select dropdown = new Select(driver.findElement(By.id("expmonth")));
		dropdown.selectByVisibleText("10");
	}
	
	@FindBy(id = "expyear")
	WebElement expYear;

	public void selectExpYear(){
		Select dropdown = new Select(driver.findElement(By.id("expyear")));
		dropdown.selectByVisibleText("2035");
	}
	
	@FindBy(id = "ccsecuritycode")
	WebElement cvvField;
	
	public String returnCvvCodeXpath(){
		return ".//*[@id='ccsecuritycode']";
	}
	
	public void enterCVVcode(){
		cvvField.sendKeys(Global.CVV_CODE);
	}
	
	@FindBy(id = "ccname")
	WebElement creditCardName;
	
	public void enterCreditCardName(){
		creditCardName.clear();
		creditCardName.sendKeys(Global.CREDIT_CARD_NAME);
	}	
	
	public void enterNewCreditCard(){
		enterCreditCardNumber();
		selectExpMonth();
		selectExpYear();
		enterCVVcode();
		enterCreditCardName();
	}
	
	
	
	/* 
	 * Address layover
	 */
	@FindBy (id = "in-modal-fullname")
	WebElement fullNameLayover;
	
	public void enterFullNameAdreessLayover(){
		fullNameLayover.clear();
		fullNameLayover.sendKeys(Global.NAME);
	}
	
	@FindBy (id = "in-modal-company")
	WebElement companyLayover;
	
	public void enterCompanyAdreessLayover(){
		companyLayover.clear();
		companyLayover.sendKeys(Global.COMPANY);
	}
	
	@FindBy (id = "in-modal-addr1")
	WebElement address1Layover;
	
	public void enterAddress1AdreessLayover(){
		address1Layover.clear();
		address1Layover.sendKeys(Global.ADDRESS);
	}
	
	@FindBy (id = "in-modal-addr2")
	WebElement address2Layover;
	
	@FindBy (id = "in-modal-city")
	WebElement cityLayover;
	
	public void enterCityAdreessLayover(){
		cityLayover.clear();
		cityLayover.sendKeys(Global.CITY);
	}
	
	@FindBy (id = "in-modal-state")
	WebElement stateLayover;
	
	public void selectStateAdressLayover(){
		Select dropdown = new Select(driver.findElement(By.id("in-modal-state")));
		dropdown.selectByVisibleText("New York");
	}
	
	@FindBy (id = "in-modal-zip")
	WebElement zipLayover;
	
	public void enterZIPAdreessLayover(){
		zipLayover.clear();
		zipLayover.sendKeys(Global.ZIP_CODE);
	}
	
	@FindBy (id = "in-modal-phone")
	WebElement phoneLayover;
	
	public void enterPhoneAdreessLayover(){
		phoneLayover.clear();
		phoneLayover.sendKeys(Global.PHONE_NUM);
	}

	@FindBy (xpath = "//button[contains(text(), 'Update Address')]")
	WebElement updateAddressButton;
	
	public void clickUpdateAddressButton(){
		updateAddressButton.click();
	}
	
	@FindBy (xpath = "//button[contains(text(), 'Cancel')]")
	WebElement cancelAddressButton;
	
	public void clickCancelAddressButton(){
		cancelAddressButton.click();
	}
	
	
	/* 
	 * Gift certificate field
	 */
	
	@FindBy (xpath = "//a[contains(text(), 'Pay with Gift Certificate')]")
	WebElement payWithGiftCertificateLink;
	
	public void clickPayWithGiftCertificateLink(){
		payWithGiftCertificateLink.click();
	}
	
	@FindBy (xpath = "//input[@name = 'code']")
	WebElement giftCertificateField;
	
	public void enterGiftCertificateCode(){
		giftCertificateField.sendKeys(Global.GIFT_CERTIFICATE_CODE);
	}
	
	@FindBy (xpath = ".//*[@id='gift-certificate-form']//button[contains(text(), 'Apply')]")
	WebElement applyGiftCertificateButton;
	
	public void clickApplyGiftCertificateButton(){
		applyGiftCertificateButton.click();
	}
	
	@FindBy (xpath = "//a[@data-action = 'remove']")
	WebElement removeGiftCertificateButton;
	
	public void clickRemoveGiftCertificateButton(){
		removeGiftCertificateButton.click();
	}
	
	@FindBy (xpath = "//a[contains(text(), 'Add other Gift Certificate')]")
	WebElement addOtherGiftCertificateLink;
	
	public void clickAddOtherGiftCertificateLink(){
		addOtherGiftCertificateLink.click();
	}
	
	
	/*
	 * Promo code
	 */
	
	@FindBy (id = "promocode")
	WebElement promocodeField;
	
	public void enterPromocodeItemLevel(){
		promocodeField.sendKeys(Global.PROMOCODE_ITEMLEVEL);
	}
	
	public void enterPromocodeOrderLevel(){
		promocodeField.sendKeys(Global.PROMOCODE_ORDERLEVEL);
	}
	
	@FindBy (xpath = ".//*[@id='promo-code-container']//button[contains(text(), 'Apply')]")
	WebElement applyPromocodeButton;
	
	public void clickApplyPromocode(){
		applyPromocodeButton.click();
	}
	
	@FindBy (css = ".icon-remove")
	WebElement removePromocodeIcon;
	
	public void clickRemovePromocodeIcon(){
		removePromocodeIcon.click();
	}
	
	
	/* 
	 * PayPal
	 */
	@FindBy (xpath = ".//*[@id='wizard-step-content']//a[@data-type='paypal']")
	WebElement payPalLink;
	
	public void selectPayPalAsPaymentMethod(){
		payPalLink.click();
	}
	
	@FindBy (xpath = "(.//*[@id='wizard-content']//button[contains(text(), 'Continue to Paypal')])[2]")
	WebElement continueToPayPalButton;
	
	public void clickContinueToPayPalButton(){
		continueToPayPalButton.click();
	}
	
	@FindBy (id = "login_email")
	WebElement emailFieldForPayPal;
	
	@FindBy (id = "login_password")
	WebElement passwordFieldForPayPal;	
	
	@FindBy (id = "submitLogin")
	WebElement loginIntoPayPalButton;
	
	public void proceedViaPayPalService() throws InterruptedException{
		emailFieldForPayPal.clear();
		emailFieldForPayPal.sendKeys(Global.PAYPAL_EMAIL_ID);
		passwordFieldForPayPal.clear();
		passwordFieldForPayPal.sendKeys(Global.PAYPAL_PASS);
		loginIntoPayPalButton.click();
		Thread.sleep(1000);
		continueButtonPayPalService.click();
	}
	
	
	@FindBy (id = "continue_abovefold")
	WebElement continueButtonPayPalService;
	
	public void clickContinueButtonPayPalService(){
		continueButtonPayPalService.click();
	}
	
	@FindBy (xpath = ".//*[@id='wizard-step-content']//b[contains(text(), 'Payment via Paypal')]")
	WebElement payPalPaymentSection;
	
	public String getPayPalPaymentSectionXpath(){
		return ".//*[@id='wizard-step-content']//b[contains(text(), 'Payment via Paypal')]";
	}
	
	
	
	
	
	
	
	
	
}




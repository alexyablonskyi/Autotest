package netsuite.pages;

import netsuite.utilities.Utilities;
import netsuite.values.Global;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	
	public void clickContinueButtonOnBillingStep() throws InterruptedException{
		Utilities.waitUntilAjaxRequestCompletes();
		continueButtonOnBillingStep.click();
	}
	
	/*
	 *  Continue button on  Shipping step
	 */
	@FindBy (xpath = "(.//*[@id='wizard-content']//*[contains(text(), 'Continue')])[2]")
	WebElement continueButtonOnShippingStep;
	
	public void clickContinueButtonOnShippingStep() throws InterruptedException{
		Utilities.waitUntilAjaxRequestCompletes();
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
	
	@FindBy (id = "shipaddress-company")
	WebElement company;
	
	@FindBy (id = "shipaddress-addr1")
	WebElement address1;
	
	@FindBy (id = "shipaddress-addr2")
	WebElement address2;
	
	@FindBy (id = "shipaddress-city")
	WebElement city;
	
	@FindBy (id = "shipaddress-state")
	WebElement state;
	
	@FindBy (id = "shipaddress-zip")
	WebElement zip;
	
	@FindBy (id = "shipaddress-phone")
	WebElement phone;
	
	public void enterShippingAddress() throws InterruptedException{
		address1.sendKeys(Global.ADDRESS);
		city.sendKeys(Global.CITY);
		Select dropdown = new Select(driver.findElement(By.id("shipaddress-state")));
		dropdown.selectByVisibleText("New York");
		zip.sendKeys(Global.ZIP_CODE);
		phone.sendKeys(Global.PHONE_NUM);
		clickContinueButtonOnShippingStep();
	}
	
	public void enterNJShippingAddress() throws InterruptedException{
		address1.sendKeys(Global.BILLING_NJ_ADDRESS);
		city.sendKeys(Global.BILLING_NJ_CITY);
		Select dropdown = new Select(driver.findElement(By.id("shipaddress-state")));
		dropdown.selectByVisibleText("New Jersey");
		zip.sendKeys(Global.BILLING_NJ_ZIP_CODE);
		phone.sendKeys(Global.BILLING_NJ_PHONE_NUM);
		clickContinueButtonOnShippingStep();
	}
	
	public void enterNonTaxableShippingAddress() throws InterruptedException{
		address1.sendKeys(Global.BILLING_NONTAX_ADDRESS);
		city.sendKeys(Global.BILLING_NONTAX_CITY);
		Select dropdown = new Select(driver.findElement(By.id("shipaddress-state")));
		dropdown.selectByVisibleText("Michigan");
		zip.sendKeys(Global.BILLING_NONTAX_ZIP_CODE);
		phone.sendKeys(Global.BILLING_NONTAX_PHONE_NUM);
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
	
	public String getFullNameLayoverXpath(){
		return ".//*[@id='in-modal-fullname']";
	}
	
	@FindBy (id = "in-modal-company")
	WebElement companyLayover;
	
	@FindBy (id = "in-modal-addr1")
	WebElement address1Layover;
	
	@FindBy (id = "in-modal-addr2")
	WebElement address2Layover;
	
	@FindBy (id = "in-modal-city")
	WebElement cityLayover;
	
	@FindBy (id = "in-modal-state")
	WebElement stateLayover;
	
	@FindBy (id = "in-modal-zip")
	WebElement zipLayover;
	
	@FindBy (id = "in-modal-phone")
	WebElement phoneLayover;

	@FindBy (xpath = "//button[contains(text(), 'Save Address')]")
	WebElement saveAddressButton;
	
	@FindBy (xpath = "//button[contains(text(), 'Cancel')]")
	WebElement cancelAddressButton;
	

	public void enterNewAddressViaLayover(){
		fullNameLayover.sendKeys(Global.BILLING_NAME);
		address1Layover.sendKeys(Global.BILLING_ADDRESS);
		cityLayover.sendKeys(Global.BILLING_CITY);
		Select dropdown = new Select(driver.findElement(By.id("in-modal-state")));
		dropdown.selectByVisibleText("New York");
		zipLayover.sendKeys(Global.BILLING_ZIP_CODE);
		phoneLayover.sendKeys(Global.BILLING_PHONE_NUM);
		saveAddressButton.click();
	}
	
	public void enterNewNJAddressViaLayover(){
		fullNameLayover.sendKeys(Global.BILLING_NJ_NAME);
		address1Layover.sendKeys(Global.BILLING_NJ_ADDRESS);
		cityLayover.sendKeys(Global.BILLING_NJ_CITY);
		Select dropdown = new Select(driver.findElement(By.id("in-modal-state")));
		dropdown.selectByVisibleText("New Jersey");
		zipLayover.sendKeys(Global.BILLING_NJ_ZIP_CODE);
		phoneLayover.sendKeys(Global.BILLING_NJ_PHONE_NUM);
		saveAddressButton.click();
	}
	
	public void enterNewNonTaxableAddressViaLayover(){
		fullNameLayover.sendKeys(Global.BILLING_NONTAX_NAME);
		address1Layover.sendKeys(Global.BILLING_NONTAX_ADDRESS);
		cityLayover.sendKeys(Global.BILLING_NONTAX_CITY);
		Select dropdown = new Select(driver.findElement(By.id("in-modal-state")));
		dropdown.selectByVisibleText("Michigan");
		zipLayover.sendKeys(Global.BILLING_NONTAX_ZIP_CODE);
		phoneLayover.sendKeys(Global.BILLING_NONTAX_PHONE_NUM);
		saveAddressButton.click();
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
	
	@FindBy (xpath = ".//*[@id='gift-certificate-form']//button[contains(text(), 'Apply')]")
	WebElement applyGiftCertificateButton;
	
	public void applyGiftCertificateCode(String gift){
		giftCertificateField.sendKeys(gift);
		applyGiftCertificateButton.click();
	}
	
	public String getAppliedGiftCertificateXpath(){
		return ".//*[@id='order-wizard-layout']//span[@title='"+Global.GIFT_CERTIFICATE_CODE+"']";
	}
	
	public String getSecondAppliedGiftCertificateXpath(){
		return ".//*[@id='order-wizard-layout']//span[@title='"+Global.GIFT_CERTIFICATE_CODE_2+"']";
	}
	
	@FindBy (xpath = "//a[@data-action = 'remove']")
	WebElement removeGiftCertificateButton;
	
	public void clickRemoveGiftCertificateButton(){
		removeGiftCertificateButton.click();
	}
	
	@FindBy (xpath = "//a[contains(text(), 'Add Another Gift Certificate')]")
	WebElement addOtherGiftCertificateLink;
	
	public void clickAddOtherGiftCertificateLink(){
		addOtherGiftCertificateLink.click();
	}
	
	@FindBy (xpath = ".//*[@id='wizard-step-content']//div[@class='alert alert-error']")
	WebElement errorMessageForGiftCertificate;
	
	public String getTextOfErrorMessageForGiftCertificate(){
		return errorMessageForGiftCertificate.getText();
	}
	/*
	 * Promo code
	 */
	
	@FindBy (id = "promocode")
	WebElement promocodeField;
	
	public void applyPromocode(String promocode){
		promocodeField.sendKeys(promocode);
		applyPromocodeButton.click();
	}
	
	@FindBy (xpath = ".//*[@id='promo-code-container']//button[contains(text(), 'Apply')]")
	WebElement applyPromocodeButton;
	
	public String getAppliedItemLevelPromocodeXpath(){
		return ".//*[@id='order-wizard-layout']//p[contains(text(),'"+Global.PROMOCODE_ITEMLEVEL+"')]";
	}
	
	public String getAppliedOrderLevelPromocodeXpath(){
		return ".//*[@id='order-wizard-layout']//p[contains(text(),'"+Global.PROMOCODE_ORDERLEVEL+"')]";
	}
	
	@FindBy (css = ".icon-remove")
	WebElement removePromocodeIcon;
	
	public void clickRemovePromocodeIcon(){
		removePromocodeIcon.click();
	}
	
	@FindBy (xpath = ".//*[@id='promo-code-container']//div[@class='alert alert-error']")
	WebElement errorMessageForPromocode;
	
	public String getTextOfErrorMessageForPromocode(){
		return errorMessageForPromocode.getText();
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
	
	/*
	 * The same as Shipping address checkbox
	 */
	@FindBy (xpath = ".//*[@id='wizard-step-content']//input[@name='same-as-address']")
	WebElement checkboxSameAsShippingAddress;

	public String getCheckboxSameAsShippingAddressXpath(){
		return ".//*[@id='wizard-step-content']//input[@name='same-as-address']";
	}
	
	public void checkSameAsShippingAddressCheckbox(){
		if(isChecked(By.xpath(getCheckboxSameAsShippingAddressXpath()))){
			System.out.println("Checkbox is checked");
		} else {
			checkboxSameAsShippingAddress.click();
		}
	}
	
	public void uncheckSameAsShippingAddressCheckbox(){
		if(isChecked(By.xpath(getCheckboxSameAsShippingAddressXpath()))){
			checkboxSameAsShippingAddress.click();
		} else {
			System.out.println("Checkbox is already Uncheck");
		}
	}
	
	public boolean isChecked(By by){
		if (driver.findElement(By.xpath(getCheckboxSameAsShippingAddressXpath())).isSelected()){
			System.out.println("Checkbox is checked");
			return true;
		}else{
			System.out.println("Checkbox is NOT checked");
			return false;
		}
	}
	
	
	/*
	 * Add new address link
	 */
	@FindBy (xpath = ".//*[@id='address-module-list-placeholder']//a[contains(text(), 'Add New Address')]")
	WebElement addNewAddressLink;
	
	public void clickAddNewAddressLink(){
		addNewAddressLink.click();
	}
	
	/*
	 * Use this address for new added Address 
	 */
	@FindBy (xpath = "(.//*[@id='address-module-list-placeholder']//button[contains(text(), 'Use this Address')])[last()]")
	WebElement useThisAddressButton;
	
	public void clickUseThisAddessButton(){
		useThisAddressButton.click();
	}
	
	/*
	 * Change address link
	 */
	@FindBy (xpath = ".//*[@id='wizard-step-content']//a[contains(text(), 'Change address')]")
	WebElement changeAddressLink;
	
	public void clickChangeAddressLink(){
		changeAddressLink.click();
	}
	
	/*
	 * Ship to this address for new added Address 
	 */
	@FindBy (xpath = "(.//*[@id='address-module-list-placeholder']//button[contains(text(), 'Ship to this Address')])[last()]")
	WebElement shipToThisAddressButton;
	
	public void clickShipToThisAddressButton(){
		shipToThisAddressButton.click();
	}
	
	
	/*
	 * Review page
	 */
	//Billing address section
	@FindBy(xpath = "(.//div[@data-manage='billaddress']//span[@class='address-line'])[1]")
	WebElement fullNameOfBillingAddress;
	
	public String getBillingAddressFullNameText(){
		return fullNameOfBillingAddress.getText();
	}
	
	//Shipping address section
	@FindBy(xpath = "(.//div[@data-manage='shipaddress']//span[@class='address-line'])[1]")
	WebElement fullNameOfShippingAddress;
	
	public String getShippingAddressFullNameText(){
		return fullNameOfShippingAddress.getText();
	}
	
	
	/*
	 * Tax value on Total section
	 */
	
	@FindBy(xpath = ".//*[@id='order-wizard-layout']//span[@class='pull-right cart-summary-tax-total-formatted']")
	WebElement taxValueOnTotalSection;
	
	public String getTaxValueFromTotalSection(){
		return taxValueOnTotalSection.getText();
	}
	
	
	
	
	
	
	
	
	
	
}




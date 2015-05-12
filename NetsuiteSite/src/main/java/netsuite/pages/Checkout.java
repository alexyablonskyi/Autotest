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
	 *  Continue button
	 */
	@FindBy (xpath = "(//*[contains(text(), 'Continue')])[3]")
	WebElement continueButton;
	
	public void clickContinueButton(){
		continueButton.click();
	}
	
	/*
	 *  Continue button on  Shipping step
	 */
	@FindBy (xpath = "(//*[contains(text(), 'Continue')])[2]")
	WebElement continueButtonOnShippingStep;
	
	public void clickContinueButtonOnShippingStep(){
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
	
	public void enterShippingAddress(){
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
	
	
	
	
	
	
	
	
	
	
}




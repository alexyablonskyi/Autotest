package netsuite.pages;

import netsuite.values.Global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkout {
	
	WebDriver driver;
	
	public Checkout(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* 
	 * CVV field
	 */
	@FindBy(id = "ccsecuritycode")
	WebElement cvvField;
	
	public String returnCvvCodeXpath(){
		return ".//*[@id='ccsecuritycode']";
	}
	
	public void enterCVVcode(){
		cvvField.sendKeys(Global.CVV_CODE);
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
	
	@FindBy (id = "wizard-step-review-left")
	WebElement confirmationOrderMessage;
	
	public String getConfirmationOrderMessageXpath (){
		return ".//*[@id='wizard-step-review-left']";
	}
	
	
	
	
	
}




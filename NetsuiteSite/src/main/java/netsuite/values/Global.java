package netsuite.values;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public interface Global {

	
// User Info
	String NAME								="Poppin QA";
	String FNAME							="Poppin";
	String LNAME							="QA";
	String COMPANY							="QA Automation test";
	String ADDRESS							="1115 Broadway Suite 307";
	String CITY								="New York";
	String ZIP_CODE							="10010";
	String PHONE_NUM						="718-926-1212";
	String NY								="New York";
	
// User Id's
	String QA_EMAIL_ID						="qa.test@poppin.com";
	String PAYPAL_EMAIL_ID					="tech@poppin.com";

		
// Password
	String QA_PASS							="poppin15";
	String PAYPAL_PASS						="W3lc0me!23";
	String INCORRECT_PASS   				="15poppin";

// Checkout	Page
	String CVV_CODE							="123";
	String CREDIT_CARD_NUMBER				="4111 1111 1111 1111";
	String CREDIT_CARD_NAME					="QA automation";
	String GIFT_CERTIFICATE_CODE 			="VAVNSMI3V";
	String GIFT_CERTIFICATE_CODE_2 			="IJ42KVFPE";
	String GIFT_CERTIFICATE_INVALID 		="ABCDEF";
	String GIFT_CERTIFICATE_USED 			="FELBTTTP4";
	String PROMOCODE_ITEMLEVEL	 			="KERRYFF";
	String PROMOCODE_ORDERLEVEL	 			="POPAPR1085";
	String PROMOCODE_INVALID				="ABCDE";
	String PROMOCODE_EXPIRED				="BULK10";
	
	
// Items
	String INVENTORY_ITEM					="ruler";
	String INVENTORY_ITEM_DROPSHIP			="Orange Campfire Ottoman";
	String NON_INVENTORY_ITEM_DROPSHIP		="mini lamp";
	String KIT_ITEM							="kit";
	String NON_TAXABLE_ITEM					="Red Block Party Lounge Bench";

// Billing Address
	String BILLING_NAME						="PoppinBilling QA";
	String BILLING_COMPANY					="QA Automation test";
	String BILLING_ADDRESS					="1115 Broadway Suite 307";
	String BILLING_CITY						="New York";
	String BILLING_ZIP_CODE					="10011";
	String BILLING_PHONE_NUM				="718-926-0000";
	
// NJ Shipping Address
	String BILLING_NJ_NAME					="New Jersey Shipping";
	String BILLING_NJ_ADDRESS				="45 Cassville Rd Test";
	String BILLING_NJ_CITY					="Jackson";
	String BILLING_NJ_ZIP_CODE				="08527";
	String BILLING_NJ_PHONE_NUM				="718-926-0000";

	
// Non taxable Shipping address
	String BILLING_NONTAX_NAME				="Non Taxable Shipping";
	String BILLING_NONTAX_ADDRESS			="555 E Lafayette St Test";
	String BILLING_NONTAX_CITY				="Detroit";
	String BILLING_NONTAX_ZIP_CODE			="48226";
	String BILLING_NONTAX_PHONE_NUM			="718-926-0000";

}






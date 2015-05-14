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
	String PROMOCODE_ITEMLEVEL	 			="KERRYFF";
	String PROMOCODE_ORDERLEVEL	 			="";
	
// Items
	String INVENTORY_ITEM					="ruler";
	String INVENTORY_ITEM_DROPSHIP			="Orange Campfire Ottoman";
	String NON_INVENTORY_ITEM_DROPSHIP		="mini lamp";
	String KIT_ITEM							="kit";

}






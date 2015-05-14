package netsuite.pages;

import netsuite.base.WorkClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	public class ShoppingCart{
		
	WebDriver driver;
	    
	public ShoppingCart(WebDriver driver){
		this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	    
	/* 
	 * Search field
	 */
	@FindBy (id="search")
	WebElement search;
	
	/* 
	 * Go searching button
	 */
	@FindBy (id="go")
	WebElement goSearching;
	
	public void searchingInventoryItem(String item){
		search.clear();
		search.sendKeys(item);
		goSearching.click();
	}
	
	
	
	/* 
	 * Add to cart button
	 */
	@FindBy (xpath = "(//*[contains(text(), 'ADD TO CART')])[1]")
	WebElement addToCartButton;
	
	public void clickAddToCartButton(){
		addToCartButton.click();
	}
	
	/* 
	 * Mini cart button
	 */
	@FindBy (css = ".mini-cart>a")
	WebElement miniCart;
	
	public void clickOnMiniCart(){
		miniCart.click();
	}
	
	
	/* 
	 * Checkout button
	 */
	@FindBy (xpath = "(//input[@value='checkout'])[1]")
	WebElement checkoutButton;
	
	public void clickCheckoutButton(){
		checkoutButton.click();
	}
	
	public void addItemViaSearch(String item) {
		clickOnMiniCart();
		searchingInventoryItem(item);
		clickAddToCartButton();
		clickOnMiniCart();
	}
}

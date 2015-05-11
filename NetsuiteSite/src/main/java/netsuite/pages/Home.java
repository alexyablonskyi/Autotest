package netsuite.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	
	public Home(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* 
	 * Login page link
	 */
	
	@FindBy(id = "myaccount")
    WebElement myAccountButton;
	
	public void openLoginPage(){
		myAccountButton.click();
	}
	
	/*
	 * Slider section
	 */
	
	@FindBy(xpath=".//*[@id='slider-wrapper']")
	WebElement sliderWrapper;
	
	public String getSliderWrapperXpath(){
		return ".//*[@id='slider-wrapper']";
	}
}

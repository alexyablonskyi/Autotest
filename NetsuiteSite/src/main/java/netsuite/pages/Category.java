package netsuite.pages;

import java.sql.Array;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Category {
	
	WebDriver driver;
	
	public Category(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/*
	 * Open Writing category via main menu
	 */
	@FindBy(xpath = ".//a[@title='Writing']")
	WebElement writingCategory;
	
	public void openWritingCategoryPage(){
		writingCategory.click();
	}
	
	
	/*
	 * Items per page filter
	 */

	@FindBy (xpath = ".//select[@id='itemsperpageselector']")
	WebElement itemsPerPage;
	
	public void selectQuantityOfItemsPerPage(String quantity){
		Select dropdown = new Select(driver.findElement(By.xpath(".//select[@id='itemsperpageselector']")));
		dropdown.selectByVisibleText(quantity);
	}
	
	public int getQuantityOfItemsOnPage(){
		int quantityOfItems = driver.findElements(By.xpath(".//p[@class = 'price']")).size();
		return quantityOfItems;
	}
	
	
	/*
	 * Find element by color
	 */
	
	public int getQuontityOfItemsWithColor(String color){
		int quantityOfItemsWithColor = driver.findElements(By.xpath(".//*[@id='handle_itemMainPortlet']//h2/a[contains(text(), '"+color+"')]")).size();
		return quantityOfItemsWithColor;
	}
	
	@FindBy (xpath = ".//*[@id='handle_itemMainPortlet']//div[@class='filterselect']")
	WebElement filterByColor;
	
	public void selectColorOnFilterByColor(String color){
		Actions actions = new Actions(driver);
		actions.moveToElement(filterByColor).perform();
		actions.moveToElement(filterByColor).pause(500);
		driver.findElement(By.xpath(".//*[@id='filter_custitem3']/li[@class='"+color+"']")).click();
	}
	/*
	
	public  getArrayOfItemsOnPage(){
		Arrays[] quantityOfItems = driver.findElements(By.xpath(".//p[@class = 'price']")).toArray(a);
		return quantityOfItems;
	}
	
	*/
	
	
}

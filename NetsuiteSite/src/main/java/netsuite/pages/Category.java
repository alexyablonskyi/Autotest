package netsuite.pages;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
	
	
	public void getArrayOfItemsOnPage(){
		List<WebElement> list = driver.findElements(By.xpath(".//p[@class = 'price']"));
		System.out.println("Number of elements: " + list.size());
		
		List<WebElement> spans = driver.findElements(By.xpath(".//span[@class = 'custom-detail']"));
		
		for(WebElement ele : list){
			for(WebElement span : spans){
					String res = ele.getText();
					System.out.println("main result: " +res);
				
					String result = span.getText();
					System.out.println("result of span: " +result);
				
					String res2 = res.replace(result, "");
			
					System.out.println("Result after replace: " + res2);
			
			
			//Integer x = Integer.valueOf(res);
			//System.out.println(x);
			}

        } 
	}
	
	
	
	
}

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
	@FindBy(xpath = ".//a[@title='Furniture']")
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
	
	
	public int[] getArrayOfItemsOnPage(){
		List<WebElement> list = driver.findElements(By.xpath(".//p[@class = 'price']"));
		System.out.println("Number of elements: " + list.size());

		int arrayPrice[] = new int[list.size()];              
		for(int j =0;j<list.size();j++){  
			arrayPrice[j] = Integer.parseInt(list.get(j).getText().replace("$", "").replace(",", ""));
			//System.out.println(arrayPrice[j]);
		}
		return arrayPrice;
	}
	
	
	public boolean bruteforce(int[] input) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 1; j < input.length; j++) {
                if (input[i]>= input[j]) {
                    System.out.println(input[i]);
                    System.out.println(input[j]);
                    return false;
                }
            }
        }
        return true;
    }

/*
public class Main {
 
   public static void main(String[] args) {
      int[] arr = { 4, 1, 2, 3, 5 };
      int inn;
      for (inn = 0; inn < arr.length - 1; inn++)
         if (arr[inn] < arr[inn + 1])
            break;
      System.out.println(inn == arr.length - 1);
   }
}*/
}

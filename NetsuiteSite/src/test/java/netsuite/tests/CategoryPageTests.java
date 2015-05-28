package netsuite.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import netsuite.base.*;
import netsuite.pages.*;
import netsuite.utilities.Utilities;

public class CategoryPageTests extends Base {
	
	Category category;
	
	@Test(enabled= false, priority=0, groups = {"Items per page filters"}, 
			description= "Verify filter for Items per page (6 items)")
	public void verifyFilterOfQuantityItemsPerPage() throws Exception{
		category = new Category(driver);
		category.openWritingCategoryPage();
		category.selectQuantityOfItemsPerPage("6");
		
		Assert.assertEquals(category.getQuantityOfItemsOnPage(), 6);
		
		System.out.println("Find elements on page= " + category.getQuantityOfItemsOnPage());
	}
	
	@Test(enabled= false, priority=1, groups = {"Filter by Color"}, 
			description= "Verify filter by Color")
	public void verifyFilterByColor() throws Exception{
		category = new Category(driver);
		category.openWritingCategoryPage();
		category.selectColorOnFilterByColor("red");
		Utilities.waitUntilAjaxRequestCompletes();

		Assert.assertEquals(category.getQuontityOfItemsWithColor("Red"), category.getQuantityOfItemsOnPage());
		
		System.out.println("Found elements on page= " + category.getQuantityOfItemsOnPage());
		System.out.println("Found elements with Red color= " + category.getQuontityOfItemsWithColor("Red"));
	}
	
	
	 
	@Test(enabled= true, priority=2, groups = {"Filter by Color"}, 
			description= "Verify filter by Color")
	public void verifyFilterByPrice() throws Exception{
		category = new Category(driver);
		category.openWritingCategoryPage();
		category.getArrayOfItemsOnPage();
		
		Thread.sleep(2000);
	
		
		//Assert.assertEquals(category.getQuontityOfItemsWithColor("Red"), category.getQuantityOfItemsOnPage());
		
		//System.out.println("Found elements on page= " + category.getQuantityOfItemsOnPage());
		//System.out.println("Found elements with Red color= " + category.getQuontityOfItemsWithColor("Red"));
	}
	
	
	
	
	
	
	
	
	
}

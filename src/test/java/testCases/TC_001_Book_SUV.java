package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookCabPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_001_Book_SUV extends BaseClass {
	@Test(enabled = true, groups = { "smoke" })
	public void search() throws InterruptedException {
		// Creating a searchPage object
		SearchPage sp = new SearchPage(driver);

		// Creating a BookCabPage object
		BookCabPage bcp = new BookCabPage(driver);

		Thread.sleep(5000);
		
		closePopUp();

		// Clicking on Cab
		
		
		sp.clickcab();

		// Setting from location Delhi
		sp.setFromTab("Delhi");
		Thread.sleep(3000);

		// Selecting the first Suggestion
		sp.click_first_from_suggestion();

		// Setting To Location manali
		sp.setToTab("Manali");
		Thread.sleep(2000);
		// Selecting the first Suggestion
		sp.click_first_to_suggestion();

		// Select date to onboard
		sp.setStartDate();

		// Select Time
		sp.SetTime();

		// Click on Search Button
		sp.clickSearch();

		// Using Assert Class to check whether the page navigated to next page
		Assert.assertEquals("Select Filters", bcp.validatePage());
		Thread.sleep(2000);

		// click on SUV checkBox
		bcp.click_checkbox_of_SUV();

		// Scroll Till First Option of Suv is seen
		bcp.ScrollTillLowestSUVTab();

		Thread.sleep(1000);
		// Print the minimum SUV price on console
		System.out.println("MINIMUM PRICE OF SUV :" + bcp.minimum_price());
		System.out.println("---------------------------------------------");
	}
}

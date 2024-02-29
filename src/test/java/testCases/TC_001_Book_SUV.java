package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BookCabPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_001_Book_SUV extends BaseClass {
	@Test(enabled = true, groups = { "smoke" })
	public void search() throws InterruptedException {
		SearchPage sp = new SearchPage(driver);
		BookCabPage bcp = new BookCabPage(driver);
		sp.clickcab();
		sp.setFromTab("Delhi");
		Thread.sleep(3000);
		sp.click_first_from_suggestion();
		sp.setToTab("Manali");
		Thread.sleep(2000);
		sp.click_first_to_suggestion();
		sp.setStartDate();
		sp.SetTime();
		sp.clickSearch();
		Assert.assertEquals("Select Filters", bcp.validatePage());
		Thread.sleep(2000);
		bcp.click_checkbox_of_SUV();
		bcp.ScrollTillLowestSUVTab();
		Thread.sleep(1000);
		System.out.println("MINIMUM PRICE OF SUV :" + bcp.minimum_price());
	}
}

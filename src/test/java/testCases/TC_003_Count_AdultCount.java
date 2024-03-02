package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_003_Count_AdultCount extends BaseClass {
	@Test(enabled = true, groups = { "smoke" })
	public void adultCount() throws InterruptedException {
		// Creating a searchPage object
		SearchPage sp = new SearchPage(driver);
		Thread.sleep(2000);
		
		//click on hotel
		sp.click_hotel_tab();
		
		//click on guest
		sp.click_guest();
		
		//Printing the max allowed adult in guest selection
		System.out.println("Total Adult Count :" + sp.getAdultCount());
		String actual_value = Integer.toString(sp.getAdultCount());
		sp.click_guest_apply();
		
		//Checking wheather the acutal adult count is 40 or not
		Assert.assertEquals(actual_value, "40");
	}
}
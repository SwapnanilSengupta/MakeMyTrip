package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_003_Count_AdultCount extends BaseClass {
	@Test(enabled = true,groups= {"smoke"})
	public void adultCount() throws InterruptedException {
		SearchPage sp = new SearchPage(driver);
		Thread.sleep(2000);
		sp.click_hotel_tab();
		sp.click_guest();
		System.out.println("Total Adult Count :" + sp.getAdultCount());
		String actual_value = Integer.toString(sp.getAdultCount());
		sp.click_guest_apply();
		Assert.assertEquals(actual_value, "40");
	}
}
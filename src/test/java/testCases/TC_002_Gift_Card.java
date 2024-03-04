package testCases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.GiftCardsPage;
import pageObjects.SearchPage;
import testBase.BaseClass;
import utilities.ExcelUtility;

public class TC_002_Gift_Card extends BaseClass {
	@Test(enabled = true, groups = { "regression" })
	public void enter_wrong_info() throws InterruptedException, IOException {
		// Creating a searchPage object
		SearchPage sp = new SearchPage(driver);

		Thread.sleep(6000);
		
		
		closePopUp();
		
		Thread.sleep(2000);

		// Scroll Till GiftCard is visible
		sp.ScrollTillGiftCardTab();
		Thread.sleep(2000);

		// Clicking on GiftCard
		sp.click_gift_card();

		// Storing Window Handle of next page
		Set<String> win_handles = driver.getWindowHandles();
		List<String> win_handles_list = new ArrayList<String>(win_handles);

		//// Creating a GiftCardPage object
		GiftCardsPage gcp = new GiftCardsPage(driver.switchTo().window(win_handles_list.get(1)));
		Thread.sleep(2000);

		// Scrolling till BirthdayCard is visible
		gcp.ScrollTillBirthDayCardTab();
		Thread.sleep(2000);

		// Click on birthday Card
		gcp.click_birthday_gift_card();

		// Using ExcelUtility file for excel operation
		ExcelUtility eu = new ExcelUtility(
				"C:\\Users\\2310300\\eclipse-workspace\\Cognizant_Hackathon_Make_My_Trip\\ExcelSheets\\User_Credential.xlsx");
		int row_num = eu.getRowCount("Sheet1");
		for (int i = 1; i <= row_num; i++) {
			gcp.setName(eu.getCellData("Sheet1", i, 0));
			String name = eu.getCellData("Sheet1", i, 0).toString();
			gcp.setMobileNumber(eu.getCellData("Sheet1", i, 1));
			gcp.setEmailId(eu.getCellData("Sheet1", i, 2));
			gcp.clickBuy();
			Thread.sleep(3000);
			String message = gcp.getErrorEmailMessage();
			captureScreenShot(name);
			Assert.assertEquals("Please enter a valid Email id.", message);
			System.out.println("ERROR MESSAGE :"+message);
			System.out.println("---------------------------------------------");
		}
	}
}

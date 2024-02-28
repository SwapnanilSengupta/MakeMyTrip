package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardsPage extends BasePage {
	public GiftCardsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"top-banner\"]/div[2]/div/div[1]/div[2]/div[2]/div[3]/ul/li[3]/div/img")
	WebElement birthday_gift_card;

	@FindBy(name ="senderName")
	WebElement senderName;

	@FindBy(name = "senderMobileNo")
	WebElement senderMobileNumber;

	@FindBy(name = "senderEmailId")
	WebElement senderEmailId;

	@FindBy(xpath = "//button[normalize-space()='BUY NOW']")
	WebElement BuyOnButton;

	@FindBy(xpath = "//p[@class='red-text font11 append-top5']")
	WebElement wrongEmailMessage;

	@FindBy(xpath = "//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[3]/ul[1]/li[3]/div[1]/img[1]")
	WebElement birthdayCardTab;

	public void click_birthday_gift_card() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", birthday_gift_card);
	}

	public void setName(String Name) {
		senderName.sendKeys(Name);
	}

	public void setMobileNumber(String Number) {
		senderMobileNumber.sendKeys(Number);
	}

	public void setEmailId(String email) {
		senderEmailId.sendKeys(email);
	}

	public void clickBuy() {
		BuyOnButton.click();
	}

	public String getErrorEmailMessage() {
		return wrongEmailMessage.getText();
	}

	public void ScrollTillBirthDayCardTab() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", birthday_gift_card);
	}

}

package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookCabPage extends BasePage {
	public BookCabPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//p[@class='latoBold font20 appendTop10 appendBottom20']")
	WebElement filter_label_validation;

	@FindBy(xpath = "//label[normalize-space()='SUV']")
	WebElement suv_checkBox;

	@FindBy(xpath = "//div[@id='List']//div[1]//div[1]//div[3]//div[1]//div[2]//div[1]//p[1]")
	WebElement minimum_price;

	@FindBy(xpath = "//div[@class='borderRadius8 appendBottom15 rapBg makeFlex column']")
	WebElement LowestSUVTab;

	public String validatePage() {
		return filter_label_validation.getText();
	}

	public void click_checkbox_of_SUV() {
		suv_checkBox.click();
	}

	public String minimum_price() {
		return minimum_price.getText();
	}

	public void ScrollTillLowestSUVTab() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", LowestSUVTab);
	}
}

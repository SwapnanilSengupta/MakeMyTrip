package testBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public static WebDriver driver;

	@BeforeClass()
	public void setup() {
		driver = new ChromeDriver();
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}

	public void captureScreenShot(String user) throws IOException {
		WebElement specific_location = driver.findElement(By.xpath("//div[@class='deliver__content']"));
		File src = specific_location.getScreenshotAs(OutputType.FILE);
		File trg = new File(
				"C:\\Users\\2310300\\eclipse-workspace\\Cognizant_Hackathon_Make_My_Trip\\ScreenShots\\"+user+".png");
		FileUtils.copyFile(src, trg);
	}
	
	public void refresh()
	{
		driver.navigate().refresh();
	}

	@AfterClass()
	public void teardown() {
		driver.quit();
	}
}

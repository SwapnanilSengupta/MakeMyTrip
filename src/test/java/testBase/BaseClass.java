package testBase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	public static WebDriver driver;

	@BeforeClass()
	@Parameters({ "browser", "os", "enviroment" })
	public void setup(String browser, String os, String env) throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		if (env.equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			} else {
				System.out.println("ERROR!!!!!!!!!");
			}
			// Below Code is for Selenium Grid if the enviroment is set to remote
		} else if (env.equalsIgnoreCase("remote")) {
			if (browser.equals("Chrome")) {
				cap.setBrowserName("chrome");
			} else if (browser.equalsIgnoreCase("Edge")) {
				cap.setBrowserName("MicrosoftEdge");
			} else {
				System.out.println("ERROR!!!!!!!!!");
			}

			if (os.equalsIgnoreCase("Window")) {
				cap.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("Mac")) {
				cap.setPlatform(Platform.MAC);
			} else {
				System.out.println("ERROR!!!!!!!!!");
			}

			driver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap);
		}
		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
	}
	
	//for caputuring screenshot
	public void captureScreenShot(String file) throws IOException {
		WebElement specific_location = driver.findElement(By.xpath("//div[@class='deliver__content']"));
		File src = specific_location.getScreenshotAs(OutputType.FILE);
		File trg = new File("C:\\Users\\2310300\\eclipse-workspace\\Cognizant_Hackathon_Make_My_Trip\\ScreenShots\\"
				+ file + ".png");
		FileUtils.copyFile(src, trg);
	}

	public static void captureScreenhotOnFailure(String file) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File(
				"C:\\Users\\2310300\\eclipse-workspace\\Cognizant_Hackathon_Make_My_Trip\\ScreenShots\\"+file+".png"));
	}

	public void refresh() {
		driver.navigate().refresh();
	}

	@AfterClass()
	public void teardown() {
		driver.quit();
	}
}

package TestCases;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	WebDriver driver;
	Logger log;

	@BeforeMethod
	public void startTest() {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://www.ksrtc.in/oprs-web/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		log = Logger.getLogger("Automation Testing");
		PropertyConfigurator.configure("./log4j.properties");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
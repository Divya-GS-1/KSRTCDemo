package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//*[@title='Recruitment']")
	WebElement click_Recruit;

	@FindBy(xpath = "//*[@id='content']/h1/a")
	WebElement click_clickHere;
	
	public  void KSRTC_HomePage () throws Exception{
		click_Recruit.click();
		Thread.sleep(5000);
		click_clickHere.click();
	}
	
}

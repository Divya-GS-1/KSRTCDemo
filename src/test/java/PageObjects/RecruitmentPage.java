package PageObjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentPage {

	WebDriver driver;
	public RecruitmentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(linkText = "English")
	WebElement  click_languageChange;
	
	@FindBy(xpath ="//*[@title='Department Applications Login']")
	WebElement click_dropdown;
	
	
	
	public void KSRTC_RecruitmentPage() throws Exception {
		Set<String> win_all=driver.getWindowHandles();
		ArrayList<String> wins=new ArrayList(win_all);
		
		driver.switchTo().window(wins.get(1));
		System.out.println("In recruitment - page object");
		click_languageChange.click();
		Thread.sleep(5000);
		click_dropdown.click();
		List<WebElement> Application_list=driver.findElements(By.xpath("//ul[@class= 'dropdown-menu multi-level show']"));
		for(WebElement dropdown:Application_list) {
			String list=dropdown.getText();
			System.out.println(list);
     if( list.contains("CRM Login"))
	{				dropdown.click();
			}
		}
		System.out.println("Job completed");
		driver.close();
		driver.switchTo().window(wins.get(0));
	}
	
	
	
	
}

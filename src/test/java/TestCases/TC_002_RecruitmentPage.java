package TestCases;

import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RecruitmentPage;

public class TC_002_RecruitmentPage extends BaseClass {

	@Test
	public void HomeTC2() throws Exception {
		System.out.println("Second Test case: Home page of KSRTC");
		HomePage KSRTC_Home = new HomePage(driver);
		KSRTC_Home.KSRTC_HomePage();
		System.out.println("Second Test case: Recruiting page");
		Thread.sleep(30000);
		System.out.println(" --Added comment, Check in from Gitdesktop--");
		System.out.println(" --* *Added comment from Github * * --");
		RecruitmentPage recruit = new RecruitmentPage(driver);
		recruit.KSRTC_RecruitmentPage();
		log.info("TestCase 2 completed");
	}
}

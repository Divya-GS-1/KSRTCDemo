package TestCases;

import java.util.Set;

import org.testng.annotations.Test;

import PageObjects.HomePage;

public class TC_001_HomePage extends BaseClass {

	@Test
	public void HomepageTestCase() throws Exception {
		String parent = driver.getWindowHandle();
		HomePage KSRTC_Home = new HomePage(driver);

		KSRTC_Home.KSRTC_HomePage();
		log.info("KSRTC Homepage started");

		Set<String> allWindowHandles = driver.getWindowHandles();

		System.out.println("Count of windows: " + allWindowHandles.size());

		for (String child : allWindowHandles) {
			System.out.println(" window ID: " + child);
			if (!child.equals(parent)) {
				System.out.println("Now in child Window " + driver.getTitle() + "  id--> " + child);
				Thread.sleep(3000);
				System.out.println("Closing child window");
				driver.close();
			}
		}
		log.info("Completed TestCase 1");

	}
}

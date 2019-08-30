package tests;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.GurukulaHomePage;
import pages.GurukulaLoginPage;
import testbase.TestBase;

/**
 * This class verifies login is working fine
 */
public class TC_Login_01 extends TestBase {

	@Test
	public void userLogin() {
		GurukulaHomePage gurukulaHomePage;
		GurukulaLoginPage gurukulaLoginPage;
		try {
			gurukulaHomePage = PageFactory.initElements(driver, GurukulaHomePage.class);
			gurukulaLoginPage = PageFactory.initElements(driver, GurukulaLoginPage.class);

			if (driver.getTitle().equals("gurukula")) {
				Assert.assertTrue(true);
				logger.info("Page Title matched");
			} else {
				captureScreen(driver, "userLogin");
				Assert.assertTrue(false);
				logger.info("Page Title not matched");
			}
			gurukulaHomePage.clickLoginLink();
			Thread.sleep(2000);

			if (driver.getTitle().equals("Authentication")) {
				Assert.assertEquals(true, true);
				logger.info("Page Title matched");
			} else {
				captureScreen(driver, "userLogin");
				logger.info("Page Title not matched");
				Assert.assertEquals(false, true);
			}

			gurukulaLoginPage.enterUsername(username);
			gurukulaLoginPage.enterPassword(password);
			gurukulaLoginPage.clickAuthenticate();

			Thread.sleep(2000);

			if (driver.getTitle().equals("gurukula")) {
				Assert.assertEquals(true, true);
				logger.info("Page Title matched");
			} else {
				captureScreen(driver, "userlogin");
				logger.info("Page Title not matched");
				Assert.assertEquals(false, true);
			}	

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

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
public class LoginTest extends TestBase {

	@Test
	public void userLogin() {
		GurukulaHomePage gurukulaHomePage = PageFactory.initElements(driver, GurukulaHomePage.class);
		GurukulaLoginPage gurukulaLoginPage = PageFactory.initElements(driver, GurukulaLoginPage.class);

		if (driver.getTitle().equals("gurukula")) {
			Assert.assertTrue(true);
			logger.info("Page Title matched");
		} else {
			try {
				captureScreen(driver, "userLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("Page Title not matched");
		}

		gurukulaHomePage.clickLoginLink();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (driver.getTitle().equals("Authentication")) {
			Assert.assertEquals(true, true);
			logger.info("Page Title matched");
		} else {
			try {
				captureScreen(driver, "userLogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Page Title not matched");
			Assert.assertEquals(false, true);
		}

		gurukulaLoginPage.enterUsername(username);
		gurukulaLoginPage.enterPassword(password);
		gurukulaLoginPage.clickAuthenticate();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if (driver.getTitle().equals("gurukula")) {
			Assert.assertEquals(true, true);
			logger.info("Page Title matched");
		} else {
			try {
				captureScreen(driver, "userlogin");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("Page Title not matched");
			Assert.assertEquals(false, true);
		}

	}

}

package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GurukulaHomePage;
import pages.GurukulaRegistrationPage;
import testbase.TestBase;

/**
 * This class verifies register new client functionality is working fine
 */

public class RegisterNewAccountTest extends TestBase {

	@Test
	public void registerNewAccount() {

		GurukulaHomePage gurukulaHomePage = PageFactory.initElements(driver, GurukulaHomePage.class);
		GurukulaRegistrationPage gurukulaRegistrationPage = PageFactory.initElements(driver,
				GurukulaRegistrationPage.class);

		if (driver.getTitle().equals("gurukula")) {
			Assert.assertTrue(true);
			logger.info("Page Title matched");
		} else {
			try {
				captureScreen(driver, "registerNewAccount");
			} catch (IOException e) {

				e.printStackTrace();
			}
			Assert.assertTrue(false);
			logger.info("Page Title not matched");
		}

		gurukulaHomePage.clickOnRegisterLink();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		boolean registrationLabelDisplayed = gurukulaRegistrationPage.verifyRegistrationLabel();
		assertEquals(registrationLabelDisplayed, true, "Registration label displayed");

		gurukulaRegistrationPage.enterName("preetesh");
		logger.info("name entered");

		gurukulaRegistrationPage.enterEmail("preeteshsoni@abc.com");
		logger.info("email entered");

		gurukulaRegistrationPage.enterPassword("Preetesh123");
		logger.info("password entered");

		gurukulaRegistrationPage.enterConfirmPassword("Preetesh123");
		logger.info("confirm password entered");

		gurukulaRegistrationPage.submitForm();

	}
}

package tests;

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

public class TC_RegisterNewAccountTest_03 extends TestBase {

	@Test
	public void registerNewAccount() {

		GurukulaHomePage gurukulaHomePage;
		GurukulaRegistrationPage gurukulaRegistrationPage;
		try {
			gurukulaHomePage = PageFactory.initElements(driver, GurukulaHomePage.class);
			gurukulaRegistrationPage = PageFactory.initElements(driver, GurukulaRegistrationPage.class);

			if (driver.getTitle().equals("gurukula")) {
				logger.info("Page Title matched");
				Assert.assertTrue(true);
			} else {
				captureScreen(driver, "registerNewAccount");
				logger.info("Page Title not matched");
				Assert.assertTrue(false);
			}

			gurukulaHomePage.clickOnRegisterLink();

			Thread.sleep(1000);

			if (gurukulaRegistrationPage.verifyRegistrationLabel()) {
				Assert.assertTrue(true);
				logger.info("Registration Label displayed");
			} else {
				captureScreen(driver, "registerNewAccount");
				logger.info("Registration Label display failed");
				Assert.assertTrue(false);
			}

			gurukulaRegistrationPage.enterName("preetesh");
			logger.info("name entered");

			gurukulaRegistrationPage.enterEmail("preeteshsoni@abc.com");
			logger.info("email entered");

			gurukulaRegistrationPage.enterPassword("Preetesh123");
			logger.info("password entered");

			gurukulaRegistrationPage.enterConfirmPassword("Preetesh123");
			logger.info("confirm password entered");

			gurukulaRegistrationPage.submitForm();
			Thread.sleep(1000);
			
			boolean failureMessage= driver.getPageSource().contains("Registration saved!");
			boolean successMessage= driver.getPageSource().contains("Registration failed! Please try again later.");
			
			
			if(successMessage) {
				Assert.assertTrue(true);
				logger.info("Registration saved");
			}else if(failureMessage) {
				
				captureScreen(driver, "registerNewAccount");
				logger.info("Registration failed");
				Assert.assertTrue(false);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}

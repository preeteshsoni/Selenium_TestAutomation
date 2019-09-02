package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GurukulaHomePage;
import pages.GurukulaLoginPage;
import testbase.TestBase;
import utilities.ExcelUtils;

/**
 * This class reads username password from excel and verifies login
 * functionality is working fine
 */

public class TC_LoginDataDriven_02 extends TestBase {

	GurukulaHomePage gurukulaHomePage = null;
	GurukulaLoginPage gurukulaLoginPage = null;

	@Test(dataProvider = "Logindata")
	public void loginDDT(String user, String pwd) {

		try {

			gurukulaHomePage = PageFactory.initElements(driver, GurukulaHomePage.class);
			gurukulaLoginPage = PageFactory.initElements(driver, GurukulaLoginPage.class);

			gurukulaHomePage.clickLoginLink();

			Thread.sleep(2000);
			gurukulaLoginPage.enterUsername(user);
			logger.info("username entered");
			gurukulaLoginPage.enterPassword(pwd);
			logger.info("password entered");
			gurukulaLoginPage.clickAuthenticate();

			Thread.sleep(2000);

			if (isSuccessMessage() == true) {
				Assert.assertTrue(true);
				logger.info("login passsed");
				gurukulaHomePage.clickAccountList();
				Thread.sleep(1000);
				gurukulaHomePage.clicklnkLogout();
			} else {
				captureScreen(driver, "loginDDT");
				logger.warn("login failed");
				gurukulaHomePage.clickOnHomeButton();
				Assert.assertTrue(false);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean isSuccessMessage() {
		try {
			driver.findElement(By.xpath("//div[@class='alert alert-success ng-scope ng-binding']"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	@DataProvider(name = "Logindata")
	String[][] getData() throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\TestDataXL.xlsx";
		int rownum = ExcelUtils.getRowCount(path, "Login");
		int colcount = ExcelUtils.getCellCount(path, "Login", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = ExcelUtils.getCellData(path, "Login", i, j);
			}
		}
		return logindata;
	}
}

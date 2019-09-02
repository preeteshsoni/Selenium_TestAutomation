package tests;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GurukulaBranchPage;
import pages.GurukulaHomePage;
import pages.GurukulaLoginPage;
import pages.GurukulaStaffPage;
import testbase.TestBase;
import utilities.ExcelUtils;

public class TC_CreateBranchesAndAddStaff_04 extends TestBase {

	GurukulaHomePage gurukulaHomePage = null;
	GurukulaLoginPage gurukulaLoginPage = null;
	GurukulaBranchPage gurukulaBranchPage = null;
	GurukulaStaffPage gurukulaStaffPage = null;

	@Test(priority = 1)
	public void loginUser() {

		try {

			gurukulaHomePage = PageFactory.initElements(driver, GurukulaHomePage.class);
			gurukulaLoginPage = PageFactory.initElements(driver, GurukulaLoginPage.class);

			gurukulaHomePage.clickLoginLink();

			Thread.sleep(2000);
			gurukulaLoginPage.enterUsername(username);
			logger.info("username entered");
			gurukulaLoginPage.enterPassword(password);
			logger.info("password entered");
			gurukulaLoginPage.clickAuthenticate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(priority = 2, dataProvider = "Branchdata")
	public void createBranch(String name, String code) throws IOException {
		try {
			gurukulaBranchPage = PageFactory.initElements(driver, GurukulaBranchPage.class);
			gurukulaHomePage.clicklnkEntities();
			logger.info("Entity clicked");
			gurukulaHomePage.clicklnkBranch();
			logger.info("Branch clicked");
			Thread.sleep(1000);
			gurukulaBranchPage.clickCreateBranch();
			logger.info("Create branch clicked");
			Thread.sleep(1000);
			gurukulaBranchPage.enterBranchName(name);
			gurukulaBranchPage.enterBranchCode(code);
			gurukulaBranchPage.clickSave();
			Assert.assertTrue(true);
			logger.info("Branch Added");
			Thread.sleep(2000);
		}

		catch (InterruptedException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			captureScreen(driver, "createBranch");
			logger.info("Branch not Added");
			Assert.assertTrue(false);
			e.printStackTrace();
		}

	}

	@Test(priority = 3, dataProvider = "Staffdata")
	public void createStaff(String name, String branch) throws IOException {
		try {
			gurukulaStaffPage = PageFactory.initElements(driver, GurukulaStaffPage.class);

			gurukulaHomePage.clicklnkEntities();
			logger.info("Entity clicked");
			gurukulaHomePage.clicklnkStaff();
			logger.info("Staff clicked");
			Thread.sleep(1000);
			gurukulaStaffPage.clickCreateStaff();
			logger.info("Create staff clicked");
			Thread.sleep(1000);

			gurukulaStaffPage.enterStaffName(name);
			gurukulaStaffPage.selectBranch(branch);
			logger.info("Name and branch entered");
			gurukulaStaffPage.clickSave();
			logger.info("Save clicked");
			Assert.assertTrue(true);
			logger.info("Staff Added");
			Thread.sleep(1000);

		} catch (InterruptedException e) {

			e.printStackTrace();
		} catch (NoSuchElementException e) {
			captureScreen(driver, "createBranch");
			logger.info("Staff not Added");
			Assert.assertTrue(false);
			e.printStackTrace();
		}

	}

	@DataProvider(name = "Branchdata")
	String[][] getBranchData() throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\TestDataXL.xlsx";
		int rownum = ExcelUtils.getRowCount(path, "Branch");
		int colcount = ExcelUtils.getCellCount(path, "Branch", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = ExcelUtils.getCellData(path, "Branch", i, j);
			}
		}
		return logindata;
	}

	@DataProvider(name = "Staffdata")
	String[][] getStaffData() throws IOException {

		String path = System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\TestDataXL.xlsx";
		int rownum = ExcelUtils.getRowCount(path, "Staff");
		int colcount = ExcelUtils.getCellCount(path, "Staff", 1);

		String logindata[][] = new String[rownum][colcount];

		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = ExcelUtils.getCellData(path, "Staff", i, j);
			}
		}
		return logindata;
	}

}

package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.GurukulaHomePage;
import pages.GurukulaLoginPage;
import testbase.TestBase;
import utilities.ExcelUtils;

public class TC_LoginDDT_01 extends TestBase{
	
	@Test(dataProvider = "Logindata")
	public void loginDDT(String user, String pwd) throws InterruptedException, IOException {
		
		GurukulaHomePage gurukulaHomePage = PageFactory.initElements(driver, GurukulaHomePage.class);
		GurukulaLoginPage gurukulaLoginPage = PageFactory.initElements(driver, GurukulaLoginPage.class);
		
		gurukulaHomePage.clickLoginLink();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		gurukulaLoginPage.enterUsername(user);
		logger.info("username entered");
		gurukulaLoginPage.enterPassword(pwd);
		logger.info("password entered");
		gurukulaLoginPage.clickAuthenticate();
		
		Thread.sleep(2000);
		
		if(isSuccessMessage()==true) {
			Assert.assertTrue(true);
			logger.info("login passsed");
			gurukulaHomePage.clickAccountList();
			Thread.sleep(1000);
			gurukulaHomePage.clicklnkLogout();
		}else
		{
			captureScreen(driver, "loginDDT");
			logger.warn("login failed");
			gurukulaHomePage.clickOnHomeButton();
			Assert.assertTrue(false);
			
		}
		
		
	}
	
	public boolean isSuccessMessage()
	{
		try {
		driver.findElement(By.xpath("//div[@class='alert alert-success ng-scope ng-binding']"));
		return true;
	}
		catch(Exception e) {
			return false;
		}
	}
	

	@DataProvider(name="Logindata")
	String[][] getData() throws IOException{
		
		String path= System.getProperty("user.dir")+ "\\src\\test\\java\\testdata\\LoginDataXL.xlsx";
		int rownum= ExcelUtils.getRowCount(path, "Sheet1");
		int colcount= ExcelUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ExcelUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}

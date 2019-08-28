package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GurukulaHomePage {

	WebDriver driver;

	public GurukulaHomePage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.LINK_TEXT, using = "Home")
	WebElement btnHome;
	
	@FindBy(linkText = "login")
	WebElement lnkLogin;

	@FindBy(how = How.LINK_TEXT, using = "Register a new account")
	WebElement lnkRegister;
	
	@FindBy(xpath = "//span[contains(@class, 'hidden-tablet ng-scope') and text()='Account']")
	WebElement mnuAccount;
	
	@FindBy(linkText = "Log out")
	WebElement lnkLogout;
	
	
	
	public void clickOnHomeButton() {
		btnHome.click();
	}

	public void clickOnRegisterLink() {
		lnkRegister.click();
	}
	
	public void clickLoginLink() {
		lnkLogin.click();
	}
	
	public void clickAccountList() {
		mnuAccount.click();
	}
	
	public void clicklnkLogout() {
		lnkLogout.click();
	}
	
	
}

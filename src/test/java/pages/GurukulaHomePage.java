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

	public void clickOnHomeButton() {
		btnHome.click();
	}

	public void clickOnRegisterLink() {
		lnkRegister.click();
	}
	
	

	/*
	 * public boolean verifyHomeButtonDisplayed() { if(homeButton.isDisplayed()) {
	 * System.out.println("home button displayed"); return true; } else {
	 * System.out.println("home button not displayed"); return false; }
	 * 
	 * 
	 * }
	 */
}

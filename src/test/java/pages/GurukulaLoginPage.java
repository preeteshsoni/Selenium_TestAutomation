package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Represents all the web elements present in Gurukula login page
 */

public class GurukulaLoginPage {

	WebDriver driver;

	public GurukulaLoginPage(WebDriver driver) {

		this.driver = driver;
	}

	@FindBy(id = "username")
	WebElement txtUsername;

	@FindBy(id = "password")
	WebElement txtPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnAuthenticate;

	public void enterUsername(String username) {
		txtUsername.sendKeys(username);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void clickAuthenticate() {
		btnAuthenticate.click();
	}

}

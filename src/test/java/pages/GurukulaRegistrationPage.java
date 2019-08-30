package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


/**
 * Represents all the web elements present in Gurukula Registration page
 */

public class GurukulaRegistrationPage {

	WebDriver driver;

	public GurukulaRegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div[1]/div/div/div/h1")
	WebElement registrationLabel;

	@FindBy(how = How.NAME, using = "login")
	WebElement txtLogin;

	@FindBy(how = How.NAME, using = "email")
	WebElement txtEmail;

	@FindBy(how = How.NAME, using = "password")
	WebElement txtPassword;

	@FindBy(how = How.NAME, using = "confirmPassword")
	WebElement txtConfirmPassword;

	public boolean verifyRegistrationLabel() {

		String reg = registrationLabel.getText();
		if (reg.contentEquals("Registration")) {
			System.out.println("register label displayed");
			return true;
		} else {
			System.out.println("register label not displayed");
			return false;
		}

	}

	public void enterName(String name) {
		txtLogin.sendKeys(name);
	}

	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void enterConfirmPassword(String password) {
		txtConfirmPassword.sendKeys(password);
	}

	public void submitForm() {
		txtConfirmPassword.submit();
	}

}

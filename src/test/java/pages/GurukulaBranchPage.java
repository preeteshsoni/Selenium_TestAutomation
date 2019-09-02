package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GurukulaBranchPage {
	WebDriver driver;

	public GurukulaBranchPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement btnCreateBranch;

	@FindBy(name = "name")
	WebElement txtBranchName;

	@FindBy(name = "code")
	WebElement txtBranchCode;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSave;

	public void clickCreateBranch() {
		btnCreateBranch.click();
	}

	public void enterBranchName(String branchname) {
		txtBranchName.sendKeys(branchname);
	}

	public void enterBranchCode(String branchcode) {
		txtBranchCode.sendKeys(branchcode);

	}

	public void clickSave() {
		btnSave.click();
	}

}

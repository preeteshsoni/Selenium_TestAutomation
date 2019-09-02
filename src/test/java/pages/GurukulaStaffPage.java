package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GurukulaStaffPage {

	WebDriver driver;

	public GurukulaStaffPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement btnCreateStaff;

	@FindBy(name = "name")
	WebElement txtStaffName;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnSave;

	@FindBy(name = "related_branch")
	WebElement lstBranches;

	public void clickCreateStaff() {
		btnCreateStaff.click();
	}

	public void enterStaffName(String staffname) {
		txtStaffName.sendKeys(staffname);
	}

	public void selectBranch(String branchname) {
		
		Select branchName = new Select(lstBranches);
		lstBranches.click();
		branchName.selectByVisibleText(branchname);
	}

	public void clickSave() {
		btnSave.click();
	}
}

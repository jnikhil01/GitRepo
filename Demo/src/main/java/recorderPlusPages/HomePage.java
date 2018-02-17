package recorderPlusPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	@FindBy(xpath = "html/body/form/div[3]/aside[1]/section/ul/li[2]/a/i[2]")
	WebElement ITAPApps;
	@FindBy(xpath = "html/body/form/div[3]/aside[1]/section/ul/li[2]/ul/li[1]/a/i[2]")
	WebElement MyITAPInfo;
	@FindBy(xpath = "//a[@href='/itapportal/EmpDetails.aspx']")
	WebElement EmployeeSearch;
	@FindBy(xpath = "//span[@id='lbl_UserName_Dropdown']")
	WebElement btnLogoff;
	@FindBy(xpath = "//a[@id='hl_signout']")
	WebElement signOut;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickITAPApps() {
		ITAPApps.click();
	}

	public void clickMyITAPInfo() {
		MyITAPInfo.click();
	}

	public void clickEmployeeSearch() throws InterruptedException {
		Thread.sleep(5000);
		EmployeeSearch.click();
	}

	public void logoff() {
		btnLogoff.click();
		signOut.click();
	}
}

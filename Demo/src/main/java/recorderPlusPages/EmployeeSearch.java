package recorderPlusPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeSearch {
	@FindBy(xpath = "html/body/form/div[3]/aside[2]/section/div[2]/div[2]/div/a")
	WebElement select;
	WebDriver driver;

	public EmployeeSearch(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSelect() {
		select.click();
		
	}

}

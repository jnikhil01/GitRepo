package recorderPlusPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeeSelect {
	WebDriver driver;

	@FindBy(id = "txtValues")
	WebElement txtValues;

	@FindBy(id = "btnSearch")
	WebElement searchButton;

	public EmployeeSelect(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setTextValues(String name) {
		txtValues.clear();
		txtValues.sendKeys(name);
	}

	public void clickSearch() throws InterruptedException {
		searchButton.click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#GridView1>tbody>tr>td")).click();
	}

}

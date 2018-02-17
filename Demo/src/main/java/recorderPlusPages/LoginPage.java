package recorderPlusPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	@FindBy(xpath = "//input[@name='UserName']")
	WebElement username;
	@FindBy(xpath = "//input[@name='Password']")
	WebElement password;
	@FindBy(xpath = "//input[@name='LoginButton']")
	WebElement btnLogin;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void openPage() {
		driver.get("https://itap.myatos.net/");
	}

	public void setUsername(String name) {
		username.sendKeys(name);
	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void click() {
		btnLogin.click();
	}

}

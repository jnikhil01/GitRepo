package uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {
	
	WebDriver driver;
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	@FindBy(xpath=".//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement SignIn;

	@FindBy(xpath=".//*[@id='email']")
	WebElement userName;
	
	@FindBy(xpath=".//*[@id='passwd']")
	WebElement password;
	
	@FindBy(xpath=".//*[@id='SubmitLogin']")
	WebElement submitButton;
	
	@FindBy(xpath=".//*[@id='center_column']/div[1]/ol/li")
	public WebElement authenticationFalied;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginToApplication(String email,String pwd) {
		SignIn.click();
		log.info("Clicked on SignIn "+SignIn.toString());
		userName.sendKeys(email);
		log.info("Entered email ID : "+email);
		password.sendKeys(pwd);
		submitButton.click();
		
		log.info("Clicked on submitButton : "+submitButton.toString());
		
	}
	
	public String getInvalidLoginText() {
		return authenticationFalied.getText();
		
	}
}

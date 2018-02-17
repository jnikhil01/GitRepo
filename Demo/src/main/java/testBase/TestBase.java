package testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public WebDriver driver;
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	String baseURL = "http://automationpractice.com/index.php";
	String browser = "firefox";
	
	public void init() {
		PropertyConfigurator.configure("log4j.properties");
		driver = new FirefoxDriver();
		driver.get(baseURL);
		log.info("Navigating to "+baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		
	}
}

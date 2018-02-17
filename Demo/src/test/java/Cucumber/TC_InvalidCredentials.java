package Cucumber;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import testBase.TestBase;
import uiActions.HomePage;

public class TC_InvalidCredentials extends TestBase {

	HomePage homePage;
	public static final Logger log = Logger.getLogger(TC_InvalidCredentials.class.getName());

	@BeforeTest
	public void setUp() {
		init();
	}

	@Test
	public void login() {
		log.info("******* Started InvalidCredentials TestCase ********");
		homePage = new HomePage(driver);
		homePage.loginToApplication("Test@gmail.com", "password");
		
		Assert.assertEquals(homePage.getInvalidLoginText(), "Authentication failed.");

		log.info("******* Finished InvalidCredentials TestCase ********");
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}

}

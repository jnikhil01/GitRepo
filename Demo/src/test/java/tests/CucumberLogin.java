package tests;

import java.util.Iterator;
import java.util.Set;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import recorderPlusPages.EmployeeSearch;
import recorderPlusPages.EmployeeSelect;
import recorderPlusPages.HomePage;
import recorderPlusPages.LoginPage;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/feature/" })

public class CucumberLogin {

	static WebDriver driver = new FirefoxDriver();;
	static LoginPage loginPage;
	static String employeeSearchWindow;
	static Set<String> windows;
	static EmployeeSearch employeeSearch;

	@Given("^Mercury tours login page \"(.*?)\" and \"(.*?)\"$")
	public void mercury_tours_login_page_and(String userName, String password) throws Throwable {
		// windows = driver.getWindowHandles();
		loginPage = new LoginPage(driver);
		loginPage.openPage();
		Thread.sleep(5000);
		loginPage.setUsername(userName);
		loginPage.setPassword(password);
	}

	@When("^Click on Login button$")
	public void when() throws Throwable {
		loginPage.click();
	}

	@Then("^The search result page title should contain the \"(.*?)\"$")
	public void the_search_result_page_title_should_contain_the(String search_term) throws Throwable {
		try {
			System.out.println(driver.getTitle());
			Assert.assertEquals(driver.getTitle(), search_term);

			HomePage homePage = new HomePage(driver);
			homePage.clickITAPApps();
			homePage.clickMyITAPInfo();
			homePage.clickEmployeeSearch();
			windows = driver.getWindowHandles();
			for (Iterator<String> iterator = windows.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				System.out.println(windows.size());
				System.out.println(driver.switchTo().window(string).getCurrentUrl());
				System.out.println(driver.switchTo().window(string).getTitle());
				
				Thread.sleep(5000);
				if (driver.switchTo().window(string).getCurrentUrl()
						.equals("https://itap.myatos.net/itapportal/empdetails.aspx")) {
					employeeSearchWindow = string;
					System.out.println("Employee search window : " + employeeSearchWindow);
					break;
				}
			}
			//homePage.logoff();
		} catch (Exception E) {
			E.printStackTrace();
			System.out.println("User does not exist");
		} finally {
			Thread.sleep(5000);
			// driver.quit();
		}
	}

	@Given("^Employee search page$")
	public void employee_search_page() throws Throwable {
		System.out.println(employeeSearchWindow);
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(employeeSearchWindow);
		employeeSearch = new EmployeeSearch(driver);
		
		Thread.sleep(20000);
		employeeSearch.clickSelect();
		//windows.clear();
		windows = driver.getWindowHandles();

		for (String string : windows) {
			if (driver.switchTo().window(string).getTitle().contains("Employee search")) {
				System.out.println(driver.switchTo().window(string).getCurrentUrl());
				System.out.println(driver.switchTo().window(string).getTitle());
				break;
			}
		}
	}

	@Then("^User searches for the the \"(.*?)\"$")
	public void user_searches_for_the_the(String DASId) throws Throwable {
		
		EmployeeSelect employeeSelect = new EmployeeSelect(driver);
		employeeSelect.setTextValues(DASId);
		employeeSelect.clickSearch();
		
		employeeSearch.clickSelect();
		driver.switchTo().window(employeeSearchWindow);
	}

}

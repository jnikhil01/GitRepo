package Cucumber;

import java.util.Iterator;
import java.util.Set;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import cucumber.api.CucumberOptions;
import cucumber.api.java.en.*;
import cucumber.api.junit.Cucumber;

/**
 * Unit test for simple App.
 */

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resource/features/" })

public class TestRunner {
	WebDriver driver = new FirefoxDriver();
	String employeeSearch=null;

	@Given("^Open ITAP$")
	public void Open_ITAP() throws Throwable {
		driver.get("https://itap.myatos.net/");
	}

	@When("^User enters Username and Password$")
	public void User_enters_Username_and_Password() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='UserName']")).sendKeys("A566317");
		driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("Monday@1112");
	}

	@When("^User enters incorrect Username and Password$")
	public void User_enters_incorrect_Username_and_Password() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='UserName']")).sendKeys("fhch");
		driver.findElement(By.xpath(".//*[@id='Password']")).sendKeys("fdfdh");
		
	}

	@Then("^User clicks on login button$")
	public void User_clicks_on_login_button() throws Throwable {
		driver.findElement(By.xpath(".//*[@id='LoginButton']")).click();
	}

	@Then("^User is successfully logged in$")
	public void User_is_successfully_logged_in() throws Throwable {
		Assert.assertEquals(driver.getCurrentUrl(), "https://itap.myatos.net/itapportal/mainpage.aspx");
	}

	@Then("^User clicks on logout$")
	public void User_clicks_on_logout() throws Throwable {
		driver.findElement(By.xpath("html/body/header/nav/div/ul/li/a")).click();
		driver.findElement(By.xpath(".//*[@id='hl_signout']")).click();
		driver.quit();
	}

	@But("^Authentication failed message is displayed on the screen$")
	public void Authentication_failed_message_is_displayed_on_the_screen() throws Throwable {
		System.out.println(driver
				.findElement(By
						.xpath(".//*[@id='form1']/div[3]/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[13]/td/font"))
				.getText());
		Assert.assertEquals(driver
				.findElement(By
						.xpath(".//*[@id='form1']/div[3]/table/tbody/tr/td/table/tbody/tr[1]/td/table/tbody/tr[13]/td/font"))
				.getText(), "Authentication Failed.");
	}

	@Then("^User navigates to Employee search$")
	public void User_navigates_to_Employee_search() throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='aside_sidebar_container']/section/ul/li[2]/a")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='aside_sidebar_container']/section/ul/li[2]/ul/li[1]/a/i[2]")).click();
		Thread.sleep(5000);
		driver.findElement(
				By.xpath(".//*[@id='aside_sidebar_container']/section/ul/li[2]/ul/li[1]/ul/li[6]/div/a/span")).click();
		Thread.sleep(5000);
		Set<String> windows = driver.getWindowHandles();
		String string = null;
		for (Iterator<String> iterator = windows.iterator(); iterator.hasNext();) {
		 string = (String) iterator.next();
			if (driver.switchTo().window(string).getCurrentUrl()
					.equals("https://itap.myatos.net/itapportal/empdetails.aspx")) {
				Thread.sleep(5000);
				driver.switchTo().window(string).findElement(By.cssSelector("#cph_MainContent_main_content_hypApprover")).click();
				break;
			}
		}
		System.out.println("adasd"+driver.switchTo().window(string).getCurrentUrl());
		System.out.println(driver.switchTo().window(string).getTitle());
		
		employeeSearch = driver.getWindowHandle();
		System.out.println(driver.switchTo().window(employeeSearch).getCurrentUrl());
	
	}
// \"([^\"]*)\"$
	@Given("^Search for \"([^\"]*)\"$")
	public void search_for_A(String DasId) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		//driver.switchTo().window(employeeSearch);
		Set<String> windows2 = driver.getWindowHandles();
		String currentWindow = driver.getWindowHandle();
		System.out.println(driver.switchTo().window(currentWindow).getCurrentUrl());
		Thread.sleep(5000);
		for (Iterator iterator = windows2.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if (driver.switchTo().window(string).getTitle().contains("Employee search")) {
				break;
			}
		}
		driver.findElement(By.xpath(".//*[@id='txtValues']")).sendKeys(DasId);
		driver.findElement(By.xpath(".//*[@id='btnSearch']")).click();
		driver.findElement(By.xpath(".//*[@id='GridView1']/tbody/tr[2]/td[1]")).click();
		driver.switchTo().window(currentWindow);

		driver.findElement(By.xpath(".//*[@id='btnGo']")).click();
		System.out.println(driver
				.findElement(By.xpath(".//*[@id='cph_MainContent_main_content_mySnap_pnlist']/table/tbody/tr[2]/td[2]"))
				.getText());
	}

}
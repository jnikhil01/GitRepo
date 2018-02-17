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

public class RecorderPlusTest {

	static WebDriver driver = new FirefoxDriver();;
	static LoginPage loginPage;
	static String employeeSearchWindow;
	static Set<String> windows;
	static EmployeeSearch employeeSearch;

	

}

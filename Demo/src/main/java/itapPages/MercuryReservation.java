package itapPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercuryReservation {
	WebDriver driver;
	By btnLogoff = By.xpath("//span[@id='lbl_UserName_Dropdown']");
	
	public MercuryReservation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void logoff(){
		
		driver.findElement(btnLogoff).click();
		driver.findElement(By.xpath("//a[@id='hl_signout']")).click();
	}
}

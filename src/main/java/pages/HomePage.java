package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
	}
	
	//i want driver from LoginTest
	public void clickOnMyAccountOption() {
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	}
	
	public void selectLogin() {
		driver.findElement(By.linkText("Login")).click();
	}
	
	public void selectRegister() {
		driver.findElement(By.linkText("Register")).click();
	}

	public void quitBrowser() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
}

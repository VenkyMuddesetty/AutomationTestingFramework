package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	public void enterUserName(String userName) {
		driver.findElement(By.id("input-email")).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	
	public void clickOnSubmitButton() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	public void verifyLoginWarningMessage() {
		String actualWarningText = driver.findElement(By.xpath("//div[contains(text(),'Warning')]")).getText();
		String expectedWarningText = "Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(actualWarningText, expectedWarningText);
	}
	
	
}

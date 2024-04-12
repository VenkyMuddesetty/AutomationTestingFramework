package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AccountPage {
	WebDriver driver;
	
	public AccountPage(WebDriver driver){
		this.driver = driver;
	}
	public void verifyLoginSuccessfulText() {
		// Assertion
		// 1. Hard Assert and 2. Soft Assert
		String actualText = driver.findElement(By.partialLinkText("Edit your account")).getText();
		String expText = "Edit your account information";
		Assert.assertEquals(actualText, expText);
	}
}

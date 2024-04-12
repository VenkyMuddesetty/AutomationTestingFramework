package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class RegisterPage {

	WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void enterFirstName(String firstName) {
		driver.findElement(By.id("input-firstname")).sendKeys(firstName);
	}
	public void enterLastName(String lastName) {
		driver.findElement(By.id("input-lastname")).sendKeys(lastName);
	}
	public void enterEmail(String email) {
		driver.findElement(By.id("input-email")).sendKeys(email);
	}
	public void enterTelephone(String telephone) {
		driver.findElement(By.id("input-telephone")).sendKeys(telephone);
	}
	public void enterPassword(String password) {
		driver.findElement(By.id("input-password")).sendKeys(password);
	}
	public void enterConfirmPassword(String confirmPassword) {
		driver.findElement(By.id("input-confirm")).sendKeys(confirmPassword);
	}
	
	
	
	public void selectPrivacyPolicy() {
		driver.findElement(By.xpath("//input[@type='checkbox']")).click(); 
	}
	
	public void clickOnContinue() {
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
	}
	
	public void verifyRegisterSuccessfullText() {
		String registerSuccessText = driver.findElement(By.xpath("//h1[text()='Your Account Has Been Created!']")).getText();
		Assert.assertTrue(registerSuccessText.contains("Has Been Created"));
		System.out.println("Your Account Has Been Created!");
	}

	public void selectNewsLetterOption() {
		driver.findElement(By.name("newsletter")).click();
	}
	
	public void verifyRegisterWarningMessage() {
		String registerWarningText = driver
				.findElement(By.xpath("//div[text()='Warning: You must agree to the Privacy Policy!']")).getText();
		Assert.assertTrue(registerWarningText.contains("Warning"));
		System.out.println("Warning message has been verified..");
	}
	
}

package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class SearchTest extends Base{

	//write 3 test cases
	//Search Scenario
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndLaunchApplication();
	}
	
	@AfterMethod
	public void quitBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	//TC-1
	@Test
	public void searchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys("HP");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String productText = driver.findElement(By.linkText("HP LP3065")).getText();
		Assert.assertTrue(productText.contains("HP"));//validation
	}
	
	//TC-2
	@Test
	public void searchWithInvalidProduct() {
		driver.findElement(By.name("search")).sendKeys("Apache RTR");
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String productText = driver.findElement(By.xpath("//p[contains(text(),'There is no product')]")).getText();
		Assert.assertTrue(productText.contains("ABC"));//validation
	}
	
	//TC-3
	@Test(dependsOnMethods = "searchWithInvalidProduct")
	public void searchWithoutEnteringAnyProduct() {
		driver.findElement(By.xpath("//i[@class='fa fa-search']")).click();
		
		String productText = driver.findElement(By.xpath("//p[contains(text(),'There is no product')]")).getText();
		Assert.assertTrue(productText.contains("There is no product"));//validation
		
	}
}

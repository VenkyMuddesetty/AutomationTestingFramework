package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.Base;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

//Login scenarios - 4 test cases
public class LoginTest extends Base{

	WebDriver driver;//global variable declaration
	

	@BeforeMethod
	public void setup() {
		
		driver = initializeBrowserAndLaunchApplication();
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountOption();
		homePage.selectLogin();
	}
	
	@AfterMethod
	public void quitBrowser() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.quitBrowser();
	}

	// TC-1
	@Test
	public void loginWithValidUsernameAndValidPassword() {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(prop.getProperty("userName"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnSubmitButton();
		
		AccountPage accPage = new AccountPage(driver);
		accPage.verifyLoginSuccessfulText();

	}

	// TC-2
	@Test
	public void loginWithValidUsernameAndInvalidPassword() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(prop.getProperty("userName"));
		loginPage.enterPassword(prop.getProperty("incorrectPassword"));
		loginPage.clickOnSubmitButton();

		loginPage.verifyLoginWarningMessage();

	}

	// TC-3
	@Test
	public void loginWithInvalidUsernameAndValidPassword() throws InterruptedException {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(prop.getProperty("incorrectUserName"));
		loginPage.enterPassword(prop.getProperty("password"));
		loginPage.clickOnSubmitButton();

		loginPage.verifyLoginWarningMessage();
	}

	// TC-4
	@Test
	public void loginWithWithoutUsernameAndPassword() throws InterruptedException {

		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnSubmitButton();

		loginPage.verifyLoginWarningMessage();
	}

}

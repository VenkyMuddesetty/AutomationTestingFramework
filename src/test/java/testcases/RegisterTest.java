package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.HomePage;
import pages.RegisterPage;

//Register Scenario

public class RegisterTest extends Base {

	WebDriver driver;// global variable declaration

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndLaunchApplication();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccountOption();
		homePage.selectRegister();
	}

	@AfterMethod
	public void quitBrowser() throws Exception {
		HomePage homePage = new HomePage(driver);
		homePage.quitBrowser();
	}

	// TC-1
	@Test
	public void registerWithAllMandatoryDetail() {

		RegisterPage regPage = new RegisterPage(driver);
		regPage.enterFirstName(prop.getProperty("firstName"));
		regPage.enterLastName(prop.getProperty("lastName"));
		regPage.enterEmail(prop.getProperty("userName"));
		regPage.enterTelephone(prop.getProperty("telephone"));
		regPage.enterPassword(prop.getProperty("password"));
		regPage.enterConfirmPassword(prop.getProperty("password"));
		
		regPage.selectPrivacyPolicy();// privacy policy
		regPage.clickOnContinue();//click on Continue
		regPage.verifyRegisterSuccessfullText();
	}

	// TC-2
	@Test
	public void registerWithAllDetailAndSubscriptionYes() {
		RegisterPage regPage = new RegisterPage(driver);
		regPage.enterFirstName(prop.getProperty("firstName"));
		regPage.enterLastName(prop.getProperty("lastName"));
		regPage.enterEmail(prop.getProperty("userName"));
		regPage.enterTelephone(prop.getProperty("telephone"));
		regPage.enterPassword(prop.getProperty("password"));
		regPage.enterConfirmPassword(prop.getProperty("password"));
		
		// select newsletter subscription
		regPage.selectNewsLetterOption();
		regPage.selectPrivacyPolicy();// privacy policy
		regPage.clickOnContinue();//click on Continue

		regPage.verifyRegisterSuccessfullText();
	}

	// TC-3
	@Test
	public void registerWithoutProvidingAnyDetail() {
		
		RegisterPage regPage = new RegisterPage(driver);
		regPage.clickOnContinue();//click on Continue
		regPage.verifyRegisterWarningMessage();
	}
}

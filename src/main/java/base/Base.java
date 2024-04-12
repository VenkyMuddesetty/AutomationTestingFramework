package base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Base {

	public WebDriver driver;
	public Properties prop;
	//read data from properties file  -created a Base class constructor
	
	public Base(){
		String propPath="C:\\SeleniumFramework\\MavenFrameworkSeleniumBatch3\\TestData\\config.properties";
		prop = new Properties();
		try {
		FileInputStream fis = new FileInputStream(propPath);
		prop.load(fis);
		System.out.println(prop.getProperty("browserName"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndLaunchApplication() {
		String browserName = prop.getProperty("browserName");
		
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} 
		else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} 
		else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} 
		else {
			System.out.println("Invalid browser Thank you..!!");
		}

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
}

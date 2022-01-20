package com.crm.comcast.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * This is BaseClass contain configuration annotation
 * 
 * @author Meghana L
 *
 */

public class BaseClass {
	public WebDriver driver;
	public static  WebDriver sdriver;
	// create object for Utilities
	public WebDriverUtility wUtil = new WebDriverUtility();
	public JavaUtility jUtil = new JavaUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	public FileUtility fUtil = new FileUtility();

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })
	public void configBs() {
		// connection to dataBase
		System.out.println("=====Connect to DB========");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBc() throws Throwable {
		// Getting the data from the Properties file
		String browser = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		// Launching the browser
		if (browser.equals("chrome")) {
			System.setProperty(IPathCanstant.CHROME_KEY, IPathCanstant.CHROME_PATH);
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			System.setProperty(IPathCanstant.FIREFOX_KEY, IPathCanstant.FIREFOX_PATH);
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser is not supported");
		}
		sdriver=driver;
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		driver.get(url);
	}

	@BeforeMethod(groups = { "smokeTest", "regressionTest" })
	public void configBm() throws Throwable {
		// Getting the data from the Properties file
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		// Login to Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);
	}

	@AfterMethod(groups = { "smokeTest", "regressionTest" })
	public void configAm() {
		// LogOut from the Application
		HomePage homepage = new HomePage(driver);
		homepage.logOut();
	}

	@AfterClass(groups = { "smokeTest", "regressionTest" })
	public void configAc() {
		// closing or quitting the browser
		driver.quit();
	}

	@AfterSuite(groups = { "smokeTest", "regressionTest" })
	public void configAs() {
		// closing the database
		System.out.println("=====database connection is closed===");
	}

}

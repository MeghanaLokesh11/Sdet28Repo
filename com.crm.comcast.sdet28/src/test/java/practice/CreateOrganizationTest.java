package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathCanstant;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * it is used to create organization
 * @author Meghana
 *
 */


public class CreateOrganizationTest {

	@Test
	public void CreateOrganizations() throws Throwable {
	
		
		//create object for utilitities
		FileUtility fUtil = new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility();
		WebDriverUtility wUtil = new WebDriverUtility();
		
		
		//get the data from property file
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		String browserName =fUtil.getPropertyFileData("browser");
		
		
		//generate random number
		int randomNumber= jUtil.getRandomNumber();
				
		//get the data from excel sheet
		String OrganizationName = eUtil.getStringCellData("sheet1", 1, 2);
		OrganizationName=OrganizationName+randomNumber;
		
		   
		 // how to use browser value and launch the browser
		   WebDriver driver = null;
		   if(browserName.equals("chrome"))
		   {
			   System.setProperty(IPathCanstant.CHROME_KEY,IPathCanstant.CHROME_PATH);
			   driver= new ChromeDriver();
			   

		   }else  {
			   System.out.println("Browser is not supported");
		   }
		   
		   driver.manage().window().maximize();
		   wUtil.waitForPageLoad(driver);
		   
		   //login to application
		   
		   driver.get(url);
		   driver.findElement(By.name("user_name")).sendKeys("admin");
		   driver.findElement(By.name("user_password")).sendKeys("manager");
		   driver.findElement(By.id("submitButton")).click();
		   
		   //create organization
		   driver.findElement(By.linkText("Organizations")).click();
		   driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		   driver.findElement(By.name("accountname")).sendKeys(OrganizationName);
		   driver.findElement(By.name("button")).click();
		   String actualOrgName =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		   if(actualOrgName.contains("TestYantra")) {
			   System.out.println("Organization is created");
		   }else {
			   System.out.println("Organization is not created");
		   }
		   
		   //logout action
		   
		WebElement ele = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
		
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();

	}
}



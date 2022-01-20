package OrgnaizationTest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathCanstant;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateProductPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.ProductInformationPage;
import com.crm.comcast.objectRepository.ProductPage;

/**
 * this program will create a product in product Module
 * 
 * @author Meghana
 *
 */
//@Listeners(com.crm.comcast.GenericUtility.ListenerImpClass.class)
public class CreateProductTest1 extends BaseClass {

	@Test (groups={"regressionTest"})
	public void CreateProduct() throws Throwable {

		// get the data from excel sheet
		String Expectedproductname = eUtil.getStringCellData("sheet1", 6, 2);
		Expectedproductname = Expectedproductname + jUtil.getRandomNumber();

		// create Product
		HomePage homepage = new HomePage(driver);
		homepage.clickProductLink();

		ProductPage productpage = new ProductPage(driver);
		productpage.clickCreateProductImg();

		CreateProductPage createpropage = new CreateProductPage(driver);
		createpropage.createProduct(Expectedproductname);

		ProductInformationPage proInfoPage = new ProductInformationPage(driver);
		String actualProductName = proInfoPage.getProductInformationText();

		// product Name hard assert verification
		assertEquals(actualProductName.contains(Expectedproductname), true);

	}
	
	@Test (groups={"smokeTest"})
	public void CreateProductwithCategory() throws Throwable {

		// get the data from excel sheet
		String Expectedproductname = eUtil.getStringCellData("sheet1", 6, 2)+jUtil.getRandomNumber();
		String CategoryDropDown = eUtil.getStringCellData("sheet1", 14, 2);
		

		// create Product
		HomePage homepage = new HomePage(driver);
		homepage.clickProductLink();

		ProductPage productpage = new ProductPage(driver);
		productpage.clickCreateProductImg();

		CreateProductPage createpropage = new CreateProductPage(driver);
		createpropage.createProductWithCategory(Expectedproductname, CategoryDropDown);

		ProductInformationPage proInfoPage = new ProductInformationPage(driver);
		String actualProductName = proInfoPage.getProductInformationText();

		// product Name verification
		
		assertEquals(actualProductName.contains(Expectedproductname), true);
		

	}
	
	
}

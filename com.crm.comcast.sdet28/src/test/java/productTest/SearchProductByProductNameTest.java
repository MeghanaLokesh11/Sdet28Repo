package productTest;

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
import org.openqa.selenium.support.ui.Select;
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
 * This program will search the product by Product Name
 * 
 * @author DELL
 *
 */
public class SearchProductByProductNameTest extends BaseClass {
	/**
	 * 
	 * @param args
	 * @throws Throwable
	 */
	@Test
	public void SearchProductByProductName() throws Throwable {

		// get the data from excel sheet
		String productname = eUtil.getStringCellData("Sheet1", 6, 2);
		String Expecteddropdown = eUtil.getStringCellData("Sheet1", 7, 2);

		// create Product
		HomePage homepage = new HomePage(driver);
		homepage.clickProductLink();

		ProductPage productpage = new ProductPage(driver);
		productpage.sendSearchForProduct(productname);
		productpage.statusProductDropDown(Expecteddropdown);
		productpage.searchbutton();
		String actualdropdown = productpage.verifyProductInfo();

		// verification
		if (actualdropdown.contains(Expecteddropdown)) {
			System.out.println("product is present ");
		} else {
			System.out.println("product is not present");
		}

	}

}

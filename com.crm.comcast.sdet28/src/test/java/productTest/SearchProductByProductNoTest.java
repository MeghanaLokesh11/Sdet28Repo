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
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.ProductPage;

/**
 * This program will search the product by Product No * @author DELL
 *
 */

public class SearchProductByProductNoTest extends BaseClass {

	@Test

	public void SearchProductByProductNo() throws Throwable {

		// get the data from excel sheet
		String productnumber = eUtil.getStringCellData("Sheet1", 8, 2);
		String Expecteddropdown = eUtil.getStringCellData("Sheet1", 9, 2);

		// create Product
		HomePage homepage = new HomePage(driver);
		homepage.clickProductLink();

		ProductPage productpage = new ProductPage(driver);
		productpage.sendSearchForProduct(productnumber);
		productpage.statusProductDropDown(Expecteddropdown);
		productpage.searchbutton();
		String actualdropdown = productpage.verifyProductNoInfo();

		// verification
		if (actualdropdown.contains(Expecteddropdown)) {
			System.out.println("productNumber is matching");
		} else {
			System.out.println("productNo is not matching");
		}

	}

}

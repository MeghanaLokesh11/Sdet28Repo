package productTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
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
 * This program will search the product by PartName
 * 
 * @author Meghana
 *
 */
public class SearchProductByPartNameTest extends BaseClass {

	@Test
	public void SearchProductByPartName() throws Throwable {

		// get the data from excel sheet
		String partNumber = eUtil.getStringCellData("sheet1", 10, 2);
		String Expecteddropdown = eUtil.getStringCellData("Sheet1", 11, 2);

		// create Product
		HomePage homepage = new HomePage(driver);
		homepage.clickProductLink();

		ProductPage productpage = new ProductPage(driver);
		productpage.sendSearchForProduct(Expecteddropdown);
		productpage.statusProductDropDown(partNumber);
		Thread.sleep(3000);
		System.out.println(Expecteddropdown);
		productpage.searchbutton();
		String actualdropdown = productpage.verifyPartNoInfo();

		// verification
		if (actualdropdown.contains(Expecteddropdown)) {
			System.out.println("part Number");
		} else {
			System.out.println("part Number is not  equal to 25");
		}

	}

}

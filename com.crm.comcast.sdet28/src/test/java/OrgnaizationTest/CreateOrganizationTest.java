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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathCanstant;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.HomePage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationInformationPage;
import com.crm.comcast.objectRepository.OrganizationPage;

/**
 * it is used to create organization
 * 
 * @author Meghana
 *
 */
@Listeners(com.crm.comcast.GenericUtility.ListenerImpClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test (groups={"smokeTest"})
	public void CreateOrg() throws Throwable {

		// get the data from excel sheet
		String ExpectedorganizationName = eUtil.getStringCellData("sheet1", 1, 2);
		ExpectedorganizationName = ExpectedorganizationName + jUtil.getRandomNumber();

		// create organization
		HomePage homepage = new HomePage(driver);
		homepage.clickOrganizationLink();

		OrganizationPage orgpage = new OrganizationPage(driver);
		orgpage.clickCreateOrgImg();

		CreateOrganizationPage createorgpage = new CreateOrganizationPage(driver);
		createorgpage.CreateOrganization(ExpectedorganizationName);

		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrgInformationText();

		// organization name verification
		assertEquals((actualOrgName.contains(ExpectedorganizationName)), true);
	}
	

	@Test (groups={"regressionTest"})
	public void CreateOrgwithIndustry() throws Throwable {

		// get the data from excel sheet
		String ExpectedorganizationName = eUtil.getStringCellData("sheet1", 1, 2);
		String OrganizationwithIndustry = eUtil.getStringCellData("sheet1", 17, 2);
		ExpectedorganizationName = ExpectedorganizationName + jUtil.getRandomNumber();

		// create organization
		HomePage homepage = new HomePage(driver);
		homepage.clickOrganizationLink();

		OrganizationPage orgpage = new OrganizationPage(driver);
		orgpage.clickCreateOrgImg();

		CreateOrganizationPage createorgpage = new CreateOrganizationPage(driver);
		createorgpage.CreateOrganizationwithIndustry(ExpectedorganizationName, OrganizationwithIndustry);

		OrganizationInformationPage orgInfoPage = new OrganizationInformationPage(driver);
		String actualOrgName = orgInfoPage.getOrgInformationText();
		
		// organization name Hard assert verification
				assertEquals((actualOrgName.contains(ExpectedorganizationName)), true);

	}
}


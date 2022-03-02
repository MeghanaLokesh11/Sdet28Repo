package bookflight;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.IPathCanstant;

public class BookFlight {
	
	@Test
	public void BookTicket() throws Throwable {
		
		System.setProperty(IPathCanstant.CHROME_KEY, IPathCanstant.CHROME_PATH);
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//step1: mavigate to fipkart
				driver.get("https://www.tripodeal.com/");
				//enter departure date
				driver.findElement(By.id("origin")).sendKeys("BLR");
				//select BLR in suggesstion
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='eac-item']/b[text()='BLR']")).click();
				//enter destination
				Thread.sleep(2000);
				driver.findElement(By.id("destination")).sendKeys("DEL");
				//select the destination
				Thread.sleep(2000);
				driver.findElement(By.xpath("//div[@class='eac-item']/b[text()='DEL']")).click();
				//select date feb 16 2022
				Thread.sleep(2000);
				driver.findElement(By.id("dateNew")).click();
				Thread.sleep(2000);
				
				bookFlightDate(driver, "12", "02", "2022");
				driver.quit();
				
	
			}
	/**
	 * This method is used for calender
	 * @param driver
	 * @param date
	 * @param month
	 * @param year
	 */
	
	public void bookFlightDate(WebDriver driver, String date, String month, String year) {
		int NoOfMonth=12;//11,10
		while(NoOfMonth>=0) {
			try {
				driver.findElement(By.xpath("//div[text()='"+month+"']"//December
						+ "/following-sibling::div[text()='"+year+"']"
						+ "/ancestor::div[@class='picker__box']"
						+ "/descendant::div[text()='"+date+"']")).click();//NoSuchElementException
			}
			catch (Exception e) {
				NoOfMonth--;
				driver.findElement(By
						.xpath("//div[@title='Next month' and @aria-controls='dateNew_table']")).click();
			}

		}
	}
			
			/**
			 * returs the current date 
			 * @return format dd MMMM  YYYY
			 */
			public String getDate() {
				SimpleDateFormat format=new SimpleDateFormat("dd MMMM yyyy");
				String date = format.format(new Date());
				return date;
			}
		
	}



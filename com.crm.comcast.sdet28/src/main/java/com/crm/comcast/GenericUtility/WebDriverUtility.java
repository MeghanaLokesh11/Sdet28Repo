package com.crm.comcast.GenericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * This class contain webdriver related methods
 * @author Meghana L
 *
 */
public class WebDriverUtility {
	
	/**
	 * it will wait 20 seconds till the element load in POM
	 * @param driver
	 */
	
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	/**
	 * This method will wait till element is visible
	 * @param driver
	 * @param element
	 */

	public void waitForVisibilityofElement(WebDriver driver,WebElement element) {
		WebDriverWait Wait = new WebDriverWait(driver,20);
		Wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will Wait till the element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClick(WebDriver driver,WebElement element) {
		WebDriverWait Wait = new WebDriverWait(driver,20);
		Wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		}
	
	/**
	 * This Method is Used to wait for the element and do click operation
	 * @param element
	 * @throws InterruptedException 
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count=0;
		while(count<50) {
			try {
				element.click();
			}catch(Throwable e) {
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * This Method will select the element based on Index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	/**
	 * This Method will select the element based on value
	 * @param element
	 * @param value
	 */
	
	public void selectOption(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		}
	
	/**
	 * This Method will select the element based on text
	 * @param text
	 * @param element
	 */
	
	public void selectOption(String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	
	}
	/**
	 * This Method will verify whether expected option is present in the dropdown list or not
	 * @param element
	 * @param expectedOptions
	 * @return
	 */
	
	public WebElement verifyTheDropDown(WebElement element , String expectedOptions) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement ele:options) {
			if(ele.equals(expectedOptions)) {
				System.out.println("value is present in dropdown");
				return ele;
			}else {
				System.out.println("value is not present in dropdown");
				return ele;
			}
		}
		
	return null;
	}
	/**
	 * This Method perform Mouse hovering action
	 * @param driver
	 * @param element
	 */
	
	public void mouseOver(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This Method perform right click action
	 * @param driver
	 * @param element
	 */
	
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	
	/**
	 * Used to perform javascript click on webelement
	 * @param driver
	 * @param element
	 */
	
	public void jsClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", element);
		
	}
	
	/**
	 * method is used to send the value using javascript executor
	 * @param driver
	 * @param valueToEnter
	 * @param element
	 */
	
	public void enterDataUsingJs(WebDriver driver,String valueToEnter ,WebElement element) {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].value"+valueToEnter+"",element);
	}
	
	/**
	 * This method will switch to different windows using partial title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchWindow(WebDriver driver,String partialWindowTitle)
		{
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> it = winIds.iterator();
		while(it.hasNext()){
			String winId=it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if(title.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * this method is used to take screenshot in the case of failure
	 * @param driver
	 * @param testCaseName
	 * @return
	 */
	public String screenshot(WebDriver driver,String testCaseName) {
		JavaUtility jUtil = new JavaUtility();
		String filePath="./errorshot"+testCaseName+jUtil.systemDateAndTime();
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filePath);
		source.renameTo(destination);
		return filePath;
		
	}
	
	/**
	 * This Method will switch the frame based on the index passed
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	
	/**
	 * his Method will switch the frame based on the nameorID passed
	 * @param driver
	 * @param nameorID
	 */
	
	public void switchFrame(WebDriver driver,String nameorID)
	{
		driver.switchTo().frame(nameorID);
	}
	
	/**
	 * his Method will switch the frame based on the element passed
	 * @param driver
	 * @param element
	 */
	
	public void switchFrame(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	/**
	 * method will acccept the alert
	 * @param driver
	 */
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	/**
	 *this  method is click on dismiss button in alert popup
	 * @param driver
	 */
	
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
		}


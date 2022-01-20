package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * HomePage POM Design
 * @author Meghana
 *
 */
public class HomePage extends WebDriverUtility {
	//initialization of element
	WebDriver driver;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//declaration of element
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Products")
	private WebElement productLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText ="Sign Out")
	private WebElement signOutLink;
	
	//getters method
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	
	public WebElement getProductLink() {
		return productLink;
	}

	public WebElement getLogoutImg() {
		return logoutImg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}

	//business logics
	/**
	 * This Method will click on organization link
	 */
	public void clickOrganizationLink() {
		organizationLink.click();
	}
	
	/**
	 * This Method will perform logout action
	 */
	
	public void logOut()
	{
	mouseOver(driver, logoutImg);	
	signOutLink.click();
	}
	
	public void clickProductLink() {
		productLink.click();
	}
	
}

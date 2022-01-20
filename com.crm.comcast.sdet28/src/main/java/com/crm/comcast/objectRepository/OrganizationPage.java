package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * create Organization POM Class
 * @author Meghana
 *
 */

public class OrganizationPage {
	//initialization of element
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//declaration of element
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgPlusImg;

	//getters method
	public WebElement getCreateOrgPlusImg() {
		return createOrgPlusImg;
	}
	
	//business logic
	/**
	 * This Method will click on createOrg PlusImage
	 */
	public void clickCreateOrgImg() {
		createOrgPlusImg.click();
	}
	
	
}

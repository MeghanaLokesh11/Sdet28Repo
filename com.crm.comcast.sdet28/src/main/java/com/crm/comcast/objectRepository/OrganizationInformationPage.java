package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Organization information POM Class
 * @author Meghana
 *
 */

public class OrganizationInformationPage {
	
	//initialize Element
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of Element
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgInfoText;

	//getters method
	public WebElement getOrgInfoText() {
		return orgInfoText;
	}
	
	//business logic
	
	public String getOrgInformationText() {
		return orgInfoText.getText();
	}

}

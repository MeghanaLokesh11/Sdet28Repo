package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

/**
 * Create Organization POM Class
 * @author Meghana
 *
 */

public class CreateOrganizationPage extends WebDriverUtility {
	//initialization  of element
	public CreateOrganizationPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//declaration of element
	@FindBy(name="accountname")
	private WebElement organizationTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="industry")
	private WebElement industryDropdown;

	//getters method
	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}
	
	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	//business logic
	/**
	 * It will create an Organization 
	 * @param orgName
	 */

	public void CreateOrganization(String orgName) {
		organizationTextField.sendKeys(orgName);
		saveButton.click();
	}
	
	public void CreateOrganizationwithIndustry(String orgName , String dropdown) {
		organizationTextField.sendKeys(orgName);
		selectOption(dropdown, industryDropdown);
		saveButton.click();
	}
}

package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

public class CreateProductPage extends WebDriverUtility {
	//initialize element
	public CreateProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of element
	@FindBy(name="productname")
	private WebElement producTextfield;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	
	@FindBy(name="productcategory")
	private WebElement productcategorydropdown;
	
	//getters method
	public WebElement getProductInfoText() {
		return producTextfield;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	public WebElement getProductcategorydropdown() {
		return productcategorydropdown;
	}
	
	//business logic
	/**
	 * This Method will create product
	 * @param productName
	 */
	public void createProduct(String productName)
	{
		producTextfield.sendKeys(productName);
		saveButton.click();
	}
	
	public void createProductWithCategory(String productName, String producTdropdown) {
		producTextfield.sendKeys(productName);
		selectOption(producTdropdown, productcategorydropdown);
		saveButton.click();
}

	
}
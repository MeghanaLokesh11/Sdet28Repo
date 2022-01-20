package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	//initialize element
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of element
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement productInfoText;

	//getters method
	public WebElement getProductInfoText() {
		return productInfoText;
	}
	
	//business logic
	
	public String getProductInformationText() {
		return productInfoText.getText();
	}
	
}

package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

/**
 * ProductPage POM Design
 * @author DELL
 *
 */

public class ProductPage extends WebDriverUtility {
	
	//initialization of elements
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//declaration of elements
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgPlusImage;
	
	@FindBy(name="search_text")
	private WebElement searchProduct;
	
	@FindBy(id="bas_searchfield")
	private WebElement elementProduct;
	
	@FindBy(name="submit")
	private WebElement searchNowButton;
	
	@FindBy(xpath="//option[@label='Product Name']")
	private WebElement verifyProductName;
	
	@FindBy(xpath = "//option[@value='product_no']")
	private WebElement verifyProductNumber;
	
	@FindBy(xpath="//td[text()='25 ']")
	private WebElement verifyPartNo;

	
	//getters method
	public WebElement getCreateOrgPlusImage() {
		return createOrgPlusImage;
	}
	
	public WebElement getSearchProduct() {
		return searchProduct;
	}
	
	public WebElement getElement() {
		return elementProduct;
	}
	
	public WebElement getSearchNowButton() {
		return searchNowButton;
	}
	
	public WebElement getVerifyProductName() {
		return verifyProductName;
	}

	public WebElement getVerifyProductNumber() {
		return verifyProductNumber;
	}
	public WebElement getVerifyPartNo() {
		return verifyPartNo;
	}


	//business logic
	/**
	 * This Method will click on createProduct PlusImg
	 */
	public void clickCreateProductImg() {
		createOrgPlusImage.click();
	}
	
	public void sendSearchForProduct(String text) {
		searchProduct.sendKeys(text);
		
	}
	
	public void statusProductDropDown(String dropdownText) {
		selectOption(dropdownText,elementProduct);
		
	}
	
	public void searchbutton() {
		searchNowButton.click();
		
	}
	
	public String verifyProductInfo() {
		return verifyProductName.getText();
	}
	
	public String verifyProductNoInfo() {
		return verifyProductNumber.getText();
	}
	
	public String verifyPartNoInfo() {
		return verifyPartNo.getText();
	}
}

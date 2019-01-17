package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPOM {
	private WebDriver driver; 
	
	public ProductPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//body/div/nav/ul/li[3]")
	WebElement catalogbtn;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	WebElement productsLnk;
	
	@FindBy(xpath="//a[@class='asc']")
	WebElement productList;
	
	@FindBy(xpath="//a[contains(text(),'Model')]")
	WebElement modelList;
	
	@FindBy(xpath="//a[contains(text(),'Price')]")
	WebElement priceList;
	
	@FindBy(xpath="//a[contains(text(),'Quantity')]")
	WebElement quantityList;
	
	@FindBy(id="input-name")
	WebElement productName;
	
	@FindBy(id="button-filter")
	WebElement filterBtn;
	
	@FindBy(xpath="//*[contains(text(),'Integer vitae iaculis massa')]")
	WebElement matchingCriteria1;
	
	@FindBy(id="input-price")
	WebElement priceTextbox;
	
	@FindBy(xpath="//*[contains(text(),'Lorem ipsum dolor sit amet')]")
	WebElement matchingCriteria2;
	
	public boolean validateProductLink(){
		catalogbtn.click();
		productsLnk.click();
		return modelList.isDisplayed();
		
	}
	
	public String enterCredentials(){
		catalogbtn.click();
		productsLnk.click();
		productName.clear();
		productName.sendKeys("Integer vitae iaculis massa");
		String actual=productName.getAttribute("value");
		return actual;
	}
	
	public String filterButton1(){
		catalogbtn.click();
		productsLnk.click();
		productName.clear();
		productName.sendKeys("Integer vitae iaculis massa");
		filterBtn.click();
		return matchingCriteria1.getText();
	
	}
	
	public String enterPrice(){
		catalogbtn.click();
		productsLnk.click();
		priceTextbox.clear();
		priceTextbox.sendKeys("515");
		return priceTextbox.getAttribute("value");
		
		
	}
	
	public String filterButton2(){
		catalogbtn.click();
		productsLnk.click();
		priceTextbox.clear();
		priceTextbox.sendKeys("515");
		filterBtn.click();
		
		 return matchingCriteria2.getText();
		 
		
		
	}
}


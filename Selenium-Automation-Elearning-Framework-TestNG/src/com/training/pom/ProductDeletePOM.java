package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDeletePOM {
	private WebDriver driver; 
	
	public ProductDeletePOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//body/div/nav/ul/li[3]")
	WebElement catalogbtn;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	WebElement productsLnk;
	
	//USE a static property
	//@FindBy(xpath="//input[@value=S]")

	@FindBy(xpath="//table/tbody/tr[2]/td[1]")
	WebElement productToDelete;
	
	@FindBy(xpath="//button[@type='button' and @class='btn btn-danger']")
	WebElement deleteBtn;
	

	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successMessage1;
	
	public void deleteProduct(){
		catalogbtn.click();
		productsLnk.click();
		productToDelete.click();
		deleteBtn.click();
		
	}
	public String verifySuccessMessage(){
		String actual= successMessage1.getText();
		return actual;
	}

}

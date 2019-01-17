package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryDeletePOM {
	
	private WebDriver driver; 

	public CategoryDeletePOM(WebDriver driver ){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//body/div/nav/ul/li[3]")
	WebElement catalogbtn;
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	WebElement categoriesLnk;
	

	
	@FindBy(xpath="//table/tbody/tr[2]/td[1]")
	WebElement categoryToDelete;
	
	//(xpath="//input[@value=String1]")

	@FindBy(xpath=" //button[@type='button' and @class='btn btn-danger']")
	WebElement deleteBtn;
	
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement successMessage;
	

      public void deleteCategory(){
	  this.catalogbtn.click();
	  this.categoriesLnk.click();
	  this.categoryToDelete.click();
	  this.deleteBtn.click();

  }
	public String validateSuccessMessage(){
		String actual= successMessage.getText();
		return actual;
	}

}

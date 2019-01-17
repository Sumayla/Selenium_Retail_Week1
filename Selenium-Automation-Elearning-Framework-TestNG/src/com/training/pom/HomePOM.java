package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePOM  {
	private WebDriver driver; 
	
	
	public HomePOM(WebDriver driver) {
		
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//body/div/nav/ul/li[3]")
	WebElement catalogbtn;
	
	@FindBy(xpath="//a[contains(text(),'Categories')]")
	WebElement categoriesLnk;
	
	@FindBy(xpath="//a[contains(text(),'Products')]")
	WebElement productsLnk;
	
	@FindBy(xpath="//a[contains(text(),'Recurring Profiles')]")
	WebElement recurringLnk;
	
	@FindBy(className="asc")
	WebElement categoryName;
	
	@FindBy(linkText="Sort Order")
	WebElement sortOrder;
	
	@FindBy(xpath="//td[contains(text(),'Action')]")
	WebElement action;

	
	public boolean validatecategoriesLnk(){
		
		this.catalogbtn.click();
		return categoriesLnk.isDisplayed();

		
	}
	
public boolean validateProductsLnk(){
		
		this.catalogbtn.click();
		
		return productsLnk.isDisplayed();

		
	}

public boolean validateRecurringLnk(){
	
	this.catalogbtn.click();
	return recurringLnk.isDisplayed();

	
}

public boolean validateCategoryName(){
	this.catalogbtn.click();
	this.categoriesLnk.click();
	return categoryName.isDisplayed();
}

public boolean validateSortOrder(){
	this.catalogbtn.click();
	this.categoriesLnk.click();
	return sortOrder.isDisplayed();
}

public boolean validateAction(){
	this.catalogbtn.click();
	this.categoriesLnk.click();
	return action.isDisplayed();
}

}

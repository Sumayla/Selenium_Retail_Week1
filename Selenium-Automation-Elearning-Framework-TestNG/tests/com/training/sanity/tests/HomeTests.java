package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.HomePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class HomeTests{




	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private HomePOM homePOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver); 
		homePOM = new HomePOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
        loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void validatecategoriesLnkDisplayed() throws InterruptedException{
		Thread.sleep(5000);
		boolean flag=homePOM.validatecategoriesLnk();
		Assert.assertTrue(flag);
		screenShot.captureScreenShot("validatecategoriesLnkDisplayed");
	}
	
	@Test(priority=2)
	public void validateProductsLnkDisplayed(){
		boolean flag=homePOM.validateProductsLnk();
		Assert.assertTrue(flag);
		screenShot.captureScreenShot("validatecategoriesLnkDisplayed");
	}
	
	
	@Test(priority=3)
	public void validateRecurringLnkDisplayed(){
		boolean flag=homePOM.validateRecurringLnk();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=4)
	public void validateCategoryItemsDisplayed(){
		boolean flag1=homePOM.validateCategoryName();
		 Assert.assertTrue(flag1);
		
		boolean flag2=homePOM.validateSortOrder();
		Assert.assertTrue(flag2);
		
		boolean flag3=homePOM.validateAction();
		Assert.assertTrue(flag3);
		

		
		
	}
}



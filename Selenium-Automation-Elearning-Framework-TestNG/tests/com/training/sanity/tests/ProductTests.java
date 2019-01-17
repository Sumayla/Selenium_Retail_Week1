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
import com.training.pom.ProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductTests {
	

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ProductPOM productPOM;
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
		productPOM = new ProductPOM(driver);
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
	
	@Test
	public void validateProductLinkTest(){
		boolean flag=productPOM.validateProductLink();
		Assert.assertTrue(flag);
		screenShot.captureScreenShot(" validateProductLinkTest");	
	}
	
	@Test
	public void enterCredentials(){
		String actual=productPOM.enterCredentials();
		String expected ="Integer vitae iaculis massa";
		Assert.assertEquals(actual, expected);
		screenShot.captureScreenShot("enterCredentials");
	}
	
	@Test
	public void filterBtn1Test(){
		String actual=productPOM.filterButton1();
		Assert.assertEquals(actual, "Integer vitae iaculis massa");
		screenShot.captureScreenShot("filterBtn1Test");
		
	}

    @Test
    public void priceBoxTest(){
    	String actual=productPOM.enterPrice();
    	Assert.assertEquals(actual, "515");
    	System.out.println("price entered is displaying");
    	String Actual=productPOM.filterButton2();
    	Assert.assertEquals(Actual, "Lorem ipsum dolor sit amet");
    	System.out.println("Filter results are displaying correctly");
    	screenShot.captureScreenShot("priceBoxTest");
    }
}

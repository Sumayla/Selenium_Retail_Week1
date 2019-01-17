package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CategoryDeletePOM;
import com.training.pom.LoginPOM;
import com.training.pom.ProductDeletePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductDeleteTest {
	
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private ProductDeletePOM productDeletePOM;
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
		productDeletePOM = new ProductDeletePOM(driver);
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
public void deleteProductTest() throws InterruptedException{
	//String S=driver.findElement(By.xpath("//table/tbody/tr[2]/td[3]")).getAttribute("value");
	//System.out.println(S);
	Thread.sleep(5000);
	productDeletePOM.deleteProduct();
	Alert alert=driver.switchTo().alert();
	Thread.sleep(5000);
	String message1=alert.getText();
	String expected1="Are you sure?";
	Assert.assertEquals(message1, expected1);
	alert.accept();
	String message2=productDeletePOM.verifySuccessMessage();
	System.out.println(message2);
	String expected2="Success: You have modified products!";
	assertTrue(message2.contains(expected2));
	screenShot.captureScreenShot("ProductDelete");
	
	
}
}

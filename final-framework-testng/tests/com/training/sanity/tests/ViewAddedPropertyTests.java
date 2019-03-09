//Test Objective: To verify whether application allows admin to view added property details in All Properties window

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot_RealEstate;
import com.training.pom.ViewAddedPropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewAddedPropertyTests {

	private WebDriver driver;
	private String baseUrl;
	private ViewAddedPropertyPOM viewAddeddPropertyPOM;
	private static Properties properties;
	private ScreenShot_RealEstate screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		viewAddeddPropertyPOM = new ViewAddedPropertyPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot_RealEstate(driver);
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}
	@Test
	public void validLoginTest()  {
		
		//Log In as a Admin user
		viewAddeddPropertyPOM.clickButton(); 
		viewAddeddPropertyPOM.sendUserName("admin");
		viewAddeddPropertyPOM.sendPassword("admin@123");
		viewAddeddPropertyPOM.clickSignInBtn();
		
		//Go to Properties link and add a new property
		viewAddeddPropertyPOM.clickPropertiesBtn();
		viewAddeddPropertyPOM.clickAddNewBtn();
		
		String value="New launch";
		
		viewAddeddPropertyPOM.sendPostTitle("New launch");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		viewAddeddPropertyPOM.sendNewTextArea("New launch2222");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		viewAddeddPropertyPOM.clickPublishBtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//screenShot.captureScreenShot("ViewAddedProperty");
		
		//Validate the message after publishing
		String Expected1 = "Post published. View post";
		String Actual1 = driver.findElement(By.xpath("//*[@id=\"message\"]/p")).getText();
		Assert.assertEquals(Actual1, Expected1);
		System.out.println("Property added: "+Expected1);
		
		viewAddeddPropertyPOM.clickAllPropertiesLink();
		viewAddeddPropertyPOM.sendSearchInput("New launch");
		viewAddeddPropertyPOM.clickSearchSubmit();
		
		//Validate that the added Property is displaying while searching
		String Expected2 = value;
		String Actual2 = driver.findElement(By.xpath("//strong//a[1][@class='row-title']")).getText();
		Assert.assertEquals(Actual2, Expected2);
		System.out.println("Search Result: "+Expected2);
		
	}
}








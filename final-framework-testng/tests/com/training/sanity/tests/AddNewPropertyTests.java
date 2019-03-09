//Test Objective: To verify whether application allows admin to add new property with all details

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot_RealEstate;
import com.training.pom.AddNewPropertyPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddNewPropertyTests{

	private WebDriver driver;
	private String baseUrl;
	private AddNewPropertyPOM addnewpropertyPOM;
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
		addnewpropertyPOM = new AddNewPropertyPOM(driver); 
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
	public void validLoginTest() throws Exception {
		
		//Login with admin credentials
		addnewpropertyPOM.clickButton(); 
		addnewpropertyPOM.sendUserName("admin");
		addnewpropertyPOM.sendPassword("admin@123");
		addnewpropertyPOM.clickSignInBtn();
		
		//Click on the Properties link and then 'Add New' link
		addnewpropertyPOM.clickPropertiesBtn();
		addnewpropertyPOM.clickAddNewBtn();
		
		//Enter the following details
		addnewpropertyPOM.sendPostTitle("aa");
		addnewpropertyPOM.sendNewTextArea("aaaaaa");
		//Thread.sleep(3000);
		addnewpropertyPOM.scrollDown();
		Thread.sleep(3000);
		addnewpropertyPOM.clickPropertyField();
		Thread.sleep(2000);
		addnewpropertyPOM.sendPriceTextArea("aa");
		Thread.sleep(2000);
		addnewpropertyPOM.sendPricePer("22");
		Thread.sleep(2000);
		addnewpropertyPOM.clickMailDetail();
		Thread.sleep(2000);
		addnewpropertyPOM.sendStatus("aa");
		addnewpropertyPOM.sendLocation("aa");
		addnewpropertyPOM.sendPossession("aa");
		addnewpropertyPOM.clickLocationTab();
		Thread.sleep(2000);
		addnewpropertyPOM.sendAddress("aaa");
		addnewpropertyPOM.clickGoogleMapAddress();
		Thread.sleep(3000);
		addnewpropertyPOM.clickDetailsTab();
		addnewpropertyPOM.sendStorageRoom("aaa");
		addnewpropertyPOM.selectBangloreCentral();
		Thread.sleep(2000);
		addnewpropertyPOM.scrollUp();
		addnewpropertyPOM.clickPublishBtn();
		
		//To take the the screenshot
		screenShot.captureScreenShot("AddNewProperty");
		
		//Validate the expected result
		String Expected = "Post published. View post";
		String Actual = driver.findElement(By.xpath("//*[@id=\"message\"]/p")).getText();
		Assert.assertEquals(Actual, Expected);
	}
}


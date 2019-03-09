//Test Objective: To verify whether application allows Admin to view added user in all Users module

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
import com.training.pom.ViewAddedUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ViewAddedUserTests {

	private WebDriver driver;
	private String baseUrl;
	private ViewAddedUserPOM viewAddeddUserPOM;
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
		viewAddeddUserPOM = new ViewAddedUserPOM(driver); 
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
		
		//Login with admin user
		viewAddeddUserPOM.clickButton(); 
		viewAddeddUserPOM.sendUserName("admin");
		viewAddeddUserPOM.sendPassword("admin@123");
		viewAddeddUserPOM.clickSignInBtn();
		viewAddeddUserPOM.clickUserLink();
		viewAddeddUserPOM.clickAddNewLink();
		
		//Enter the following details for creating the New User
		viewAddeddUserPOM.sendNewUserName("Venus");
		viewAddeddUserPOM.sendEmail("neeladas@gmail.com");
		
		//Assigning the Name to a string variable 
		String value = "Neela Das";
		
		viewAddeddUserPOM.sendFirstName("Neela");
		viewAddeddUserPOM.sendLastName("Das");
		viewAddeddUserPOM.sendWebsite("www.bing.com");
		viewAddeddUserPOM.clickShowPassword();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		viewAddeddUserPOM.sendNewPassword("abcd@@&&34543");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		viewAddeddUserPOM.clickRoleDropdown();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		viewAddeddUserPOM.clickCreateUserBtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//The following will take the screenshot
		screenShot.captureScreenShot("ViewAddedUser");
		
		//Click on All Users link and search the user
		viewAddeddUserPOM.clickAllUsersLink();
		viewAddeddUserPOM.sendSearchInput("Neela Das");
		viewAddeddUserPOM.clickSearchSubmit();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Validate the expected result
		String Expected = value;
		String Actual = driver.findElement(By.xpath("//td[2][1][@class='name column-name']")).getText();
		Assert.assertEquals(Actual, Expected);
		System.out.println("Search Result: "+Actual);
		
		
	}
}

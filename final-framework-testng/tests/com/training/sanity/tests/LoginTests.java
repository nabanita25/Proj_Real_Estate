//Test Objective: To Verify whether application allows registered user to login into application

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

import com.training.generics.ScreenShot;
import com.training.generics.ScreenShot_RealEstate;
import com.training.pom.SunilLoginPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
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
		loginPOM = new LoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot_RealEstate(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLoginTest() throws Exception {
		
		//Enter credentials for login
		loginPOM.clickButton(); 
		loginPOM.sendUserName("sennivedita78@gmail.com");
		loginPOM.sendPassword("nivedita&&112267");
		Thread.sleep(3000);
		loginPOM.clickSignInBtn(); 
		
		//To take the screenshot my login
		screenShot.captureScreenShot("Login_To_MyProfile");
		
		//Validate the expected result
		String Expected = "Howdy, Nivedita Sen!";
		String Actual = driver.findElement(By.xpath("//*[@id=\"titlebar\"]/div/div/div/span")).getText();
		Assert.assertEquals(Actual, Expected);
	}
}


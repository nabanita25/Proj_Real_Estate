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
import com.training.pom.ChangeProfilePOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangeProfileTests {

	private WebDriver driver;
	private String baseUrl;
	private ChangeProfilePOM changeprofilePOM;
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
		changeprofilePOM = new ChangeProfilePOM(driver); 
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
		changeprofilePOM.clickButton(); 
		changeprofilePOM.sendUserName("sennivedita78@gmail.com");
		changeprofilePOM.sendPassword("nivedita&&112267");
		changeprofilePOM.clickLoginBtn();
		Thread.sleep(3000);
		changeprofilePOM.clickOnHyperlink();
		Thread.sleep(3000);
		changeprofilePOM.clickOnMyProfile();
		Thread.sleep(3000);
		changeprofilePOM.sendAgentTitle("Sir");
		changeprofilePOM.sendPhone("9854564348");
		changeprofilePOM.clickSaveChanges(); 
		screenShot.captureScreenShot("ChangeProfile");
		
		String Expected = "Your profile has been updated.";
		String Actual = driver.findElement(By.xpath("//*[@id=\"post-133\"]/div[2]/div/div[1]/div/p")).getText();
		Assert.assertEquals(Actual, Expected);
	}
}


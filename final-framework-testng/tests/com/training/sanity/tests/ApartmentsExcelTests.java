//To validate that the User is able to send ENQUIRIES from Apartment tab

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

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot_RealEstate;
import com.training.pom.ApartmentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ApartmentsExcelTests {

	private WebDriver driver;
	private String baseUrl;
	private ApartmentPOM apartmentPOM;
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
		apartmentPOM = new ApartmentPOM(driver); 
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
	@Test(dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void apartmentExcelTest(String name, String email, String subject, String message)  {
		
		//Mouse hover on Apartment tab and click on Prestige image
		apartmentPOM.moveToApartment();
		apartmentPOM.clickImage();
		apartmentPOM.sendYourName(name);
		apartmentPOM.sendYourEmail(email);
		apartmentPOM.sendYourSubject(subject);
		apartmentPOM.sendYourMessage(message);
		apartmentPOM.clickSendBtn();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//Validate the expected result
		String Expected = "Thank you for your message. It has been sent.";
		String Actual = apartmentPOM.Assertion();
		Assert.assertEquals(Actual, Expected);
	}
}


//Test Objective: To verify whether application allows to search details & fill inquiry details in Commercial tab

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
import com.training.pom.CommercialPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class CommercialTests {

	private WebDriver driver;
	private String baseUrl;
	private CommercialPOM commercialPOM;
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
		commercialPOM = new CommercialPOM(driver); 
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
		
		//Click on 'Commercial' tab and search for Apartments
		commercialPOM.clickCommercialTab(); 
		commercialPOM.clickEnterAddress();
		commercialPOM.clickSearch();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		commercialPOM.clickDropUsALine();
		
		// Enter the following fields:
		commercialPOM.sendName("ccc");
		commercialPOM.sendEmail("ccc@gmail.com");
		commercialPOM.sendSubject("ccc");
		commercialPOM.sendMessage("ccc");
		
		//Click on 'Send' button
		commercialPOM.clickSendBtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Validate the expected result
		String Expected = "Thanks you for your message.";
		String Actual = driver.findElement(By.xpath("//*[@id=\"wpcf7-f119-p134-o1\"]/form/div[4]")).getText();
		Assert.assertEquals(Actual, Expected);
		
    }
}


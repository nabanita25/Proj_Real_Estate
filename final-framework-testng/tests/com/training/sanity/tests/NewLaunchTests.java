//Test Objective: To verify whether application allows customer to view, enquire & calculate loan on New launches

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
import com.training.pom.NewLaunchPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class NewLaunchTests {

	private WebDriver driver;
	private String baseUrl;
	private NewLaunchPOM newLaunchPOM;
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
		newLaunchPOM = new NewLaunchPOM(driver); 
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
	public void validLoginTest() {
		
		//Mouse hover on 'New Launch' tab and click on the image
		newLaunchPOM.moveToNewLanch(); 
		newLaunchPOM.clickImage();
		newLaunchPOM.clickImageBtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Enter the following details and click on 'Send' button
		newLaunchPOM.sendYourName("aa");
		newLaunchPOM.sendYourEmail("aa@gmail.com");
		newLaunchPOM.sendYourSubject("aaa");
		newLaunchPOM.sendYourMessage("aaaa");
		newLaunchPOM.clickSendBtn();
		
		//Enter the following detail for calculation and click on 'Calculate' button
		newLaunchPOM.sendSalePrice("50000");
		newLaunchPOM.sendDownPayment("2000");
		newLaunchPOM.sendLoanTerm("2");
		newLaunchPOM.sendInterestRate("5");
		newLaunchPOM.clickCalculateBtn();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Validate the expected result
		String Expected = "Monthly Payment: 2105.83 Rs.";
		String Actual = driver.findElement(By.xpath("//div[@class='notification success']")).getText();
		Assert.assertEquals(Actual, Expected);
		
    }
}

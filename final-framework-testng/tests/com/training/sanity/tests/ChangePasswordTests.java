//Test Objective: To verify whether application allows the user to change the password

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
import com.training.pom.ChangePasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ChangePasswordTests {

	private WebDriver driver;
	private String baseUrl;
	private ChangePasswordPOM changePasswordPOM;
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
		changePasswordPOM = new ChangePasswordPOM(driver);
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
	public void validRegisterTest() {
		
		//Login with valid credential
		changePasswordPOM.clickButton();
		changePasswordPOM.sendUserName("sennivedita78@gmail.com");
		changePasswordPOM.sendPassword("nivedita&&112267");
		changePasswordPOM.clickSignInBtn();
		changePasswordPOM.clickChangePassword();
		
		//Enter the current password, new password and confirm the password
		changePasswordPOM.sendCurrentPass("nivedita&&112267");
		changePasswordPOM.sendNewPass("nivedita&&112268");
		changePasswordPOM.sendConfirmPass("nivedita&&112268");
		changePasswordPOM.clickSaveChanges();
		
		//To take the screenshot
		screenShot.captureScreenShot("ChangePassword");
		
		//Validate the expected message
		String Expected = "Your password has been updated.";
		String Actual = driver.findElement(By.xpath("//*[@id=\"post-129\"]/div[2]/div/div[1]/div/p")).getText();
		Assert.assertEquals(Actual, Expected);

	}
}

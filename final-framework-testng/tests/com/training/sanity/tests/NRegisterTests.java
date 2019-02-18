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
import com.training.pom.NRegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class NRegisterTests {

	private WebDriver driver;
	private String baseUrl;
	private NRegisterPOM registerPOM;
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
		registerPOM = new NRegisterPOM(driver);
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
		registerPOM.loginButton();
		registerPOM.clickRegisterTab();
		registerPOM.sendEmail("nivedita0001@gmail.com");
		registerPOM.sendFirstName("Nivedita");
		registerPOM.sendLastName("Roy");
		registerPOM.clickRegisterBtn();
		screenShot.captureScreenShot("Register3");
		//boolean Expected = true;
		String Expected = "You have successfully registered to Real Estate. We have emailed your password to the email address you entered.";
		//boolean Actual = driver.findElement(By.xpath("//*[@id=\"post-133\"]/div/div/div/div[1]/p")).isDisplayed();
		String Actual = driver.findElement(By.xpath("//*[@id=\"post-133\"]/div/div/div/div[1]/p")).getText();
		Assert.assertEquals(Actual, Expected);

	}
}

// To verify whether details entered by user during registration get displayed in database (used Maria DB)

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.NRegisterPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RegisterDBTest {
	private WebDriver driver;
	private String baseUrl;
	private NRegisterPOM registerPOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
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
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void registerDBTest(String email, String firstname, String lastname)  {
		
        //genericMethods.getElement("email", "firstname", "lastname");
		
		registerPOM.clickRegisterTab();
		
		//Storing the values in a string variable for comparing with DB values
		String EMAIL = registerPOM.sendEmail("jara@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String FIRSTNAME = registerPOM.sendFirstName("Jara");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String LASTNAME = registerPOM.sendLastName("Gupta");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		registerPOM.clickRegisterBtn();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//To validate that the values sending from application is matching with DB values
		Assert.assertEquals(EMAIL, email);
		Assert.assertEquals(FIRSTNAME, firstname);
		Assert.assertEquals(LASTNAME, lastname);
		
	    //screenShot.captureScreenShot(userName);

	}

}
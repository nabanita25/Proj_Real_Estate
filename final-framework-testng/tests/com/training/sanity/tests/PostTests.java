//Test Objective:To verify whether application allows admin to add post & same post getting displayed in blog section for User
 
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
import com.training.pom.PostPOM;
import com.training.pom.ViewAddedUserPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PostTests {

	private WebDriver driver;
	private String baseUrl;
	private ViewAddedUserPOM viewAddeddUserPOM;
	private PostPOM postPOM;
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
		postPOM = new PostPOM(driver);
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

		// Login with admin user

		viewAddeddUserPOM.clickButton();
		viewAddeddUserPOM.sendUserName("admin");
		viewAddeddUserPOM.sendPassword("admin@123");
		viewAddeddUserPOM.clickSignInBtn();

		// Click on the Post link and enter the following details

		postPOM.clickPostLink();
		postPOM.clickCategoryLink();
		postPOM.sendName("New9");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String value = "New9";

		postPOM.sendSlug("New9");
		postPOM.sendDescription("New9 category");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		postPOM.scrollDown();
		postPOM.clickAddNewCategoryLink();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Scroll up and search for post created postPOM.scrollUp1();
		postPOM.sendSearchInput("New9");
		postPOM.clickSearchCategory();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Validate that the created post is displaying in the Post search result
		String Expected1 = value;
		String Actual1 = postPOM.searchResult();
		Assert.assertEquals(Actual1, Expected1);
		System.out.println("Test1 Passed - Search Result: " + Actual1);

		// Click on the All Post link and enter the following details
		postPOM.clickPostLink();
		postPOM.clickAllPostLink();
		postPOM.clickAddNewPostButton();

		postPOM.sendPostTitle("New9");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		postPOM.sendBodyContent("aaaa");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// postPOM.checkCategoryCheckbox();
		// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		postPOM.clickPublishButton();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// Validate that the created Post is displaying in the Blog
		String Expected2 = "Post published. View post";
		String Actual2 = driver.findElement(By.xpath("//*[@id=\"message\"]/p")).getText();
		Assert.assertEquals(Actual2, Expected2);
		System.out.println("Test2 Passed - Output message: " + Actual2);

		postPOM.scrollUp2();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		postPOM.mouseHoverToLogout();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		postPOM.clickBlogtab();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		postPOM.clickPhraseSearch();
		postPOM.newWindowTab();
		String value1 = "New9";

		// Validate that the created Post is displaying in the Blog
		String Expected3 = value1;
		String Actual3 = postPOM.phraseSearchResult();
		Assert.assertEquals(Actual3, Expected3);
		System.out.println("Test3 Passed - Created POST is: " + Actual3);

	}
}
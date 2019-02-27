package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewPropertyPOM {
	private WebDriver driver;

	public AddNewPropertyPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	//Inspecting the following web elements:
	
	@FindBy(xpath = "//*[@id=\"responsive\"]/li[8]/a")
	private WebElement login;

	@FindBy(id = "user_login")
	private WebElement userName;

	@FindBy(id = "user_pass")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement signInBtn;

	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/a/div[3]")
	private WebElement propertiesBtn;

	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/ul/li[3]/a")
	private WebElement addNewBtn;

	@FindBy(name = "post_title")
	private WebElement postTitle;

	@FindBy(id = "content_ifr")
	private WebElement newTextArea;

	@FindBy(xpath = "//*[@id=\"realteo_metaboxes\"]/h2")
	private WebElement propertyField;

	@FindBy(xpath = "//*[@id=\"_price\"]")
	private WebElement priceTextArea;

	@FindBy(id = "_price_per")
	private WebElement priceper;

	@FindBy(xpath = "//*[@id=\"ui-id-2\"]")
	private WebElement mainDetail;

	@FindBy(name = "_status")
	private WebElement status;

	@FindBy(name = "_location")
	private WebElement location;

	@FindBy(name = "_possession")
	private WebElement possession;

	@FindBy(xpath = "//*[@id=\"ui-id-3\"]")
	private WebElement locationTab;

	@FindBy(name = "_friendly_address")
	private WebElement address;

	@FindBy(name = "_address")
	private WebElement googleMapAddress;

	@FindBy(xpath = "//*[@id=\"locations_tab\"]/div[2]/div[2]/p")
	private WebElement googleMapAddressLinks;

	@FindBy(xpath = "//*[@id=\"ui-id-4\"]")
	private WebElement detailsTab;

	@FindBy(name = "_storage_room")
	private WebElement storageRoom;

	@FindBy(xpath = "//ul[@class='children acf-bl']/li[2]/label/input[@type='checkbox' and @value='274']")
	private WebElement selectBangloreCentral;

	@FindBy(xpath = "//*[@id=\"publish\"]")
	private WebElement publish;

	//Writing the methods after inspecting the web elements:
	
	public void clickButton() {
		this.login.click();
	}

	public void sendUserName(String userName) {
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickSignInBtn() {
		this.signInBtn.click();
	}

	public void clickPropertiesBtn() {
		this.propertiesBtn.click();
	}

	public void clickAddNewBtn() {
		this.addNewBtn.click();
	}

	public void sendPostTitle(String postTitle) {
		this.postTitle.sendKeys(postTitle);
	}

	public void sendNewTextArea(String newTextArea) {
		this.newTextArea.sendKeys(newTextArea);
	}

	// Scroll down method
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", newTextArea);
	}

	public void clickPropertyField() {
		this.propertyField.click();
	}

	public void sendPriceTextArea(String priceTextArea) {
		this.priceTextArea.sendKeys(priceTextArea);
	}

	public void sendPricePer(String priceper) {
		this.priceper.sendKeys(priceper);
	}

	public void clickMailDetail() {
		this.mainDetail.click();
	}

	public void sendStatus(String status) {
		this.status.sendKeys(status);
	}

	public void sendLocation(String location) {
		this.location.sendKeys(location);
	}

	public void sendPossession(String possession) {
		this.possession.sendKeys(possession);
	}

	public void clickLocationTab() {
		this.locationTab.click();
	}

	public void sendAddress(String address) {
		this.address.sendKeys(address);
	}

	//Method using the DOWN key from keyboard
	public void clickGoogleMapAddress() throws Exception {
		WebElement googleMapAddress = driver.findElement(By.id("_address"));
		googleMapAddress.click();
		googleMapAddress.sendKeys("yeshwanthapur");
		Thread.sleep(2000);
		googleMapAddress.sendKeys(Keys.DOWN);
		googleMapAddress.sendKeys(Keys.RETURN);
        //action.moveToElement(googleMapAddress).moveToElement(driver.findElement(By.xpath("//*[@id=\"locations_tab\"]/div[2]/div[2]/p"))).click();
	}
	
	public void clickDetailsTab() {
		this.detailsTab.click();
	}

	public void sendStorageRoom(String storageRoom) {
		this.storageRoom.sendKeys(storageRoom);
	}

	public void selectBangloreCentral() {
		this.selectBangloreCentral.click();
	}
	
	// Scroll up method
	public void scrollUp() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", postTitle);
	}

	public void clickPublishBtn() {
		this.publish.click();
	}

}
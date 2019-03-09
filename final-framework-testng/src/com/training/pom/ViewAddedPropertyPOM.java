//To inspect the Web elements of the Property page

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ViewAddedPropertyPOM {
	private WebDriver driver;

	public ViewAddedPropertyPOM(WebDriver driver) {
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
	
	@FindBy(xpath = "//*[@id=\"publish\"]")
	private WebElement publish;
	
	@FindBy(xpath = "//*[@id=\"menu-posts-property\"]/ul/li[2]/a")
	private WebElement allProperties;
	
	@FindBy(id = "post-search-input")
	private WebElement searchInput;
	
	@FindBy(id = "search-submit")
	private WebElement searchSubmitBtn;
	
	@FindBy(xpath = "//*[@id=\"post-3761\"]/td[1]/strong/a")
	private WebElement searchResult;
	
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
	
	public void clickPublishBtn() {
		this.publish.click();
	}
	
	public void clickAllPropertiesLink() {
		this.allProperties.click();
	}
	
	public void sendSearchInput(String searchInput) {
		this.searchInput.sendKeys(searchInput);
	}
	
	public void clickSearchSubmit() {
		this.searchSubmitBtn.click();
	}
	
	
}

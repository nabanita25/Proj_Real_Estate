package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeProfilePOM {
	private WebDriver driver;

	public ChangeProfilePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"responsive\"]/li[8]/a")
	private WebElement login;

	@FindBy(id = "user_login")
	private WebElement userName;

	@FindBy(id = "user_pass")
	private WebElement password;

	@FindBy(name = "login")
	private WebElement loginBtn;

	@FindBy(xpath = "//div[@class='user-name']")
	private WebElement userhyperlink;

	@FindBy(linkText = "My Profile")
	private WebElement myProfile;

	@FindBy(id = "agent_title")
	private WebElement agentTitle;

	@FindBy(id = "phone")
	private WebElement phone_1;

	@FindBy(xpath = "//*[@id=\"edit_user\"]/button")
	private WebElement saveChanges;

	public void clickButton() {
		this.login.click();
	}

	public void sendUserName(String userName) {
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	public void clickOnHyperlink() {
		System.out.println("hyper link is called");
		Actions action = new Actions(driver);
		action.moveToElement(userhyperlink).build().perform();
		System.out.println("hyper");
		action.moveToElement(userhyperlink).click();
		
	}
	
	public void clickOnMyProfile() {
		this.myProfile.click(); 
	}

	public void sendAgentTitle(String agentTitle) {
		this.agentTitle.sendKeys(agentTitle);
	}

	public void sendPhone(String phone_1) {
		this.phone_1.sendKeys(phone_1);
	}

	public void clickSaveChanges() {
		this.saveChanges.click();
	}
}

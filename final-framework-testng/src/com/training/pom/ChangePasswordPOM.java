//To inspect the Web elements of the Change Password page

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPOM {
	private WebDriver driver;

	public ChangePasswordPOM(WebDriver driver) {
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
	private WebElement SignInBtn;

	@FindBy(linkText = "Change Password")
	private WebElement changePassword;

	@FindBy(name = "current_pass")
	private WebElement currentPass;
	
	@FindBy(name = "pass1")
	private WebElement newPass;
	
	@FindBy(name = "pass2")
	private WebElement confirmPass;

	@FindBy(id = "wp-submit")
	private WebElement saveChanges;

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
		this.SignInBtn.click();
	}

	public void clickChangePassword() {
		this.changePassword.click();
	}

	public void sendCurrentPass(String currentPass) {
		this.currentPass.sendKeys(currentPass);
	}

	public void sendNewPass(String newPass) {
		this.newPass.sendKeys(newPass);
	}
	
	public void sendConfirmPass(String confirmPass) {
		this.confirmPass.sendKeys(confirmPass);
	}

	public void clickSaveChanges() {
		this.saveChanges.click();
	}
}
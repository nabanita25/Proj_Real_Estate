//To inspect the Web elements of the Reset Password page

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPOM {
	private WebDriver driver; 
	
	public ResetPasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Inspecting the following web elements:
	
	@FindBy(xpath="//*[@id=\"responsive\"]/li[8]/a")
	private WebElement login; 
	
	@FindBy(linkText="Lost Your Password?")
	private WebElement lostPassword; 
	
	@FindBy(id="user_login")
	private WebElement userLogin; 
	
	@FindBy(name="submit")
	private WebElement resetPassowrd; 
	
	//Writing the methods after inspecting the web elements:
	
	public void clickButton() {
		this.login.click();
	}	
	
	public void clickLostPassword() {
		this.lostPassword.click();
	}
	
	public void sendEmailAddress(String userLogin) {
		this.userLogin.sendKeys(userLogin);
	}
	
	public void clickResetPasswordButton() {
		this.resetPassowrd.click();
	}
	
	
}


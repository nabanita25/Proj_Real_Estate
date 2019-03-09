//To inspect the Web elements of the Login page

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPOM {
	private WebDriver driver; 
	
	public LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Inspecting the following web elements:
	
	@FindBy(xpath="//*[@id=\"responsive\"]/li[8]/a")
	private WebElement login; 
	
	@FindBy(id="user_login")
	private WebElement userName; 
	
	@FindBy(id="user_pass")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement signInBtn; 
	
	//Writing the methods after inspecting the web elements:
	
	public void clickButton() {
		this.login.click();;
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
}


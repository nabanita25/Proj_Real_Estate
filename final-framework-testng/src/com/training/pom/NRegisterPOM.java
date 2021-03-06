//To inspect the web elements of the Register page

package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NRegisterPOM {
	private WebDriver driver; 
	
	public NRegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//Inspecting the following web elements:
	
	@FindBy(xpath="//*[@id=\"responsive\"]/li[8]/a")
	private WebElement loginBtn; 
	
	@FindBy(xpath="//*[@id=\"post-133\"]/div/div/div/ul/li[2]/a")
	private WebElement registerTab; 
	
	@FindBy(id="email")
	private WebElement email_1;
	
	@FindBy(id="first-name")
	private WebElement firstName; 
	
	@FindBy(id="last-name")
	private WebElement lastName;
	
	@FindBy(xpath="//*[@id=\"signupform\"]/p[5]/input")
	private WebElement registerBtn;
	
	//Writing the methods after inspecting the web elements:
	
	public void loginButton() {
		//this.userName.clear();
		this.loginBtn.click();
	}	
	
	public void clickRegisterTab() {
		//this.userName.clear();
		this.registerTab.click();
	}
	
	public String sendEmail(String email_1) {
		//this.userName.clear();
		this.email_1.sendKeys(email_1);
		return this.email_1.getAttribute("value");
	}
	
	public String sendFirstName(String firstName) {
		//this.password.clear(); 
		this.firstName.sendKeys(firstName); 
		return this.firstName.getAttribute("value");
	}
	
	public String sendLastName(String lastName) {
		//this.password.clear(); 
		this.lastName.sendKeys(lastName);
		return this.lastName.getAttribute("value");
	}
	
	public void clickRegisterBtn() {
		this.registerBtn.click(); 
	}

	
}



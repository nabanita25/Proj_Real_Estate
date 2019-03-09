//To inspect the Web elements of the User page

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ViewAddedUserPOM {
	private WebDriver driver;

	public ViewAddedUserPOM(WebDriver driver) {
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

	@FindBy(xpath = "//*[@id=\"menu-users\"]/a/div[3]")
	private WebElement usersLink;

	@FindBy(xpath = "//*[@id=\"menu-users\"]/ul/li[3]/a")
	private WebElement addNewLink;

	@FindBy(name = "user_login")
	private WebElement newUserName;

	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(name = "first_name")
	private WebElement firstName;
	
	@FindBy(name = "last_name")
	private WebElement lastName;
	
	@FindBy(name = "url")
	private WebElement website;
	
	@FindBy(xpath = "//*[@id=\"createuser\"]/table/tbody/tr[6]/td/button")
	private WebElement showPassword;
	
	@FindBy(name = "pass1-text")
	private WebElement enterPassword;
	
	@FindBy(xpath = "//*[@id=\"role\"]")
	private WebElement role;
	
	@FindBy(id = "createusersub")
	private WebElement createUser;
	
	@FindBy(xpath = "//*[@id=\"menu-users\"]/ul/li[2]/a")
	private WebElement allUsersLink;
	
	@FindBy(id = "user-search-input")
	private WebElement searchInput;
	
	@FindBy(id = "search-submit")
	private WebElement searchSubmitBtn;
	
	@FindBy(xpath = "//*[@id=\"user-70\"]/td[1]/strong/a")
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

	public void clickUserLink() {
		this.usersLink.click();
	}

	public void clickAddNewLink() {
		this.addNewLink.click();
	}

	public void sendNewUserName(String newUserName) {
		this.newUserName.sendKeys(newUserName);
	}
	
	public void sendEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void sendFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
	}
	
	public void sendLastName(String lastName) {
		this.lastName.sendKeys(lastName);
	}
	
	public void sendWebsite(String website) {
		this.website.sendKeys(website);
	}

	public void clickShowPassword() {
		this.showPassword.click();
	}
	
	public void sendNewPassword(String enterPassword) {
		this.enterPassword.clear(); 
		this.enterPassword.sendKeys(enterPassword);
	}
	
	//Selecting value from ROLE drop-down
	public void clickRoleDropdown() {
		Select drpRole = new Select(driver.findElement(By.xpath("//*[@id=\"role\"]")));
		drpRole.selectByIndex(2);		
	}
	
	public void clickCreateUserBtn() {
		this.createUser.click();
	}
	
	public void clickAllUsersLink() {
		this.allUsersLink.click();
	}
	
	public void sendSearchInput(String searchInput) {
		this.searchInput.sendKeys(searchInput);
	}
	
	public void clickSearchSubmit() {
		this.searchSubmitBtn.click();
	}
	
}


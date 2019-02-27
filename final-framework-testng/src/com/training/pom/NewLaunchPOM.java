package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLaunchPOM{
	private WebDriver driver;

	public NewLaunchPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//Inspecting the following web elements:

	@FindBy(xpath = "//*[@id=\"wpmm-megamenu\"]/div/div[3]/div[1]/a/img")
	private WebElement image;
	
	@FindBy(xpath = "//*[@id=\"wrapper\"]/div[4]/div/div/div[1]/button[2]")
	private WebElement imageBtn;
	
	@FindBy(name = "your-name")
	private WebElement name;
	
	@FindBy(name = "your-email")
	private WebElement email;
	
	@FindBy(name = "your-subject")
	private WebElement subject;
	
	@FindBy(name = "your-message")
	private WebElement message;
	
	@FindBy(xpath = "//*[@id=\"wpcf7-f4-o1\"]/form/p[5]/input")
	private WebElement sendBtn;
	
	@FindBy(id = "amount")
	private WebElement salePrice;
	
	@FindBy(id = "downpayment")
	private WebElement downPayment;
	
	@FindBy(id = "years")
	private WebElement loanTerm;
	
	@FindBy(id = "interest")
	private WebElement interestRate;
	
	@FindBy(xpath = "//button[@class='button calc-button']")
	private WebElement calculateBtn;
	
	//Writing the methods after inspecting the web elements:
	
	public void moveToNewLanch() {
		WebElement newLaunch = driver.findElement(By.linkText("NEW LAUNCH"));
        Actions builder = new Actions(driver);
        builder.moveToElement(newLaunch).build().perform();
	}
	
	public void clickImage() {
		this.image.click();
	}
	
	public void clickImageBtn() {
		this.imageBtn.click();
	}
	
	public void sendYourName(String name) {
		this.name.sendKeys(name);
	}
	
	public void sendYourEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void sendYourSubject(String subject) {
		this.subject.sendKeys(subject);
	}
	
	public void sendYourMessage(String message) {
		this.message.sendKeys(message);
	}
	
	public void clickSendBtn() {
		this.sendBtn.click();
	}
	
	public void sendSalePrice(String salePrice) {
		this.salePrice.sendKeys(salePrice);
	}
	
	public void sendDownPayment(String downPayment) {
		this.downPayment.sendKeys(downPayment);
	}
	
	public void sendLoanTerm(String loanTerm) {
		this.loanTerm.sendKeys(loanTerm);
	}
	
	public void sendInterestRate(String interestRate) {
		this.interestRate.sendKeys(interestRate);
	}
	
	public void clickCalculateBtn() {
		this.calculateBtn.click();
	}
	
}
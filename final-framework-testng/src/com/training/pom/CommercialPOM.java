package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommercialPOM {
	private WebDriver driver;

	public CommercialPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//Inspecting the following web elements:

	@FindBy(xpath = "//*[@id=\"menu-item-513\"]/a")
	private WebElement commercialTab;
	
	@FindBy(xpath = "//button[@class='button fullwidth']")
	private WebElement clickSearch;
	
	@FindBy(xpath = "//*[@id=\"text-4\"]/div/div/p[2]/a")
	private WebElement dropUsALine;
	
	@FindBy(name = "name")
	private WebElement name;
	
	@FindBy(name = "email")
	private WebElement email;
	
	@FindBy(name = "subject")
	private WebElement subject;
	
	@FindBy(xpath = "//*[@id=\"wpcf7-f119-p134-o1\"]/form/div[3]/span/textarea")
	private WebElement message;
	
	@FindBy(xpath = "//*[@id=\"wpcf7-f119-p134-o1\"]/form/p/input")
	private WebElement sendBtn;
	
	//Writing the methods after inspecting the web elements:
	
	public void clickCommercialTab() {
		this.commercialTab.click();
	}
	
	public void clickEnterAddress() throws Exception {
		
		WebElement googleMapAddress = driver.findElement(By.name("keyword_search"));
		googleMapAddress.click();
		googleMapAddress.sendKeys("Bangalore");
		Thread.sleep(2000);
		googleMapAddress.sendKeys(Keys.DOWN);
		googleMapAddress.sendKeys(Keys.RETURN);
	}
	
	public void clickSearch() {
		this.clickSearch.click();
	}
	
	public void clickDropUsALine() {
		this.dropUsALine.click();
	}
	
	public void sendName(String name) {
		this.name.sendKeys(name);
	}
	
	public void sendEmail(String email) {
		this.email.sendKeys(email);
	}
	
	public void sendSubject(String subject) {
		this.subject.sendKeys(subject);
	}
	
	public void sendMessage(String message) {
		this.message.clear();
		this.message.sendKeys(message);
	}
	
	public void clickSendBtn() {
		this.sendBtn.click();
	}
}

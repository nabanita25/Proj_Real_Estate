//To inspect the Web elements of the Apartment page

package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentPOM {
	private WebDriver driver;

	public ApartmentPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//Inspecting the following web elements:

		@FindBy(xpath = "//*[@id=\"wpmm-megamenu\"]/div[2]/div[2]/div[1]/a/img")
		private WebElement image;
		
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
		
		
		//Writing the methods after inspecting the web elements:
		
		public void moveToApartment() {
			WebElement apartment = driver.findElement(By.linkText("APARTMENTS"));
	        Actions builder = new Actions(driver);
	        builder.moveToElement(apartment).build().perform();
		}
		
		public void clickImage() {
			this.image.click();
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
		
		public String Assertion() {
			return driver.findElement(By.xpath("//*[@id=\"wpcf7-f4-o1\"]/form/div[2]")).getText();
		}
}
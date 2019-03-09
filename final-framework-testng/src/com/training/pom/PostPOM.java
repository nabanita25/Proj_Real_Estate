//To inspect the required web elements of Post link page

package com.training.pom;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostPOM {
	private WebDriver driver;

	public PostPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//Inspecting the following web elements:

	@FindBy(xpath = "//*[@id=\"menu-posts\"]/a/div[3]")
	private WebElement postLink;
	
	@FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[4]/a")
	private WebElement categoriesLink;
	
	@FindBy(name = "tag-name")
	private WebElement name;
	
	@FindBy(name = "slug")
	private WebElement slug;
	
	@FindBy(name = "description")
	private WebElement description;
	
	@FindBy(xpath = "//*[@id=\"submit\"]")
	private WebElement newCategoryBtn;
	
	@FindBy(xpath = "//*[@id=\"doaction2\"]")
	private WebElement applyBtn;
	
	@FindBy(name = "s")
	private WebElement searchInput;
		
	@FindBy(xpath = "//*[@id=\"search-submit\"]")
	private WebElement clickSearchCategory;
	
	@FindBy(xpath = "//table//tbody/tr[1]//td[1]/strong/a")
	private WebElement searchResult;
	
	@FindBy(xpath = "//*[@id=\"menu-posts\"]/ul/li[2]/a")
	private WebElement allPostLink;
	
	@FindBy(xpath = "//*[@id=\"wpbody-content\"]/div[3]/a")
	private WebElement addNewPostBtn;
	
	@FindBy(name = "post_title")
	private WebElement postTitle;
	
	@FindBy(name = "content")
	private WebElement bodyContent;
	
	@FindBy(xpath = "//*[@id=\"in-category-546\"]")
	private WebElement categoryCheckbox;
	
	@FindBy(xpath = "//*[@id=\"publish\"]")
	private WebElement publishBtn;
	
	@FindBy(xpath = "//*[@id=\"menu-item-617\"]/a")
	private WebElement clickBlog;
	
	@FindBy(xpath = "//input[@title='Search input']")
	private WebElement phraseSearch;
	
	@FindBy(xpath = "//*[@id=\"post-4024\"]/div/h3/a")
	private WebElement phraseSearchResult;
		
	//Writing the methods after inspecting the web elements:
	public void clickPostLink() {
		this.postLink.click();
	}
	
	public void clickCategoryLink() {
		this.categoriesLink.click();
	}
	
	public void sendName(String name) {
		this.name.sendKeys(name);
	}
	
	public void sendSlug(String slug) {
		this.slug.sendKeys(slug);
	}
	
	public void sendDescription(String description) {
		this.description.sendKeys(description);
	}
	
	public void clickAddNewCategoryLink() {
		this.newCategoryBtn.click();
	}
	
	public void scrollUp1() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", name);
	}
	
	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", applyBtn);
	}
	
	public void sendSearchInput(String searchInput) {
		this.searchInput.clear();
		this.searchInput.sendKeys(searchInput);
	}
	
	public void clickSearchCategory() {
		this.clickSearchCategory.click();
	}
	
	public String searchResult() {
		return searchResult.getText();
	}
	
	public void clickAllPostLink() {
		this.allPostLink.click();
	}
	
	public void clickAddNewPostButton() {
		this.addNewPostBtn.click();
	}
	
	public void sendPostTitle(String postTitle) {
		this.postTitle.clear();
		this.postTitle.sendKeys(postTitle);
	}
	
	public void sendBodyContent(String bodyContent) {
		this.bodyContent.sendKeys(bodyContent);
	}
	
	public void checkCategoryCheckbox() {
		this.categoryCheckbox.isSelected();
	}
	
	public void clickPublishButton() {
		this.publishBtn.click();
	}
	
	public void mouseHoverToLogout() {
		WebElement user= driver.findElement(By.xpath("//a//img[@class='avatar avatar-26 photo']"));
		Actions act= new Actions(driver);
		act.moveToElement(user).build().perform();
		driver.findElement(By.id("wp-admin-bar-logout")).click();
	}
	
	public void scrollUp2() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", postTitle);
	}
	
	public void clickBlogtab() {
		this.clickBlog.click();
	}
	
	public void clickPhraseSearch() throws Exception {
		phraseSearch.click();
		phraseSearch.clear();
		phraseSearch.sendKeys("New9");
		Thread.sleep(2000);
		phraseSearch.sendKeys(Keys.UP);
		phraseSearch.sendKeys(Keys.ENTER);
	}
	
	public void newWindowTab() {
		ArrayList <String> blogtab = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(blogtab.get(0));
	}
	
	public String phraseSearchResult() {
		return phraseSearchResult.getText();
	}
	
}


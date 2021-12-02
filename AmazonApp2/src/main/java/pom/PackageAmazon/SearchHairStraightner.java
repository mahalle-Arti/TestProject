package pom.PackageAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHairStraightner {
	WebDriver driver;
	private WebDriverWait wait;
	
	
@FindBy (xpath="//input[@type='text']")
private WebElement searchTextBox;

@FindBy (xpath = "//input[@type='submit']")
private WebElement searchButton;

@FindBy (xpath = "//img[@src='https://m.media-amazon.com/images/I/51WpQPLsZSS._AC_SR180,120_QL70_.jpg']")
private WebElement Item;

@FindBy (xpath = "//input[@id='add-to-cart-button']")
private WebElement addToCart;

public SearchHairStraightner(WebDriver driver){
	this.driver=driver;
	wait = new WebDriverWait(driver,20);
	PageFactory.initElements(driver, this);
}
public void textBox() {
	wait.until(ExpectedConditions.visibilityOf(searchTextBox));
	searchTextBox.sendKeys("hairstrighterner");
}

public void clickOnsarchButton() {
	wait.until(ExpectedConditions.visibilityOf(searchButton));
	searchButton.click();
}
public void clickOnItem() {
	wait.until(ExpectedConditions.visibilityOf(Item));
	Item.click();
}
public void clickOnAddToCart() {
	wait.until(ExpectedConditions.visibilityOf(addToCart));
	addToCart.click();
}	

}

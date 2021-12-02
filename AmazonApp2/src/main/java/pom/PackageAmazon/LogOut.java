package pom.PackageAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogOut {
	WebDriver driver;
	private WebDriverWait wait;
	Actions act;
	
@FindBy (xpath = "(//a[@data-nav-role='signin'])[1]")
private WebElement accountAndList;

@FindBy (xpath = "//span[contains(text(),'Sign Out')]")
private WebElement signOut;

public LogOut(WebDriver driver){
	this.driver=driver;
	wait = new WebDriverWait(driver,20);
	PageFactory.initElements(driver, this);
    act = new Actions(driver);
	}

public void MoveToSignOut() {
	wait.until(ExpectedConditions.visibilityOf(accountAndList));
	act.moveToElement(accountAndList).build().perform();
}
public void ClickOnSignOut() {
	wait.until(ExpectedConditions.visibilityOf(signOut));
	act.moveToElement(signOut).click().build().perform();
}
}

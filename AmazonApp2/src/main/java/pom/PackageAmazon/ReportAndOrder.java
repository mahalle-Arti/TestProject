package pom.PackageAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportAndOrder {
	private WebDriverWait wait;
	
	@FindBy (xpath= "//a[@id='nav-orders']")
	
    private WebElement ReportAndOrder;
	
	
	public ReportAndOrder(WebDriver driver){
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver,20);
	}
	
	public void clickOnReportAndOrder() {
		wait.until(ExpectedConditions.visibilityOf(ReportAndOrder));
		ReportAndOrder.click();
	}
}

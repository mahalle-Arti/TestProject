package pom.PackageAmazon;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.Package.Utils;

public class InitialPage {

	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath = "//input[@type='email']")
	private WebElement emailOrPhone;
	
	@FindBy (xpath = "//input[@id='continue']")
	private WebElement continueButton;
	
	public InitialPage(WebDriver driver){
		this.driver=driver;
		wait = new WebDriverWait(driver,20);
		PageFactory.initElements(driver, this);
	}
	
	public void inputEmailOrPhone() throws EncryptedDocumentException, IOException {
		wait.until(ExpectedConditions.visibilityOf(emailOrPhone));
		//String user = Utils.excelSheet(1, 0);
		emailOrPhone.sendKeys("8857997593");
		driver.getCurrentUrl();
		
	}
	public void clickContinueButton() {
		wait = new WebDriverWait(driver,50);          //if we want to change the time
		continueButton.click();
	}
}

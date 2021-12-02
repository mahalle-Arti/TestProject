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

public class PasswordPage {
	
	private WebDriverWait wait;
	
       @FindBy (xpath = "//input[@type='password']")
        private WebElement password;
       
       @FindBy (xpath = "//input[@id='signInSubmit']")
       private WebElement signInSubmit;
       
       public PasswordPage(WebDriver driver){
    	   wait = new WebDriverWait(driver,20);
    	   PageFactory.initElements(driver, this);
       }
       
       public void passwordText() throws EncryptedDocumentException, IOException {
    	   wait.until(ExpectedConditions.visibilityOf(password));
    	   //String pass = Utils.excelSheet(1, 1);
    	   password.sendKeys("Arti@123");
    	 
       }
       
       public void clickSignIn() {
    	   wait.until(ExpectedConditions.visibilityOf(signInSubmit));
    	   signInSubmit.click();
       }
       
}

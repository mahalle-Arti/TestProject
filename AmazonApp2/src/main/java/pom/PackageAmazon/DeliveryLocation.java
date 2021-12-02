package pom.PackageAmazon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeliveryLocation {
	
	private WebDriverWait wait;
	
	 @FindBy (xpath = "//a[@id='nav-global-location-popover-link']")
     private WebElement deliveryTo;
	 
	 @FindBy (xpath = "(//input[@type='text'])[2]")
     private WebElement textBoxPincode;
	 
	 @FindBy (xpath = "(//input[@class='a-button-input'])[4]")
     private WebElement applyButton;
	 
	 
	  public DeliveryLocation(WebDriver driver){
		  wait = new WebDriverWait(driver,20);
   	   PageFactory.initElements(driver, this);
      }
      
      public void clickDeliveryToOption() {
    	  wait.until(ExpectedConditions.visibilityOf(deliveryTo));
    	  deliveryTo.click();
      }
      
      public void clickTextBoxPincode() {
    	  wait.until(ExpectedConditions.visibilityOf(textBoxPincode));
    	  textBoxPincode.sendKeys("444001");
      }
      public void clickApplyButton() {
    	  wait.until(ExpectedConditions.visibilityOf(applyButton));
    	  applyButton.click();
      } 
	
}

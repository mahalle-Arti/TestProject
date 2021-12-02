package base.pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
 
	
	  public WebDriver openChromeBrowser() {
	  
	  System.setProperty("webdriver.chrome.driver","F:\\Velocity\\chromedriver.exe");
	  WebDriver driver =new ChromeDriver(); 
	  return driver; }
	 
	public WebDriver openFirefoxBrowser() {
	    System.setProperty("webdriver.gecko.driver","F:\\Velocity\\geckodriverF\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    return driver;
}
}       
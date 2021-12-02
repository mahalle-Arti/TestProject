package test.pack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pom.PackageAmazon.InitialPage;
import pom.PackageAmazon.LogOut;
import pom.PackageAmazon.PasswordPage;
import pom.PackageAmazon.SearchHairStraightner;
import pom.PackageAmazon.SearchPhotoFrame;

public class VerifyAmazon2 {

	WebDriver driver;
	InitialPage initialPage;
    PasswordPage passpage ;
    SearchPhotoFrame searchPhotoFrame;
    SearchHairStraightner searchHairStraightner;
	
	
	@BeforeClass
	public void launchBrowser() {

		System.setProperty("webdriver.chrome.driver","F:\\Velocity\\chromedriver.exe");
		driver =new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		driver.get("https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26action%3Dsign-out%26path%3D%252Fgp%252Fyourstore%252Fhome%26ref_%3Dnav_AccountFlyout_signout%26signIn%3D1%26useRedirectOnSuccess%3D1");
	    driver.manage().window().maximize();
	    initialPage = new InitialPage(driver);
	    passpage = new PasswordPage(driver);
	    searchPhotoFrame = new SearchPhotoFrame(driver);
	    searchHairStraightner = new SearchHairStraightner(driver);
	    }

	@BeforeMethod
	public void inputCredentials() throws EncryptedDocumentException, IOException {
		 
		initialPage.inputEmailOrPhone();
		initialPage.clickContinueButton();
		
		passpage.passwordText();
		passpage.clickSignIn();
}
	
	@Test (priority = 0)
	public void verifyPhotoFrame() {

		 searchPhotoFrame.textBox();
		 searchPhotoFrame.clickOnsarchButton();
		 searchPhotoFrame.clickOnItem();
		 searchPhotoFrame.clickOnAddToCart();
		 String url = driver.getCurrentUrl();
			if(url.equals("https://www.amazon.in/gp/huc/view.html?ie=UTF8&newItems=C4bf373fb-628f-4943-9f9a-f60505daec6c%2C1"))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}	
	}
	
	@Test (priority = 1)
	public void verifyHairStraightner() {

		searchHairStraightner.textBox();
		searchHairStraightner.clickOnsarchButton();
		searchHairStraightner.clickOnItem();
		searchHairStraightner.clickOnAddToCart();
		 String url = driver.getCurrentUrl();
			if(url.equals("https://www.amazon.in/gp/huc/view.html?ie=UTF8&newItems=Cc51f8b8b-d816-4ff5-931e-50297c8c16d5%2C1"))
			{
				System.out.println("pass");
			}
			else
			{
				System.out.println("fail");
			}	
		
	}
	
	@AfterMethod
	public void verifySignOut() {
		LogOut logOut = new LogOut(driver); 
		logOut.MoveToSignOut();
		logOut.ClickOnSignOut();
	}
	
	@AfterClass
	public void closeBrowser() {
	driver.close();
	}
}
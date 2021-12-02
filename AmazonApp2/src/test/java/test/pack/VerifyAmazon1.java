package test.pack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.pack.Base;
import pom.PackageAmazon.DeliveryLocation;
import pom.PackageAmazon.InitialPage;
import pom.PackageAmazon.LogOut;
import pom.PackageAmazon.PasswordPage;
import pom.PackageAmazon.ReportAndOrder;

public class VerifyAmazon1 extends Base {
    WebDriver driver;
    WebDriver ffdriver;
    InitialPage initialPage;
    PasswordPage passpage;
    DeliveryLocation deliveryLocation;
    ReportAndOrder reportOrder;
    SoftAssert softAssert;
    
    @BeforeTest
    @Parameters("browser")
    public void launchBrowser(String browser) {
System.out.println("Launch browser");
		if(browser.equals("Chrome"))
		{
			driver = openChromeBrowser();
		}
		if(browser.equals("Firefox"))
		{
		driver = openFirefoxBrowser();
        }
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
    }
	@BeforeClass
	public void ToVerifyLoginPage() {
		
		driver.get("https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26action%3Dsign-out%26path%3D%252Fgp%252Fyourstore%252Fhome%26ref_%3Dnav_AccountFlyout_signout%26signIn%3D1%26useRedirectOnSuccess%3D1");
		driver.manage().window().maximize();
		
		initialPage = new InitialPage(driver);
	    passpage = new PasswordPage(driver);
	    deliveryLocation = new DeliveryLocation(driver);
	    reportOrder = new ReportAndOrder(driver);
	    softAssert = new SoftAssert();
	   
	}
	
	@BeforeMethod
	public void LoginToAmazon() throws EncryptedDocumentException, IOException {
		System.out.println("open url and input credentials");
		
	    initialPage.inputEmailOrPhone();
		initialPage.clickContinueButton();
		
		passpage.passwordText();
		passpage.clickSignIn();
	}
	
	@Test(priority = 0)
	public void VerifyDeliveryLocation() {
		System.out.println("verify delivery location tab");
		
		deliveryLocation.clickDeliveryToOption();
		deliveryLocation.clickTextBoxPincode();
		deliveryLocation.clickApplyButton();
		
		//String url = driver.getCurrentUrl();
		//softAssert.assertEquals(url,"https://www.amazon.in/ap/signin?_encoding=UTF8&openid.assoc_handle=inflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26action%3Dsign-out%26path%3D%252Fgp%252Fyourstore%252Fhome%26ref_%3Dnav_AccountFlyout_signout%26signIn%3D1%26useRedirectOnSuccess%3D1] but found [https://www.amazon.in/gp/yourstore/home?ie=UTF8&action=sign-out&path=%2Fgp%2Fyourstore%2Fhome&ref_=nav_AccountFlyout_signout&signIn=1&useRedirectOnSuccess=1&");
	
		//String title = driver.getTitle();
		//softAssert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
	
	}
	
	@Test(priority = 1)
	public void VerifyReportAndOrder() throws InterruptedException {
		System.out.println("verify returns and orders tab");
		Thread.sleep(2000);
		
		reportOrder.clickOnReportAndOrder();
		String url = driver.getCurrentUrl();
		if(url.equals("https://www.amazon.in/gp/css/order-history?ref_=nav_orders_first"))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}	
	}
	
	@AfterMethod
	public void logout() {
		LogOut logOut = new LogOut(driver);
		logOut.MoveToSignOut();
		logOut.ClickOnSignOut();
	}
	
	@AfterClass
	public void cleanObjects() {
		initialPage = null;
	    passpage = null;
	    deliveryLocation = null;
	    reportOrder = null;
	    softAssert = null;
	}
	    
	    @AfterTest
	    public void closeBrowser() {
	    	driver.quit();
	    	driver = null;
	    	System.gc();
	    	
	   
	}
	
	
}

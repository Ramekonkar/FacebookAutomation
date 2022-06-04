package testPack;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browser.Base;
import pomClass.GroupTab;
import pomClass.HomePage;
import pomClass.LoginPage;
import pomClass.VideoTab;

public class Facebook2 {
	WebDriver driver;
	LoginPage loginPage;
	VideoTab videoTab;
	String url;
	String title;
	SoftAssert soft;
	GroupTab groupTab;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browserName) {
      if(browserName.equals("Chrome")) {
    	 driver = Base.openChromeBrowser();
      }
      if(browserName.equals("Firefox")) {
     	 driver = Base.openFirefoxBrowser();
       }
      
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
	
	@BeforeClass
	public void pomClassObject() {
		loginPage = new LoginPage(driver);
		videoTab = new VideoTab(driver);
		groupTab = new GroupTab(driver);
	}
	
	@BeforeMethod
	public void enterUrl() throws EncryptedDocumentException, IOException {
	    driver.get("https://www.facebook.com/");
	
		loginPage.sendUserName();
		loginPage.sendPassword();
		loginPage.clickOnLogin();
		 soft = new SoftAssert();

	}
	@Test
	public void verifyVideoTab() {
		
		videoTab.clickOnVideo();
		 url = driver.getCurrentUrl();
		 title = driver.getTitle();
		
		if(url.equals("https://www.facebook.com/watch/?ref=tab") && title.equals("Watch|Facebook")) {
			System.out.println("pass");
		}
		else {
			System.out.println("Fail");
		}
//		 soft.assertEquals(url, "https://www.facebook.com/watch/?ref=tab");
//		 soft.assertEquals(title, "Watch|Facebook","title is not correct");
//		 soft.assertAll();
		
	}
	
	@Test
	public void verifyGroupTab() {
		
		groupTab.clickOnGroup();
		 url = driver.getCurrentUrl();
		 title = driver.getTitle();
		
		if(url.equals("https://www.facebook.com/groups/feed/") && title.equals("Groups|Facebook")) {
			System.out.println("pass");
		}
		else {
			System.out.println("Fail");
		}
//		 soft.assertEquals(url, "https://www.facebook.com/groups/feed/","url is not correct");
//		 soft.assertEquals(title, "Groups|Facebook","title is not correct");
//		 soft.assertAll();

	}
	
	@AfterMethod
	public void logoutFromFacebook() {
		HomePage logOut = new HomePage(driver);
		logOut.clickOnLogoutPage();

	}
	
	@AfterClass
	public void clearObject() {
		loginPage = null;
		videoTab = null;
		groupTab = null;
	}
		
	

    @AfterTest
    public void closeBrowser() {
		driver.close();
		driver = null;
		System.gc();

	
    }


}

package practiceseven.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practicefour.ParseProperties;
import practicefour.Wait;
import practiceseven.libs.Do;
import practiceseven.pagebuilder.LoginPage;
import practiceseven.pagebuilder.WebPages;
import practiceseven.pages.HomePage;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class TestCase2 {
	   private WebDriver driver;
	   private Do du;
	   private Wait wait;
	   
		@BeforeClass
		public void startFirefox(){
			Browsers brower = new Browsers(BrowsersType.firefox);
			driver = brower.driver; 
			du = new Do(driver);
			driver.manage().window().maximize();
			wait = new Wait(driver);		
		}
		

		//@Test
		public void test2(){
			HomePage homepage = new HomePage(driver);
			homepage.navigateToJD("http://www.jd.com/");
		}
		
		@Test
		public void newPageOjectMethod(){
			driver.get("http://www.126.com");
	        new LoginPage(driver).setUserName("FireflyAutomation").setPasswd("Firefly").login();
			
		}
}

package practiceseven.testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practicefour.ParseProperties;
import practiceseven.libs.Do;
import practiceseven.pages.HomePage;
import practiceseven.pages.RegisterOnJD;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;


public class TestCase1 {
	   private WebDriver driver;
	   private Do du;
	   
		@BeforeClass
		public void inialize(){
		
			Browsers brower = new Browsers(BrowsersType.firefox);
			driver = brower.driver; 
			du = new Do(driver);
			driver.manage().window().maximize();
		}
		
		
		@Test
		public void regAccount(){
			//Wait wait = new Wait(ffwb);
			//ffwb.get("http://www.jd.com/");
			RegisterOnJD reg = new RegisterOnJD(driver);
			HomePage homepage = new HomePage(driver);
			
			
			
			homepage.navigateToJD("http://www.jd.com/");
			homepage.register();
			reg.setAccountName("testRD");
			reg.setPassword("admin123");
			reg.submit();
			Assert.assertEquals(reg.getWebElement().isDisplayed(),true);
		}
		
		
		
		
		@AfterClass
		public void releaseBrowser(){
			driver.quit();
		}
		
}

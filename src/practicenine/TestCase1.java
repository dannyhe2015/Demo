package practicenine;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import practicefour.ParseProperties;
import practicefour.Wait;
import practiceseven.pages.NewHomePage;
import practiceseven.pages.NewRegisterPage;
import practiceseven.utils.WebPages;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;
import practiceeight.HomePage;
import practiceeight.LoginPage;
import practicenine.BaiduLocs;
import practicenine.newpractice_2.TestData;
import practiceseven.libs.Do;

public class TestCase1 {
	
	    protected  static WebDriver driver;
		private ParseProperties data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
		private Wait wa;
		private Do du;
		private Switch sw;
		
		@BeforeClass
		public void startFirefox(){
			Browsers browser = new Browsers(BrowsersType.firefox);
			driver = browser.driver;	
            du = new Do(driver);
            sw = new Switch(driver);
            wa = new Wait(driver);
		}
		
		
		@Test
		public void loginBaidu(){
	
			driver.get("http://www.baidu.com");
			
			/*loginBaidu("some","someone");
			du.what(BaiduLocs.baiduMusic).click();
			
			wa.waitFor(5000);
			du.what(BaiduLocs.dayTopSong).click();
			du.what(BaiduLocs.goToDownload).click();
			
			sw.toSpecificWindow("     下载_百度音乐-听到极致"); 
			du.what(BaiduLocs.download).click();*/
			

			try {
				Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\tool\\download.exe");
				Thread.sleep(5000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		@Test
		public void login126DotCom(){		
			TestData td = new TestData(System.getProperty("user.dir")+"\\src\\practicenine\\testdata\\userinfo.csv");
			Login126Page loginpage = new Login126Page(driver);	
			
			String url =td.getTestData("URL", "tc1");
			String username = td.getTestData("username", "tc1");
			String password = td.getTestData("password", "tc1");
			
			driver.get(url);			
			loginpage.setUserName(username);
			loginpage.setPassword(password);
			loginpage.signIn();
			wa.waitFor(5000);
			
		}
		
		
		
		
		
		public void loginBaidu(String username,String password){
			du.what(BaiduLocs.login).click();
			wa.waitForElementPresent(BaiduLocs.username);
			du.what(BaiduLocs.username).sendKeys(username);
			du.what(BaiduLocs.password).sendKeys(password);
			du.what(BaiduLocs.submit).click();
			wa.waitFor(5000);
			wa.waitForElementPresent(BaiduLocs.baiduMusic);
		}

		//@AfterClass
		public void end(){
			driver.quit();
		}
		
		
}

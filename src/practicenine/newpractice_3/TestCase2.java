package practicenine.newpractice_3;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practicenine.Switch;
import practicenine.newpractice_1.DBOp;
import practiceseven.libs.Do;
import practiceseven.libs.Wait;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class TestCase2 {

	private WebDriver driver = null;
	private Wait wait = null;
	private Do du = null;
	private DBOp loc = null;
	
	@BeforeClass
	public void initalModule(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		
		du = new Do(driver);
	    wait = new Wait(driver);
	    
	    
	    loc = new DBOp("Mail126Page");
	    loc.conn();
	}
	
	
	@Test
	public void doDownload(){
		driver.get("http://www.baidu.com");
		du.what(Locators.Music).click();		
		du.what(Locators.classicMusic).click();
		wait.waitForElementPresent(Locators.DownloadIcon);
		du.what(Locators.DownloadIcon).click();
		wait.waitFor(1000);
		Switch sw = new Switch(driver);
		sw.toSpecificWindow("œ¬‘ÿ_∞Ÿ∂»“Ù¿÷");
		try {
			Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\tool\\download.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		du.what(Locators.DownloadLink).click();
		wait.waitFor(15000);

	}
	
	
	@Test
	public void doCSSSeletor(){
		driver.get("http://www.126.com");
		du.whatCSS(loc.getLocatorCSS("UserName")).sendKeys("FireflyAutomation");
		du.whatCSS(loc.getLocatorCSS("Password")).sendKeys("Firefly");
		du.whatCSS(loc.getLocatorCSS("SignUp")).click();
		wait.waitFor(5000);
	}
	
	
	
	
	@Test
	public void alipay(){
		driver.get("https://www.alipay.com/");
		wait.waitFor(5000);
		driver.switchTo().frame("loginIframe");
		try {
			Runtime.getRuntime().exec(String.format(System.getProperty("user.dir")+"\\tool\\alipay.exe %1$s","password007"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		du.what(Locators.UserName).sendKeys("fff2fw@126.com",Keys.TAB);
		wait.waitFor(5000);		
		du.what(Locators.Login).click();
		
		
		
	}
	
	
	
	
	
	
	@AfterClass
	public void release(){
		driver.quit();
	}
	
}

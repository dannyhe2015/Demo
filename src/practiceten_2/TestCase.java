package practiceten_2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

import practicefour.Wait;

public class TestCase {

	private WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	private Wait wait = null;
	private HighLight hl = null;
	
	@BeforeClass
	public void startFirefox(){
		File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
	    File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
		firefoxprofile =  new FirefoxProfile();
		try {
			firefoxprofile.addExtension(firebug);
			firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
			ffwb = new FirefoxDriver(firefoxprofile);
			wait = new Wait(ffwb);
			ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			ffwb.manage().window().maximize();
			hl = new HighLight(ffwb);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	
	

	
	
	
	

	
	@Test
	public void mouseRightclickContext(){
		ffwb.get("http://www.126.com/");		
		ffwb.findElement(By.xpath("//input[@id='idInput']")).clear();
		hl.setHighLight(ffwb.findElement(By.xpath("//input[@id='idInput']")));
		ffwb.findElement(By.xpath("//input[@id='idInput']")).sendKeys("FireflyAutomation");
		hl.setHighLight(ffwb.findElement(By.xpath("//input[@id='pwdInput']")));
		ffwb.findElement(By.xpath("//input[@id='pwdInput']")).sendKeys("Firefly");
		hl.setHighLight(ffwb.findElement(By.xpath("//button[@id='loginBtn']")));
		ffwb.findElement(By.xpath("//button[@id='loginBtn']")).click();			
		wait.waitFor(5000);
		Actions actions = new Actions(ffwb);
		hl.setHighLight(ffwb.findElement(By.xpath("//div/span[text()='收件箱']")));
		actions.contextClick(ffwb.findElement(By.xpath("//div/span[text()='收件箱']"))).perform();
		wait.waitFor(2000);
		hl.setHighLight(ffwb.findElement(By.xpath("//div[contains(@id,'mail_menu')][last()]/descendant::span[text()='打开']")));
		ffwb.findElement(By.xpath("//div[contains(@id,'mail_menu')][last()]/descendant::span[text()='打开']")).click();
		wait.waitFor(2000);
		Assert.assertEquals(ffwb.findElement(By.xpath("//header[@class='frame-main-cont-head']/descendant::span[text()='举 报']")).isDisplayed(), true);
		
		
		
	}
	
	
	
	
	@AfterClass
	public void releaseFFDriver(){
		ffwb.quit();
	}
}

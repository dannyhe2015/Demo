package practiceten.testcases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import practicefour.Wait;
import practiceseven.libs.Do;
import practiceten.BrowsersType;
import practiceten.MutipleTasks;

public class LoginJD extends MutipleTasks{

	private WebDriver driver;
	private Wait wait = null;
	private Do du;
	
    @Parameters({"node","browser"})
	@BeforeClass
	public void beforeClass(String node,String browser){
		//String node = map.get("node1");
		BrowsersType bt = new BrowsersType();		
		if(browser.equals("ff"))
		   driver = bt.setFirefox(node);
		else if(browser.equals("chrome"))
			driver = bt.setChrome(node);
		else
		    driver = bt.setIE(node);		
		du = new Do(driver);
		wait =  new Wait(driver);
	}

	
	
	@Test
	public void accessJD(){	
		
		//µÇÂ¼jd¹Ù·½ÍøÕ¾
		driver.get("http://www.jd.com");
		wait.waitForElementPresent("//a[text()='[µÇÂ¼]']");
		du.what("//a[text()='[µÇÂ¼]']").click();		
		//µÇÂ¼ÓÃ»§ÐÅÏ¢
		wait.waitForElementPresent("//input[@id='loginname']");
		du.what("//input[@id='loginname']").sendKeys("test201301@mailinator.com");
		du.what("//input[@id='nloginpwd']").sendKeys("admin123");
		du.what("//input[@id='loginsubmit']").click();
		
		
	}
	
	
	@AfterClass
	public void realse(){
		driver.quit();
	}
	
	

	
	
	
	
	
	
	
	
	@AfterClass
	public void releaseFFDriver(){
		driver.quit();
	}
}

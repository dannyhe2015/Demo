package practicefour;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class Practice2OnTestNG {
	
    protected  static WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	
	private ParseProperties data ; 
	private ParseProperties locator ; 
	
	private Wait wait;
	
	@Parameters({"data","locator"})
	@BeforeClass
	public void startFirefox(@Optional("data") String da,@Optional("loc1")String loc){
		data = new ParseProperties(System.getProperty("user.dir")+da); 
		locator = new ParseProperties(System.getProperty("user.dir")+loc); 		
		
		Browsers browser = new Browsers(BrowsersType.firefox);			
		ffwb = browser.driver;
		wait = new Wait(ffwb);
		
	}
	
	
	@Test
	public void accessMail(){        
			
		ffwb.get(data.getValue("url"));
		ffwb.findElement(By.xpath(locator.getValue("username"))).clear();
		ffwb.findElement(By.xpath(locator.getValue("username"))).sendKeys(data.getValue("username"));
		ffwb.findElement(By.xpath(locator.getValue("password"))).sendKeys(data.getValue("password"));
		ffwb.findElement(By.xpath(locator.getValue("submit"))).click();	
		
		wait.waitForElementPresent(locator.getValue("homepage"));	
		
		Assert.assertEquals(ffwb.findElement(By.xpath(locator.getValue("sendbox"))).isDisplayed(), true);
	
		//ffwb.findElement(By.xpath(locator.getValue("sendbox"))).click();
		wait.waitFor(10000);
		
	}
	
	
	
	//@Test
	public void getUnReadMails(){
		int expectedRes = 40;
		String unreadmailsnum = ffwb.findElement(By.xpath(locator.getValue("inboxMailsNum"))).getText();
		String str = unreadmailsnum.substring(1, unreadmailsnum.length()-1);
		int i = Integer.valueOf(str);
		System.out.println(i);
		Assert.assertEquals((expectedRes==i),true);
	}
	
	
	@AfterClass
	public void release(){
		ffwb.quit();
	}
	
	
	
	
	
	
}

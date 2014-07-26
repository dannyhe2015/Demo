package practicefour.homework;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import practicefour.ParseProperties;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class Mail126DotCom {
	private WebDriver driver;
	private ParseProperties data; 
    private Do du;
	
	@BeforeClass
	public void inital(){
		
		data = new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties"); 
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;		
		du = new Do(driver);
	}
	
	
	@Test
	public void login126Site(){
		driver.get("http://www.126.com");
		du.what("username").sendKeys("FireflyAutomation");//FireflyAutomation
		du.what("password").sendKeys("Firefly");//Firefly
		du.what("submit").click();
		du.waitForElementPresent("inbox");
		du.waitFor(5000);

	}
	
	
	@Test(dependsOnMethods = { "login126Site" })
	public void restriveMailsIn(){
		int actualunreadMailsNum = 0;
		int totalPagesNum = 0;
		String strNum = du.what("inboxMailsNum").getText();
		int inboxunReadMailsNum = Integer.valueOf(strNum.substring(1, strNum.length()-1));
	
		
		du.what("inbox").click();
		du.waitForElementPresent("unreadLink");
		du.what("unreadLink").click();
		du.waitForElementPresent("unreadList");
		totalPagesNum = Integer.valueOf(du.what("totalPages").getText().split("/")[1]);
		
		while(totalPagesNum>=1){
			actualunreadMailsNum = actualunreadMailsNum+du.whats("unreadMails").size();
			try{
				du.waitFor(2000);
				du.what("nextBtn").click();

			}catch(Exception e){
				break;
			}
			totalPagesNum--;
		}
		System.out.println("1----:"+inboxunReadMailsNum);
		System.out.println("2----:"+actualunreadMailsNum);
		Assert.assertEquals(inboxunReadMailsNum, actualunreadMailsNum);
	}
	
	@Test(dependsOnMethods = { "login126Site" })
	public void upload(){
		du.what("sendbox").click();
		du.what("attachment").sendKeys("c:\\terry.txt");
		du.waitFor(5000);
	}

	@AfterClass
	public void realse(){
		driver.quit();
	}
	
	
}

package practicejava.homework;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practiceseven.libs.Do;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class Mail126Dom {

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
	public void access126Com(){
		driver.get("http://www.126.com");
		du.what(Login126Page.user).sendKeys("FireflyAutomation");
		du.what(Login126Page.password).sendKeys("Firefly",Keys.ENTER);
		du.waitForElementPresent(HomePage.home);
		
		Assert.assertEquals(du.what(HomePage.home).isDisplayed(),true);
	}
}

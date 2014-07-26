package practiceseven.testcases;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practicefour.ParseProperties;
import practicefour.homework.Do;
import practiceseven.locators.NewRegLoc;
import practiceseven.pages.NewHomePage;
import practiceseven.pages.NewRegisterPage;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class TestCase3 {
	
	private WebDriver driver;
	private NewRegisterPage newregjd;
	private NewHomePage newhome;
	 
	@BeforeClass
	public void inital(){		
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;	
		
		newregjd = new NewRegisterPage(driver);
		newhome = new NewHomePage(driver);
	}
	
	
	@Test
	public void regJDAccount(){
		SimpleDateFormat sdf = new SimpleDateFormat();
		String layout = "yyyyMMddHHmmss";
		sdf.applyPattern(layout);
		
		Calendar cl = Calendar.getInstance();
		
		String accountname = sdf.format(cl.getTime());
		
		newhome.navigateToJD("http://www.jd.com").register();
		newregjd.setAccountName("test"+accountname).setPasswords("terryselenium_123").submit();
		Assert.assertEquals(newregjd.getWebElement(NewRegLoc.regsuc, "test"+accountname).isDisplayed(), true);
		
	}
}

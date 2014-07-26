package practicenine.newpractice_1;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import practicefour.Wait;
import practicenine.Login126Page;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class TestSQLite {
	
	private static WebDriver driver;
	private Mail126Page mail126page;
	private static Wait wa;
	
	static{
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		wa = new Wait(driver);
	}
	
	
	@BeforeClass
	public void start(){
		//all initial pages should be put here.
		mail126page = new Mail126Page(driver);		
		
	}
	
	
	
	@Test
	public void login126DotCom(){			
		driver.get("http://www.126.com");			
		mail126page.setUserName("FireflyAutomation");
		mail126page.setPassword("Firefly");
		mail126page.signIn();
		wa.waitFor(5000);		
	}
	
	
}

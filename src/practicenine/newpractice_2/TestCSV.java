package practicenine.newpractice_2;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.Test;



import practicefour.Wait;
import practicenine.Login126Page;
import practicenine.newpractice_1.Mail126Page;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class TestCSV {
	
	private static WebDriver driver;
	private Mail126Page mail126page;
	private static Wait wa;
	private TestData td;
	
	static{
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		wa = new Wait(driver);
		
	}
	
	
	@BeforeClass
	public void start(){
		//all initial pages should be put here.
		mail126page = new Mail126Page(driver);		
		
		//all initial data shoule be put here.
		td = new TestData(System.getProperty("user.dir")+"\\src\\practicenine\\testdata\\userinfo.csv");
	}
	
	
	
	@Test
	public void login126DotCom(){	
		String username =this.getTestData("username");
		String password = this.getTestData("password");
		
		driver.get("http://www.126.com");			
		mail126page.setUserName(username);
		mail126page.setPassword(password);
		mail126page.signIn();
		wa.waitFor(5000);		
	}
	
	
	@AfterClass
	public void release(){
		driver.quit();
	}
	
	public String getTestData(String columname){
		return td.getTestData(columname, "tc1");
	}
	
}

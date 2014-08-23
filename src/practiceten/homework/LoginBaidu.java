package practiceten.homework;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class LoginBaidu {
	
	private WebDriver driver = null;	
	private BaiduHomePage baiduhomepage;
	
	@BeforeClass
	public void initalModule(){
		
		Browsers.nodeurl = "http://localhost:5555/wd/hub";
		Browsers browser = new Browsers(BrowsersType.chrome);
		
		driver = browser.driver;		
		
	   
	    baiduhomepage = new BaiduHomePage(driver);
	}
	
	
	@Test
	public void doLogin(){
		driver.get("http://www.baidu.com");		
		baiduhomepage.login("u1", "p1");
	}
	
	
	public void release(){
		driver.quit();
	}
}

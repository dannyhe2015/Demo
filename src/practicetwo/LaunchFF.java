package practicetwo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LaunchFF {
	
	private WebDriver ffwb = null;
	private FirefoxProfile firefoxprofile = null;
	private String projectpath = System.getProperty("user.dir");
	
	
	@BeforeClass
	public void startFirefox(){
		//System.setProperty("webdriver.firefox.bin", "c:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe"); 
		File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
	    File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
		firefoxprofile =  new FirefoxProfile();
		//try {
			//firefoxprofile.addExtension(firebug);
			//firefoxprofile.addExtension(firepath);
			firefoxprofile.setPreference("webdriver.accept.untrusted.certs", "true"); 
			firefoxprofile.setPreference("extensions.firebug.currentVersion", "1.12.1");
			firefoxprofile.setPreference("network.proxy.type", 0);
			firefoxprofile.setPreference("network.proxy.http", "10.1.1.0");
			firefoxprofile.setPreference("network.proxy.http_port", 3128);
		//} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//}
		ffwb = new FirefoxDriver(firefoxprofile);
	}
	
	
	
	@Test
	public void searchOnBaidu(){		
		ffwb.get("http://www.baidu.com");
		System.out.print(Locator.username1);

		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void releaseFFDriver(){
		ffwb.quit();
	}
	
}

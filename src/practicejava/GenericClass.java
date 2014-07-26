package practicejava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class GenericClass<Driver extends WebDriver> {

	private Driver driver;
	private String projectpath = System.getProperty("user.dir");
		
	public Driver getDriver(){
		return driver;
	}
	
	public void setDriver(Driver driver){
		System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.ie.driver", projectpath+"/tool/IEDriverServer32.exe"); 
		System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver.exe"); 
		this.driver = driver;
	}
	
	
	@Test
	public void test(){
		
		GenericClass<WebDriver> gen = new GenericClass<WebDriver>();
		gen.setDriver(new FirefoxDriver());		
		gen.getDriver().navigate().to("http://www.baidu.com");		
		gen.getDriver().quit();
		
		gen.setDriver(new ChromeDriver());
		gen.getDriver().navigate().to("http://www.baidu.com");
		gen.getDriver().quit();
		
	
	}
}

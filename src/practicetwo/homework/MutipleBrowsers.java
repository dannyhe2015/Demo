package practicetwo.homework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class MutipleBrowsers {
	
	private WebDriver driver = null;; 
	private Browsers browser =null;
	
	
	@Parameters({"platform"})
	@BeforeMethod(groups="browsers")
	public void inital(String platform ){
		if(platform.equals("FF"))
		 browser = new Browsers(BrowsersType.firefox);
		else if(platform.equals("chrome"))
		  browser = new Browsers(BrowsersType.chrome);
		else
		  browser = new Browsers(BrowsersType.ie);
		 driver = browser.driver;
	}


	
	@Test(groups="submodule1")
	public void submodule1(){
		driver.get("http://www.baidu.com");
		System.out.println("---testSubModule1--");
	}
	
	
	@Test(groups="submodule2")
	public void submodule2(){
		driver.get("http://www.bing.com");
		System.out.println("---testSubModule1--");
	}
	
	
	@Test(groups="submodule3")
	public void submodule3(){
		driver.get("http://www.so.com/");
		System.out.println("---testSubModule3--");
	}
	
	@Test(groups="submodule4")
	public void submodule4(){
		driver.get("http://www.oracle.com/");
		System.out.println("---testSubModule4--");
	}
	
	
	@AfterMethod(groups="browsers")
	public void release(){
		driver.quit();
	}
	
	
	
}

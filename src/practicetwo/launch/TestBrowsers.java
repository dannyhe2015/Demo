package practicetwo.launch;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practiceeight.APIObject;


public class TestBrowsers {
	
	private WebDriver driver;
	private APIObject testlinkapi;
	private String caseName;
	
	@BeforeClass
	public void beforeClass(){
//		String url = "http://localhost/testlink/testlink-1.9.3/lib/api/xmlrpc.php";
//		String devKey = "30c180b8b6e68be02a032152cc0e94a4";
//		String projectName = "TerrySeleniumTraining";
//		String tl = "WebdriverLesson";
//		String buildName = "build001";
//		String platform = "IE";
//
//		testlinkapi = new APIObject(url, devKey, projectName, tl, buildName,
//				platform);   	
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
	}

	
	@Test
	public void start(){
		caseName = "DoOne";
		driver.get("http://www.126.com");
		driver.findElement(By.xpath("//input[@id='idInput']")).clear();
		driver.findElement(By.xpath("//input[@id='idInput']")).sendKeys("FireflyAutomation");
		
		driver.findElement(By.xpath("//input[@id='pwdInput']")).sendKeys("Firefly");
		driver.findElement(By.xpath("//input[@id='pwdInput']")).submit();
		Assert.assertEquals(true, true);
		
	}

	
	//@AfterMethod
	public void import2TestLink(ITestResult res){
		testlinkapi.getAPI();
    	testlinkapi.getTestCases();
    	
    	testlinkapi.executeTestCase(caseName,res.getStatus(),"Luter does!");
	}
	
	

	
	
	
	@AfterClass
	public void quit(){
		driver.quit();
	}
	
	
}

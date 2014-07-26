package practiceseven.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import practiceseven.libs.Do;
import practiceseven.pages.Login126Page;
import practiceseven.pages.MailBoxPage;
import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class UploadFiles {
	
	private WebDriver driver;

	private Login126Page login126page; 
	private MailBoxPage mailboxpage;

	@BeforeClass
	public void inital(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
		driver.get("http://www.126.com");
		login126page = new Login126Page(driver);
		mailboxpage = new MailBoxPage(driver);
	}
	
	
	
	@Test
	public void test(){
		login126page.login("FireflyAutomation", "Firefly");
		mailboxpage.upload("c:\\terry.txt");
		System.out.println("The step must be executed.");
	}
}

package practiceseven.pages;

import org.openqa.selenium.WebDriver;

import practiceseven.libs.Do;
import practiceseven.libs.Wait;

public class Login126Page {

	private String username = "//input[@id='idInput']";
	private String passwd = "//input[@id='pwdInput']";
	private String submit = "//button[@id='loginBtn']";
	private String home = "//span[contains(text(),'п╢ пе')]";
	
	private WebDriver driver;
	private Do du;
	private Wait wait;
	
	public Login126Page(WebDriver driver){
		this.driver = driver;	
		du = new Do(driver);
		wait = new Wait(driver);
	}
	
	
	public void login(String username,String passwd){
		du.what(this.username).sendKeys(username);
		du.what(this.passwd).sendKeys(passwd);
		du.what(submit).click();
		wait.waitForElementPresent(home);
	}
	
	
	
	
	
	
}

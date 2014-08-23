package practiceten.homework;

import org.openqa.selenium.WebDriver;

import practicenine.DBOp;
import practiceseven.libs.Wait;

public class BaiduHomePage extends PageBase{

	private WebDriver driver;
    private Wait wait;

	
	public BaiduHomePage(WebDriver driver){
		super(driver,"BaiduHomePage");		
		this.driver = driver;	
		wait = new Wait(driver);
		
		
	}
	
	
	public void login(String userName,String password){
		wait.waitForElementPresent(getLocValue("Login"));
		
		getLoc("Login").click();
		
		wait.waitForElementPresent(getLocValue("UserName"));
		
		getLoc("UserName").sendKeys(userName);
		
		getLoc("Password").sendKeys(password);
		
		getLoc("Submit").click();
	}
	
}

package practiceseven.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import practiceseven.libs.Do;
import practiceseven.locators.NewRegLoc;

public class NewRegisterPage {

	private WebDriver driver;	
	private Do du;
			
	public NewRegisterPage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
	}
	
	public NewRegisterPage setAccountName(String accountname){
		du.what(NewRegLoc.accountname).sendKeys(accountname);
		return this;
	}
	
	public NewRegisterPage setPasswords(String password){
		for(WebElement we :du.whats(NewRegLoc.passwords)){
			we.sendKeys(password);
		}
		return this;
	}
	
	
	public void submit(){
       du.what(NewRegLoc.submit).click();
	}
	
	public WebElement getWebElement(String wn){
		return  du.what(wn);		
	}
	
	public WebElement getWebElement(String wn,String accountname){
	   return  du.what(String.format(wn, accountname));		
	}
	
}

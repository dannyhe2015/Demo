package practiceseven.pages;

import org.openqa.selenium.WebDriver;

import practiceseven.libs.Do;
import practiceseven.locators.HomeLoc;
import practiceseven.locators.NewRegLoc;

public class NewHomePage {

	private WebDriver driver;	
	private Do du;
			
	public NewHomePage(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
	}
	
	public NewHomePage navigateToJD(String url){
		driver.get(url);
		return this;
	}
	
	public void register(){
		du.what(HomeLoc.reg).click();
	}
}

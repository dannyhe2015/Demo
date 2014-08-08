package practiceseven.utils;

import org.openqa.selenium.WebDriver;

import practiceseven.pages.NewHomePage;
import practiceseven.pages.NewRegisterPage;

public class WebPages {

	private WebDriver driver = null;
	
	public WebPages(WebDriver driver){
		this.driver = driver;
	}
	
	public NewHomePage homePage(){
		return new NewHomePage(driver);
	}
	
	
	public NewRegisterPage regPage(){
		return new NewRegisterPage(driver);
	}
	
}

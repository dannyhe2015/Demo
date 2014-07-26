package practiceseven.pagebuilder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='idInput']")
	private static WebElement username;
	
	@FindBy(xpath = "//input[@id='pwdInput']")
	private static WebElement passwd;
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	private static WebElement login;
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
		public LoginPage setUserName(String um){
			username.clear();
			username.sendKeys(um);
			return this;
		}
		
		public LoginPage setPasswd(String pw){
			passwd.clear();
			passwd.sendKeys(pw);
			return this;
		}
		
		public LoginPage login(){
			login.click();
			return this;
		}
		



	
}

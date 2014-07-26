package practiceseven.pagebuilder;

import org.openqa.selenium.WebDriver;

public class WebPages {

	private static WebDriver dirver;
	private LoginPage loginpage = null;
	private HomePage homepage = null;
	
	public WebPages(WebDriver driver){
		this.dirver = driver;
	}
	
	public static class Builder{
		private LoginPage loginpage = null;
		private HomePage homepage = null;
		
		public Builder(){
			
		}
		public Builder loginPage(){
			loginpage = new LoginPage(dirver);			
			return this; 
		}
		
		
		public Builder homePage(){
			homepage = new HomePage(dirver);			
			return this; 
		}
		
		
		///
		///add more pages here
		///
		
		public WebPages build(){
			return new WebPages(this);
		}
	}
	
	private WebPages(Builder builder){
		this.loginpage = builder.loginpage;
		this.homepage = builder.homepage;
	}


	
	
}

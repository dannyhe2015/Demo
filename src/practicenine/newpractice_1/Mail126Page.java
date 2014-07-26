package practicenine.newpractice_1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Mail126Page {

	private WebDriver driver;
	private DBOp dbsession = new DBOp("Mail126Page");
	
	public Mail126Page(WebDriver driver){
	    this.driver = driver;	
	    dbsession.conn();
	}
	
	
	public void setUserName(String username){
		driver.findElement(By.cssSelector(dbsession.getLocatorCSS("UserName"))).sendKeys(username);
	}
	
	
	
	public void setPassword(String passwd){
		driver.findElement(By.cssSelector(dbsession.getLocatorCSS("Password"))).sendKeys(passwd);
	}
	
	
	public void signIn(){
		driver.findElement(By.cssSelector(dbsession.getLocatorCSS("SignUp"))).click();
	}
	//
	
	
}

package practiceseven.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import practiceseven.libs.Do;
import practiceseven.libs.Wait;

public class MailBoxPage {
	private String writemail = "//span[contains(text(),'п╢ пе1')]";
	
	private String uploadfile = "//input[@type='file']";
	
	
	private WebDriver driver;
	private Do du;
	private Wait wait;
	
	public MailBoxPage(WebDriver driver){
		this.driver = driver;	
		du = new Do(driver);
		wait = new Wait(driver);
	}
	
	
	public void upload(String file){
		if(du.what(writemail)!=null)
		    du.what(writemail).click();

		du.what("//span[contains(text(),'п╢ пе')]").click();
		du.what(uploadfile).sendKeys(file);
	}
	
}

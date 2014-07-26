package practiceseven.pagebuilder;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
	
	@FindBy(xpath = "//span[contains(text(),' ’ –≈')]")
	private WebElement receivedmails;
	
	
	
	public HomePage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void receiveMails(){
		receivedmails.click();
	}
	
	

	
}

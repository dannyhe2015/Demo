package practiceten_2;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HighLight {
	
	private WebDriver driver = null;
	
	public HighLight(WebDriver driver) {		 
       this.driver = driver;
    }
	
	
	
	public void setHighLight(WebElement element){
		 JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("element = arguments[0];" +
	             "original_style = element.getAttribute('style');" +
	                 "element.setAttribute('style', original_style + \";" +
	             "background: yellow; border: 2px solid red;\");" +
	             "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);
	}
	
	
	
}

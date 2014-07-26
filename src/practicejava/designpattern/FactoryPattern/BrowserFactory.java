package practicejava.designpattern.FactoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	public static WebDriver getIEDriver(){
		return new InternetExplorerDriver();
	}
	
	
	public static WebDriver getFirefoxDriver(){
		return new FirefoxDriver();
	}
	
	
	public static WebDriver getChromeDriver(){
		return new ChromeDriver();
	}
	
	
}

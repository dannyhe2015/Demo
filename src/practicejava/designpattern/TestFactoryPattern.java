package practicejava.designpattern;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import practicejava.designpattern.FactoryPattern.BrowserFactory;

public class TestFactoryPattern {

	protected WebDriver driver;
	
	@Test
	public void testFactoryPattern(){
		driver = BrowserFactory.getFirefoxDriver();
		driver.get("http://www.jd.com");
	}
	
}

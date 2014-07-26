package practicenine.flash;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class testFlash {
	
	
	private WebDriver driver;

	@Test
	public void start(){
		Browsers browser = new Browsers(BrowsersType.chrome);
		driver = browser.driver;
		
		driver.get("http://www.permadi.com/tutorial/flashjscommand/");
		driver.manage().window().maximize();
		
		FlashObjectWebDriver flashApp = new FlashObjectWebDriver(driver, "myFlashMovie");
		
		flashApp.callFlashObject("Play"); // first number
		 try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 flashApp.callFlashObject("StopPlay"); // operation
		 
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 flashApp.callFlashObject("Rewind");
		 System.out.println(flashApp.callFlashObject("GetVariable","/:message"));
		 flashApp.callFlashObject("SetVariable","/:message","Terry test!");
		 System.out.println(flashApp.callFlashObject("GetVariable","/:message"));
		 
		 
	}
	 

	@AfterTest
	public void releaseBrowsers(){
		driver.quit();
	}
}

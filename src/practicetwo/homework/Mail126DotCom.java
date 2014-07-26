package practicetwo.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import practicetwo.launch.Browsers;
import practicetwo.launch.BrowsersType;

public class Mail126DotCom {
	
	private WebDriver driver;
	
	@BeforeClass
	public void initalize(){
		Browsers browser = new Browsers(BrowsersType.firefox);
		driver = browser.driver;
	}

	//
	@BeforeMethod
	public void login(){
		driver.get("http://www.126.com");
		//driver.findElement(By.xpath("//input[@id='idInput']")).clear();
		driver.findElement(By.xpath("//input[@id='idInput']")).sendKeys("","FireflyAutomation");
		driver.findElement(By.xpath("//input[@id='pwdInput']")).sendKeys("Firefly",Keys.ENTER);
	
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	
	@Test(description="aa")
	public void viewInbox(){
		driver.findElement(By.xpath("//span[text()='收件箱']")).click();
	}
	
	
	@Test(description="aa")
	public void viewSentBox(){
		driver.findElement(By.xpath("//span[text()='已发送']")).click();
	}
	
	
	
	@AfterMethod
	public void logout(){
		driver.findElement(By.xpath("//a[text()='退出']")).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@AfterClass
	public void release(){
		driver.close();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

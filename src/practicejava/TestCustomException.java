package practicejava;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import practiceseven.libs.Do;
import practiceseven.locators.NewRegLoc;

public class TestCustomException {

	@Test
	public void verifyElementIsDisplayed() throws CustomException{
		GenericClass<FirefoxDriver> ff = new GenericClass<FirefoxDriver>();
		ff.setDriver(new FirefoxDriver());
		Do du = new Do(ff.getDriver());
		
		ff.getDriver().navigate().to("http://www.baidu.com");
		du.what(NewRegLoc.accountname).click();
	}
}

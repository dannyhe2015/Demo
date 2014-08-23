
package practiceten.homework;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import practicenine.DBOp;
import practiceseven.libs.Do;



public class PageBase {

	private WebDriver driver;
	private Do du;
	private DBOp db;	
	private Map<String,String> sf = new HashMap();
	
	public PageBase(WebDriver driver){
		this.driver = driver;
		du = new Do(driver);
		
		db = new DBOp("BaiduHomePage");		
		db.conn(System.getProperty("user.dir")+"\\src\\practiceten\\homework\\BaiduDB.sqlite");
	}
	
	
	public WebElement getLoc(String loc){
		
		WebElement we = null;		
		
		if(db.getLocatorXpath(loc)!=null){			    
		    try{
		    	we = du.what(db.getLocatorXpath(loc));
		    }catch(Exception e){
		    	if(db.getLocatorCSS(loc)!=null)
		    		we = du.whatCSS(db.getLocatorCSS(loc));
		    }
			
		}
		else{			
			we = du.whatCSS(db.getLocatorCSS(loc));
		}
			
		
		return we;
	}
	
	public String getLocValue(String loc){
		sf.clear();
		
		if(db.getLocatorXpath(loc)!=null){	
		    sf.put(loc, db.getLocatorXpath(loc));		   
		}
		else{
			sf.put(loc,db.getLocatorCSS(loc));			
		}
		
		return sf.get(loc);
	}
	
	
}

package practicenine;

public interface BaiduLocs {
	
	String login ="//a[@name='tj_login']";
	String username = "//input[ contains(@placeholder,'用户名')]";
	String password = "//input[ contains(@placeholder,'密码') and preceding-sibling::label[text()='密码']]";
	
     
	String submit ="//input[@value='登录' and following-sibling::a[text()='立即注册']]";
     
	String baiduMusic = "//p/a[contains(@href,'music')]";
	
	String dayTopSong = "//div[preceding-sibling::div/a[contains(@href,'dayhot')]]/ul/li[1]/span[3]/a";
	
	String goToDownload = "//span[text()='下载']";
	
	String download =  "//a[contains(@href,'link=http')]//span[text()='下载']";
}

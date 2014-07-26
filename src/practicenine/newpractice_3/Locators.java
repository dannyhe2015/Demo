package practicenine.newpractice_3;

public interface Locators {

	
	String classicMusic = "//a[text()='经典老歌']";
	String DownloadIcon = "//li[1]/descendant::span/a[@title='下载']";
	String DownloadLink = "//a[contains(@class,'actived')][1]/span/span[contains(text(),'下载')]";
	
	String UserName = "//div[@id='J-username']/input";
	String Login = "//div[@id='J-submit']/input";
	String Music = "//p/a[contains(@href,'music')]";
	
}

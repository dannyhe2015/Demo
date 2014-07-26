package practiceseven.locators;

public interface NewRegLoc {

	String accountname = "//input[@id='regName']";
	String passwords = "//input[@id='pwd']|//input[@id='pwdRepeat']";
	String submit = "//input[@id='registsubmit']";
	
	String regsuc = "//div[contains(text(),'%1$s ÒÑ×¢²á³É¹¦')]";
	
}

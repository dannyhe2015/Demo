package practicejava.JavaBasic;

public class TestJavaBasic extends TestJavaBasicParent{

	private String a = "A";
	public int i = 12;
	
	 static int age = 0;
	
	 
	 static{
		 age = 13;
		 System.out.println("Static block initalized for Age as 13");
	 }
	 
	 {
		 System.out.println("normal block initalized ");
	 }
	 
	 public TestJavaBasic(){
		 System.out.println("TestJavaBasic initalized ");
	 }
	 
	public String getRes(String a,String... b){
		return "male";
		
	}
	
	
	public String getAge(String name){
		return "18";
	}
	
	
	public static void setAge(int actualAge){
		age = actualAge;
	}
	
	
	
	public static void main(String[] args){
		
//		TestJavaBasicParent parent = new TestJavaBasic();
//		System.out.print(parent.getAge("terry"));		
//		TestJavaBasic.setAge(11);
		
		TestJavaBasic t1 = new TestJavaBasic();
		TestJavaBasic t2 = new TestJavaBasic();
		TestJavaBasic t3 = new TestJavaBasic();
		WebDriver driver = new FirefoxDriver();
		
	}
}

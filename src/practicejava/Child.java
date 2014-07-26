package practicejava;

public class Child extends Father{

   public void fmethod(){
		System.out.println("child");
	}
   
   
   public void testChild(){
	   System.out.println("child2");
   }
   
   
   public static void main(String args[]){
	   Father fa = new Child();
	   fa.fmethod();
   }
}

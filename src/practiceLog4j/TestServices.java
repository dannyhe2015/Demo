package practiceLog4j;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class TestServices {
	 private Logger logger = LogManager.getLogger(TestServices.class.getName());
	   
	    private String[] messages = new String[] {
	        "Hello, World",
	        "Goodbye Cruel World",
	        "You had me at hello"
	    };
	    private Random rand = new Random(1);
	 
	    public String retrieveMessage() {
	        logger.entry();
	 
	        String testMsg = getMessage(getKey());
	 
	        return logger.exit(testMsg);
	    }
	 
	    public void exampleException() {
	        logger.entry();
	        try {
	            String msg = messages[messages.length];
	            logger.error("An exception should have been thrown");
	        } catch (Exception ex) {
	            logger.catching(ex);
	        }
	        logger.exit();
	    }
	 
	    public String getMessage(int key) {
	        logger.entry(key);
	 
	        String value = messages[key];
	 
	        return logger.exit(value);
	    }
	 
	    private int getKey() {
	        logger.entry();
	        int key = rand.nextInt(messages.length);
	        return logger.exit(key);
	    }
	    
	    
	public static void main(String[] args){
		TestServices service = new TestServices();
	        service.retrieveMessage();
	        service.retrieveMessage();
	        service.exampleException();

	}
}

package practicejava.commclasses;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestDecimalFormat {

	public static void main(String[] args){
		Calendar calDate = Calendar.getInstance();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyyMMddHHmmss");
		String strDate = simpledateformat.format(calDate.getTime());
		
		System.out.println("获取当前日期："+strDate);
		
		System.out.println("获取昨天日期："+generateFormatDate("yyyyMMddHHmmss",1, "day"));
		
	}

		
	
	public static String generateFormatDate(String formate,int leadtime, String date){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat df = new SimpleDateFormat(formate);
		if (date == "hour"){
		  cal.add(Calendar.HOUR, leadtime); 		
		}else{
		  cal.add(Calendar.DATE, leadtime); 
		}
			
		return df.format(cal.getTime());		
	}
	
}

package practicejava;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class RequiredJava {

	public static void main(String args[]){
		

		Integer z1 = 128;
		Integer z2 = 128;
		
		
		Integer z3 = 2;
		Integer z4 = 2;
		System.out.println("################:0");
		System.out.println(z1==z2);
		System.out.println(z3==z4);
		//boxing and unboxing
		String a = "a";
		String b = "a";
		System.out.println(a==b);
		
		
		System.out.println("################:1");
		String a1 = new String("a");
		String a2 = new String("a");
		System.out.println(a1==a2);
		System.out.println(a1.equals(a2));
		
		//DecimalFormat
		double data = 1234.56789;
		DecimalFormat df = new DecimalFormat();
		
		String style = "00000.0";
		df.applyPattern(style);
		System.out.println(df.format(data));
		
		style = "#0000.0";
		df.applyPattern(style);
		System.out.println(df.format(data));
		
		style = "$0,000.0";
		df.applyPattern(style);
		System.out.println(df.format(data));
		
		//===SimpleDateFormat
		System.out.println("################:2");
		SimpleDateFormat sdf = new SimpleDateFormat();
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		sdf.applyPattern(dateFormat);
		
		Calendar cd = Calendar.getInstance();
		System.out.println(sdf.format(cd.getTime()));
		
		dateFormat = "yyyyMMddHHmmss";
		sdf.applyPattern(dateFormat);
		System.out.println("accountname"+sdf.format(cd.getTime()));
		
		
		System.out.println("################:3");
		//Arrays
		String str1[] = {"a","b","c","d"};
		String str2[] = Arrays.copyOf(str1, 3);
		for(int i =0 ; i< str2.length;i++){
			System.out.println(str2[i]);
		}
		System.out.println("================");
		
		String str[] = {"a","c","d","b"};		
		Arrays.sort(str);
		for(int i =0 ; i< str.length;i++){
			System.out.println(str[i]);
		}
		
		//Collection
		//List		
		List ls = new LinkedList();
		ls.add("a");
		ls.add(23);
		ls.add(null);
		
		Iterator it = ls.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		System.out.println("================");
		System.out.println(ls.get(1));
		
		System.out.println("================");
		ls = new ArrayList();
		ls.add(1);
		ls.add(2);
		ls.add(3);
		
		System.out.println("arraylist.length:"+ls.size()+" getindex(1):"+ls.get(1));
		ls.remove(0);
		System.out.println("arraylist.length:"+ls.size());
		
		//Set
		Set set = new HashSet();
		set.add("a1");
		set.add("a2");
		set.add("a3");
		set.add("a3");
		set.add("a4");
		System.out.println("======set==========");
		
		Iterator setit = set.iterator();
		while(setit.hasNext()){
			System.out.println(setit.next());
		}
		
		//·ºÐÍ
		List j = new Vector();
		j.add("a");
		j.add(123);
		j.add(1.2);
		j.add(true);
		
		List<Integer> generic = new Vector<Integer>();
		//generic.add("a");
		generic.add(123);

		
		System.out.println("======map==========");
		Map mp = new  HashMap();
	    mp.put("username", "terry");
	    mp.put("password", "123");
	    
	    System.out.println(mp.get("username"));
	    
		
	    StringBuffer r=new StringBuffer("abc");
	    r.append("123");
	    r.delete(1, r.length());
	    String ae = r.toString();

	}
}

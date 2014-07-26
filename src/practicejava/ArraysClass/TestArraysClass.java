package practicejava.ArraysClass;

import java.util.Arrays;

public class TestArraysClass {

	public static void main(String args[]){
		String arr1[] = {"a","b","c","d"};
		String arr2[] = Arrays.copyOf(arr1, 3);  //copy前3个元素；
		String arr3[] = Arrays.copyOfRange(arr1, 1, 4);
		
		
		for(int i=0;i<arr2.length;i++){
			System.out.println(arr2[i]);			
		}
		System.out.println("1-----------------");
		for(int i=0;i<arr3.length;i++){
			System.out.println(arr3[i]);
		}
		
		System.out.println("2:-----------------");
		//测试点一个排序验证；a1,a2,b3,b4
		String source[] = {"a1","b3","b4","a2"};
		 Arrays.sort(source);
		 for(int i=0;i<source.length;i++){
				System.out.println(source[i]);
		}
	}
}

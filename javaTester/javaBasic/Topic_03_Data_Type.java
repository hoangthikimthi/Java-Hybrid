package javaBasic;

import org.testng.annotations.Test;

public class Topic_03_Data_Type {

	public static void main(String[] args) {
		int a =10;
		int b=a;
		System.out.println(a);
		System.out.println(b);
		
		b=8;
		System.out.println(a);
		System.out.println(b);
	}
	
	@Test
	public void DataType_Baitap01() 
	{
		int a =6;
		int b =2;
		System.out.println("tong ="+ a+b);
		System.out.println(a-b);
		System.out.println("tich =" + a*b);
		System.out.println("thương =" + a/b);
				
    }
	
	@Test
	public void DataType_Baitap02() 
	{
		float a =7.5f;
		float b =3.8f;
		System.out.println("Dien tich =" + a*b);
				
    }
	
	@Test
	public void DataType_Baitap03() 
	{
		String name = "Automation FC";
		System.out.println("Hello " + name);
				
    }
}

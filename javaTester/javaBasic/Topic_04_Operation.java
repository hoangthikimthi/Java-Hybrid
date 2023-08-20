package javaBasic;

import org.testng.annotations.Test;

public class Topic_04_Operation {
	public void DataType_Baitap01(String name, int age) {
		System.out.println("After 15 year, age of " + name + " will be " + age+15 );		
    }
	@Test
	public void ketqua_BT1() {
		DataType_Baitap01("nam", 8);		
    }
	
	public void Baitap02(int a, int b) {
		b = b-a;
		a = b+a;
		b = a-b;
		//a = b-a;
		System.out.println("ket qua a = "+a);	
		System.out.println("ket qua b = "+b);		
    }
	@Test
	public void ketqua_BT2() {
		Baitap02(5,6);		
    }
	
	
	public void Baitap03(int a, int b) {
			boolean kquasosanh; 
			kquasosanh = (a>b) ? true : false;
			System.out.println(kquasosanh);
    }
	@Test
	public void ketqua_BT3() {
		Baitap03(6,5);		
    }
}

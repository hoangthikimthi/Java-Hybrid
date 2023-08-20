package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_Condition_Exercise {
Scanner scanner = new Scanner(System.in);
	
@Test
public void BT01 () {
		int number = scanner.nextInt();
		if (number%2 == 0) {
			System.out.println("So " + number + " la so chan");
		} else {
		System.out.println("So " + number + " la so le");
		}
	}
@Test
public void BT02 () {
		int number1 = scanner.nextInt();
		int number2 = scanner.nextInt();
		if (number1 >= number2) {
			System.out.println(number1 + " lon hon hoac bang " + number2);
		} else {
			System.out.println(number1 + " nho hon " + number2);
			
		}
	}

@Test
public void BT03 () {
		String name1 = scanner.nextLine();
		String name2 = scanner.nextLine();
		if (name1.equals(name2)) {
			System.out.println("hai nguoi cung ten");
		} else {
			System.out.println("hai nguoi khac ten");
		}
	}


@Test
public void BT04 () {
	int a = scanner.nextInt();
	int b = scanner.nextInt();
	int c = scanner.nextInt();
	if (a >= b && a>=c) {
		System.out.println(a + " la so lon nhat");
	} else if (b >= a && b>=c) {
		System.out.println(b + " la so lon nhat");	
	} else {
		System.out.println(c + " la so lon nhat");	
	}
  }

@Test
public void BT05 () {
	int a = scanner.nextInt();
	
	if (a >= 10 && a<=100) {
		System.out.println(a + " nam trong [10,100]");	
	} else {
		System.out.println(a + " khong nam trong [10,100]");	
	}
  }

@Test
public void BT06 () {
	float a = scanner.nextFloat();
	
	if (a >= 8.5 && a <= 10) {
		System.out.println("Diem D");	
	} else if (a >= 5 && a < 7.5){
		System.out.println("Diem C");	
	} else if (a >= 7.5 && a < 8.5){
		System.out.println("Diem B");	
	} else {
		System.out.println("Diem A");	
	}
  }
  @Test
  public void BT07 () {
  int month = scanner.nextInt();
	
	if (month ==1 || month ==3 || month ==5|| month ==7|| month ==8 || month ==10|| month ==12) {
		System.out.println("Thang "+ month + " co 31 ngay");	
	} else if (month ==4 || month ==6 || month ==9||month ==11){
		System.out.println("Thang "+ month + " co 30 ngay");	
	} else {
		System.out.println("Thang "+ month + " co 28,29 ngay");
	}
  }
}


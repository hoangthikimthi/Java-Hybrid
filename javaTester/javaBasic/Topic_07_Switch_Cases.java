package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_Switch_Cases {
Scanner scanner = new Scanner(System.in);

  @Test
  public void BT01 () {
  int month = scanner.nextInt();
	switch (month) {
	case 1: 
		System.out.println("one");
		break;
	case 2: 
		System.out.println("two");
		break;
	case 3: 
		System.out.println("three");
		break;
	case 4: 
		System.out.println("four");
		break;
	case 5: 
		System.out.println("five");
		break;
	case 6: 
		System.out.println("six");
		break;
	case 7: 
		System.out.println("seven");
		break;
	case 8: 
		System.out.println("eight");
		break;
	case 9: 
		System.out.println("nine");
		break;
	case 10: 
		System.out.println("ten");
		break;	
	}
  }
	
	  @Test
	  public void BT02 () {
      String c = scanner.nextLine();
	  int a = scanner.nextInt();
	  int b = scanner.nextInt();

		switch (c) {
		case "+": 
			System.out.println("Ket qua phep cong la " + (a+b));
			break;
		case "-": 
			System.out.println("Ket qua phep tru la " + (a-b));
			break;
		case "x": 
			System.out.println("Ket qua phep nhan la " + (a*b));
			break;
		case "/": 
			System.out.println("Ket qua phep chia la " + (a/b));
			break;
		}
  }
	  @Test
	  public void BT03 () {
	  int month = scanner.nextInt();
	  switch (month) {
		case 1: 
		case 3: 
		case 5: 
		case 7: 
		case 8: 
		case 10: 
		case 12: 
			System.out.println("Có 31 ngày trong tháng");
			break;
		case 2: 
			System.out.println("Có 28 hoặc 29 ngày trong tháng");
			break;
		case 4: 
		case 6: 
		case 9: 
		case 11: 
			System.out.println("Có 30 ngày trong tháng");
			break;
		default: 
			System.out.println("Vui lòng nhập 1-12 tháng");
			break;
		}
	  }
}


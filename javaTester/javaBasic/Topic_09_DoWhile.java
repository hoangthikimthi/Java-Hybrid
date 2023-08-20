package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_09_DoWhile {
	static Scanner scanner = new Scanner(System.in);

	@Test
	public void BT_01() {
		int i = scanner.nextInt();
		for (; i < 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	@Test
	public void BT_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		for (; a < b; a++) {
			if (a % 3 == 0 & a % 5 == 0) {
				System.out.println(a);
			}
		}
	}

	@Test
	public void BT_02_While() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		while (a < b) {
			if (a % 3 == 0 & a % 5 == 0) {
				System.out.println(a);
			}
			a++;
		}
	}

	// BT 04 giong BT 02

	@Test
	public void BT_05_While() {
		int a = scanner.nextInt();
		int giaithua = 1;
		while (a > 0) {
			giaithua *= a;
			a--;
		}
		System.out.println(giaithua);
	}

	@Test
	public void BT_06_While() {
		int a = scanner.nextInt();
		int sum = 0;
		while (a >0) {
			if (a % 2 == 0) {
				sum +=a;
			}
			a--;
		}
		System.out.println(sum);
	}
}

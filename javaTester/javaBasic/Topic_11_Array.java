package javaBasic;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_11_Array {
	static int[] years = { 2001, 1994, 1995, 2017 };
	int id;
	String name;
	int age;
	int score;

	// @Test
	public void ToString() {

		String yearsString = Arrays.toString(years);
		System.out.println(yearsString);
	}

	// @Test
	public void ToList() {
		List<int[]> yearList = Arrays.asList(years);
		for (int[] year : yearList) {
			for (int i : year) {
				System.out.println(i);
			}
		}
	}

	// @Test
	public void BT_01_Max() {
		int[] number = { 2, 7, 6, 8, 9 };
		int x = 0;
		for (int j = 0; j < number.length; j++) {
			if (x < number[j]) {
				x = number[j];
			}
		}
		System.out.println(x);
	}

	// @Test
	public void BT_02_TongDauCuoi() {
		int[] number = { 2, 7, 6, 8, 9 };
		int x = number[0] + number[number.length - 1];
		System.out.println(x);
	}

	// @Test
	public void BT_03_sochan() {
		int[] number = { 2, 7, 6, 8, 9 };
		for (int i : number) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}

	// @Test
	public void BT_04_TongSole_Duong() {
		int[] number = { -2, 7, 6, -8, 9, 1, 2 };
		int tong = 0;
		for (int i = 0; i < number.length; i++) {
			if (number[i] % 2 != 0 & number[i] > 0) {
				tong += number[i];
			}
		}
		System.out.println(tong);
	}

	// @Test
	public void BT_05_HienThiTheoDieuKien() {
		int[] number = { -2, 7, 6, -8, 9, 1, 2 };
		for (int i = 0; i < number.length; i++) {
			if (number[i] >= 0 & number[i] <= 10) {
				System.out.println(number[i]);
			}
		}
	}

	// @Test
	public void BT_06_Tong_TrungBinhcong() {
		int[] number = { 1, 2, 3 };
		int tong = 0;

		for (int i = 0; i < number.length; i++) {
			tong += number[i];
		}
		System.out.println(tong);
		int tbc = tong / number.length;
		System.out.println(tbc);
	}

	public Topic_11_Array(int id, String name, int age, int score) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
	}

	public void display() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(age);
		System.out.println(score);
	}

	public static void main(String[] args) {
		Topic_11_Array[] students = new Topic_11_Array[3];
		students[0] = new Topic_11_Array(1, "a", 4, 10);
		students[1] = new Topic_11_Array(2, "b", 5, 9);
		students[2] = new Topic_11_Array(3, "c", 6, 8);
		for (int i = 0; i < 3; i++) {
			students[i].display();
		}
	}
}

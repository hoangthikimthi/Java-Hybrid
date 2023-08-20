package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_Break_Continue {
	String courseName = "Automation Testing Advanced";
	String chuoi2 = "Automation Testing 345 Tutorials Online 789";

	// @Test
	public void BT_01() {
		char courseNameArr[] = courseName.toCharArray();
		int count = 0;
		for (char character : courseNameArr) {
			if (character <= 'Z' && character >= 'A') {
				count++;
			}
		}
		System.out.println(count);
	}

	// @Test
	public void BT_02_dem() {
		String tachChuoi2[] = chuoi2.split("");
		int count = 0;
		for (String character : tachChuoi2) {
			if (character.equalsIgnoreCase("a")) {
				count++;
			}
		}
		System.out.println(count);
	}

	//@Test
	public void BT_02_Kiemtra_Testing() {
		System.out.println(chuoi2.contains("Testing"));
		System.out.println(chuoi2.startsWith("Automation"));
		System.out.println(chuoi2.endsWith("Online"));
		
		int index = chuoi2.indexOf("Tutorials");
		System.out.println(index);
		
		String replace = chuoi2.replace("Online", "Offline");
		System.out.println(replace);
		
		char chuoi2Arr[] = chuoi2.toCharArray();
		int count = 0;
		for (char character : chuoi2Arr) {
			if (character <= '9' && character >= '0') {
				count++;
			}
		}
		System.out.println(count);
	}
	@Test
	public void BT_03_DaoNguoc_Reverse() {
		char courseNameArr[] = courseName.toCharArray();
		for(int i = courseName.length() - 1; i>=0; i--  ) {
			System.out.print(courseNameArr[i]);
		}
	}
	
	@Test
	public void BT_04_DaoNguoc_SDT() {

	}
}

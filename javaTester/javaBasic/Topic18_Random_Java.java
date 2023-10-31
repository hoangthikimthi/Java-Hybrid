package javaBasic;

import java.util.Calendar;
import java.util.Random;

public class Topic18_Random_Java {
	public static void main(String[] args) throws InterruptedException {
		System.out.println(getRandomEmail());
		Thread.sleep(1000);
		System.out.println(getRandomEmail());
		Thread.sleep(1000);
		System.out.println(getRandomEmail());
		Thread.sleep(1000);
		System.out.println(getRandomEmail());

		System.out.println(getRandomNumber(100, 200));
		System.out.println(getRandomNumber(100, 200));
		System.out.println(getRandomNumber(100, 200));
	}

	// random 3 số
	public static int getRandomNumber() {
		int uLimit = 999;
		int lLimit = 100;
		Random rand = new Random();
		return lLimit + rand.nextInt(uLimit - lLimit);
	}

	// random a-b
	public static int getRandomNumber(int minimum, int maximum) {
		Random rand = new Random();
		return minimum + rand.nextInt(maximum - minimum);
	}

	// random 0-9999
	public static int getGenerateRandomNumber() {
		Random rant = new Random();
		return rant.nextInt(9999);

	}

	public static String getRandomEmail() {
		return "automation" + getRandomNumberByDateTime() + "@live.com";
	}

	// Get random number by date time minute second (no duplicate)
	public static long getRandomNumberByDateTime() {
		return Calendar.getInstance().getTimeInMillis() % 100000;
	}
}

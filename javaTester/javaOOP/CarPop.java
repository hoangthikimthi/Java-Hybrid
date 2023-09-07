package javaOOP;

public class CarPop {
	static String carCompany;
	static String carType;
	static String fuelType;
	static Float mileAge;
	static Double carPrice;

	public static void main(String[] args) {
		carCompany = "honda";
		carType = "city";
		fuelType = "petrol";
		mileAge = 200f;
		carPrice = 5000000d;

		System.out.println("car company = " + carCompany);
		System.out.println("car car Type = " + carType);
		System.out.println("car fuel Type = " + fuelType);
		System.out.println("car mile Age = " + mileAge);
		System.out.println("car car Price = " + carPrice);
	}

}

package utilities;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataFaker {

	private Locale local = new Locale("vi");
	private Faker faker = new Faker(local);

	public static DataFaker getDataHelper() {
		return new DataFaker();
	}

	public String getFirstName() {
		return faker.address().firstName();
	}

	public String getLastName() {
		return faker.address().lastName();
	}

	public String getEmail() {
		return faker.internet().emailAddress();
	}

	public String getPhoneNumber() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getPassword() {
		return faker.internet().password(6, 12, true, true);
	}

}

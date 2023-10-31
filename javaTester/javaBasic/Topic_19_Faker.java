package javaBasic;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class Topic_19_Faker {

	public static void main(String[] args) {

		// US
		Faker faker = new Faker();
		faker.address().firstName();
		faker.address().lastName();
		faker.business().creditCardNumber();
		faker.business().creditCardExpiry();
		faker.finance().creditCard(CreditCardType.VISA);

		// VI
		Faker fakerVi = new Faker();
		fakerVi.address().firstName();
		fakerVi.address().lastName();
		fakerVi.business().creditCardNumber();
	}

}

package testngpractise;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider
	public Object[][] getdata() {

		Object[][] credentials = new Object[3][3];

		credentials[0][0] = "joshuavj90@gmail.com";
		credentials[0][1] = "123456";
		credentials[0][2] = "abcd987";
		credentials[1][0] = "vincentjoshua@gmail.com";
		credentials[1][1] = "98765";
		credentials[1][2] = "ghjk85";
		credentials[2][0] = "example1@gmail.com";
		credentials[2][1] = "57574345";
		credentials[2][2] = "58d5sw16";

		return credentials;		

	}

}

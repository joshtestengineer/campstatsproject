package testngpractise;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class dataProviderTest {

	@Parameters({ "emailid" })
	@BeforeMethod
	public void parameter(String emailid) {
		System.out.println("EmailID is " + emailid);
	}

	@Test(dataProvider = "getdata", dataProviderClass = DataProviderClass.class)

	public void loginTest(String username, String password, String pin) {

		/*
		 * ChromeDriverService service = new
		 * ChromeDriverService.Builder().withLogOutput(System.out).build();
		 * 
		 * WebDriver driver = new ChromeDriver(service);
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * driver.get("https://www.facebook.com/");
		 * driver.findElement(By.id("email")).sendKeys(username);
		 * driver.findElement(By.id("pass")).sendKeys(password);
		 */
		System.out.println("Username is " + username);
		System.out.println("Password is " + password);
		System.out.println("Pin is " + pin);

		// Thread.sleep(3000);
		// driver.close();

	}

}

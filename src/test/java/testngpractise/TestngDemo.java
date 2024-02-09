package testngpractise;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestngDemo {
	
	@Test
	public void SampleAutomation() throws InterruptedException  {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://omayo.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("alert1")).click();
		Thread.sleep(4000);
		Alert alert = driver.switchTo().alert();
		String at = alert.getText();
		System.out.println("Alert text is "+"'"+at+"'");
		alert.dismiss();
		
//Assertions
		
		
		
		
		/*Set<String> window = driver.getWindowHandles();
		Iterator<String> multi = window.iterator();
		
		while (multi.hasNext()) {
			String navigate = multi.next();
			driver.switchTo().window(navigate);
			driver.
		}*/



	}

}
